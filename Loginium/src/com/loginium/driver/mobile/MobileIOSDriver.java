package com.loginium.driver.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.loginium.driver.DriverBase;
import com.loginium.driver.DriverSetting;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileIOSDriver extends DriverBase {

	public MobileIOSDriver(DriverSetting driverSetting) throws MalformedURLException {
		super(driverSetting);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, driverSetting.getPlatform());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, driverSetting.getPlatformVersion());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, driverSetting.getDeviceName());
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, driverSetting.getBrowserName());
		capabilities.setCapability("safariInitialUrl", "http://www.google.com");		
		setWebDriver(new IOSDriver(new URL(driverSetting.getRemoteURL()), capabilities));	
	}
}
