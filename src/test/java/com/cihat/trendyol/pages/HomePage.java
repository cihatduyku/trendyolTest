package com.cihat.trendyol.pages;

import com.cihat.trendyol.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class HomePage extends BasePageUtil {

    private final By txtPopup = By.id("homepage-popup-text");
    private final By btnLogin = By.id("accountBtn");
    private final By areaLoggedIn = By.id("logged-in-container");
    private final By btnCloseOnNotificationPopup = By.className("modal-close");
    private final By tabItem = By.cssSelector(".main-nav .category-header");
    private Random random = new Random();
    private Map<String, Integer> tabNames = new HashMap<>();

    public HomePage() {
        tabNames.put("KADIN", 0);
        tabNames.put("ERKEK", 1);
        tabNames.put("ÇOCUK", 2);
        tabNames.put("AYAKKABI & ÇANTA", 3);
        tabNames.put("SAAT & AKSESUAR", 4);
        tabNames.put("KOZMETİK", 5);
        tabNames.put("EV & YASAM ", 6);
        tabNames.put("ELEKTRONİK", 7);
        tabNames.put("SÜPERMARKET", 8);
    }

    public void clickCloseGenderSelectionPopup() {
        sendKeys(Keys.ESCAPE);
        waitElementInvisibility(txtPopup);
    }

    public void checkGenderSelectionPopup() {
        Assert.assertEquals("Cinsiyet seçim popupı metni düzgün görüntülenmedi!",
                "Alışveriş deneyiminizi kolaylaştırmak için aşağıdaki seçeneklere bakabilirsiniz", getText(txtPopup));
    }

    public void clickLoginButton() {
        clickElement(btnLogin);
    }

    public void checkPageForLoggedIn() {
        Assert.assertTrue("Kullanıcı login olamadı", isElementDisplayed(areaLoggedIn));
    }

    public void clickCloseNotificationPopup() {
        clickElement(btnCloseOnNotificationPopup);
    }


    public void clickTabByName(String name) {
        int tabIndex = tabNames.get(name);
        WebElement tab = findElements(tabItem).get(tabIndex);
        clickElement(tab);
    }

    public void clickRandomTab() {
        List<WebElement> lstTabItem = findElements(tabItem);
        int randomTabNumber = random.nextInt(lstTabItem.size());
        clickElement(lstTabItem.get(randomTabNumber));
    }
}
