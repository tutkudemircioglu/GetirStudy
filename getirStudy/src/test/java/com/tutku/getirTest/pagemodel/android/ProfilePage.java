package com.tutku.getirTest.pagemodel.android;

import com.tutku.getirTest.pagemodel.contracts.IProfilePage;
import com.tutku.getirTest.util.Util;
import org.openqa.selenium.By;

public class ProfilePage extends Util implements IProfilePage {

    protected final By btnLogout = By.id("com.getir.casestudy.dev:id/itemLogout");

    @Override
    public void clickLogoutButton() {
        clickElement(btnLogout);
    }
}
