package com.product.driver;

import com.product.enums.Browser;
import com.product.exceptions.InvalidBrowserException;
import com.product.utils.CommonUtils;
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
import java.util.Objects;

import static com.product.enums.Browser.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class DriverFactory {
    private  WebDriver driver = null;

    @SneakyThrows
    public static  WebDriver getDriver(String browser) {

        String executionType = getExecutionType();
        DesiredCapabilities cap = new DesiredCapabilities();

        switch (mapBrowserName(browser)) {
            case CHROME:
                if (executionType.equalsIgnoreCase("remote")) {
                    cap.setBrowserName(CHROME.toString().toLowerCase());
                    URL hubUrl = new URL(FrameworkConfigs.configs.hubUrl());
                    return new RemoteWebDriver(hubUrl, cap);
                } else {
                    WebDriverManager.chromedriver().setup();
                    return   new ChromeDriver();
                }


            case FIREFOX:
                if (executionType.equalsIgnoreCase("remote")) {
                    cap.setBrowserName(FIREFOX.toString().toLowerCase());
                    URL hubUrl = new URL(FrameworkConfigs.configs.hubUrl());
                    return new RemoteWebDriver(hubUrl, cap);
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                }
            case EDGE:
                if (executionType.equalsIgnoreCase("remote")) {
                    cap.setBrowserName(EDGE.toString().toLowerCase());
                    URL hubUrl = new URL(FrameworkConfigs.configs.hubUrl());
                    return new RemoteWebDriver(hubUrl, cap);
                } else {
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
                }
            default:
                throw new InvalidBrowserException(FrameworkConfigs.configs.browser() + " is not a valid browser !!!"); // use custom exception
        }


    }

    @SneakyThrows
    private static Browser mapBrowserName(String browser) {
        try {
            return Browser.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidBrowserException(FrameworkConfigs.configs.browser() + " is not a valid browser !!!");
        }
    }

    @SneakyThrows
    private static String getExecutionType() {
        String executionType = CommonUtils.getParameter("executionType");
        if (Objects.nonNull(executionType) && (!executionType.isEmpty()))
            return executionType;
        else
            return FrameworkConfigs.configs.executionType();
    }
}
