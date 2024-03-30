package com.epam.taf.components;

import com.epam.taf.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.taf.util.WaitUtils.waitElementToBeClickable;
import static com.epam.taf.util.WaitUtils.waitForVisibility;

public class AlertBannerComponent extends AbstractComponent {

    @FindBy(css = "div[role='alert']")
    private WebElement alertBanner;

    @FindBy(className = "AlertBanner-icon")
    private WebElement alertBannerIcon;

    @FindBy(css = ".AlertBanner-text .Link")
    private WebElement signInLink;

    public AlertBannerComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertBannerDisplayed() {
        waitForVisibility(alertBanner);
        boolean isAlertBannerDisplayed = alertBanner.isDisplayed();
        logger.info("The Alert banner is displayed");
        return isAlertBannerDisplayed;
    }

    public boolean isAlertBannerIconDisplayed() {
        waitForVisibility(alertBannerIcon);
        return alertBannerIcon.isDisplayed();
    }

    public LoginPage clickSignInLink() {
        waitForVisibility(signInLink);
        waitElementToBeClickable(signInLink);
        signInLink.click();
        logger.info("The Sign in link is clicked");
        return new LoginPage(driver);
    }
}
