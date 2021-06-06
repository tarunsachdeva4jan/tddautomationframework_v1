package com.envision.core.components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private static final int MAX_RETRY = 2;
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) { // Check if test not succeed
			if (retryCount < MAX_RETRY) { // Check if maxtry count is reached
				retryCount++; // Increase the maxTry count by 1
				result.setStatus(ITestResult.FAILURE); // Mark test as failed
				return true;
			} // Tells TestNG to re-run the test
			else {
				result.setStatus(ITestResult.FAILURE); // If maxCount reached,test marked as
			} // failed
		} else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
