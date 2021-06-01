package com.envision.core.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {

	public void splitStringBy(String strToSplit, String by) {

	}

	public static String generateFolderPath(String path) { // extentReports

		String str = System.getProperty("user.dir") + File.separator + path;
		str = str + File.separator + new SimpleDateFormat("MMM-dd").format(new Date());
		str = str + File.separator + new SimpleDateFormat("hh-mm-ss").format(new Date());
		return str;
	}

	public static void main(String[] args) {
		// System.out.println(StringHelper.generatePathInCurrentDirectory());

		System.out.println(new Date());
	}

}
