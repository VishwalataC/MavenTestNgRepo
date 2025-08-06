package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.HomePageElements;
import com.creatio.crm.framework.web.commons.WebCommons;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginIsSuccessful() {
		explicitWait(homePageHeaderLink,60);
		log("pass","Application Login is Successful");
	}
	
	public void verifySignUpIsSuccessful() {
		explicitWait(homePageHeaderLink,120);
		log("pass","Application Sign Up is Successful");
	}

}
