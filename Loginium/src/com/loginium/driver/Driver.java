package com.loginium.driver;

import org.openqa.selenium.WebDriver;

public interface Driver extends WebDriver {
	WebDriver getWebDriver();
	DriverSetting getDriverSetting();
}
