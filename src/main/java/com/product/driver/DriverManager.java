package com.product.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverManager {

    private static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadSafeDriver.get(); //to get webdriver. Thread saftey will come by default
    }

    public static void setDriver(WebDriver dr) {
        threadSafeDriver.set(dr);
    }

    public static void unload() {
        threadSafeDriver.remove();
    }
}
