package com.tutku.getirTest.pagemodel.android;

import com.tutku.getirTest.pagemodel.contracts.IPaymentPage;
import com.tutku.getirTest.util.Util;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PaymentPage extends Util implements IPaymentPage {

    protected final By btnBack = By.id("com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView");
    protected final By txtAmountTitle = By.id("com.getir.casestudy.dev:id/tvAmountTitle");
    protected final By txtAmount = By.id("com.getir.casestudy.dev:id/tvAmount");
    protected final By txtAddressTitle = By.id("com.getir.casestudy.dev:id/tvAddressTitle");
    protected final By txtAddress = By.id("com.getir.casestudy.dev:id/tvAddress");
    protected final By txtPaymentMethodTitle = By.id("com.getir.casestudy.dev:id/tvPaymentMethodTitle");
    protected final By txtPaymentMethod = By.id("com.getir.casestudy.dev:id/tvPaymentMethod");
    protected final By btnOrderNow = By.id("com.getir.casestudy.dev:id/btnCheckout");

    @Override
    public void checkPaymentPage() {
        Assert.assertEquals("ödeme ekranındaki Amount başlığı görüntülenemedi!", "Amount", getText(txtAmountTitle));
        Assert.assertEquals("ödeme ekranındaki Adress başlığı görüntülenemedi!", "Address", getText(txtAddressTitle));
        Assert.assertEquals("ödeme ekranındaki PaymentMethod başlığı görüntülenemedi!", "Payment Method", getText(txtPaymentMethodTitle));
        Assert.assertEquals("ödeme ekranındaki PaymentMethod görüntülenemedi!", "Current Payment Method", getText(txtPaymentMethod));
        Assert.assertEquals("ödeme ekranındaki Adress görüntülenemedi!", "Current Address", getText(txtAddress));
        Assert.assertTrue("ödeme ekranındaki tutar görüntülenemedi!",getText(txtAmount).contains("₺"));
        Assert.assertTrue("Order now butonu görüntülenemedi!", isElementDisplayed(btnOrderNow));
    }

    @Override
    public void clickBackButton() {
        clickElement(btnBack);
    }
}
