package com.cihat.trendyol.util;

import com.cihat.trendyol.tests.BaseTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageUtil {

    public WebDriver driver = BaseTest.getDriver();

    public void clickElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

   public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public List<WebElement> findElements(By selector)
    {
        return driver.findElements(selector);
    }

    public void MouseOver(WebElement we){
        Actions action = new Actions(driver);
        action.moveToElement(we).build().perform();
    }

    public void Wait(int millisecond) throws InterruptedException {
        Thread.sleep(millisecond);
    }

    public void waitElementInvisibility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    public void waitElementVisibility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void sendKeys(By selector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).sendKeys(text);
    }

    public void scrollTo(int x, int y){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo([0],[1])", x,y);
    }

    public void clickForcefully(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getText(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, BaseTest.DEFAULT_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).getText();
    }

    public boolean isElementDisplayed(By selector) {
        try {
            return driver.findElement(selector).isDisplayed();
        }catch (WebDriverException e){
            return false;
        }
    }

    public boolean checkImageDisplayed(WebElement element){
        return (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
    }

    public boolean checkImageBroken(WebElement element){
        try {
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            clientBuilder.disableCookieManagement();
            HttpClient client = clientBuilder.build();
            HttpGet request = new HttpGet(element.getAttribute("src"));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void sendKeys(Keys key){
        Actions action = new Actions(driver);
        action.sendKeys(key).perform();
    }
}
