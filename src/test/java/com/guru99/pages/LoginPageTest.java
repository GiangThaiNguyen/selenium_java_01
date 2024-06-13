package com.guru99.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyUserLoginWithCorrectCredential() {
        loginPage = new LoginPage(driver);
        String userName = configProperty.getProperty("userName");
        String passWord = configProperty.getProperty("password");
        loginPage.loginToApplication(userName, passWord);

        String expectedTitle = "Guru99 Bank Manager HomePage";
        String actualTitle = cmmDriver.getTitleOfThePage();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
