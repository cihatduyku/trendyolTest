package com.cihat.trendyol.tests;

import com.cihat.trendyol.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class HomeTest {

    private HomePage homePage;

    public HomeTest() {
        this.homePage = new HomePage();
    }

    @Given("^Trendyol anasayfada cinsiyet popupı kapatılır$")
    public void trendyolAnasayfadaCinsiyetPopupıKapatılır() {
        homePage.clickCloseGenderSelectionPopup();
    }

    @Given("^Trendyol anasayfada cinsiyet popupı açıldığı kontrol edilir$")
    public void trendyolAnasayfadaCinsiyetPopupıAçıldığıKontrolEdilir() {
        homePage.checkGenderSelectionPopup();
    }

    @And("^Trendyol anasayfada giriş yap butonuna tıklanır$")
    public void trendyolAnasayfadaGirişYapButonunaTıklanır() {
        homePage.clickLoginButton();
    }

    @And("^Giriş yapmış kullanıcı için ana ekran kontrol edilir$")
    public void girişYapmışKullanıcıIçinAnaEkranKontrolEdilir() {
        homePage.checkPageForLoggedIn();
    }

    @And("^Bildirim popupı kapatılır$")
    public void bildirimPopupıKapatılır() {
        homePage.clickCloseNotificationPopup();
    }

    @And("^Trendyol anasayfasında ([^\"]*) tabına tıklanır$")
    public void trendyolAnasayfasındaTabınaTıklanır(String name) {
        homePage.clickTabByName(name);
    }

    @And("^Trendyol anasayfasında rastgele taba tıklanır$")
    public void trendyolAnasayfasındaRastgeleTabaTıklanır() {
        homePage.clickRandomTab();
    }

}
