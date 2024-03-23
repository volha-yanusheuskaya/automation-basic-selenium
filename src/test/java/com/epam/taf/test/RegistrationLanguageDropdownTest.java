package com.epam.taf.test;

import org.testng.annotations.Test;
import com.epam.taf.pages.RegistrationPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationLanguageDropdownTest extends CommonConditions {

    private static final int EXPECTED_NUMBER_OF_LANGUAGES = 7;
    private static final String FRANCE_LANGUAGE = "Français (CA)";

    private RegistrationPage registrationScreen;

    @Test(priority = 1)
    public void verifyLanguageValues() {
        registrationScreen = new RegistrationPage(driver);
        int actualNumberOfLanguages = registrationScreen
                .openPage()
                .clickAcceptCookieBanner()
                .clickLanguageDropdown()
                .getLanguageDropdownSize();
        assertEquals(actualNumberOfLanguages, EXPECTED_NUMBER_OF_LANGUAGES, "Languages are not 7!");
    }

    @Test(priority = 2)
    public void selectFrenchLanguage() {
        String languageDropdownHeader = registrationScreen
                .clickLanguageByValue(FRANCE_LANGUAGE)
                .getLanguageDropdownHeader();
        assertEquals(languageDropdownHeader, FRANCE_LANGUAGE, "France language is not displayed!");
    }

    @Test(priority = 3)
    public void selectedLanguageHasCheckmark() {
        boolean languageValueHasCheckmark = registrationScreen
                .clickLanguageDropdown()
                .isLanguageValueHasCheckmark(FRANCE_LANGUAGE);
        assertTrue(languageValueHasCheckmark, "Checkmark is not displayed!");
    }
}
