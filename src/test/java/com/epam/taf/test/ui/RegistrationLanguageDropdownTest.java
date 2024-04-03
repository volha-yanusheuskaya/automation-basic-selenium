package com.epam.taf.test.ui;

import com.epam.taf.components.CookieBannerComponent;
import com.epam.taf.components.LanguageDropdownComponent;
import org.testng.annotations.Test;
import com.epam.taf.pages.RegistrationPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationLanguageDropdownTest extends CommonConditions {

    private static final int EXPECTED_NUMBER_OF_LANGUAGES = 7;
    private static final String FRANCE_LANGUAGE = "Français (CA)";

    private LanguageDropdownComponent languageDropdownComponent;

    @Test(priority = 1)
    public void verifyLanguageValues() {
        languageDropdownComponent = new LanguageDropdownComponent(driver);

        new RegistrationPage(driver).openPage();
        new CookieBannerComponent(driver).clickAcceptCookieBanner();

        int actualNumberOfLanguages = languageDropdownComponent
                .clickLanguageDropdown()
                .getLanguageDropdownSize();
        assertEquals(actualNumberOfLanguages, EXPECTED_NUMBER_OF_LANGUAGES, "Languages are not 7!");
    }

    @Test(priority = 2)
    public void selectFrenchLanguage() {
        String languageDropdownHeader = languageDropdownComponent
                .clickLanguageByValue(FRANCE_LANGUAGE)
                .getLanguageDropdownHeader();
        assertEquals(languageDropdownHeader, FRANCE_LANGUAGE, "France language is not displayed!");
    }

    @Test(priority = 3)
    public void selectedLanguageHasCheckmark() {
        boolean languageValueHasCheckmark = languageDropdownComponent
                .clickLanguageDropdown()
                .isLanguageValueHasCheckmark(FRANCE_LANGUAGE);
        assertTrue(languageValueHasCheckmark, "Checkmark is not displayed!");
    }
}
