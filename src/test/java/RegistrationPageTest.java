import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taf.driver.DriverFactory;
import taf.product.profile.pages.RegistrationScreen;

import static org.testng.Assert.assertEquals;

public class RegistrationPageTest {

    private RegistrationScreen registrationScreen;

    @BeforeClass
    public void browserSetup() {
        WebDriver driver = DriverFactory.getInstance().getChromeDriver();
        registrationScreen = new RegistrationScreen(driver);
    }

    @Test(priority = 1)
    public void verifyRegistrationScreenTitle() {
        assertEquals(registrationScreen.openPage().getPageTitle(),
                "Create an account | Thomson Reuters",
                "Titles are not equals!");
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

    @AfterClass
    public void browserTearDown() {
        DriverFactory.getInstance().closeDriver();
    }
}
