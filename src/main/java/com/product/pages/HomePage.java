package com.product.pages;

import com.product.enums.WaitStraitgy;
import com.product.factories.WaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {


    private final By dropdownUser = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By about = By.xpath("//*[text()='About']");
    private final By support = By.xpath("//*[text()='Support']");
    private final By changePassword = By.xpath("//*[text()='Change Password']");
    private final By logout = By.xpath("//*[text()='Logout']");
    private final By brandLogo = By.xpath("//img[@alt='client brand banner']");


    public HomePage userDropdown() {
        click(dropdownUser, WaitStraitgy.CLICKABLE, "user dropdown", true);
        return this;


    }

    @SneakyThrows
    public AboutPage about() {
        click(about, WaitStraitgy.CLICKABLE, "about", true);
        return new AboutPage();
    }

    @SneakyThrows
    public ChangePasswordPage changePassword() {
        click(changePassword, WaitStraitgy.CLICKABLE, "change password", true);
        return new ChangePasswordPage();
    }

    @SneakyThrows
    public LoginPage logout() {
        click(logout, WaitStraitgy.CLICKABLE, "logout", true);
        return new LoginPage();
    }

    @SneakyThrows
    public HomePage isLogoPresent() {
        WaitFactory.performExplicitWait(WaitStraitgy.VISIBLE, brandLogo);
        return new HomePage();
    }


}
