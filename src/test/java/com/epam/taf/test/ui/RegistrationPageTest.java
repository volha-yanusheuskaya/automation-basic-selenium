package com.epam.taf.test.ui;

import com.epam.taf.components.CookieBannerComponent;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.epam.taf.pages.RegistrationPage;

import static org.testng.Assert.assertEquals;

public class RegistrationPageTest extends CommonConditions {

    private static final String REGISTRATION_PAGE_TITLE = "Create an account | Thomson Reuters";

    private RegistrationPage registrationScreen;

    @Test(priority = 1)
    public void verifyRegistrationScreenTitle() {
        registrationScreen = new RegistrationPage(driver);
        registrationScreen.openPage();
        new CookieBannerComponent(driver).clickAcceptCookieBanner();
        assertEquals(registrationScreen.getPageTitle(), REGISTRATION_PAGE_TITLE, "Titles are not equals!");
    }

    @Test(priority = 2)
    public void verifyRegistrationScreenContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registrationScreen.isFirstNameInputDisplayed(), "First name input is not displayed!");
        softAssert.assertTrue(registrationScreen.isLastNameInputDisplayed(), "Last name input is not displayed!");
        softAssert.assertTrue(registrationScreen.isEmailInputDisplayed(), "Email input is not displayed!");
        softAssert.assertTrue(registrationScreen.isNewPasswordInputDisplayed(), "New password input is not displayed!");
        softAssert.assertTrue(registrationScreen.isPasswordConfirmationInputDisplayed(), "Password confirmation input is not displayed!");
        softAssert.assertTrue(registrationScreen.isTermOfUseCheckboxDisplayed(), "Term of use checkbox is not displayed!");
        softAssert.assertTrue(registrationScreen.isContinueButtonDisplayed(), "Continue button is not displayed!");
        softAssert.assertAll();
    }
}
