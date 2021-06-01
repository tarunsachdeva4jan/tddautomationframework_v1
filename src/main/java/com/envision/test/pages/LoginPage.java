package com.envision.test.pages;

import org.junit.Assert;

import com.envision.core.components.WebComponents;

public class LoginPage extends WebComponents {

	static String pageName = LoginPage.class.getSimpleName();

	public LoginPage() {
		super(pageName);
	}

	public void enterUserName(String userName) throws Exception {
		typeInto("tbx_Username", userName);
	}

	public void enterPassword(String password) throws Exception {

		typeInto("tbx_Password", password);
	}

	public void hitSubmit() throws Exception {
		clickIt("btn_Submit");
	}

	public void validateErrorHighlightOnUserName(String userName, String errorCode)
			throws Exception {

		typeInto("tbx_Username", userName);
		pauseABit(1);
		String color = FetchCssValue("tbx_Username", "color");
		Assert.assertTrue(color.contains(errorCode));
	}

	public void loginToApplication(String userName, String password) throws Exception {
		enterUserName(userName);
		enterPassword(password);
		hitSubmit();
	}

}
