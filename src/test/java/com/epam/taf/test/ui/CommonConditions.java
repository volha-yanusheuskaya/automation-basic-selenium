package com.epam.taf.test.ui;

import com.epam.taf.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.epam.taf.driver.DriverSingleton;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.getInstance().closeDriver();
    }
}
