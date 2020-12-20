package com.tutku.getirTest.pagemodel.android;

import com.tutku.getirTest.pagemodel.contracts.ILoginPage;
import com.tutku.getirTest.util.Util;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends Util implements ILoginPage {


    protected final By edtUsername = By.id("com.getir.casestudy.dev:id/usernameEditText");
    protected final By edtPassword = By.id("com.getir.casestudy.dev:id/passwordEditText");
    protected final By btnSubmit = By.id("com.getir.casestudy.dev:id/loginButton");
    protected final By btnBasket = By.id("com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton");


    @Override
    public void setUsername(String username) {
        sendKeys(edtUsername, username);
    }

    @Override
    public void setPassword(String password) {
        sendKeys(edtPassword, password);
    }

    @Override
    public void clickSubmitButton() {
        clickElement(btnSubmit);
        forceWait(3);
//        waitElementInvisibility(btnSubmit);
    }

    @Override
    public void checkPageForNotLoggedIn() {
        Assert.assertTrue("Hatalı şifre girmesine rağmen kullanıcı login oldu!", isElementDisplayed(btnSubmit));
    }

    @Override
    public void checkLogouted() {
        Assert.assertTrue("Kullanıcı çıkış yapamadı!", isElementDisplayed(btnSubmit));
    }
}
