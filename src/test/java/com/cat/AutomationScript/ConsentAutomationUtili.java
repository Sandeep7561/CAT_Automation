package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;



public class ConsentAutomationUtili extends ConsultTemplateUtili
{

	
	/**
	 * to be called after addPage or selectPage
	 * @param pageTitle page title
	 * @param showTitle show title yes or blank for no
	 * @param markComplete mark course as complete yes or blank for no
	 * @param pageContent content for the page
	 * @param consentButton title for the consent button
	 * @param desktopImage desktop image yes or blank for no
	 * @param mobileImage mobile image yes or blank for no
	 * @param desktopImageDesc desktop image description
	 * @param desktopAltText desktop alt text
	 * @param mobileImageDesc mobile image description
	 * @param mobileAltText mobile alt text
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 * @throws Exception
	 */
	static public void editConsentTemplate(String pageTitle, String showTitle, String markComplete, String pageContent, String consentButton, String desktopImage, String mobileImage, String desktopImageDesc, String desktopAltText, String mobileImageDesc, String mobileAltText, String pageAudio, String backgroundImage) throws Exception
	{
		
			getWaitPageLoad();
			Date d = new Date();	
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			if (showTitle.toLowerCase() == "no")
			{
				uncheckCheckBox(".//input[@name='titleVisible']");
			}
			
			if (showTitle.toLowerCase() == "yes")
			{
				checkCheckBox(".//input[@name='titleVisible']");
			}
			
			if (markComplete.toLowerCase() == "no")
			{
				uncheckCheckBox(".//input[@name='markCouCmpl']");
			}
			
			if (markComplete.toLowerCase() == "yes")
			{
				checkCheckBox(".//input[@name='markCouCmpl']");
			}
			
			if (pageContent != "")
				typeTextById("ckeditorContentconscentContent1", pageContent + " " + d.toString());
			
			if (consentButton != "")
				typeTextById("ckeditorContentconscnetText1", consentButton + " " + d.toString());
			
			if (desktopImage != "")
			{
				getScrrolToWebElement("//div[text()=' Consent ']");
				getUploadImage("//*[@id='conscentImage']/div/div[1]/div[1]");
			}
			if (mobileImage != "")
			{
				getUploadImage("//*[@id='conscentImage_mobileReady']/div/div[1]/div[1]");
			}
			
			if (desktopImageDesc != "")
				getScrrolToWebElement("//*[@id='conscentImage_mobileReady']/div/div[1]/img");
				typeTextById("graphicDescriptionconscentImage", desktopImageDesc + " " + d.toString());
			
			if (desktopAltText != "")
				typeTextById("altTextconscentImage", desktopAltText + " " + d.toString());
			
			if (mobileImageDesc != "")
				typeTextById("graphicDescriptionconscentImage_mobileReady", mobileImageDesc + " " + d.toString());
			
			if (mobileAltText != "")
				typeTextById("altTextconscentImage_mobileReady", mobileAltText + " " + d.toString());
			if (backgroundImage.toLowerCase() == "yes")
			{
				
				uploadBackgroundImage();
			}
			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		}


}
