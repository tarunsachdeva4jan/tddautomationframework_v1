package com.envision.test.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.envision.core.components.DataProviderUtils;
import com.envision.core.components.Hooks;
import com.envision.core.components.Retry;
import com.envision.core.properties.PropertiesLoader;
import com.envision.test.pages.HomePage;
import com.envision.test.pages.LoginPage;

public class LoginTest extends Hooks {

	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "testCaseDataProvider")
	public void loginScenario(String userName, String password) throws Exception {
		HomePage homePage = new HomePage();
		homePage.navigateToHomePage();
		Thread.sleep(3000);
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

}
