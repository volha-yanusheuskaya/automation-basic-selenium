package taf.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import taf.driver.DriverFactory;

import static taf.driver.DriverWait.waitForVisibility;

public class WebElementUtils {

    private static final WebDriver driver = DriverFactory.getInstance().getChromeDriver();

    private WebElementUtils() {

    }

    public static WebElement highlightElement(WebElement webElement) {
        WebElement element = waitForVisibility(webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        return element;
    }
}
