package com.product.pages;

import com.product.driver.DriverManager;
import com.product.enums.WaitStraitgy;
import com.product.factories.WaitFactory;
import com.product.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void click(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        element.click();
        ExtentLogger.pass(elementName + " clicked", isScreenshotNeeded);
    }

    protected void sendKeys(By by, WaitStraitgy waitStraitgy, String value, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        element.sendKeys(value);
        ExtentLogger.pass("Entered " + value + " in " + elementName, isScreenshotNeeded);
    }

    public String getTitle() {
        String title = DriverManager.getDriver().getTitle();
        ExtentLogger.pass("Get Title " + title);
        return title;
    }
}
