package com.envision.core.browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

	protected boolean isHeadless;

	protected boolean isRemote;

	public abstract void setPreferences();

	public abstract WebDriver initBrowser();
	
}
