package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;



public class EditDragAndDropUtili extends ConsultTemplateUtili
{
	/**
	 * to be called after addPage or selectPage
	 * @param pageTitle page title
	 * @param showTitle show title yes/no
	 * @param pageLayout to be either: "Drag and Drop With Flags" or "Drag and Drop Without Flags"
	 * @param pageContent content for the page
	 * @param categoryText first category text
	 * @param categoryImage first category image yes or blank for no
	 * @param categoryImageDesc first category image description
	 * @param categoryAltText first category alt text
	 * @param lineItemText first line item text
	 * @param lineItemCategory first line item category (ex: CAT1)
	 * @param lineItemImage first line item image yes or blank for no
	 * @param lineItemImageDesc first line item image description
	 * @param lineItemAltText first line item alt text
	 * @param dndRetryNumber retry attempts, leave blank if not configured
	 * @param dndRetryTitle retry title for prompt , leave blank if not configured
	 * @param dndRetryMessage retry message, leave blank if not configured
	 * @param dndRetryButton retyr button text, leave blank if not configured
	 * @param feedbackOption "single" or "multiple"
	 * @param singleFeedback feedback text for single feedback
	 * @param singleImage single feedback image yes or blank for no
	 * @param singleImageDesc single feedback image description
	 * @param singleAltText single feedback alt text
	 * @param correctTitle multiple feedback correct tile
	 * @param correctContent multiple feedback correct text
	 * @param correctImage multiple feedback image yes or blank for no
	 * @param correctImageDesc multiple feedback image description
	 * @param correctAltText  multiple feedback alt text
	 * @param incorrectTitle multiple feedback  incorrect title
	 * @param incorrectContent multiple feedback incorrect text
	 * @param incorrectImage multiple feedback incorrect image yes or blank for no
	 * @param incorrectImageDesc multiple feedback image description
	 * @param incorrectAltText multiple feedback alt text
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 */
	static public void editDragAndDropTemplate(String pageTitle, String showTitle, String pageLayout, String pageContent, String categoryText, String categoryImage, String categoryImageDesc, String categoryAltText, String lineItemText, String lineItemCategory, String lineItemImage, String lineItemImageDesc, String lineItemAltText, String dndRetryNumber, String dndRetryTitle, String dndRetryMessage, String dndRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String pageAudio, String backgroundImage) throws Exception
	{
		
			getWaitPageLoad();
		//try
		//{
			Date d = new Date();
			//Log.startTestCase("start editing drag and drop template");
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			if (showTitle.toLowerCase() == "no")
			{
				uncheckCheckBox(".//input[@name='titleVisible']");
				//Log.info("unchecked show title");
			}

			if (showTitle.toLowerCase() == "yes")
			{
				checkCheckBox(".//input[@name='titleVisible']");
				//Log.info("checked show title");
			}
			if (pageLayout == "Drag and Drop With Flags" || pageLayout == "Drag and Drop Without Flags")
				getScrrolToWebElement(".//*[@id='dragOptionslayout']/div[1]/div/select");
			selectDropdownValueXpathVisibleText(".//*[@id='dragOptionslayout']/div[1]/div/select", pageLayout);
			if (pageContent != "")
				typeTextById("ckeditorContentdragOptionsContent", pageContent + " " + d.toString());
			if (categoryText != "")
				typeTextById("categoryTextdragOptionsMultiText1", categoryText + " " + d.toString());
			if (categoryImage != "")
			{
				//String image = getRandomImage();
				getUploadImage("//div[label[text()='Category Image:']]/descendant::input[@id='UploaddragOptionsMultiText1']");
				//clickIdentifierXpath("//div[label[text()='Category Image:']]/descendant::img[@class='audioIcon set-cursor']");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[5]/div[2]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(5000);
				//uploadFile("\\resource\\images\\"+image+".jpg");
				//Log.info("uploaded category 1 image");
			}

			if (categoryImageDesc != "")
				getScrrolToWebElement(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[6]/input");
			typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[6]/input", categoryImageDesc + " " + d.toString());
			if (categoryAltText != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[7]/input", categoryAltText + " " + d.toString());
			if (lineItemText != "")
				typeTextById("lineItemdragOptionsMultiText1", lineItemText + " " + d.toString());
			if (lineItemCategory != "")
				selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivdragOptionsMultiText1']/div[5]/select", lineItemCategory);
			if (lineItemImage != "")
			{
				///String image = getRandomImage();
				//clickIdentifierXpath("//div[label[text()='Drag-and-drop item Image:']]/descendant::img[@class='audioIcon set-cursor']");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='lineItemDivdragOptionsMultiText1']/div[7]/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(5000);
				//uploadFile("\\resource\\images\\"+image+".jpg");
				//Log.info("uploaded line item 1 image");
				getUploadImage("//div[label[text()='Drag-and-drop item Image:']]/descendant::input[@id='UploaddragOptionsMultiText1']");
			}

			if (lineItemImageDesc != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText1']/div[8]/input", lineItemImageDesc + " " + d.toString());

			if (lineItemAltText != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText1']/div[9]/input", lineItemAltText + " " + d.toString());
			//fix dnd issues
			if (dndRetryNumber != "")
				typeTextById("titleTextdragOptionsRetryAttempt", dndRetryNumber);

			if (dndRetryTitle != "")
				typeTextById("titleTextdragOptionsRetryAlertTitle", dndRetryTitle + " " + d.toString());

			if (dndRetryMessage != "")
				typeTextById("ckeditorContentdragOptionsRetryAlertText", dndRetryMessage + " " + d.toString());

			if (dndRetryButton != "")
				typeTextById("titleTextdragOptionsRetryAlertButtonTitle", dndRetryButton + " " + d.toString());

			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div/div/input[1]");
				if (singleFeedback != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				if (singleImage != "")
				{
					getUploadImage("//div[label[text()='Feedback :']]/descendant::input[@id='singleFeedbackImage']");
					//String image = getRandomImage();
					//clickIdentifierXpath("//div[label[text()='Feedback :']]/descendant::img[@class='audioIcon set-cursor']");
					//clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div/div[2]/img");
					//WebElement file = driver.findElement(By.xpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div/div[2]/input[2]"));
					//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\" + image + ".jpg");
					//Log.info("uploaded feedback image");
				}

				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());

				if (singleAltText != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}

			if (feedbackOption.toLowerCase() == "multiple")
			{
				clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div/div/input[2]");

				if (correctTitle != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[1]/input", correctTitle + " " + d.toString());

				if (incorrectTitle != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[2]/input", incorrectTitle + " " + d.toString());

				if (correctContent != "")
					typeTextById("ckeditorContentCorrectdragOptionsFeedback", correctContent + " " + d.toString());

				if (incorrectContent != "")
					typeTextById("ckeditorContentIncorrectdragOptionsFeedback", incorrectContent + " " + d.toString());

				if (correctImage != "")
				{
					//String image = getRandomImage();
					getUploadImage(".//*[@id='dragOptionsFeedback']/descendant::input[@id='correctFeedbackImage']");

					//clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/img");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\"+image+".jpg");
					//Log.info("uploaded correct feedback image");
				}

				if (incorrectImage != "")
				{
					getUploadImage(".//*[@id='dragOptionsFeedback']/descendant::input[@id='incorrectFeedbackImage']");
					//String image = getRandomImage();
					//clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/img");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\" + image + ".jpg");
					//Log.info("uploaded incorrect feedback image");
				}

				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
			}
			//if (pageAudio.toLowerCase() == "yes")
			//{
			//	uploadPageAudio();			
			//}

			if (backgroundImage.toLowerCase() == "yes")
			{
				uploadBackgroundImage();
			}


			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,0)", "");

			//clickIdentifierByID("ok-button");

			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved.contains("Page saved"))
			//	Log.pass("page saved");
			//else
			//	Log.fail("page failed to save for reason: " + pageSaved);
		}

		//catch(Exception e){  
		//	Log.fail("Failed to edit drag and drop template");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
		//	Log.fail("Failed to edit drag and drop template");
		//	e.printStackTrace();
		//	throw e;

		//}
	//}

	/**
	 * to be called after selectPage or editDragAndDrop
	 * @param categoryPosition the category position
	 * @param categoryText  category text
	 * @param categoryImage  category image yes or blank for no
	 * @param categoryImageDesc  category image description
	 * @param categoryAltText  category alt text
	 */
	static public void addCategory(String categoryPosition, String categoryText, String categoryImage, String categoryImageDesc, String categoryAltText) throws Exception
	{
		//try
		//{

			Date d = new Date();
			//Log.info("adding category " + categoryPosition);
			clickIdentifierByID("multiTitle_adddragOptionsMultiText");
			if (categoryText != "")
				typeTextById("categoryTextdragOptionsMultiText" + categoryPosition, categoryText + " " + d.toString());

			if (categoryImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[6]/div[2]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[6]/div[2]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(5000);
				uploadFile("\\resource\\images\\" + image + ".jpg");
				//Log.info("uploaded category " + categoryPosition + " image");
			}

			if (categoryImageDesc != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[7]/input", categoryImageDesc + " " + d.toString());

			if (categoryAltText != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[8]/input", categoryAltText + " " + d.toString());

			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,0)", "");
			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
			//clickIdentifierByID("ok-button");

			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved.contains("Page saved"))
			//	Log.pass("category " + categoryPosition + " saved");
			//else
			//	Log.fail("category " + categoryPosition + " failed to save for reason: " + pageSaved);

		}

		//catch(Exception e){  
		//	Log.fail("Failed to add drag and drop category " + categoryPosition);
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
		//	Log.fail("Failed to add drag and drop category " + categoryPosition);
		//	e.printStackTrace();
		//	throw e;
		//}
	//}

	/**
	 * to be called after selectPage or editDragAndDrop
	 * @param lineItemPosition line item position
	 * @param lineItemText  line item text
	 * @param lineItemCategory  line item category (ex: CAT1)
	 * @param lineItemImage  line item image yes or blank for no
	 * @param lineItemImageDesc  line item image description
	 * @param lineItemAltText  line item alt text
	 */
	static public void addLineItem(String lineItemPosition, String lineItemText, String lineItemCategory, String lineItemImage, String lineItemImageDesc, String lineItemAltText) throws Exception
	{
		//try
		//{
			Date d = new Date();
			clickIdentifierByID("multiText_adddragOptionsMultiText");
			//Log.info("adding line item " + lineItemPosition);
			if (lineItemText != "")
				typeTextById("lineItemdragOptionsMultiText" + lineItemPosition, lineItemText + " " + d.toString());
			if (lineItemCategory != "")
				selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[6]/select", lineItemCategory);
			if (lineItemImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[8]/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[8]/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(5000);
				uploadFile("\\resource\\images\\" + image + ".jpg");
				//Log.info("uploaded line item " + lineItemPosition + " image");
			}

			if (lineItemImageDesc != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[9]/input", lineItemImageDesc + " " + d.toString());
			if (lineItemAltText != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[10]/input", lineItemAltText + " " + d.toString());

			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,0)", "");
			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
			//clickIdentifierByID("ok-button");

			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved.contains("Page saved"))
			//	Log.pass("line item " + lineItemPosition + " saved");
			//else
			//	Log.fail("line item " + lineItemPosition + " failed to save for reason: " + pageSaved);

		}

		//catch(Exception e){  
		//	Log.fail("Failed to add drag and drop line item " + lineItemPosition);
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
		//	Log.fail("Failed to add drag and drop line item " + lineItemPosition);
		//	e.printStackTrace();
		//	throw e;
		//}
	//}

}
