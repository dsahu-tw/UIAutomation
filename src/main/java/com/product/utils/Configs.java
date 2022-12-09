package com.product.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/configs/config.properties"
})
public interface Configs extends Config {
    @DefaultValue("qa")
    String environment();

    @DefaultValue("https://www.google.com/")
    @Key("${environment}.url")
    String url();

    @DefaultValue("No")
    String overrideExtentReport();

    @DefaultValue("Yes")
    String passedStepsScreenshot();

    @DefaultValue("Yes")
    String failedStepsScreenshot();

    @DefaultValue("Yes")
    String skippedStepsScreenshot();

    @DefaultValue("0")
    String failedTestRetryCount();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("remote")
    String executionType();

    @DefaultValue("http://localhost:4444/")
    @Key("${environment}.hubUrl")
    String hubUrl();


}


