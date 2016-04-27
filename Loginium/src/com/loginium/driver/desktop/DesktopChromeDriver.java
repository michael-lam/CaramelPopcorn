package com.loginium.driver.desktop;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.loginium.LoginiumConstants.Platform;
import com.loginium.driver.DriverBase;
import com.loginium.driver.DriverSetting;

public class DesktopChromeDriver extends DriverBase {

	public DesktopChromeDriver(DriverSetting driverSetting) throws MalformedURLException {
		super(driverSetting);

		if (driverSetting.getRemoteURL() == null || driverSetting.getRemoteURL().equals("")) {
			File file = new File("");
			String path = "";
			if (driverSetting.getPlatform() == Platform.WINDOWS) {
				path = file.getAbsolutePath() + "\\src\\com\\loginium\\resource\\chromedriver_win32.exe";
			} else if (driverSetting.getPlatform() == Platform.MAC) {
				path = file.getAbsolutePath() + "\\core\\com\\loginium\\resource\\chromedriver_mac";
			} else {
				new UnsupportedOperationException(String.format("Cannot create Chrome driver instance on ", driverSetting.getPlatform()));
			}

			log.info("Picking up Chrome executable at " + path);
			System.setProperty("webdriver.chrome.driver", path);
			setWebDriver(new ChromeDriver());
		} else {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setVersion(driverSetting.getBrowserVersion());
			capabilities.setCapability(CapabilityType.PLATFORM, driverSetting.getPlatform());
			setWebDriver(new RemoteWebDriver(new URL(driverSetting.getRemoteURL()), capabilities));
		}
	}
}
