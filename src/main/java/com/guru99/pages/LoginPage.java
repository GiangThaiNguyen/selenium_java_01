package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @CacheLookup
    @FindBy(name="uid")
    private WebElement userID;

    @CacheLookup
    @FindBy(name="password")
    private WebElement password;

    @CacheLookup
    @FindBy(name="btnLogin")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication(String userName, String passWord) {
        elementControl.setText(userID, userName);
        elementControl.setText(password, passWord);
        elementControl.clickElement(loginBtn);
    }
}
