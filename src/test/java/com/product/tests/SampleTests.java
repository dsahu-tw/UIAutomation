package com.product.tests;

import com.product.annotations.FrameworkAnnotations;
import com.product.enums.CategoryType;
import com.product.listeners.ListenerClass;
import com.product.pages.LoginPage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@NoArgsConstructor(access = AccessLevel.PRIVATE) // private constructor so no one can access by creating object
public final class SampleTests extends BaseTest { //final keyword to avoid extending test cases by some class


    @FrameworkAnnotations(author = {"Deepak", "Shyam"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test(dataProvider = "dp_test1", retryAnalyzer = ListenerClass.class, description = "Sample test - happy path")
    public void verifyPageTitleAfterLogoutHappyPath(String userName, String password, String pageTitle) {


        LoginPage loginPage = new LoginPage()
                .enterUserName(userName)
                .enterPassword(password)
                .login()
                .isLogoPresent()
                .userDropdown()
                .logout();

        String title = loginPage.getTitle();
        Assertions.assertThat(title)
                .as(title + "does not match")
                .isEqualTo(pageTitle);


    }

    @FrameworkAnnotations(author = {"Deepak", "Shyam"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test(dataProvider = "dp_test2", retryAnalyzer = ListenerClass.class, description = "Sample test - failing scenario")
    public void verifyPageTitleAfterLogoutFailed(String userName, String password, String pageTitle) {


        LoginPage loginPage = new LoginPage()
                .enterUserName(userName)
                .enterPassword(password)
                .login()
                .isLogoPresent()
                .userDropdown()
                .logout();

        String title = loginPage.getTitle();
        Assertions.assertThat(title)
                .as(title + "does not match")
                .isEqualTo(pageTitle);


    }


    @DataProvider(name = "dp_test1", parallel = true)
    public Object[][] data1() {
        return new Object[][]{{"admin", "admin123", "OrangeHRM"}};
    }

    @DataProvider(name = "dp_test2", parallel = true)
    public Object[][] data2() {
        return new Object[][]{{"admin", "admin123", "OrangeHR"}};
    }


}
