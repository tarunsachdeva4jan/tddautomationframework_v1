package com.envision.core.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	public static String url;

	public static String browser;

	public static long implicitWait;

	public static long explicitWait;

	public static String pollingWait;

	public static boolean remoteRun;

	public static boolean takeScreenshot;

	public static boolean isHeadless;

	public static void readConfigurations() throws FileNotFoundException, IOException {
		String envName = System.getProperty("envName");
		File path = new File(
				System.getProperty("user.dir") + "//configurations//" + envName + ".properties");
		Properties configProperties = new Properties();
		configProperties.load(new FileInputStream(path));
		url = configProperties.getProperty("URL");
		browser = configProperties.getProperty("Browser");
		implicitWait = Long.parseLong(configProperties.getProperty("ImplicitWait"));
		explicitWait = Long.parseLong(configProperties.getProperty("ExplicitWait"));
		pollingWait = configProperties.getProperty("PollingWait");
		isHeadless = Boolean.valueOf(configProperties.getProperty("Headless"));
		remoteRun = Boolean.valueOf(configProperties.getProperty("RemoteRun"));
		takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
	}

}
