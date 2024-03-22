package com.epam.taf.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.epam.taf.driver.DriverSingleton;

import static com.epam.taf.driver.DriverWait.waitForVisibility;

public class WebElementUtils {

    private static final WebDriver driver = DriverSingleton.getDriver();

    private WebElementUtils() {
    }

    public static WebElement highlightElement(WebElement webElement) {
        WebElement element = waitForVisibility(webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        return element;
    }
}
