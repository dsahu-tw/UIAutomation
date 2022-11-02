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
        WebElement element;
        switch (strategy) {
            case VISIBLE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            case PRESENCE:
                element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
                break;
            case CLICKABLE:
                element = wait.until(ExpectedConditions.elementToBeClickable(by));
                break;
            default:
                return DriverManager.getDriver().findElement(by);
        }
        return element;
    }


}
