package com.product.pages;

import com.product.driver.DriverManager;
import com.product.enums.WaitStraitgy;
import com.product.factories.ActionsFactory;
import com.product.factories.WaitFactory;
import com.product.reports.ExtentLogger;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    @SneakyThrows
    protected void click(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        element.click();
        ExtentLogger.pass(elementName + " clicked", isScreenshotNeeded);

    }

    @SneakyThrows
    protected void clickByActions(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        ActionsFactory.startActions().moveToElement(element).click(element).build().perform();
        ExtentLogger.pass(elementName + " clicked", isScreenshotNeeded);

    }

    @SneakyThrows
    protected void hover(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        ActionsFactory.startActions().moveToElement(element).build().perform();
        ExtentLogger.pass(elementName + " hovered", isScreenshotNeeded);

    }

    @SneakyThrows
    protected void doubleClick(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        ActionsFactory.startActions().moveToElement(element).doubleClick(element).build().perform();
        ExtentLogger.pass(elementName + " double clicked", isScreenshotNeeded);

    }


    @SneakyThrows
    protected void clear(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        element.clear();
        ExtentLogger.pass(elementName + " cleared", isScreenshotNeeded);

    }

    @SneakyThrows
    protected String getAttribute(By by, WaitStraitgy waitStraitgy, String elementName, String attributeName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        String text = element.getAttribute(attributeName);
        ExtentLogger.pass(text + "Get attribute of " + elementName + ":" + text, isScreenshotNeeded);
        return text;
    }

    @SneakyThrows
    protected boolean isElementPresent(By by, WaitStraitgy waitStraitgy, String elementName, boolean isScreenshotNeeded) {
        try {
            WaitFactory.performExplicitWait(waitStraitgy, by);
            ExtentLogger.pass(elementName + "found ", isScreenshotNeeded);
            return true;
        } catch (Exception e) {
            ExtentLogger.fail(elementName + "not found ", isScreenshotNeeded);
            return false;
        }
    }

    @SneakyThrows
    protected void sendKeys(By by, WaitStraitgy waitStraitgy, String value, String elementName, boolean isScreenshotNeeded) {
        WebElement element = WaitFactory.performExplicitWait(waitStraitgy, by);
        element.sendKeys(value);
        ExtentLogger.pass("Entered " + value + " in " + elementName, isScreenshotNeeded);
    }

    @SneakyThrows
    protected String getPageTitle() {
        String title = DriverManager.getDriver().getTitle();
        ExtentLogger.pass("Get Title " + title);
        return title;
    }


}
