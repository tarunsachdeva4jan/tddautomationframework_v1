package com.envision.core.browser;

import org.openqa.selenium.WebDriver;

import com.envision.core.components.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class WebDriverManager {

	public static ThreadLocal<WebDriver> realWebDriver = new ThreadLocal<WebDriver>();

	public Browser GetBrowser(BrowserType browserType) throws Exception {
		Browser browser;
		if (browserType == BrowserType.CHROME) {
			browser = new Chrome();
		} else if (browserType == BrowserType.FIREFOX) {
			browser = new Firefox();
		} else if (browserType == BrowserType.IE) {
			browser = new InternetExplorer();
		} else {
			throw new Exception("Browser not supported, please check the browsername");
		}
		return browser;
	}

	public void launchBrowser(String browserName) throws Exception {
		try {
			Browser browser = GetBrowser(BrowserType.valueOf(browserName));
			WebDriver driver = browser.initBrowser();
			realWebDriver.set(driver);
			/*
			 * ExtentTestManager.getTest().log(LogStatus.PASS, "Browser [" + browserName +
			 * "] Opened Successfully");
			 */
		} catch (Exception e) {
			/*
			 * ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to open Browser [" +
			 * browserName + "] ");
			 */ }
	}

	public void closeBrowser() {
		try {
			realWebDriver.get().close();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Browser Closed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to close browser");
		}
	}

	public void closeAllBrowsers() {
		try {
			realWebDriver.get().quit();
			ExtentTestManager.getTest().log(LogStatus.PASS, "All Browsers Closed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to close all browsers");
		}
	}

	public static void main(String[] args) throws Exception {
		WebDriverManager wdm = new WebDriverManager();
		wdm.launchBrowser("FIREFOX");
		Thread.sleep(5000);
		wdm.closeAllBrowsers();
	}
}
