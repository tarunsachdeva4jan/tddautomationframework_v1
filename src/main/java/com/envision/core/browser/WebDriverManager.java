package com.envision.core.browser;

import org.openqa.selenium.WebDriver;

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
		Browser browser = GetBrowser(BrowserType.valueOf(browserName));
		WebDriver driver = browser.initBrowser();
		realWebDriver.set(driver);
	}

	public void closeBrowser() {
		realWebDriver.get().close();
	}

	public void closeAllBrowsers() {
		realWebDriver.get().quit();
	}

	public static void main(String[] args) throws Exception {
		WebDriverManager wdm = new WebDriverManager();
		wdm.launchBrowser("FIREFOX");
		Thread.sleep(5000);
		wdm.closeAllBrowsers();
	}
}
