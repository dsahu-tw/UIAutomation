package com.product.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.product.driver.DriverManager;
import com.product.utils.FrameworkConfigs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentLogger {

    public static void pass(String message) {
        ExtentReportManager.getTest().pass(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        if (isScreenshotNeeded && FrameworkConfigs.configs.passedStepsScreenshot().equalsIgnoreCase("yes"))
            ExtentReportManager.getTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        else
            pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getTest().fail(message);
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if (isScreenshotNeeded && FrameworkConfigs.configs.passedStepsScreenshot().equalsIgnoreCase("yes"))
            ExtentReportManager.getTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        else
            fail(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getTest().skip(message);
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        if (isScreenshotNeeded && FrameworkConfigs.configs.passedStepsScreenshot().equalsIgnoreCase("yes"))
            ExtentReportManager.getTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        else
            skip(message);
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
