package com.guru99.commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CommonDriver {
    private final WebDriver driver;
    private Duration pageLoadTimeout;
    private Duration elementPageLoadTimeout;

    public CommonDriver(String browserType) throws Exception {
        pageLoadTimeout = Duration.ofSeconds(10);
        elementPageLoadTimeout = Duration.ofSeconds(10);

        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Invalid browser type: " + browserType);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void navigateToUrl(String url) {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout);
        driver.manage().timeouts().implicitlyWait(elementPageLoadTimeout);
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Duration getElementPageLoadTimeout() {
        return elementPageLoadTimeout;
    }

    public void setElementPageLoadTimeout(Duration elementPageLoadTimeout) {
        this.elementPageLoadTimeout = elementPageLoadTimeout;
    }

    public Duration getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(Duration pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public String getTitleOfThePage() {
        return driver.getTitle();
    }

    public void closeAllBrowsers() {
        driver.quit();
    }
}
