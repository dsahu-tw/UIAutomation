package com.product.constants;

import com.product.utils.FrameworkConfigs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // private constructor so no one can access by creating object
public final class FrameworkConstants { // final class so no one can inherit the class and access variables

    private static final String TESTRESOURCEPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
    private static final String CHROMEDRIVERPATH = TESTRESOURCEPATH + File.separator + "executables" + File.separator + "chromedriver";
    private static final String CONFIGPATH = TESTRESOURCEPATH + File.separator + "configs" + File.separator + "config.properties";
    private static final Duration EXPLICITWAITTIMEOUT = Duration.ofSeconds(10);
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + File.separator + "extent-report-out";

    public static Duration getExplicitWaitTimeout() {
        return EXPLICITWAITTIMEOUT;
    }

    public static String getExtentReportPath() {
        if (FrameworkConfigs.configs.overrideExtentReport().equalsIgnoreCase("yes")) {
            return EXTENTREPORTPATH + File.separator + System.currentTimeMillis() + "index.html";
        }

        return EXTENTREPORTPATH + File.separator + "index.html";
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigPath() {
        return CONFIGPATH;
    }


}
