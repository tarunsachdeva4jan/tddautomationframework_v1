package com.envision.core.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox extends Browser {

	private FirefoxOptions firefoxOptions;

	@Override
	public void setPreferences() {
		firefoxOptions = new FirefoxOptions();
		setHeadless(isHeadless);
	}

	@Override
	public WebDriver initBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//geckodriver.exe");
		setPreferences();
		driver = new FirefoxDriver(firefoxOptions);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	public void setHeadless(boolean isHeadless) {
		if (isHeadless) {
			firefoxOptions.setHeadless(true);
		}
	}

}
