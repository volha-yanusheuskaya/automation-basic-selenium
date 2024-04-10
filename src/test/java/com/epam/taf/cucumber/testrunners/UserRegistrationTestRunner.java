package com.epam.taf.cucumber.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/epam/taf/cucumber/features"},
        glue = {"com/epam/taf/cucumber/stepdefinitions", "com/epam/taf/cucumber/hooks"},
        tags = "@registration",
        plugin = {"pretty",
                "html:target/TestReport/html/",
                "json:target/TestReport/json/report.json",
                "junit:target/TestReport/junit/report.xml",
                "testng:target/TestReport/testng/report.xml"},
                monochrome = true
        )
public class UserRegistrationTestRunner extends AbstractTestNGCucumberTests {
}
