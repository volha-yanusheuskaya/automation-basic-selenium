package com.epam.taf.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.taf.util.WaitUtils.waitForInvisibility;
import static com.epam.taf.util.WaitUtils.waitForVisibility;

public class CookieBannerComponent extends AbstractComponent {

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptCookieBanner;

    public CookieBannerComponent(WebDriver driver) {
        super(driver);
    }

    public void clickAcceptCookieBanner() {
        waitForVisibility(acceptCookieBanner);
        acceptCookieBanner.click();
        waitForInvisibility(acceptCookieBanner);
    }
}
