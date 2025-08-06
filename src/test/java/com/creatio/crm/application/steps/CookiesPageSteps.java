package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements{

	//to pass driver information at constructor level to avoid repeated code
	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCookiesPopUpIsDisplayed() {
		explicitWait(cookiesHeader,5); //wait for element
		log("pass", "Cookies Pop-Up Is Displayed Successfully");
	}
	
	public void verifyCookiesPopUpContent(String expectedContent) { //provide content for datasheet
		String actualContent = getElementText(cookiesContent);
		Assert.assertEquals(actualContent, expectedContent);
		log("pass", "Cookies Pop-Up content Is Displayed as Expected");
		log("info", actualContent);  //print actual content
	}
	
	public void verifyCookiesPopUpLogos() {
		Assert.assertTrue(isElementDisplayed(cookiebotLogo));
		log("pass", "Cookie bot logo is displayed successfully");
		addScreenshot(cookiebotLogo, "cookiebotLogo");
		Assert.assertTrue(isElementDisplayed(creatioLogo));
		log("pass", "Creatio logo is displayed successfully");
		addScreenshot(creatioLogo, "creatioLogo");
	}
	
	public void isCookiesPopUpSelectionButtonsAreDisplayed() {
		Assert.assertTrue(isElementDisplayed(allowAllBtn));
		log("pass", "Allow All Cookies selection button is displayed successfully in the cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(allowSelectionBtn));
		log("pass", "Allow Selection Cookies button is displayed successfully in the cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(denyBtn));
		log("pass", "Deny Cookies selection button is displayed successfully in the cookies Pop-Up");
	}
	
	public void isCookiesPopUpSelectionButtonsAreEnabled() {
		Assert.assertTrue(isElementEnabled(allowAllBtn));
		log("pass", "Allow All Cookies selection button is in Enabled state in the cookies Pop-Up");
		Assert.assertTrue(isElementEnabled(allowSelectionBtn));
		log("pass", "Allow Selection Cookies selection button is in Enabled state in the cookies Pop-Up");
		Assert.assertTrue(isElementEnabled(denyBtn));
		log("pass", "Deny Cookies selection button is in Enabled state in the cookies Pop-Up");
	}

	public void isCookiesSwitchButtonsAreDisplayed() {
//		explicitWait(necessarySwitchtn, 30);
		Assert.assertTrue(isElementDisplayed(necessarySwitchtn));
		log("pass", "Necessary Cookies Selection Switch-Button is displayed successfully in the cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(preferencesSwitchBtn));
		log("pass", "Preferences Cookies Selection Switch-Button is displayed successfully in the cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(statisticsSwitchBtn));
		log("pass", "Statistics Cookies Selection Switch-Button is displayed successfully in the cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(marketingSwitchBtn));
		log("pass", "Marketing Cookies Selection Switch-Button is displayed successfully in the cookies Pop-Up");
	}
	
	public void selectTheCookiesOption(String option) {
		if(option.equalsIgnoreCase("AllowAll")) 
			elementClick(allowAllBtn);
		else if(option.equalsIgnoreCase("AllowSelection")) 
			elementClick(allowSelectionBtn);
		else if(option.equalsIgnoreCase("Deny")) 
			elementClick(denyBtn);
		
		log("info", "Clicked on the " +option+ " button in the Cookies pop-up");
	}
	
	public void verifyCookiesPopUpClosed() {
		waitForElementDisappeared(cookiesHeader, 30);
		log("pass", "Cookies Pop-Up is closed successfully");
	}
	
	public void verifyShowDetailsLink() {
		Assert.assertTrue(showDetailsLink.isDisplayed());
		elementClick(showDetailsLink);
		log("pass", "Show Details link was successfully opened in the cookies pop-up.");
	}
	
	public void verifyCookiePopUpExpandedDetails() {
		explicitWait(cookiePopUpExpandedDetails, 5);
		Assert.assertTrue(cookiePopUpExpandedDetails.isDisplayed());
		log("pass", "Verified: Clicking ‘Show Details’ expands the cookie pop-up Details as intended");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
