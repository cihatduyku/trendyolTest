package com.cihat.trendyol.pages;

import com.cihat.trendyol.logger.Log;
import com.cihat.trendyol.util.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class TabPage extends BasePageUtil {

    public final By boutiqueItem = By.cssSelector("[class='component-list component-big-list'] [class='component-item']");
    private Random random = new Random();

    public void checkAllBoutiqueImageByOrder() {
        for (WebElement element : findElements(boutiqueItem)) {
            Log.info("Butik resimleri kontrol ediliyor...");

            if(!checkImageDisplayed(element.findElement(By.tagName("img")))){
                Log.warn("Butik resmi görüntülenemedi!");
            }

            if(!checkImageBroken(element.findElement(By.tagName("img")))){
                Log.warn("Butik resmi için http 200 cevabı alınamıyor!");
            }

        }

    }

    public void clickRandomBoutique() {
        waitElementVisibility(boutiqueItem);
        List<WebElement> boutiqueList = findElements(boutiqueItem);
        int randomBoutiqueNumber= random.nextInt(boutiqueList.size());
        clickElement(boutiqueList.get(randomBoutiqueNumber));
    }
}
