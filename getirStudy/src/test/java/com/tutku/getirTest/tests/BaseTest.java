package com.tutku.getirTest.tests;

import com.testinium.deviceinformation.model.Device;
import com.tutku.getirTest.logger.Log;
import com.tutku.getirTest.util.DeviceManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static AppiumDriver appiumDriver;
    private static final int DEFAULT_WAIT = 20;
    private static boolean deviceNameAndroid;

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public static int getDefaultWait() {
        return DEFAULT_WAIT;
    }

    public static boolean getDeviceNameAndroid(){
        return deviceNameAndroid;
    }

    @Before
    public void setUp() throws Exception {

        if (StringUtils.isEmpty(System.getProperty("key"))) {
            Device device = DeviceManager.getDeviceInfo();
            if (deviceNameAndroid = device.getDeviceProductName().equalsIgnoreCase("Android")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S9");
                capabilities.setCapability(MobileCapabilityType.VERSION, "9");
                capabilities.setCapability(MobileCapabilityType.UDID, "2ca4ed6e08037ece");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.getir.casestudy.dev");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.getir.casestudy.modules.splash.ui.SplashActivity");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 250);

                URL url = new URL("http://localhost:4723/wd/hub");
                appiumDriver = new AndroidDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(60l, TimeUnit.SECONDS);
            } else {
                DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                capabilities.setCapability("xcodeOrgId", "PMLH8MF4G9");
                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                capabilities.setCapability("bundleId", "");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone8");
                capabilities.setCapability(MobileCapabilityType.UDID, "82d7f770d4d847265c25b60ff0bd3316720d8b07");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 250);

                URL url = new URL("http://localhost:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(60l, TimeUnit.SECONDS);
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File screenShotName = new File("src/test/resources/screenshots/" + scenario.getName() +"_"+ timeStamp + ".png");
            try {
                FileUtils.copyFile(scrFile, screenShotName);
            } catch (IOException e) {
                Log.info("Ekran görüntüsü kaydedilemedi...");
            }
        }
        appiumDriver.quit();
    }
}
