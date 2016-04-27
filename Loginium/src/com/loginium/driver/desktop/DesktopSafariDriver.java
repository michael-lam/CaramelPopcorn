package com.loginium.driver.desktop;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.loginium.driver.DriverBase;
import com.loginium.driver.DriverSetting;

public class DesktopSafariDriver extends DriverBase {

	public DesktopSafariDriver(DriverSetting driverSetting) throws MalformedURLException {
		super(driverSetting);

		if (driverSetting.getRemoteURL() == null || driverSetting.getRemoteURL().equals("")) {
			setWebDriver(new SafariDriver());
		} else {

			DesiredCapabilities capabilities = DesiredCapabilities.safari();
			capabilities.setVersion(driverSetting.getBrowserVersion());
			capabilities.setCapability(CapabilityType.PLATFORM, driverSetting.getPlatform());
			setWebDriver(new RemoteWebDriver(new URL(driverSetting.getRemoteURL()), capabilities));
		}
	}
}
