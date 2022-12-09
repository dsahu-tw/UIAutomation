package com.product.tests;

import com.product.driver.Driver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //So this class can only be extended and object can not be created
public class BaseTest {


    @BeforeMethod
    public void setUp() {
        Driver.initDriver();

    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();

    }

}
