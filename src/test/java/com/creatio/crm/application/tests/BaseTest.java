package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilities.ExcelUtil;

public class BaseTest extends BasePage{

	//Maintain all the object here
	public CookiesPageSteps cookiesPage = null;
	public HomePageSteps homePage = null;
	public LoginPageSteps loginPage = null;
	public SignUpPageSteps signUpPage = null;
	
	@BeforeMethod(alwaysRun=true, dependsOnMethods="setupBrowser")
	public void initializePageObjects() {
		WebDriver driver = new BasePage().getDriver();
		cookiesPage = new CookiesPageSteps(driver);
		homePage = new HomePageSteps(driver);
		loginPage = new LoginPageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);
	}
	
//	@DataProvider(name="data")
//	public String[][] testData(){
//		String[][] data = {{"vishu", "vishwalata@1231"},{"qwedxzAZxc", "asd234!@sd334"}};
//		return data;
//	}
// or use excel sheet instead
	
	@DataProvider(name = "data")
		public String[][] testData(Method method){
			String[][] data = ExcelUtil.readExcelData("TestData.xlsx", method.getName());
			return data;
		}
	
}
