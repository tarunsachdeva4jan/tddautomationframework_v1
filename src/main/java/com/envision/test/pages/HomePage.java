package com.envision.test.pages;

import com.envision.core.components.WebComponents;
import com.envision.core.properties.PropertiesLoader;

public class HomePage extends WebComponents {

	static String pageName = HomePage.class.getSimpleName();

	public HomePage() {
		super(pageName);
	}

	public LoginPage clickSignIn() throws Exception {
		clickIt("lnk_SignIn");
		return new LoginPage();
	}

	public void navigateToHomePage() throws Exception {
		launchUrl(PropertiesLoader.url);
	}

}
