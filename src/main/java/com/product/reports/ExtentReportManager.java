package com.product.reports;

import com.aventstack.extentreports.ExtentTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExtentReportManager {

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return extTest.get(); //to get webdriver. Thread saftey will come by default
    }

    public static void setTest(ExtentTest test) {
        extTest.set(test);
    }

    public static void unload() {
        extTest.remove();
    }

}
