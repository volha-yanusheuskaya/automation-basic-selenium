package com.epam.taf.cucumber;

import com.epam.taf.driver.DriverSingleton;
import com.epam.taf.service.PropertyFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected final Logger logger = LogManager.getRootLogger();

    public WebElement findElement(String elementName) {
        return DriverSingleton.getInstance().getDriver()
                .findElement(By.cssSelector(PropertyFileReader.getCssSelector(elementName)));
    }

    public void clickElement(String elementName) {
        DriverSingleton.getInstance().getDriver()
                .findElement(By.cssSelector(PropertyFileReader.getCssSelector(elementName))).click();
    }

    public boolean isElementDisplayed(String elementName) {
        WebElement element = findElement(elementName);
        logger.info(String.format("The %s element is displayed", elementName));
        return element.isDisplayed();
    }
}
