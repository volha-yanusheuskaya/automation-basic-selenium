package com.epam.taf.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.epam.taf.model.User;
import com.epam.taf.pages.AlertBannerComponent;
import com.epam.taf.pages.RegistrationPage;
import com.epam.taf.service.UserCreator;

import static org.testng.Assert.assertTrue;

public class RegistrationUserExistsTest extends CommonConditions {

    private AlertBannerComponent alertBannerComponent;

    @Test(priority = 1)
    public void verifyAlertBanner() {
        alertBannerComponent = new AlertBannerComponent(driver);
        User existingUser = UserCreator.createExistingUser();

        new RegistrationPage(driver)
                .openPage()
                .clickAcceptCookieBanner();
        new RegistrationPage(driver).fillOutRegistrationForm(existingUser);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertBannerComponent.isAlertBannerDisplayed());
        softAssert.assertTrue(alertBannerComponent.isAlertBannerIconDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyRedirectToProfilePage() {
        assertTrue(alertBannerComponent.clickSignInLink().isUserNameInputDisplayed());
    }
}
