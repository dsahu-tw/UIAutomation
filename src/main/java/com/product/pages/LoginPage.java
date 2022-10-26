package com.product.pages;

import com.product.driver.DriverManager;
import com.product.enums.WaitStraitgy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    private final By textboxUserName = By.name("username");
    private final By textboxPassword = By.name("password");
    private final By btnLogin = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");


    @SneakyThrows
    public LoginPage enterUserName(String userName) {
//      wait.until(d->d.textboxUserName.isEnabled());textboxUserName.sendKeys(userName);
        sendKeys(textboxUserName, WaitStraitgy.CLICKABLE, userName, "user name", true);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(textboxPassword, WaitStraitgy.CLICKABLE, password, "password", true);
        return this;
    }

    public HomePage login() {
        click(btnLogin, WaitStraitgy.CLICKABLE, "login", true);
        return new HomePage();
    }


}
