package com.tutku.getirTest.pagemodel.android;

import com.tutku.getirTest.pagemodel.contracts.ICategoryDetailPage;
import com.tutku.getirTest.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CategoryDetailPage extends Util implements ICategoryDetailPage {

    protected final By btnAddProduct = By.id("com.getir.casestudy.dev:id/btnAdd");
    protected final By txtProductTitle = By.id("com.getir.casestudy.dev:id/tvTitle");
    protected final By btnBasket = By.id("com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton");
    private static Random random = new Random();


    @Override
    public void clickAddToRandomProduct() {
        waitElementVisibility(btnAddProduct);
        List<WebElement> productlist = findElements(btnAddProduct);
        int randomProductNumber = random.nextInt(productlist.size());
        clickElement(productlist.get(randomProductNumber));
    }

    @Override
    public void clickBasketButton() {
        clickElement(btnBasket);
        forceWait(2);
    }
}
