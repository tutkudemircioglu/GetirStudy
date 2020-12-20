package com.tutku.getirTest.util;

import com.tutku.getirTest.tests.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Util {
    public AppiumDriver driver = BaseTest.getAppiumDriver();
    public int defaultWait = BaseTest.getDefaultWait();
    public boolean deviceNameAndroid = BaseTest.getDeviceNameAndroid();


    protected void sendKeys(By selector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clickElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    protected List<WebElement> findElements(By selector) {
        return driver.findElements(selector);
    }

    protected void forceWait(int timeout) {
        try {
            Thread.sleep((timeout * 1000));
        } catch (InterruptedException var) {
        }
    }

    protected boolean isElementDisplayed(By selector) {
        try {
            return driver.findElement(selector).isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    protected String getText(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).getText();
    }

    public enum DIRECTION {
        DOWN, UP;
    }

    protected void swipe(MobileDriver driver, DIRECTION direction, Duration duration) {
        Dimension size = driver.manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = (size.width / 2);

                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;


            case DOWN:
                startY = (int) (size.height * 0.70);
                endY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;
        }
    }

    protected boolean isElementVisible(By selector) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWait);
             wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return true;
        } catch (Exception var4) {
            return false;
        }
    }

    protected void waitElementInvisibility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    protected void waitElementVisibility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected void waitElementClickable(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }
}
