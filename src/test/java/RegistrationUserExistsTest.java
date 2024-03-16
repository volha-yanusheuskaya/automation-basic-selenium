import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taf.driver.DriverFactory;
import taf.product.profile.components.AlertBannerComponent;
import taf.product.profile.service.RegistrationService;

import static org.testng.Assert.assertTrue;

public class RegistrationUserExistsTest {

    private AlertBannerComponent alertBannerComponent;

    @BeforeClass
    public void browserSetup() {
        WebDriver driver = DriverFactory.getInstance().getChromeDriver();
        RegistrationService registrationService = new RegistrationService();
        alertBannerComponent = new AlertBannerComponent(driver);
        registrationService.registerExistingUser(driver);
    }

    @Test(priority = 1)
    public void verifyAlertBanner() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertBannerComponent.isAlertBannerDisplayed());
        softAssert.assertTrue(alertBannerComponent.isAlertBannerIconDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyRedirectToProfilePage() {
        alertBannerComponent.clickSignInLink();
        assertTrue(alertBannerComponent.isUserNameInputDisplayed());
    }

    @AfterClass
    public void browserTearDown() {
        DriverFactory.getInstance().closeDriver();
    }
}
