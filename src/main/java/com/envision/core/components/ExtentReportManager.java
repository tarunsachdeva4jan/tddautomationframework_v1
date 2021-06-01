package com.envision.core.components;

import java.io.File;

import com.envision.core.helpers.StringHelper;
import com.envision.core.properties.PropertiesLoader;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {

	private static ExtentReports suiteReport;

	public static synchronized ExtentReports getReporter() {
		
		try {
			PropertiesLoader.readConfigurations();
			if (suiteReport == null) {
				String extentReportPath = "extentReports";
				extentReportPath = StringHelper.generateFolderPath(extentReportPath);
				File f = new File(extentReportPath);
				if (!f.isDirectory()) {
					f.mkdirs();
				}
				suiteReport = new ExtentReports(extentReportPath + "//TestResults.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suiteReport;
	}

}
