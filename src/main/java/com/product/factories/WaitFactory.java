package com.product.factories;

import com.product.constants.FrameworkConstants;
import com.product.driver.DriverManager;
import com.product.enums.WaitStraitgy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WaitFactory {

    @SneakyThrows
    public static WebElement performExplicitWait(WaitStraitgy strategy, By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTimeout());
        if (strategy == WaitStraitgy.CLICKABLE) {
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } else if (strategy == WaitStraitgy.VISIBLE) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (strategy == WaitStraitgy.PRESENCE) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } else {
            return DriverManager.getDriver().findElement(by);
        }

    }


}
