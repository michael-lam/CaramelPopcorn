package com.loginium.driver.factory;

import java.net.MalformedURLException;

import com.loginium.LoginiumConstants.Platform;
import com.loginium.driver.Driver;
import com.loginium.driver.DriverSetting;
import com.loginium.driver.mobile.MobileAndroidDriver;
import com.loginium.driver.mobile.MobileIOSDriver;

public class MobileDriverFactory extends DriverFactory {

	@Override
	public Driver initWebDriver(DriverSetting driverSetting) throws MalformedURLException {
		Driver driver = null;

		if (driverSetting.getPlatform() == Platform.IOS)
			driver = new MobileIOSDriver(driverSetting);
		else if (driverSetting.getPlatform() == Platform.ANDROID)
			driver = new MobileAndroidDriver(driverSetting);
		else {
			System.out.printf("Cannot create Mobile driver for browser %s with remote URL %s.\n",
					driverSetting.getBrowserName(), driverSetting.getRemoteURL());
		}

		return driver;
	}
}
