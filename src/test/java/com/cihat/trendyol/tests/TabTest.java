package com.cihat.trendyol.tests;

import com.cihat.trendyol.pages.TabPage;
import cucumber.api.java.en.And;

public class TabTest {


    private TabPage tabPage;

    public TabTest() {
        this.tabPage = new TabPage();
    }

    @And("^([^\"]*) tabının butik imajları kontrol edilir$")
    public void tabnameTabininButikImajlariKontrolEdilir(String arg0) {
        tabPage.checkAllBoutiqueImageByOrder();

    }

    @And("^Tabdan rastgele butiğe tıklanır$")
    public void tabdanRastgeleButigeTiklanir() {
        tabPage.clickRandomBoutique();
    }
}
