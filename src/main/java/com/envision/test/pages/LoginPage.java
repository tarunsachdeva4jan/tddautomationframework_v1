package com.envision.test.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.envision.core.browser.WebDriverManager;
import com.envision.core.components.ElementFinder;
import com.envision.core.components.WebComponents;

public class LoginPage {

	public void enterUserName(String userName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath("LoginPage", "tbx_Username");
		element.clear();
		element.click();
		element.sendKeys(userName);
	}

	public void enterPassword(String password) throws Exception {
		WebElement element = ElementFinder.findElementByXpath("LoginPage", "tbx_Password");
		element.clear();
		element.click();
		element.sendKeys(password);
	}

	public void hitSubmit() throws Exception {
		WebElement element = ElementFinder.findElementByXpath("LoginPage", "btn_Submit");

		element.click();

	}

	public void validateErrorHighlightOnUserName(String userName, String errorCode) throws Exception {
		WebElement element = ElementFinder.findElementByXpath("LoginPage", "tbx_Username");
		element.clear();
		element.click();
		element.sendKeys(userName);
		element.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		String color = element.getCssValue("color");
		System.out.println(color);
		/* rgb(241, 51, 64) */

		Assert.assertEquals(errorCode, color);
	}

	public void loginToApplication(String userName, String password) throws Exception {
		enterUserName(userName);
		enterPassword(password);
		hitSubmit();
	}

}
