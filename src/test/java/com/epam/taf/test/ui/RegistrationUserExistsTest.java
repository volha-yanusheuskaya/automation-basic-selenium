package com.epam.taf.test.ui;

import com.epam.taf.components.CookieBannerComponent;
import com.epam.taf.service.RegistrationService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.epam.taf.components.AlertBannerComponent;
import com.epam.taf.pages.RegistrationPage;
import com.epam.taf.service.UserCreator;

import static org.testng.Assert.assertTrue;

public class RegistrationUserExistsTest extends CommonConditions {

    private AlertBannerComponent alertBannerComponent;

    @Test(priority = 1)
    public void verifyAlertBanner() {
        alertBannerComponent = new AlertBannerComponent(driver);

        new RegistrationPage(driver).openPage();
        new CookieBannerComponent(driver).clickAcceptCookieBanner();

        new RegistrationService(driver).fillOutRegistrationForm(UserCreator.createExistingUser());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertBannerComponent.isAlertBannerDisplayed());
        softAssert.assertTrue(alertBannerComponent.isAlertBannerIconDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyRedirectToLoginPage() {
        assertTrue(alertBannerComponent.clickSignInLink().isUserNameInputDisplayed());
    }
}
