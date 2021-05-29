package com.envision.test.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.envision.core.browser.WebDriverManager;
import com.envision.core.components.DataProviderUtils;
import com.envision.core.properties.PropertiesLoader;
import com.envision.test.pages.HomePage;
import com.envision.test.pages.LoginPage;

public class DemoTest {

	WebDriverManager webDriverManager;
	WebDriver driver;

	@BeforeSuite
	public void beforeAnythingElse() throws Exception {
		PropertiesLoader.readConfigurations();
	}

	@BeforeClass
	public void beforeClass() {
		webDriverManager = new WebDriverManager();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		webDriverManager.launchBrowser(PropertiesLoader.browser);
		driver = WebDriverManager.realWebDriver.get();
	}

	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "testCaseDataProvider")
	public void loginScenario(String userName, String password) throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertiesLoader.url);
		Thread.sleep(3000);
		HomePage homePage = new HomePage();
		LoginPage loginPage = homePage.clickSignIn();
		loginPage.loginToApplication(userName, password);
	}

	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "testCaseDataProvider")
	public void loginScenarioNegative(String userName, String password, String expectedValue)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertiesLoader.url);
		Thread.sleep(3000);
		HomePage homePage = new HomePage();
		LoginPage loginPage = homePage.clickSignIn();
		loginPage.validateErrorHighlightOnUserName(userName, expectedValue);
	}

	@AfterMethod
	public void afterMethod() {
		webDriverManager.closeBrowser();
	}

}
