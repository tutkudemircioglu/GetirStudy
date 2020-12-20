package com.tutku.getirTest.tests;

import com.tutku.getirTest.pagemodel.android.BasketPage;
import com.tutku.getirTest.pagemodel.contracts.IBasketPage;
import com.tutku.getirTest.pagemodel.contracts.ICategoryDetailPage;
import com.tutku.getirTest.util.Util;
import cucumber.api.java.en.And;

public class BasketTest extends Util {

    public IBasketPage basketPage;
    public ICategoryDetailPage categoryDetailPage;

    public BasketTest() {
        this.basketPage = new BasketPage();
    }

    @And("^Sepet ekranında eklenen ürünler kontrol edilir$")
    public void sepetEkranındaEklenenÜrünlerKontrolEdilir() {
        basketPage.checkProductOnBasket();
    }

    @And("^Sepet ekranında eklenen ürünler silinir$")
    public void sepetEkranındaEklenenÜrünlerSilinir() {
        basketPage.clickRemoveButton();
    }

    @And("^Sepet ekranında tüm ürünlerin silindiği kontrol edilir$")
    public void sepetEkranındaTümÜrünlerinSilindiğiKontrolEdilir() {
        basketPage.checkRemovedProduct();
    }

    @And("^Sepet ekranındaki payment butonuna tıklanır$")
    public void sepetEkranındakiPaymentButonunaTıklanır() {
        basketPage.clickPaymentButton();
    }

    @And("^Sepet ekranında eklenen ürünler birer tane arttırılır$")
    public void sepetEkranındaEklenenÜrünlerBirerTaneArttırılır() {
        basketPage.productIncreased();
    }

    @And("^Sepet ekranında arttırılan ürünler kontrol edilir$")
    public void sepetEkranındaArttırılanÜrünlerKontrolEdilir() {
        basketPage.checkProductIncreased();
    }
}
