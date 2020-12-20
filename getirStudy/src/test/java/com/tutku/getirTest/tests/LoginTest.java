package com.tutku.getirTest.tests;

import com.tutku.getirTest.pagemodel.android.LoginPage;
import com.tutku.getirTest.pagemodel.contracts.ILoginPage;
import com.tutku.getirTest.util.Util;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginTest extends Util {

    public ILoginPage loginPage;

    public LoginTest() {
        this.loginPage = new LoginPage();
    }

    @Given("^Giriş ekranında username alanına \"([^\"]*)\" yazılır$")
    public void girişEkranındaUsernameAlanınaYazılır(String username) throws Throwable {
        loginPage.setUsername(username);
    }

    @When("^Giriş ekranında password alanına \"([^\"]*)\" yazılır$")
    public void girişEkranındaPasswordAlanınaYazılır(String password) throws Throwable {
        loginPage.setPassword(password);
    }

    @And("^Giriş ekranında submit butonuna tıklanır$")
    public void girişEkranındaSubmitButonunaTıklanır() {
        loginPage.clickSubmitButton();
    }

    @And("^Kullanıcının giriş yapamadığı kontrol edilir$")
    public void kullanıcınınGirişYapamadığıKontrolEdilir() {
        loginPage.checkPageForNotLoggedIn();
    }

    @And("^Kullanıcının çıkış yaptığı kontrol edilir$")
    public void kullanıcınınÇıkışYaptığıKontrolEdilir() {
        loginPage.checkLogouted();
    }
}
