package com.epam.taf.test.ui;

import com.epam.taf.listeners.ReportPortalListener;
import com.epam.taf.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.epam.taf.driver.DriverSingleton;

@Listeners({TestListener.class, ReportPortalListener.class})
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
