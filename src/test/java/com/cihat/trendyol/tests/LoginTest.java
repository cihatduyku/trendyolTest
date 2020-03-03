package com.cihat.trendyol.tests;

import com.cihat.trendyol.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class LoginTest {

    private LoginPage loginPage;

    public LoginTest() {
        this.loginPage = new LoginPage();
    }

    @And("^Giriş popupında eposta alanına \"([^\"]*)\" yazılır$")
    public void girişPopupındaEpostaAlanınaYazılır(String arg0) {
        loginPage.setEmail(arg0);
    }

    @When("^Giriş popupında şifre alanına \"([^\"]*)\" yazılır$")
    public void girişPopupındaŞifreAlanınaYazılır(String arg0) {
        loginPage.setPassword(arg0);
    }

    @And("^Giriş popupında giriş yap butonuna tıklanır$")
    public void girişPopupındaGirişYapButonunaTıklanır() {
        loginPage.clickLoginButton();
    }

    @And("^Giriş popupının kapanması beklenir$")
    public void girişPopupınınKapanmasıBeklenir() {
        loginPage.waitLoginPopupClosed();
    }


}
