package com.epam.taf.cucumber.hooks;

import com.epam.taf.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    protected final Logger logger = LogManager.getRootLogger();

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("\n Starting Scenario: {} ", scenario.getName());
        DriverSingleton.getInstance().getDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("\n Finished Scenario: {}", scenario.getName() + " -> Status: " + scenario.getStatus());
        DriverSingleton.getInstance().closeDriver();
    }
}
