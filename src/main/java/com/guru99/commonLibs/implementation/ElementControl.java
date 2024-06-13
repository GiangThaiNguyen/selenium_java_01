package com.guru99.commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
    WebDriver driver;

    public ElementControl(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void setText(WebElement element,String string) {
        element.sendKeys(string);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean isDisplay(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isEnable(WebElement element) {
        return element.isEnabled();
    }

    public void selectFromDropDown(WebElement element, String selection) {
        Select selDropDown = new Select(element);
        selDropDown.selectByVisibleText(selection);
    }
}
