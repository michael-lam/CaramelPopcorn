package com.loginium.element;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.loginium.LoginiumConstants.LocatorType;
import com.loginium.driver.DriverManager;

public class SelectElement {
	private static Logger log = LogManager.getLogger();
	private final Locator locator;

	public Locator getLocator() {
		return locator;
	}

	public SelectElement(Locator locator) {
		this.locator = locator;
	}

	public SelectElement(LocatorType type, String value) {
		this.locator = new Locator(type, value);
	}

	public SelectElement(String xpath) {
		this.locator = new Locator(LocatorType.XPATH, xpath);
	}

	public boolean isMultiple() {
		logStartAction(String.format("get selecting multiple options status: %s", locator.getBy()));
		logEndAction(String.format("got selecting multiple options status \"%s\": %s", getSelectElement().isMultiple(), locator.getBy()));
		return getSelectElement().isMultiple();
	}

	public List<WebElement> getOptions() {
		logStartAction(String.format("get all options: %s", locator.getBy()));
		logEndAction(String.format("got options \"%s\": %s", getSelectElement().getOptions(), locator.getBy()));
		return getSelectElement().getOptions();
	}

	public List<WebElement> getAllSelectedOptions() {
		logStartAction(String.format("get all selected options: %s", locator.getBy()));
		logEndAction(String.format("got selected options \"%s\": %s", getSelectElement().getAllSelectedOptions(), locator.getBy()));
		return getSelectElement().getAllSelectedOptions();
	}

	public WebElement getFirstSelectedOption() {
		logStartAction(String.format("get first selected option: %s", locator.getBy()));
		logEndAction(String.format("got first option \"%s\": %s", getSelectElement().getFirstSelectedOption(), locator.getBy()));
		return getSelectElement().getFirstSelectedOption();
	}

	public void selectByVisibleText(String text) {
		logStartAction(String.format("select by visible text \"%s\": %s", text, locator.getBy()));
		logEndAction(String.format("select by visible text \"%s\": %s", text, locator.getBy()));
		getSelectElement().selectByVisibleText(text);
	}

	public void selectByIndex(int index) {
		logStartAction(String.format("select by index \"%s\": %s", index, locator.getBy()));		
		getSelectElement().selectByIndex(index);
		logEndAction(String.format("select by index \"%s\": %s", index, locator.getBy()));
	}

	public void selectByValue(String value) {
		logStartAction(String.format("select by value \"%s\": %s", value, locator.getBy()));		
		getSelectElement().selectByValue(value);
		logEndAction(String.format("select by value \"%s\": %s", value, locator.getBy()));
	}

	public void deselectAll() {
		logStartAction(String.format("deselect all: %s", locator.getBy()));
		getSelectElement().deselectAll();
		logEndAction(String.format("deselect all: %s", locator.getBy()));
	}

	public void deselectByValue(String value) {
		logStartAction(String.format("deselect by value \"%s\": %s", value, locator.getBy()));
		getSelectElement().deselectByValue(value);
		logEndAction(String.format("deselect by value \"%s\": %s", value, locator.getBy()));
	}

	public void deselectByIndex(int index) {
		logStartAction(String.format("deselect by index \"%s\": %s", index, locator.getBy()));
		getSelectElement().deselectByIndex(index);
		logEndAction(String.format("deselect by index \"%s\": %s", index, locator.getBy()));
	}

	public void deselectByVisibleText(String text) {
		logStartAction(String.format("deselect by visible text \"%s\": %s", text, locator.getBy()));
		getSelectElement().deselectByVisibleText(text);
		logEndAction(String.format("deselect by visible text \"%s\": %s", text, locator.getBy()));
	}

	private Select getSelectElement() {
		return new Select(DriverManager.getWebDriver().findElement(locator.getBy()));
	}

	private void logStartAction(String msg) {
		log.info("Executing: [{}]", msg);
	}

	private void logEndAction(String msg) {
		log.info("Done: [{}]", msg);
	}
}
