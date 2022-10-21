package com.product.driver;

import com.product.enums.Browser;
import com.product.exceptions.InvalidBrowserException;
import com.product.reports.ExtentLogger;
import com.product.reports.ExtentReport;
import com.product.reports.ExtentReportManager;
import com.product.utils.FrameworkConfigs;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {


    @SneakyThrows
    public static void initDriver() {
        WebDriver driver;
        if (Objects.isNull(DriverManager.getDriver())) {
            //System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath()); //calling this just to show usage of FrameworkConstants

            if (FrameworkConfigs.configs.browser().equalsIgnoreCase(Browser.CHROME.toString())) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (FrameworkConfigs.configs.browser().equalsIgnoreCase(Browser.FIREFOX.toString())) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new InvalidBrowserException(FrameworkConfigs.configs.browser() + " is not a valid browser !!!"); // use custom exception
            }


            DriverManager.setDriver(driver);
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
