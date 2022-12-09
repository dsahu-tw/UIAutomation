package com.product.pages;

import com.product.enums.WaitStraitgy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    private final By textboxUserName = By.name("username");
    private final By textboxPassword = By.name("password");
    private final By btnLogin = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");


    @SneakyThrows
    public LoginPage enterUserName(String userName) {
        sendKeys(textboxUserName, WaitStraitgy.CLICKABLE, userName, "user name", true);
        return this;
    }

    @SneakyThrows
    public LoginPage enterPassword(String password) {
        sendKeys(textboxPassword, WaitStraitgy.CLICKABLE, password, "password", true);
        return this;
    }

    @SneakyThrows
    public HomePage login() {
        click(btnLogin, WaitStraitgy.CLICKABLE, "login", true);
//        clickByActions(btnLogin, WaitStraitgy.CLICKABLE, "login", true);
        return new HomePage();
    }

    @SneakyThrows
    public boolean isLoginBtnPresent() {
        return isElementPresent(btnLogin, WaitStraitgy.PRESENCE, "login", false);

    }

    @SneakyThrows
    public String getTitle() {
       return getPageTitle();

    }


}
