package com.creatio.crm.application.tests;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class ApplicationTests extends BaseTest{

	@Test(priority=1)
	public void verifyCookiesPopUp() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
	}
	
	@Test(priority=2, dataProvider="data")
	public void verifyCookiesPopUpContent(String Content) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookiesPopUpContent(Content);
	}
	
	@Test(priority=3)
	public void verifyCookiesPopUplogos() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookiesPopUpLogos();
	}
	
	@Test(priority=4)
	public void CookiesPopUpSelectionButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.isCookiesPopUpSelectionButtonsAreDisplayed();
		cookiesPage.isCookiesPopUpSelectionButtonsAreEnabled();
	}
	
	@Test(priority=5)
	public void CookiesSwitchButtonsAreDisplayed() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.isCookiesSwitchButtonsAreDisplayed();
	}
	
	@Test(priority=6)
	public void VerifyCookiesPopUpExpandedView() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyShowDetailsLink();
		cookiesPage.verifyCookiePopUpExpandedDetails();
	}
	
	@Test(priority=7)
	public void VerifyCookiesSelectionByAllowingAllCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("allowAll");
		cookiesPage.verifyCookiesPopUpClosed();
	}

	@Test(priority=8)
	public void VerifyCookiesSelectionByAllowSelectionCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("allowSelection");
		cookiesPage.verifyCookiesPopUpClosed();
	}
	
	@Test(priority=9)
	public void VerifyCookiesSelectionByDenyingCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("deny");
		cookiesPage.verifyCookiesPopUpClosed();
	}
	
	@Test(priority=10)
	public void VerifySignUpPage() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("allowSelection");
		cookiesPage.verifyCookiesPopUpClosed();
		signUpPage.clickOnSignUpButton();
		signUpPage.verifySignUpPageIsLaunched();
	}
	
	@Test(priority=11, dataProvider="data")
	public void VerifySignUpForNewUserAccount(String username, String password) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("allowSelection");
		cookiesPage.verifyCookiesPopUpClosed();
		signUpPage.clickOnSignUpButton();
		signUpPage.verifySignUpPageIsLaunched();
		signUpPage.enterUserDetails(username, password);
		signUpPage.clickOnContinueButton();
		signUpPage.enterCompanyDetails();  //Read data from excel sheet
		signUpPage.clickOnSignUpButton();
		homePage.verifySignUpIsSuccessful();
	}
	
	
	@Test(priority=11, dataProvider="data")
	public void VerifySignUpForNewUserAccountDB(String username, String password) throws SQLException {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("allowSelection");
		cookiesPage.verifyCookiesPopUpClosed();
		signUpPage.clickOnSignUpButton();
		signUpPage.verifySignUpPageIsLaunched();
		signUpPage.enterUserDetails(username, password);
		signUpPage.clickOnContinueButton();
		signUpPage.enterCompanyDetailsDB();  //Read data from database
		signUpPage.clickOnSignUpButton();
		homePage.verifySignUpIsSuccessful();
	}
	
	@Test(priority=12, dataProvider="data")
	public void VerifyApplicationLogin(String username, String password) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.selectTheCookiesOption("allowSelection");
		cookiesPage.verifyCookiesPopUpClosed();
		loginPage.enterCredentials(username, password);
		loginPage.clickOnLoginButton();
		homePage.verifyLoginIsSuccessful();
	}
	
}
