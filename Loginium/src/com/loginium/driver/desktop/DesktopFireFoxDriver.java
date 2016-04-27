package com.loginium.driver.desktop;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.loginium.driver.DriverBase;
import com.loginium.driver.DriverSetting;

public class DesktopFireFoxDriver extends DriverBase {

	public DesktopFireFoxDriver(DriverSetting driverSetting) throws MalformedURLException {
		super(driverSetting);

		if (driverSetting.getRemoteURL() == null || driverSetting.getRemoteURL().equals("")) {
			setWebDriver(new FirefoxDriver());
		} else {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setVersion(driverSetting.getBrowserVersion());
			capabilities.setCapability(CapabilityType.PLATFORM, driverSetting.getPlatform());

			setWebDriver(new RemoteWebDriver(new URL(driverSetting.getRemoteURL()), capabilities));
		}
	}
}
