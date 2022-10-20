package com.product.pages;

import com.product.enums.WaitStraitgy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class HomePage extends BasePage {

    private final WebDriver d;

    public HomePage(WebDriver driver) {
        this.d = driver;
        PageFactory.initElements(driver, this);

    }


    private final By dropdownUser = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By about = By.xpath("//*[text()='About']");
    private final By support = By.xpath("//*[text()='Support']");
    private final By changePassword = By.xpath("//*[text()='Change Password']");
    private final By logout = By.xpath("//*[text()='Logout']");


    public HomePage userDropdown() {
        click(dropdownUser, WaitStraitgy.CLICKABLE, "user dropdown", true);
        return this;
    }

    public AboutPage about() {
        click(about, WaitStraitgy.CLICKABLE, "about", true);
        return new AboutPage();
    }

    public ChangePasswordPage changePassword() {
        click(changePassword, WaitStraitgy.CLICKABLE, "change password", true);
        return new ChangePasswordPage();
    }

    public LoginPage logout() {
        click(logout, WaitStraitgy.CLICKABLE, "logout", true);
        return new LoginPage();
    }


}
