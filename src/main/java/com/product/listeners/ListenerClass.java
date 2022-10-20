package com.product.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.product.annotations.FrameworkAnnotations;
import com.product.driver.DriverManager;
import com.product.reports.ExtentReport;
import com.product.reports.ExtentReportManager;
import com.product.utils.FrameworkConfigs;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.util.Arrays;

public final class ListenerClass implements ITestListener, ISuiteListener, IRetryAnalyzer {

    private int count = 0;

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {

        Object[] params = result.getParameters();
        ExtentReport.createTest(result.getMethod().getMethodName() + Arrays.toString(params));
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass(result.getMethod().getMethodName() + " passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().fail(result.getMethod().getMethodName() + " failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip(result.getMethod().getMethodName() + " skipped");
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    @Override
    public boolean retry(ITestResult iTestResult) {

        int retry = Integer.parseInt(FrameworkConfigs.configs.failedTestRetryCount());

        if (count < retry) {
            count++;
            return true;
        }

        return false;
    }
}
