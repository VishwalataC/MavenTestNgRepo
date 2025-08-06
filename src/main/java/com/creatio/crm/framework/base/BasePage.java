package com.creatio.crm.framework.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.creatio.crm.framework.reports.Reports;

public class BasePage extends Reports{
	// This class will have all the common methods related to browser
	// configurations to initialize the test scripts

	private static WebDriver driver = null;

	// Method to launch the browser based on the browser name coming from runner
	// file
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser") 
	public void setupBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Invalid browser name");
		}
//		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().deleteAllCookies();
	}

	// Method to tear-down/close the browser windows
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		driver.quit();
	}

	// Method to share browser session (driver) details with all other classes
	public WebDriver getDriver() {
		return driver;
	}

	// Method to modify browser session (driver) details from all other classes
	public void setDriver(WebDriver newDriver) {
		driver = newDriver;
	}
	
}
