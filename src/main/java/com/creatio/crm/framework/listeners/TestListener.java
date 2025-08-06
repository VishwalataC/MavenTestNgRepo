package com.creatio.crm.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class TestListener extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		startReporting(testmethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		logger.pass("Test Execution is Successful for Test Case : "+testmethodName);
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		logger.fail("Test execution is failed for Test case : " +testmethodName);
		logger.fail("Test execution is failed due to Error : " +result.getThrowable().getLocalizedMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenShot(new BasePage().getDriver(), testmethodName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}
	
	public void onTestskip(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		logger.fail("Test execution is skip for Test case : " +testmethodName);
		logger.fail("Test execution is skip due to Error : " +result.getThrowable().getLocalizedMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenShot(new BasePage().getDriver(), testmethodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

}
