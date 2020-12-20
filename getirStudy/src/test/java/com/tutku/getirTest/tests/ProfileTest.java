package com.tutku.getirTest.tests;

import com.tutku.getirTest.pagemodel.android.ProfilePage;
import com.tutku.getirTest.pagemodel.contracts.IProfilePage;
import com.tutku.getirTest.util.Util;
import cucumber.api.java.en.And;

public class ProfileTest extends Util {
    public IProfilePage profilePage;

    public ProfileTest() {
        this.profilePage = new ProfilePage();
    }

    @And("^Profil ekranında log out butonuna tıklanır$")
    public void profilEkranındaLogOutButonunaTıklanır() {
        profilePage.clickLogoutButton();
    }
}


