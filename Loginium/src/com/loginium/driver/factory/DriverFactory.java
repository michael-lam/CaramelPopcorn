package com.loginium.driver.factory;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.loginium.LoginiumConstants.Platform;
import com.loginium.driver.Driver;
import com.loginium.driver.DriverSetting;

public abstract class DriverFactory {
	private static Logger log = LogManager.getLogger();

	public Driver createWebDriver(DriverSetting driverSetting) throws MalformedURLException, UnexpectedException {
		log.info("Executing: [create new Driver {browserName: {}, version: {}, platform: {}}]", driverSetting.getBrowserName(), driverSetting.getBrowserVersion(), driverSetting.getPlatform());
		Driver driver = initWebDriver(driverSetting);

		if (driver == null) {
			throw new UnexpectedException(
					String.format("driver cannot be null! Please check your setting.\r\nAvailable Browsers are %s. Available Platforms are %s.", Platform.values(), Platform.values()));
		}
		// "driver cannot be null. Please check your setting.\r\nAvailable
		// Browsers are FIREFOX, INTERNET_EXPLORER, SAFARI, CHROME, BROWSER.
		// Available Platforms are WINDOWS, MAC, ANDROID, IOS, LINUX.");
		log.info("Done: [create new Driver {browserName: {}, version: {}, platform: {}}]", driverSetting.getBrowserName(), driverSetting.getBrowserVersion(), driverSetting.getPlatform());
		return driver;
	}

	protected abstract Driver initWebDriver(DriverSetting driverSetting) throws MalformedURLException;
}
