package com.tutku.getirTest.tests;

import com.tutku.getirTest.pagemodel.android.PaymentPage;
import com.tutku.getirTest.pagemodel.contracts.IPaymentPage;
import com.tutku.getirTest.util.Util;
import cucumber.api.java.en.And;

public class PaymentTest extends Util {
    public IPaymentPage paymentPage;

    public PaymentTest() {
        this.paymentPage = new PaymentPage();
    }

    @And("^Ödeme ekranı kontrol edilir$")
    public void ödemeEkranıKontrolEdilir() {
        paymentPage.checkPaymentPage();
    }

    @And("^Ödeme ekranındaki geri butonuna tıklanır$")
    public void ödemeEkranındakiGeriButonunaTıklanır() {
        paymentPage.clickBackButton();
    }
}
