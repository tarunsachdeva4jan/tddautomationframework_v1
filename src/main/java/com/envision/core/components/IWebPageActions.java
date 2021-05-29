package com.envision.core.components;

import java.util.List;

import org.openqa.selenium.WebDriver.Options;

/**
 * @author Tarun
 * @description This interface defines all the functions for interacting with a
 *              web browser (any/all browsers i.e. chrome, firefox, IE, mozilla_
 */

public interface IWebPageActions {

	public abstract void clickIt(String elementName) throws Exception;

	public abstract void mouseClickIt(String element) throws Exception;

	public abstract void jsClickIt(String element) throws Exception;

	public abstract void typeInto(String elementName, String valueToType) throws Exception;

	public abstract String getText(String elementName) throws Exception;

	public abstract void selectValueFromDropdown(String by, String elementName, String value)
			throws Exception;

	public abstract void selectByVisibleText(String elementName, String text) throws Exception;

	public abstract void selectByValue(String elementName, String value) throws Exception;

	public abstract void selectByIndex(String elementName, String index) throws Exception;

	public abstract List<Options> getAllSelectedOptions(String elementName) throws Exception;

	public abstract List<Options> getAllOptions(String elementName) throws Exception;

	public abstract void mouseHoverTo(String elementName) throws Exception;

	public abstract void rightClickOn(String elementName) throws Exception;

	public abstract void rightClickOnScreen(String elementName) throws Exception;

	public abstract void dragTo(String elementName, int x, int y) throws Exception;

	public abstract void dragTo(String dragFrom, String dragTo) throws Exception;

	public abstract void dragAndMoveElement(String source, String target) throws Exception;

	public abstract void doubleClick(String elementName) throws Exception;

	public abstract boolean ifDisplayed(String elementName) throws Exception;

	public abstract boolean ifEnabled(String element) throws Exception;

	public abstract boolean ifSelected(String elementName) throws Exception;

	public abstract void switchToFrame(String frame) throws Exception;

	public abstract void switchToOriginalWindow() throws Exception;

}
