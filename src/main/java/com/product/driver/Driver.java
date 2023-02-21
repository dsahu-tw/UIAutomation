package com.product.driver;

import com.product.utils.CommonUtils;
import com.product.utils.FrameworkConfigs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {


    @SneakyThrows
    public static void initDriver() {

        if (Objects.isNull(DriverManager.getDriver())) {
            String dBrowser = CommonUtils.getParameter("browser");
            if (Objects.nonNull(dBrowser) && (!dBrowser.isEmpty()))
                DriverManager.setDriver(DriverFactory.getDriver(dBrowser));
            else
                DriverManager.setDriver(DriverFactory.getDriver(FrameworkConfigs.configs.browser()));

            DriverManager.getDriver().manage().window().maximize();
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
