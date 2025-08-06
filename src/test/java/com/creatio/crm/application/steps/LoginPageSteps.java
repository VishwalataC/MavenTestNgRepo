package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.LoginPageElements;
import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void launchApplication() {		
		launchTheApplication();
		explicitWait(loginPageHeader, 20);
		Assert.assertEquals(getWindowTitle(), prop.getProperty("title"));
		log("pass","Application is launched successfully");
	}
	
	public void verifyLoginHeader() {
		explicitWait(loginPageHeader, 5);
		Assert.assertEquals(getElementText(loginPageHeader), prop.get("loginHeader"));
		log("pass","Application Login Header is displayed as expected");
	}
	
	public void enterCredentials(String username, String password) {
		explicitWait(businessEmailTxtb, 5);
		enterText(businessEmailTxtb, username);
		enterText(passwordTxtb, password);
		log("info","Credentials are entered successfully");
	}
	
	public void clickOnLoginButton() {
		elementClick(loginBtn);
		log("info","Clicked on the Login Button");
	}
	
	public void clickOnSignUpLink() {
		explicitWait(signUpLink, 5);
		jsClick(signUpLink);
		log("info","Clicked on the SignUp Link");
	}	

}
