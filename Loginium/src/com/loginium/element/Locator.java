package com.loginium.element;

import org.openqa.selenium.By;
import com.loginium.LoginiumConstants.LocatorType;

public class Locator {
	private LocatorType type;
	private String path;

	public LocatorType getType() {
		return type;
	}

	public void setType(LocatorType type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Locator() {
	}

	public Locator(LocatorType type, String path) {
		this.setType(type);
		this.setPath(path);
	}

	public Locator(String xpath) {
		this.setType(LocatorType.XPATH);
		this.setPath(xpath);
	}

	public By getBy() {
		if (type == LocatorType.ID) {
			return By.id(path);
		} else if (type == LocatorType.NAME) {
			return By.name(path);
		} else if (type == LocatorType.LINK_TEXT) {
			return By.linkText(path);
		} else if (type == LocatorType.PARTIAL_LINK_TEXT) {
			return By.partialLinkText(path);
		} else if (type == LocatorType.TAG_NAME) {
			return By.tagName(path);
		} else if (type == LocatorType.CLASS_NAME) {
			return By.className(path);
		} else if (type == LocatorType.CSS) {
			return By.cssSelector(path);
		} else if (type == LocatorType.XPATH) {
			return By.xpath(path);
		} else {
			return null;
		}
	}
}
