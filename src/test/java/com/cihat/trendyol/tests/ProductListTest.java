package com.cihat.trendyol.tests;

import com.cihat.trendyol.pages.ProductListPage;
import cucumber.api.java.en.And;

public class ProductListTest {


    private ProductListPage productListPage;

    public ProductListTest() {
        this.productListPage = new ProductListPage();
    }

    @And("^Ürünlerin imajları kontrol edilir$")
    public void ürenlerinImajlarıKontrolEdilir() {
        productListPage.checkProductImages();
    }

    @And("^Ürünlerin içerisinden rastgele seçim yapılır$")
    public void ürünlerinIçerisindenRastgeleSeçimYapılır() {
        productListPage.clickRandomProduct();
    }

}
