package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class CookiesPageElements extends WebCommons {

	@FindBy(xpath = "//div[@id='CybotCookiebotDialogBodyContentTitle']")
	public WebElement cookiesHeader;

	@FindBy(xpath = "CybotCookiebotDialogBodyContentText")
	public WebElement cookiesContent;

	@FindBy(xpath = "//button[text()='Allow all']")
	public WebElement allowAllBtn;

	@FindBy(xpath = "//button[text()='Allow selection']")
	public WebElement allowSelectionBtn;

	@FindBy(xpath = "//button[text()='Deny']")
	public WebElement denyBtn;

	@FindBy(xpath = "//input[@id='CybotCookiebotDialogBodyLevelButtonNecessary']")
	public WebElement necessarySwitchtn;

	@FindBy(xpath = "//input[@id='CybotCookiebotDialogBodyLevelButtonPreferences']")
	public WebElement preferencesSwitchBtn;

	@FindBy(xpath = "//input[@id='CybotCookiebotDialogBodyLevelButtonStatistics']")
	public WebElement statisticsSwitchBtn;

	@FindBy(xpath = "//input[@id='CybotCookiebotDialogBodyLevelButtonMarketing']")
	public WebElement marketingSwitchBtn;

	@FindBy(xpath = "//a[@id='CybotCookiebotDialogBodyEdgeMoreDetailsLink']")
	public WebElement showDetailsLink;

	@FindBy(xpath = "//img[@id='CybotCookiebotDialogPoweredbyImage']")
	public WebElement creatioLogo;

	@FindBy(xpath = "//a[@id='CybotCookiebotDialogPoweredbyCybot']")
	public WebElement cookiebotLogo;

	@FindBy(xpath = "//a[@id='CybotCookiebotDialogNavDetails']")
	public WebElement cookiePopUpExpandedDetails;

}
