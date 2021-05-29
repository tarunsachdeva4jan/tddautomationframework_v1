package com.envision.core.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.envision.core.browser.WebDriverManager;
import com.envision.core.properties.PropertiesLoader;

public class ElementFinder {

	public static WebElement findElementBy(String by, String value) throws Exception {
		WebElement element;
		WebDriver driver = WebDriverManager.realWebDriver.get();
		By bys;
		if (by.equalsIgnoreCase("id")) {
			bys = By.id(value);
		} else if (by.equalsIgnoreCase("xpath")) {
			bys = By.xpath(value);
		} else {
			return null;
		}

		element = waitForElementToBeVisible(driver, bys);
		
		return element;
	}

	public static WebElement waitForElementToBeVisible(WebDriver driver, By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, PropertiesLoader.explicitWait);
		WebElement element;
		try {
			element = waitForElementTobePresent(driver, by);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(
					"Element is not visible within time [" + PropertiesLoader.explicitWait + "]");
			element = null;
			throw e;
		}
		return element;
	}

	public static WebElement waitForElementTobePresent(WebDriver driver, By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, PropertiesLoader.explicitWait);
		WebElement element;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Element is not present in the DOM within time ["
					+ PropertiesLoader.explicitWait + "]");
			element = null;

			throw e;

		}
		return element;
	}

	public static void waitForElementToBeInvisible(WebDriver driver, long timeOutInSeconds,
			String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}

	public static void waitForElementToBeClickable(WebDriver driver, long timeOutInSeconds,
			String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}

	public static WebElement findElementByXpath(String pageName, String elementName)
			throws Exception {
		String xpath = RepositoryContext.FetchXpathFromOR(pageName, elementName);
		return findElementBy("xpath", xpath);

	}

	public static WebElement findElementByID(String pageName, String elementName) throws Exception {
		String id = RepositoryContext.FetchIDFromOR(pageName, elementName);
		return findElementBy("id", id);
	}

}
