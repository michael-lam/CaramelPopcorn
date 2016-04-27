package com.loginium.driver;

import com.loginium.LoginiumConstants.Browser;
import com.loginium.LoginiumConstants.Platform;

public class DriverSetting {

	private Browser browserName;
	private String browserVersion;
	private Platform platform;
	private String platformVersion;
	private String remoteURL;
	private String deviceName;

	public Browser getBrowserName() {
		return browserName;
	}

	public void setBrowserName(Browser browserName) {
		this.browserName = browserName;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getRemoteURL() {
		return remoteURL;
	}

	public void setRemoteURL(String remoteURL) {
		this.remoteURL = remoteURL;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}
