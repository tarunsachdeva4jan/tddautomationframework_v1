package com.envision.core.components;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {

	static ExtentReports report = ExtentReportManager.getReporter();
	static ThreadLocal<ExtentTest> extent_Test = new ThreadLocal<ExtentTest>();
	static ThreadLocal<Integer> testId = new ThreadLocal<Integer>();// Test 1121200121
	static Map<Integer, ExtentTest> testMap = new HashMap<Integer, ExtentTest>();

	public synchronized static ExtentTest getTest() {
		return (ExtentTest) testMap.get((int) (long) Thread.currentThread().getId());
	}

	public synchronized static ExtentTest startTest(String testName, String description) {
		ExtentTest test = report.startTest(testName);
		extent_Test.set(test);
		testMap.put((int) (long) Thread.currentThread().getId(), extent_Test.get());
		return test;
	}

	public synchronized static void stopTest() {
		report.endTest((ExtentTest) testMap.get((int) (long) Thread.currentThread().getId()));
	}

}
