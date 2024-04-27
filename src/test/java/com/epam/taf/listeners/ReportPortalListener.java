package com.epam.taf.listeners;

import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.epam.taf.driver.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.util.Date;

public class ReportPortalListener extends ReportPortalTestNGListener {

    @Override
    public void onTestFailure(ITestResult testResult) {
        saveScreenshot();
        super.onTestFailure(testResult);
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        saveScreenshot();
        super.onTestSuccess(testResult);
    }

    private static void saveScreenshot() {
        String message = "Screenshot is attached!";
        String level = "1";
        if (DriverSingleton.getInstance().getDriver() instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) DriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            ReportPortal.emitLog(message, level, new Date(), screenshot);
        }
    }
}
