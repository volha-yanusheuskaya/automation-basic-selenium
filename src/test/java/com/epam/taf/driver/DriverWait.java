package com.epam.taf.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWait {

    public static final int TIME_OUT_IN_SECONDS = 60;

    public static final WebDriver driver = DriverSingleton.getInstance().getDriver();

    private DriverWait() {
    }

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInvisibility(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitElementToBeClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
