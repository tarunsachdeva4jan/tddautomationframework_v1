package com.envision.core.components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.envision.core.browser.WebDriverManager;
import com.envision.core.properties.PropertiesLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Hooks implements ITestListener {

	public WebDriverManager webDriverManager;
	public WebDriver driver;
	public static ExtentTest test;
	public ExtentReports report;

	@BeforeSuite
	public void beforeAnythingElse() throws Exception {
		PropertiesLoader.readConfigurations();
	}

	@BeforeClass
	public void beforeClass() {
		webDriverManager = new WebDriverManager();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		webDriverManager.launchBrowser(PropertiesLoader.browser);
		driver = WebDriverManager.realWebDriver.get();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		webDriverManager.closeBrowser();
		ExtentTestManager.stopTest();
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName(); // ValidateShoppingCart();
	}

	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(getTestMethodName(result), "");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		try {
			String base64 = WebComponents.captureSnapshot(getTestMethodName(result),
					WebDriverManager.realWebDriver.get());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					ExtentTestManager.getTest().addBase64ScreenShot(base64));
		} catch (Exception e) {

		}

	}

	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test SKIPPED");
	}

	public void onFinish(ITestContext context) {
		ExtentReportManager.getReporter().flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

}
