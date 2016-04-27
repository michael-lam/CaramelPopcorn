package com.loginium.element;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import com.loginium.LoginiumConstants.LocatorType;
import com.loginium.driver.DriverManager;

public class Element implements WebElement {

	private static Logger log = LogManager.getLogger();
	private final Locator locator;

	public Locator getLocator() {
		return locator;
	}

	public Element(Locator locator) {
		this.locator = locator;
	}

	public Element(LocatorType type, String value) {
		this.locator = new Locator(type, value);
	}

	public Element(String xpath) {
		this.locator = new Locator(LocatorType.XPATH, xpath);
	}

	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return getWebElement().getScreenshotAs(target);
	}

	public void click() {
		logStartAction(String.format("click: %s", locator.getBy()));	
		getWebElement().click();
		logEndAction(String.format("click: %s", locator.getBy()));
	}
	
	public void submit() {
		logStartAction(String.format("submit: %s", locator.getBy()));
		getWebElement().submit();
		logEndAction(String.format("submit: %s", locator.getBy()));
	}

	public void sendKeys(CharSequence... keysToSend) {
		logStartAction(String.format("send \"%s\" to: %s", keysToSend.toString(), locator.getBy()));
		getWebElement().sendKeys(keysToSend);
		logEndAction(String.format("send \"%s\" to: %s", keysToSend.toString(), locator.getBy()));
	}

	public void clear() {
		logStartAction(String.format("clear text: %s", locator.getBy()));
		getWebElement().clear();
		logEndAction(String.format("clear text: %s", locator.getBy()));
	}

	public void type(CharSequence... keysToSend) {
		logStartAction(String.format("type \"%s\" into: %s", keysToSend.toString(), locator.getBy()));
		clear();
		sendKeys(keysToSend);
		logEndAction(String.format("type \"%s\" into: %s", keysToSend.toString(), locator.getBy()));
	}

	public String getTagName() {
		logStartAction(String.format("get Tag Name: %s", locator.getBy()));
		logEndAction(String.format("got Tag Name value \"%s\": %s", getWebElement().getTagName(), locator.getBy()));
		return getWebElement().getTagName();
	}

	public String getAttribute(String name) {
		logStartAction(String.format("get %s attribute: %s", name, locator.getBy()));
		logEndAction(String.format("got attribute value \"%s\": %s", getWebElement().getAttribute(name), locator.getBy()));
		return getWebElement().getAttribute(name);
	}

	public boolean isSelected() {
		logStartAction(String.format("get Selected status: %s", locator.getBy()));
		logEndAction(String.format("got Selected status \"%s\": %s", getWebElement().isSelected(), locator.getBy()));
		return getWebElement().isSelected();
	}

	public boolean isEnabled() {
		logStartAction(String.format("get Enabled status: %s", locator.getBy()));
		logEndAction(String.format("got Enabled status \"%s\": %s", getWebElement().isEnabled(), locator.getBy()));
		return getWebElement().isEnabled();
	}

	public String getText() {
		logStartAction(String.format("get text: %s", locator.getBy()));
		logEndAction(String.format("got text value \"%s\": %s", getWebElement().getText(), locator.getBy()));
		return getWebElement().getText();
	}

	public List<WebElement> findElements(By by) {
//		logAction("Finding children of");
		return getWebElement().findElements(by);
	}

	public WebElement findElement(By by) {
//		logAction("Finding child of");
		return getWebElement().findElement(by);
	}

	public boolean isDisplayed() {
		logStartAction(String.format("get Displayed status: %s", locator.getBy()));
		logEndAction(String.format("got Displayed status \"%s\": %s", getWebElement().isDisplayed(), locator.getBy()));
		return getWebElement().isDisplayed();
	}

	public Point getLocation() {
		logStartAction(String.format("get Location: %s", locator.getBy()));
		logEndAction(String.format("got Location \"%s\": %s", getWebElement().getLocation(), locator.getBy()));
		return getWebElement().getLocation();
	}

	public Dimension getSize() {
		logStartAction(String.format("get Size: %s", locator.getBy()));
		logEndAction(String.format("got Size \"%s\": %s", getWebElement().getSize(), locator.getBy()));
		return getWebElement().getSize();
	}

	public Rectangle getRect() {
		return getWebElement().getRect();
	}

	public String getCssValue(String propertyName) {
		return getWebElement().getCssValue(propertyName);
	}

	private WebElement getWebElement() {
		return DriverManager.getWebDriver().findElement(locator.getBy());
	}

	private void logStartAction(String msg) {
		log.info("Executing: [{}]", msg);
	}

	private void logEndAction(String msg) {
		log.info("Done: [{}]", msg);
	}
}
