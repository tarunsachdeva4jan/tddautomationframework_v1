package com.envision.core.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.envision.core.browser.WebDriverManager;

public class WebComponents implements IBrowserActions, IWebPageActions {

	WebDriver driver;
	String pageName;

	public WebComponents(String pageName) {
		this.driver = WebDriverManager.realWebDriver.get();
		this.pageName = pageName;
	}

	public void scrollUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollLeft(WebDriver driver) {

	}

	public void scrollRight(WebDriver driver) {

	}

	public void switchToWindow(WebDriver driver, int index) {
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(index));
	}

	public void switchToLastWindow(WebDriver driver) {
		switchToWindow(driver, driver.getWindowHandles().size() - 1);
	}

	public void switchToChildWindow(WebDriver driver) {
		switchToWindow(driver, 1);

	}

	public void switchToGrandChildWindow(WebDriver driver) {
		switchToWindow(driver, 2);

	}

	public int countOpenWindows(WebDriver driver) {
		return driver.getWindowHandles().size();
	}

	public void refreshWindow(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void refreshWindowByKeys(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.F5);
	}

	public void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void navigateBackward(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateTo(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void enterTextInAlertAndAccept(WebDriver driver, String keys) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keys);
		alert.accept();
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void jsHighlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');",
					element);
			Thread.sleep(300);
			js.executeScript("arguments[0].setAttribute('style', 'border: none;');", element);
			Thread.sleep(300);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickIt(String elementName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		element.click();
	}

	public void mouseClickIt(String elementName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		new Actions(driver).click(element).build().perform();

	}

	public void jsClickIt(String element) {

	}

	public void typeInto(String elementName, String valueToType) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		element.click();
		element.clear();
		element.sendKeys(valueToType);
	}

	public String getText(String elementName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		String text = element.getText();
		return text;
	}

	public void selectValueFromDropdown(String by, String elementName, String value)
			throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		Select select = new Select(element);
		if (by.equalsIgnoreCase("Value")) {
			select.selectByValue(value);
		} else if (by.equalsIgnoreCase("VisibleText")) {
			select.selectByVisibleText(value);
		} else if (by.equalsIgnoreCase("Index")) {
			int index = Integer.valueOf(value);
			select.selectByIndex(index);
		}
	}

	public void selectByVisibleText(String elementName, String text) throws Exception {
		selectValueFromDropdown("VisibleText", elementName, text);

	}

	public void selectByValue(String elementName, String value) throws Exception {
		selectValueFromDropdown("Value", elementName, value);

	}

	public void selectByIndex(String elementName, String index) throws Exception {
		selectValueFromDropdown("Index", elementName, index);
	}

	public List<Options> getAllSelectedOptions(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Options> getAllOptions(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void mouseHoverTo(String elementName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		new Actions(driver).moveToElement(element).build().perform();
	}

	public void rightClickOn(String elementName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		new Actions(driver).contextClick(element).build().perform();
	}

	public void rightClickOnScreen(String elementName) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		new Actions(driver).contextClick().build().perform();

	}

	public void dragTo(String elementName, int x, int y) throws Exception {
		WebElement element = ElementFinder.findElementByXpath(pageName, elementName);
		new Actions(driver).dragAndDropBy(element, x, y).build().perform();

	}

	public void dragTo(String dragFrom, String dragTo) throws Exception {
		WebElement source = ElementFinder.findElementByXpath(pageName, dragFrom);
		WebElement target = ElementFinder.findElementByXpath(pageName, dragTo);
		new Actions(driver).dragAndDrop(source, target).build().perform();

	}

	public void dragAndMoveElement(String source, String target) throws Exception {
		WebElement source1 = ElementFinder.findElementByXpath(pageName, source);
		WebElement target2 = ElementFinder.findElementByXpath(pageName, target);
		new Actions(driver).clickAndHold(source1).moveToElement(target2).release().build()
				.perform();
	}

	public void doubleClick(String elementName) throws Exception {
		WebElement source = ElementFinder.findElementByXpath(pageName, elementName);
		new Actions(driver).doubleClick(source).build().perform();

	}

	public boolean ifDisplayed(String elementName) throws Exception {
		WebElement source = ElementFinder.findElementByXpath(pageName, elementName);
		if (source.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean ifEnabled(String element) throws Exception {
		WebElement source = ElementFinder.findElementByXpath(pageName, element);
		if (source.isEnabled())
			return true;
		else
			return false;

	}

	public boolean ifSelected(String elementName) throws Exception {
		WebElement source = ElementFinder.findElementByXpath(pageName, elementName);
		if (source.isSelected())
			return true;
		else
			return false;
	}

	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);

	}

	public void switchToOriginalWindow() {
		driver.switchTo().defaultContent();
	}

}
