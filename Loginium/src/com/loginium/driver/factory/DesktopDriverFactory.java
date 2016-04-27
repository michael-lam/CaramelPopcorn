package com.loginium.driver.factory;

import java.net.MalformedURLException;

import com.loginium.driver.Driver;
import com.loginium.driver.DriverSetting;
import com.loginium.driver.desktop.DesktopChromeDriver;
import com.loginium.driver.desktop.DesktopFireFoxDriver;
import com.loginium.driver.desktop.DesktopInternetExplorerDriver;
import com.loginium.driver.desktop.DesktopSafariDriver;

public class DesktopDriverFactory extends DriverFactory{

	@Override
	protected Driver initWebDriver(DriverSetting driverSetting) throws MalformedURLException {
		Driver driver = null;

		switch (driverSetting.getBrowserName()) {
		case FIREFOX:
			driver = new DesktopFireFoxDriver(driverSetting);
			break;
		case INTERNET_EXPLORER:
			driver = new DesktopInternetExplorerDriver(driverSetting);
			break;
		case CHROME:
			driver = new DesktopChromeDriver(driverSetting);
			break;
		case SAFARI:
			driver = new DesktopSafariDriver(driverSetting);
			break;
		default:
			System.out.printf("Cannot create Local Local/Remote driver for browser %s on %s.\n", driverSetting.getBrowserName(),
					driverSetting.getPlatform());
		}

		return driver;
	}
}
