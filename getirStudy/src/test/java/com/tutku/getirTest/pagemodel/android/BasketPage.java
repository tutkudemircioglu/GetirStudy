package com.tutku.getirTest.pagemodel.android;

import com.tutku.getirTest.pagemodel.contracts.IBasketPage;
import com.tutku.getirTest.util.Util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class BasketPage extends Util implements IBasketPage {

    protected final By txtProductCount = By.id("com.getir.casestudy.dev:id/tvCount");
    protected final By btnRemove = By.id("com.getir.casestudy.dev:id/btnRemove");
    protected final By btnAdd = By.id("com.getir.casestudy.dev:id/btnAdd");
    protected final By btnPayment = By.id("com.getir.casestudy.dev:id/btnCheckout");
    protected final By txtResult = By.id("com.getir.casestudy.dev:id/tvTitle");


    @Override
    public void checkProductOnBasket() {
        List<WebElement> productCountList = findElements(txtProductCount);
        for (int i = 0; i < productCountList.size(); i++) {
            Assert.assertEquals("Sepette eklenen ürün görüntülenemedi!", "1", productCountList.get(i).getText());
        }
    }

    @Override
    public void clickRemoveButton() {
        int count = Integer.parseInt(getText(txtProductCount));
        for (int i = 0; i < count; i++) {
            if (isElementVisible(btnRemove)) {
                clickElement(btnRemove);
            } else {
                break;
            }
        }
    }

    @Override
    public void checkRemovedProduct() {
        Assert.assertEquals("Ürünler silinmedi!", "There is no result", getText(txtResult));
    }

    @Override
    public void clickPaymentButton() {
        clickElement(btnPayment);
    }

    @Override
    public void productIncreased() {
        List<WebElement> addButtonList = findElements(btnAdd);
        for (int i = 0; i < addButtonList.size(); i++) {
            clickElement(addButtonList.get(i));
        }
    }

    @Override
    public void checkProductIncreased() {
        List<WebElement> productCountList = findElements(txtProductCount);
        for (int i = 0; i < productCountList.size(); i++) {
            Assert.assertEquals("Sepette eklenen ürün görüntülenemedi!", "2", productCountList.get(i).getText());
        }
    }
}
