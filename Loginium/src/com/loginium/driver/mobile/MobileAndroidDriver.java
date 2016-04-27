package com.loginium.driver.mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.loginium.driver.DriverBase;
import com.loginium.driver.DriverSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAndroidDriver extends DriverBase {

	public MobileAndroidDriver(DriverSetting driverSetting) throws MalformedURLException {
		super(driverSetting);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, WordUtils.capitalize(driverSetting.getPlatform().toString().toLowerCase()));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, driverSetting.getPlatformVersion());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, driverSetting.getDeviceName());
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, WordUtils.capitalize(driverSetting.getBrowserName().toString().toLowerCase()));
		setWebDriver(new AndroidDriver(new URL(driverSetting.getRemoteURL()), capabilities));
	}
}
