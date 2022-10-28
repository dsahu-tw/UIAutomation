package com.product.driver;

import com.product.enums.Browser;
import com.product.exceptions.InvalidBrowserException;
import com.product.utils.FrameworkConfigs;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.openqa.selenium.remote.BrowserType.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {
    private static WebDriver driver = null;

    @SneakyThrows
    public static WebDriver getDriver(String browser) {

        String executionType = FrameworkConfigs.configs.executionType();
        URL hubUrl = new URL("http://localhost:4444/");


        if (browser.equalsIgnoreCase(Browser.CHROME.toString())) {
            if (executionType.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(CHROME);
                driver = new RemoteWebDriver(hubUrl, cap);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase(Browser.FIREFOX.toString())) {
            if (executionType.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(FIREFOX);
                driver = new RemoteWebDriver(hubUrl, cap);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (browser.equalsIgnoreCase(Browser.EDGE.toString())) {
            if (executionType.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(EDGE);
                driver = new RemoteWebDriver(hubUrl, cap);
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        } else {
            throw new InvalidBrowserException(FrameworkConfigs.configs.browser() + " is not a valid browser !!!"); // use custom exception
        }
        return driver;
    }
}
