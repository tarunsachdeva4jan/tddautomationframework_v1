package com.envision.core.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class InternetExplorer extends Browser {

	private InternetExplorerOptions ieOptions;

	@Override
	public void setPreferences() {
		ieOptions = new InternetExplorerOptions();
		ieOptions.ignoreZoomSettings();
		ieOptions.introduceFlakinessByIgnoringSecurityDomains();
		ieOptions.destructivelyEnsureCleanSession();

	}

	@Override
	public WebDriver initBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//IEDriverServer.exe");
		setPreferences();
		driver = new InternetExplorerDriver(ieOptions);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public void setRemoteRun(boolean isRemoteRunEnabled) {
		if (isRemoteRunEnabled) {

		}
	}

}
