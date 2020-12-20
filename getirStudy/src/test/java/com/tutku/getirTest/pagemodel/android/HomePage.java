package com.tutku.getirTest.pagemodel.android;

import com.tutku.getirTest.pagemodel.contracts.IHomePage;
import com.tutku.getirTest.util.Util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class HomePage extends Util implements IHomePage {

    protected final By categoryItem = By.className("android.widget.TextView");
    protected final By btnProfile = By.id("com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView");
    private Random random = new Random();
    private Map<String, Integer> categoryName = new HashMap<>();

    public HomePage() {
        categoryName.put("Meyve ve Sebze", 0);
        categoryName.put("Atıştırmalık", 1);
        categoryName.put("Dondurma", 2);
        categoryName.put("Yiyecek", 3);
        categoryName.put("İçecek", 4);
        categoryName.put("Fit & Form", 5);
        categoryName.put("Süt & Kahvaltı", 6);
        categoryName.put("Temel Gıda", 7);
        categoryName.put("Kişisel Bakım", 8);
        categoryName.put("Ev & Yaşam", 9);
        categoryName.put("Ev Bakım", 10);
        categoryName.put("Teknoloji", 11);
        categoryName.put("Bebek", 12);
    }

    public void checkPageForLoggedIn() {
        Assert.assertTrue("Kullanıcı login olamadı", isElementDisplayed(btnProfile));
    }

    public void clickCategoryByName(String name) {
        int productIndex = categoryName.get(name);

            if (productIndex<10) {
                WebElement product = findElements(categoryItem).get(productIndex);
                clickElement(product);
            } else {
                swipe(driver, DIRECTION.DOWN, Duration.ofMillis(3000));
                WebElement product = findElements(categoryItem).get(productIndex);
                clickElement(product);
            }
    }

    public void clickRandomCategory() {
        List<WebElement> lstCategory = findElements(categoryItem);
        int randomCategoryNumber = random.nextInt(lstCategory.size());
        clickElement(lstCategory.get(randomCategoryNumber));
    }

    @Override
    public void clickProfileButton() {
        clickElement(btnProfile);
    }
}
