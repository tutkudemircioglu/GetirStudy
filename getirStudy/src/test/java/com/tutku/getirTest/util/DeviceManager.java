package com.tutku.getirTest.util;

import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;

import java.io.IOException;

public class DeviceManager {
    private static Device deviceName;


    public static Device getDeviceInfo() {
        if (deviceName == null) {
            DeviceInfoImpl deviceInfo = new DeviceInfoImpl(DeviceType.ALL);

            try {
                deviceName = deviceInfo.getFirstDevice();
                System.out.println("getFirstDevice   :"+deviceName);
            } catch (IOException var2) {
                var2.printStackTrace();
            } catch (DeviceNotFoundException var3) {
                var3.printStackTrace();
            }
        }
        return deviceName;
    }
}
