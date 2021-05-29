package com.envision.test.pages;

import org.openqa.selenium.WebElement;

import com.envision.core.components.ElementFinder;

public class HomePage {

	public LoginPage clickSignIn() throws Exception {
		WebElement element = ElementFinder.findElementByXpath("HomePage", "lnk_SignIn");
		element.click();
		return new LoginPage();
	}

}
