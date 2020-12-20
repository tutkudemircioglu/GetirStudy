package com.tutku.getirTest.tests;

import com.tutku.getirTest.pagemodel.android.HomePage;
import com.tutku.getirTest.pagemodel.contracts.IHomePage;
import com.tutku.getirTest.util.Util;
import cucumber.api.java.en.And;

public class HomeTest extends Util {

    public IHomePage homePage;

    public HomeTest() {
        this.homePage = new HomePage();
    }

    @And("^Giriş yapmış kullanıcı için ana ekran kontrol edilir$")
    public void girişYapmışKullanıcıIçinAnaEkranKontrolEdilir() {
        homePage.checkPageForLoggedIn();
    }

    @And("^Getir anasayfasında ([^\"]*) kategorisine tıklanır$")
    public void getirAnasayfasındaKategorisineTıklanır(String name) {
        homePage.clickCategoryByName(name);
    }

    @And("^Getir anasayfasında rastgele kategoriye tıklanır$")
    public void getirAnasayfasındaRastgeleÜrüneTıklanır() {
        homePage.clickRandomCategory();
    }

    @And("^Getir anasayfasında profil butonuna tıklanır$")
    public void getirAnasayfasındaProfilButonunaTıklanır() {
        homePage.clickProfileButton();
    }
}
