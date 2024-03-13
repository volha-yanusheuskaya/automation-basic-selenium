package taf.product.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static taf.driver.DriverWait.waitElementToBeClickable;
import static taf.driver.DriverWait.waitForVisibility;

public class AlertBannerComponent extends AbstractScreen {

    @FindBy(css = "div[role='alert']")
    private WebElement alertBanner;

    @FindBy(className = "AlertBanner-icon")
    private WebElement alertBannerIcon;

    @FindBy(css = ".AlertBanner-text .Link")
    private WebElement signInLink;

    @FindBy(id = "username")
    private WebElement userNameInput;

    public AlertBannerComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertBannerDisplayed() {
        waitForVisibility(alertBanner);
        return alertBanner.isDisplayed();
    }

    public boolean isAlertBannerIconDisplayed() {
        waitForVisibility(alertBannerIcon);
        return alertBannerIcon.isDisplayed();
    }

    public void clickSignInLink() {
        waitForVisibility(signInLink);
        waitElementToBeClickable(signInLink);
        signInLink.click();
    }

    public boolean isUserNameInputDisplayed() {
        waitForVisibility(userNameInput);
        return userNameInput.isDisplayed();
    }
}
