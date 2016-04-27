package com.loginium.driver;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.loginium.LoginiumConstants.Platform;
import com.loginium.driver.factory.DesktopDriverFactory;
import com.loginium.driver.factory.DriverFactory;
import com.loginium.driver.factory.MobileDriverFactory;

public class DriverManager {

	private static Map<Long, Driver> driverMap = new ConcurrentHashMap<Long, Driver>();
	
	public static synchronized void storeWebDriver(Driver driver) {
		driverMap.put(Thread.currentThread().getId(), driver);
	}

	public static synchronized Driver getWebDriver() {
		return driverMap.get(Thread.currentThread().getId());
	}

	public static synchronized void removeWebDriver() {
		driverMap.remove(Thread.currentThread().getId());
	}

	public static synchronized void createWebDriver(DriverSetting driverSetting) throws MalformedURLException, UnexpectedException {
		DriverFactory driverFactory = null;
		Driver driver = null;

		if (driverSetting.getPlatform() == Platform.IOS || driverSetting.getPlatform() == Platform.ANDROID) {
			driverFactory = new MobileDriverFactory();
		} else if (driverSetting.getPlatform() == Platform.LINUX || driverSetting.getPlatform() == Platform.WINDOWS || driverSetting.getPlatform() == Platform.MAC) {
			driverFactory = new DesktopDriverFactory();
		}
//		else {
//			new UnsupportedOperationException(String.format("Invalid Platform name \"%s\". Available Platforms are: \"%s\"", driverSetting.getPlatform(), Platform.values()));
//		}

		driver = driverFactory.createWebDriver(driverSetting);
		storeWebDriver(driver);
	}
}
