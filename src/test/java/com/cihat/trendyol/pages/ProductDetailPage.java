package com.cihat.trendyol.pages;

import com.cihat.trendyol.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ProductDetailPage extends BasePageUtil{

    private final By areaSize = By.xpath("//span[contains(text(),'Seçiniz')]");
    private final By btnAddToCart = By.xpath("//div[contains(text(),'Sepete Ekle')]");
    private final By txtProductInfo = By.xpath("//div[contains(text(),'Ürün Bilgileri')]");
    private final By sizeItem = By.className("vrn-item");
    private final By btnAddedOnCart = By.id("basketItemCount");
    private Random random = new Random();

    public void selectSizeRandom() {
        waitElementVisibility(btnAddToCart);
        if(isElementDisplayed(areaSize)) {
            clickElement(areaSize);
            List<WebElement> lstSizeItem = findElements(sizeItem);
            int num = random.nextInt(lstSizeItem.size());
            clickElement(lstSizeItem.get(num));
        }
    }

    public void clickAddToCartButton() {
        clickElement(btnAddToCart);
    }

    public void checkProductAddedOnCartButton() {
        Assert.assertEquals("Sepete eklendikten sonra açılan popup görüntülenemedi!","1", getText(btnAddedOnCart));
    }

    public void checkPageOpened() {
        Assert.assertTrue("Ürün detay sayfası açılmadı!",isElementDisplayed(txtProductInfo));
    }
}
