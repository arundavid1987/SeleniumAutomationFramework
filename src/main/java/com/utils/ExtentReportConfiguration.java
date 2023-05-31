package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {

	private static ExtentReports extent;

	public static ExtentReports createhtmlfile(String fileName) {
		
		ExtentSparkReporter extentpark=new ExtentSparkReporter(fileName);
 
		extentpark.config().setTheme(Theme.DARK);
		extentpark.config().setDocumentTitle("Happiestminds Test Automation Report");
		extentpark.config().setEncoding("utf-8");
		extentpark.config().setReportName("Test Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(extentpark);
		extent.setSystemInfo("Tester", "Happiestminds Testing team");
		extent.setSystemInfo("Organization", "HappiestMinds");
		extent.setSystemInfo("TestNG XML ", System.getProperty("suitefilename"));
		extent.setSystemInfo("OS ", System.getProperty("os.name").toLowerCase());
		
		

		return extent;
	}
	
	

}
