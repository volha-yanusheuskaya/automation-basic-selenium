package com.epam.taf.driver;

import com.epam.taf.browser.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private static DriverSingleton instance = new DriverSingleton();

    private static final Logger logger = LogManager.getRootLogger();

    private DriverSingleton() {
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            instance = new DriverSingleton();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.createInstance();
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            logger.error("The Driver is not closed!");
        }
    }
}
