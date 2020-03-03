package com.cihat.trendyol.pages;

import com.cihat.trendyol.util.BasePageUtil;
import org.openqa.selenium.By;


public class LoginPage extends BasePageUtil {

    private final By edtEmail = By.id("email");
    private final By edtPassword = By.id("password");
    private final By btnLogin = By.id("loginSubmit");


    public void setEmail(String email) {
        sendKeys(edtEmail,email);
    }

    public void setPassword(String password) {
        sendKeys(edtPassword,password);
    }

    public void clickLoginButton() {
        clickElement(btnLogin);
    }

    public void waitLoginPopupClosed() {
        waitElementInvisibility(btnLogin);
    }
}
