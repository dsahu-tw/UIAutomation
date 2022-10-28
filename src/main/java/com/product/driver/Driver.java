package com.product.driver;

import com.product.utils.FrameworkConfigs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {


    @SneakyThrows
    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.getDriver(FrameworkConfigs.configs.browser()));
            DriverManager.getDriver().get(FrameworkConfigs.configs.url());
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
