package com.creatio.crm.framework.reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

	// This class will have all the common methods related to test result reports
	public static ExtentHtmlReporter html = null;
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;

	// method to setup report
	@BeforeSuite(alwaysRun=true)
	public void setUpReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports//AutomationTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	// Method to start the printing process for specific test case
	public void startReporting(String testcaseName) {
		logger = extent.createTest(testcaseName);  // pass the TC name from listener
		logger.info("Test execution started for the Test method : "+testcaseName);
	}

	// Method to stop printing process
	public void stopReporting() {
		extent.flush();
	}
}
