package com.envision.core.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Tarun
 * @description This interface defines all the functions for interacting with a
 *              web browser (any/all browsers i.e. chrome, firefox, IE, mozilla_
 */

public interface IBrowserActions {

	/**
	 * Method to maximize browser window
	 * 
	 * @throws Exception
	 */

	public abstract void scrollUp(WebDriver driver);

	public abstract void scrollDown(WebDriver driver);

	public abstract void scrollLeft(WebDriver driver);

	public abstract void scrollRight(WebDriver driver);

	public abstract void switchToWindow(WebDriver driver, int index);

	public abstract void switchToLastWindow(WebDriver driver);

	public abstract void switchToChildWindow(WebDriver driver);

	public abstract void switchToGrandChildWindow(WebDriver driver);

	public abstract int countOpenWindows(WebDriver driver);

	public abstract void refreshWindow(WebDriver driver);

	public abstract void refreshWindowByKeys(WebDriver driver);

	public abstract void navigateForward(WebDriver driver);

	public abstract void navigateBackward(WebDriver driver);

	public abstract void navigateTo(WebDriver driver, String url);

	public abstract void switchToAlert(WebDriver driver);

	public abstract void switchToAlertAndAccept(WebDriver driver);

	public abstract void switchToAlertAndDismiss(WebDriver driver);

	public abstract void enterTextInAlertAndAccept(WebDriver driver, String keys);

	public abstract String getTitle(WebDriver driver);

	public abstract String getPageSource(WebDriver driver);

	public abstract void scrollIntoView(WebDriver driver, WebElement element);

	public abstract void jsHighlightElement(WebDriver driver, WebElement element);

}
