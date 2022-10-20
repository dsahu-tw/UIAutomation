package com.product.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.product.constants.FrameworkConstants;
import com.product.enums.CategoryType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.File;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReport {

    private static ExtentReports extent;
    private static String dynamicReportPath;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            dynamicReportPath = FrameworkConstants.getExtentReportPath();
            ExtentSparkReporter spark = new ExtentSparkReporter(dynamicReportPath);
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Product Test Report");
            spark.config().setReportName("Demo Report");
        }
    }

    @SneakyThrows
    public static void flushReports() {
        if (Objects.nonNull(extent))
            extent.flush();
        ExtentReportManager.unload();
        Desktop.getDesktop().browse(new File(dynamicReportPath).toURI());
    }

    public static void createTest(String testcaseName) {
        ExtentTest test = extent.createTest(testcaseName);
        ExtentReportManager.setTest(test);
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors) {
            ExtentReportManager.getTest().assignAuthor(author);
        }

    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentReportManager.getTest().assignCategory(category.toString());
        }

    }

}
