package com.tutku.getirTest.tests;

import com.tutku.getirTest.pagemodel.android.CategoryDetailPage;
import com.tutku.getirTest.pagemodel.contracts.ICategoryDetailPage;
import com.tutku.getirTest.util.Util;
import cucumber.api.java.en.And;

public class CategoryDetailTest extends Util {
    public ICategoryDetailPage categoryDetailPage;

    public CategoryDetailTest() {
        this.categoryDetailPage = new CategoryDetailPage();
    }

    @And("^([^\"]*) kategorisinden rastgele bir ürün sepete eklenir$")
    public void categoriesKategorisindenRastgeleBirÜrünSepeteEklenir(String arg0) {
        categoryDetailPage.clickAddToRandomProduct();
    }

    @And("^Kategori detay ekranındaki sepetim butonuna tıklanır$")
    public void kategoriDetayEkranındakiSepetimButonunaTıklanır() {
        categoryDetailPage.clickBasketButton();

    }

    @And("^Kategori detay ekranında rasgele bir ürün sepete eklenir$")
    public void kategoriDetayEkranındaRasgeleBirÜrünSepeteEklenir() {
        categoryDetailPage.clickAddToRandomProduct();
    }
}
