package com.loginium.report;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

import com.loginium.driver.DriverManager;
import com.loginium.driver.DriverSetting;

@Plugin(name = "ThreadDetailConverter", category = "Converter")
@ConverterKeys({ "thd", "thdetail" })
public final class ThreadDetailConverter extends LogEventPatternConverter {

	public ThreadDetailConverter(String name, String style) {
		super(name, style);
	}

	public static ThreadDetailConverter newInstance(final String[] options) {
		return new ThreadDetailConverter("Thanh", "Le");
	}

	@Override
	public void format(LogEvent event, StringBuilder strBuilder) {
		strBuilder.append(getTCDetail());
	}

	protected String getTCDetail() {

		try {
			DriverSetting driverSetting = DriverManager.getWebDriver().getDriverSetting();
			String detail = " [Thread ID: " + Thread.currentThread().getId() + " - " + driverSetting.getDeviceName()
					+ " - " + driverSetting.getPlatform() + " - " + driverSetting.getBrowserName() + "]";
			return detail;
		} catch (Exception ex) {
			return "";
		}

	}

}
