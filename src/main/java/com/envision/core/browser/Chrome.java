package com.envision.core.browser;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends Browser {

	private ChromeOptions chromeOptions;

	@Override
	public void setPreferences() {
		chromeOptions = new ChromeOptions();
		setHeadless(isHeadless);
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setExperimentalOption("excludeSwitches",
				Collections.singletonList("enable-automation"));
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.addArguments("--start-maximized");
		
	}

	@Override
	public WebDriver initBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//chromedriver.exe");
		setPreferences();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);

		return driver;
	}

	public void setHeadless(boolean isHeadless) {
		if (isHeadless) {
			chromeOptions.setHeadless(true);
		}
	}

	public void setRemoteRun(boolean isRemoteRunEnabled) {
		if (isRemoteRunEnabled) {

		}
	}

}
