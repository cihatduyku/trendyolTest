package com.cihat.trendyol.tests;

import com.cihat.trendyol.logger.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;


public class BaseTest {

    private static WebDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    private static final int DEFAULT_WAIT = 20;
    private static final String driverName = "webdriver.chrome.driver";
    private static final String googleDriverPath = "./driver/chromedriver";
    private static final String firefoxDriverPath = "./driver/firefoxdriver";
    private static final String baseUrl = "https://www.trendyol.com";

    public static WebDriver getDriver() {
        return driver;
    }

    public static int getDefaultWait(){
        return DEFAULT_WAIT;
    }

    @Before
    public void setup() {
        String browser = System.getProperty("BROWSER");
        if(browser==null)
        {
            browser = System.getenv("BROWSER");
            if(browser==null)
            {
                browser= "chrome";
            }
        }
        if(browser.equals("chrome")){
            System.setProperty(driverName, googleDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }
        else if(browser.equals("firefox")){
            System.setProperty(driverName, firefoxDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }

        driver.navigate().to(baseUrl);
        Log.info("Browser açılıyor...");

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File screenShotName = new File("src/test/resources/screenshots/" + scenario.getName() +"_"+ timeStamp + ".png");
            try {
                FileUtils.copyFile(scrFile, screenShotName);
            } catch (IOException e) {
                Log.info("Ekran görüntüsü kaydedilemedi...");
            }
        }
        driver.quit();
    }

}
