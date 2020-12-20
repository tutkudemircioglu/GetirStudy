package com.tutku.getirTest.pagemodel.contracts;


public interface ILoginPage {

    void setUsername(String arg0);

    void setPassword(String arg0);

    void clickSubmitButton();

    void checkPageForNotLoggedIn();

    void checkLogouted();
}
