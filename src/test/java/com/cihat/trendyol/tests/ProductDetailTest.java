package com.cihat.trendyol.tests;

import com.cihat.trendyol.pages.ProductDetailPage;
import cucumber.api.java.en.And;

public class ProductDetailTest {

    private ProductDetailPage productDetailPage;

    public ProductDetailTest() {
        this.productDetailPage = new ProductDetailPage();
    }
    
    @And("^Ürün sayfasında beden seçimi yapılır$")
    public void ürünSayfasındaBedenSeçimiYapılır() {
        productDetailPage.selectSizeRandom();
    }

    @And("^Ürün sayfasında sepete ekle butonuna tıklanır$")
    public void ürünSayfasındaSepeteEkleButonunaTıklanır() {
        productDetailPage.clickAddToCartButton();
    }

    @And("^Ürün sayfasında sepete eklendi butonu kontrol edilir$")
    public void ürünSayfasındaSepeteEklendiButonuKontrolEdilir() {
        productDetailPage.checkProductAddedOnCartButton();
    }

    @And("^Ürün detay sayfasının açıldığı kontrol edilir$")
    public void ürünDetaySayfasınınAçıldığıKontrolEdilir() {
        productDetailPage.checkPageOpened();
    }
}
