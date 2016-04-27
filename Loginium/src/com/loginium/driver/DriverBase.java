package com.loginium.driver;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase implements Driver {

	protected static Logger log = LogManager.getLogger();
	protected WebDriver webDriver;
	protected DriverSetting driverSetting;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	protected void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public DriverSetting getDriverSetting() {
		return driverSetting;
	}

	protected void setDriverSetting(DriverSetting driverSetting) {
		this.driverSetting = driverSetting;
	}

	public DriverBase(DriverSetting driverSetting) {
		setDriverSetting(driverSetting);
	}

	public void get(String url) {
		webDriver.get(url);
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		logStartAction(String.format("find elements: %s", by));
		List<WebElement> elems = webDriver.findElements(by);
		logEndAction(String.format("find elements: %s", by));
		return elems;
	}

	public WebElement findElement(By by) {
		logStartAction(String.format("find element: %s", by));
		WebElement elem = webDriver.findElement(by);
		logEndAction(String.format("find element: %s", by));
		return elem;
	}

	public String getPageSource() {
		logEndAction("get Page Source");
		return webDriver.getPageSource();
	}

	public void close() {
		logStartAction("close Window");
		webDriver.close();
		logEndAction("close Window");
	}

	public void quit() {
		logStartAction("quit browser");
		webDriver.quit();
		logEndAction("quit browser");
	}

	public Set<String> getWindowHandles() {
		logEndAction("get Window Handles");
		return webDriver.getWindowHandles();
	}

	public String getWindowHandle() {
		logEndAction("get Window Handle");
		return webDriver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return webDriver.switchTo();
	}

	public Navigation navigate() {
		return webDriver.navigate();
	}

	public Options manage() {
		return webDriver.manage();
	}

	private void logStartAction(String msg) {
		log.info("Executing: [{}]", msg);
	}

	private void logEndAction(String msg) {
		log.info("Done: [{}]", msg);
	}
}
