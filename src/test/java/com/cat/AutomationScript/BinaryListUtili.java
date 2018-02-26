package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class BinaryListUtili extends ConsentAutomationUtili{


	/**
	 * To be called after addPage or selectPage
	 * @param showTitle show page title yes/no
	 * @param pageTitle list the page title
	 * @param binaryContent binary page content
	 * @param binaryChoice1 name for choice 1
	 * @param binaryChoice2 name for choice 2
	 * @param binaryDesktop show desktop image yes or blank for no
	 * @param binaryDesktopImageDesc desktop image description
	 * @param binaryDesktopAltText desktop alt text
	 * @param binaryMobile show mobile image yes or blank for no
	 * @param binaryMobileImageDesc mobile image description
	 * @param binaryMobileAltText mobile alt text
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 * @throws Exception
	 */
	static public void editBinaryTemplate(String showTitle, String pageTitle, String binaryContent, String binaryChoice1, String binaryChoice2, String binaryDesktop, String binaryDesktopImageDesc, String binaryDesktopAltText, String binaryMobile, String binaryMobileImageDesc, String binaryMobileAltText, String pageAudio, String backgroundImage) throws Exception
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
		if (binaryContent != "")
			typeTextById("ckeditorContentbinaryListContent", binaryContent + " " + d.toString());
		if (binaryChoice1 != "")
			typeTextById("categoryTextbinaryListOptions1", binaryChoice1 + " " + d.toString());
		if (binaryChoice2 != "")
			typeTextById("categoryTextbinaryListOptions2", binaryChoice2 + " " + d.toString());
		if (binaryDesktop != "")
		{
			getScrrolToWebElement("//div[@id='categoryTextbinaryListOptions2']");
			getUploadImage("//input[@id='UploadbinaryListImage']");
			
		}

		if (binaryDesktopImageDesc != "")
			typeTextById("graphicDescriptionbinaryListImage", binaryDesktopImageDesc + " " + d.toString());
		if (binaryDesktopAltText != "")
			typeTextById("altTextbinaryListImage", binaryDesktopAltText + " " + d.toString());
		if (binaryMobile != "")
		{
			getUploadImage("//input[@id='UploadbinaryListImage_mobileReady']");
		}

		if (binaryMobileImageDesc != "")
			typeTextById("graphicDescriptionbinaryListImage_mobileReady", binaryMobileImageDesc + " " + d.toString());
		if (binaryMobileAltText != "")
			typeTextById("altTextbinaryListImage_mobileReady", binaryMobileAltText + " " + d.toString());
		if (backgroundImage.toLowerCase() == "yes")
		{

			uploadBackgroundImage();
		}

		getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
	}

	/**
	 * This method will add 2 binary panels, must be called after editBinaryTemplate
	 * @param binaryPanels must be set to 2
	 * @param binaryPanel1Text text for binary panel 1
	 * @param binaryPanel1Category select the choice for panel 1 (ex: "Choice 1")
	 * @param binaryPanel1Unmask the unmask position for panel 1, starting from 0 and increasing by 1 for each panel
	 * @param binaryPanel2Text text for binary panel 2
	 * @param binaryPanel2Category select the choice for panel 2 (ex: "Choice 2")
	 * @param binaryPanel2Unmask the unmask position for panel 2, starting from 0 and increasing by 1 for each panel
	 */
	static public void edit2binaryPanels(String binaryPanels, String binaryPanel1Text, String binaryPanel1Category, String binaryPanel1Unmask, String binaryPanel2Text, String binaryPanel2Category, String binaryPanel2Unmask) throws Exception
	{
		getWaitPageLoad();
		Date d = new Date();
		selectDropdownValueVisibleText("maskSectionbinaryListOptions", "2");
		if (binaryPanel1Text != "")
			typeTextById("lineItembinaryListOptions0", binaryPanel1Text + " " + d.toString());
		if (binaryPanel1Category != "")
			selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivbinaryListOptions0']/div[5]/select", binaryPanel1Category);
		if (binaryPanel1Unmask != "")
			selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivbinaryListOptions0']/div[7]/select", binaryPanel1Unmask);
		if (binaryPanel2Text != "")
			typeTextById("lineItembinaryListOptions1", binaryPanel2Text + " " + d.toString());
		if (binaryPanel2Category != "")
			selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivbinaryListOptions1']/div[5]/select", binaryPanel2Category);
		if (binaryPanel2Unmask != "")
			selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivbinaryListOptions1']/div[7]/select", binaryPanel2Unmask);
		getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		//getWaitForElementPresent("//td[text()='Page saved']",90);
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
	}

	/**
	 * Must be called after editBinaryTemplate
	 * @param binaryPosition the correct number for the added position, there are aleady 2 so this should start at 3
	 * @param binaryText the text for the new choice
	 */
	static public void addBinaryCategory(int binaryPosition, String binaryText) throws Exception
	{
		Date d = new Date();
		clickIdentifierByID("multiTitle_addbinaryListOptions");
		typeTextById("categoryTextbinaryListOptions" + binaryPosition, binaryText + " " + d.toString());
		getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		//clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
	}



}
