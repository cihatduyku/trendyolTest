package com.cihat.trendyol.pages;

import com.cihat.trendyol.logger.Log;
import com.cihat.trendyol.util.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ProductListPage extends BasePageUtil{

    private final By productItem = By.cssSelector("[class='products'] [class='boutique-product']");
    private Random random = new Random();


    public void checkProductImages() {
        waitElementVisibility(productItem);
        System.out.println(findElements(productItem).size());
        for (WebElement element : findElements(productItem)) {
            Log.info("Butik resimleri kontrol ediliyor...");

            if(!checkImageDisplayed(element.findElement(By.tagName("img")))){
                Log.warn("Butik resmi görüntülenemedi!");
            }

            if(!checkImageBroken(element.findElement(By.tagName("img")))){
                Log.warn("Butik resmi için http 200 cevabı alınamıyor!");
            }

        }

    }

    public void clickRandomProduct() {
        waitElementVisibility(productItem);
        List<WebElement> productList = findElements(productItem);
        int randomProductNumber = random.nextInt(productList.size());
        clickElement(productList.get(randomProductNumber));
    }
}
