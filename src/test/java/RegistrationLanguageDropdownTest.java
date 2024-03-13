import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import taf.driver.DriverFactory;
import taf.product.profile.RegistrationScreen;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationLanguageDropdownTest {

    private static final int EXPECTED_NUMBER_OF_LANGUAGES = 7;
    private static final String FRANCE_LANGUAGE = "Français (CA)";

    private RegistrationScreen registrationScreen;

    @BeforeClass
    public void browserSetup() {
        WebDriver driver = DriverFactory.getInstance().getChromeDriver();
        registrationScreen = new RegistrationScreen(driver);
        registrationScreen.openPage().clickCloseCookieBanner();
    }

    @Test(priority = 1)
    public void verifyLanguageValues() {
        assertEquals(registrationScreen.clickLanguageDropdown().getLanguageDropdownSize(), EXPECTED_NUMBER_OF_LANGUAGES,
                "Languages are not 7!");
    }

    @Test(priority = 2)
    public void selectFrenchLanguage() {
        assertEquals(registrationScreen.clickLanguageByValue(FRANCE_LANGUAGE).getLanguageDropdownHeader(),
                FRANCE_LANGUAGE, "France language is not displayed!");
    }

    @Test(priority = 3)
    public void selectedLanguageHasCheckmark() {
        assertTrue(registrationScreen.clickLanguageDropdown().isLanguageValueHasCheckmark(FRANCE_LANGUAGE),
                "Checkmark is not displayed!");
    }

    @AfterClass
    public void browserTearDown() {
        DriverFactory.getInstance().closeDriver();
    }
}
