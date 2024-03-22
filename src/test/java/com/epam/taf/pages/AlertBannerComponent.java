package com.epam.taf.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.taf.driver.DriverWait.waitElementToBeClickable;
import static com.epam.taf.driver.DriverWait.waitForVisibility;

public class AlertBannerComponent extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

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
        boolean isAlertBannerDisplayed = alertBanner.isDisplayed();
        logger.info("The Alert banner is displayed");
        return isAlertBannerDisplayed;
    }

    public boolean isAlertBannerIconDisplayed() {
        waitForVisibility(alertBannerIcon);
        return alertBannerIcon.isDisplayed();
    }

    public AlertBannerComponent clickSignInLink() {
        waitForVisibility(signInLink);
        waitElementToBeClickable(signInLink);
        signInLink.click();
        logger.info("The Sign in link is clicked");
        return this;
    }

    public boolean isUserNameInputDisplayed() {
        waitForVisibility(userNameInput);
        logger.info("The Login form is displayed");
        return userNameInput.isDisplayed();
    }
}
