package com.guru99.pages;

import com.guru99.commonLibs.implementation.CommonDriver;
import com.guru99.commonLibs.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    CommonDriver cmmDriver;
    LoginPage loginPage;
    String currentWorkingDirectory;
    String configFileName;
    Properties configProperty;

    @BeforeSuite
    public void preSetup() throws IOException {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/src/test/java/com/guru99/configs/config.properties";
        configProperty = ConfigUtils.readProperty(configFileName);
    }

    @BeforeTest
    public void setup() throws Exception {
        cmmDriver = new CommonDriver(configProperty.getProperty("browserType"));
        driver = cmmDriver.getDriver();
        cmmDriver.navigateToUrl(configProperty.getProperty("baseUrl"));
    }

    @AfterTest
    public void tearDown() {
        cmmDriver.closeAllBrowsers();
    }
}
