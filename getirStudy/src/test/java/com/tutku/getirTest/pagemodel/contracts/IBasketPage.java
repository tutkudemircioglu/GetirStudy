package com.tutku.getirTest.pagemodel.contracts;

public interface IBasketPage {

    void checkProductOnBasket();

    void clickRemoveButton();

    void checkRemovedProduct();

    void clickPaymentButton();

    void productIncreased();

    void checkProductIncreased();
}
