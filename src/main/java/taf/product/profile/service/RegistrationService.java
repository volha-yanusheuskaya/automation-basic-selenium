package taf.product.profile.service;

import org.openqa.selenium.WebDriver;
import taf.product.profile.pages.RegistrationScreen;

public class RegistrationService {

    public void registerExistingUser(WebDriver driver) {
        new RegistrationScreen(driver)
                .openPage()
                .clickCloseCookieBanner()
                .typeUserName("Auto", "Test")
                .typeExistsEmail()
                .typePassword("1234Test")
                .clickTermOfUseCheckbox()
                .clickContinueButton();
    }
}
