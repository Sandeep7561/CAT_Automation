package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;



public class SAQTemplateUtili extends ConsentAutomationUtili
{


	/**
	 * Must be called after addLesson or addTopic or any template
	 * @param template provide the template either: "consult", "text", "consent", "hotspot, "binary", "selectable", "sidebar, "dnd, "saq", "carousel", "video", "snr", "concern" or "multiple"
	 */

	static public void addPage(String template) throws Exception
	{
		getWaitPageLoad();
		//try {
			//Log.startTestCase("adding a " + template + " page");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			String template1 = "";
			if (template == "consult")
				template1 = "0-0";
			if (template == "text")
				template1 = "0-1";
			if (template == "consent")
				template1 = "0-2";
			if (template == "hotspot")
				template1 = "0-3";
			if (template == "binary")
				template1 = "0-4";
			if (template == "selectable")
				template1 = "1-0";
			if (template == "sidebar")
				template1 = "1-1";
			if (template == "dnd")
				template1 = "1-2";
			if (template == "saq")
				template1 = "1-3";
			if (template == "carousel")
				template1 = "1-4";
			if (template == "video")
				template1 = "2-0";
			if (template == "snr")
				template1 = "2-1";
			if (template == "concern")
				template1 = "2-2";
			if (template == "multiple")
				template1 = "2-3";
			Thread.sleep(1000);
			//getWaitForElementPresent(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]", 100);
			clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[3]");
			Thread.sleep(300);
			//getWaitForElementPresent("//*[@id='template-row-column-image-" + template1 + "']/img", 100);
			clickIdentifierXpath("//*[@id='template-row-column-image-"+template1+"']/img");
			//Log.info("selected the " + template + " template");
			//System.out.println("added the " + template + " template");
			//clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			//Log.pass(template + " page added");
			//Thread.sleep(10000);
		}
		//catch(Exception e){  
			//Log.fail("Failed to add page");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to add page");
		//	e.printStackTrace();
		//	throw e;
		//}
	//}
	/**
	 * to be called after addPage or selectPage
	 * @param pageTitle page title
	 * @param showTitle show title yes/no
	 * @param typeSAQ "Text SAQ" or "Graphical SAQ"
	 * @param layoutSAQ "Left To Right" or "Right To Left"
	 * @param questionText the question text
	 * @param questionType "Multiple Choice" or "Check All"
	 * @param correctAnswer is first answer correct
	 * @param answerText first answer text
	 * @param answerImage first answer image yes or blank for no
	 * @param answerDesktopImage first answer desktop image yes or blank for no
	 * @param answerImageDesc first answer image description
	 * @param answerAltText first answer alt text
	 * @param retryNumber number of retry attempts, leave blank to not configured
	 * @param retryTitle retry title, leave blank if not configured
	 * @param retryMessage retry message text, leave blank if not configured
	 * @param retryButton retry button text, leave blank if not configured
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
	 * @param incorrectImage multiple feedback incorrect image yes/no
	 * @param incorrectImageDesc multiple feedback image description
	 * @param incorrectAltText multiple feedback alt text
	 * @param desktopImage yes or blank for no
	 * @param desktopImageDesc desktop image description
	 * @param desktopAltText desktop alt text
	 * @param mobileImage yes or blank for no
	 * @param mobileImageDesc mobile image description
	 * @param mobileAltText mobile alt text
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 */
	static public void editSAQ(String pageTitle, String showTitle, String typeSAQ, String layoutSAQ, String questionText, String questionType, String correctAnswer, String answerText, String answerImage, String answerDesktopImage, String answerImageDesc, String answerAltText, String retryNumber, String retryTitle, String retryMessage, String retryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String desktopImage, String desktopImageDesc, String desktopAltText, String mobileImage, String mobileImageDesc, String mobileAltText, String pageAudio, String backgroundImage) throws Exception
	{
		
			getWaitPageLoad();
		//try
		//{
			Date d = new Date();
			//Log.startTestCase("start editing SAQ");
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
			if (typeSAQ == "Text SAQ" || typeSAQ == "Graphical SAQ")
				selectDropdownValueXpathVisibleText(".//*[@id='SAQLayout1']/div[1]/div/select", typeSAQ);
			if (layoutSAQ == "Left To Right" || layoutSAQ == "Right To Left")
				selectDropdownValueXpathVisibleText(".//*[@id='SAQLayoutForView']/div[1]/div/select", layoutSAQ);
			if (questionText != "")
				typeTextById("ckeditorContentSAQQuestion1", questionText + " " + d.toString());
			if (questionType == "Multiple Choice" || questionType == "Check All")
				selectDropdownValueXpathVisibleText(".//*[@id='SAQType']/div[1]/div/select", questionType);
			if (correctAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div/label/input");
				//Log.info("unchecked correct answer");
			}
			if (correctAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div/label/input");
				//Log.info("checked correct answer");
			}

			if (answerText != "")
				typeTextById("ckeditorSAQAns1", answerText + " " + d.toString());

			if (answerImage.toLowerCase() == "yes")
			{
				
				checkCheckBox(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div/label/input");
				//Log.info("checked answer image");
			}

			if (answerDesktopImage != "")
			{
				getScrrolToWebElement("//div[@id='ckeditorContentSAQQuestion1']");
				getUploadImage(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[2]/div/div[1]/input[1]");
				//String image = getRandomImage();
				//clickIdentifierXpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[2]/div/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[2]/div/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(8000);
				//uploadFile("\\resource\\images\\" + image + ".jpg");
				//Log.info("uploaded answer image");
			}

			if (answerImageDesc != "")
				typeTextByXpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[3]/div/input", answerImageDesc + " " + d.toString());
			if (answerAltText != "")
				typeTextByXpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[4]/div/input", answerAltText + " " + d.toString());
			if (retryNumber != "")
				typeTextById("titleTextSAQRetryAttempt", retryNumber);
			if (retryTitle != "")
				typeTextById("titleTextSAQRetryAlertTitle", retryTitle + " " + d.toString());
			if (retryMessage != "")
				typeTextById("ckeditorContentSAQRetryAlertText", retryMessage + " " + d.toString());
			if (retryButton != "")
				typeTextById("titleTextSAQRetryAlertButtonTitle", retryButton + " " + d.toString());
			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='SAQFeedback1']/div/div/input[1]");
				if (singleFeedback != "")
					//getScrrolToWebElement(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[2]/div");
				typeTextByXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				if (singleImage != "")
				{
					getUploadImage("//div[label[text()='Feedback :']]/descendant::input[@id='singleFeedbackImage']");
					//String image = getRandomImage();
					//clickIdentifierXpath("//div[label[text()='Feedback :']]/descendant::img[@class='audioIcon set-cursor']");
					//WebElement file = driver.findElement(By.xpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[3]/div/div[2]/input[2]"));
					//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//Thread.sleep(6000);
					//uploadFile("\\resource\\images\\"+image+".jpg");
					//Log.info("uploaded feedback image");
				}

				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());

				if (singleAltText != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}

			if (feedbackOption.toLowerCase() == "multiple")
			{

				//getScrrolToWebElement(".//*[@id='SAQFeedback1']/div/div/input[2]");
				clickIdentifierXpath(".//*[@id='SAQFeedback1']/div/div/input[2]");

				if (correctTitle != "")
					typeTextById("correctTitle", correctTitle + " " + d.toString());

				if (incorrectTitle != "")
					typeTextById("incorrectTitle", incorrectTitle + " " + d.toString());

				if (correctContent != "")
					typeTextById("ckeditorContentCorrectSAQFeedback1", correctContent + " " + d.toString());

				if (incorrectContent != "")

					typeTextById("ckeditorContentIncorrectSAQFeedback1", incorrectContent + " " + d.toString());

				if (correctImage != "")
				{
					//getScrrolToWebElement("//input[@id='multiGraphicContentContainer_addSAQAns1']");
					getUploadImage("//div[div[div[@id='ckeditorContentCorrectSAQFeedback1']]]/descendant::input[@id='correctFeedbackImage']");
					//String image = getRandomImage();
					//clickIdentifierXpath(".//*[@id='feedbackCorrectImage']/div[1]/div[2]/img");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\"+image+".jpg");
					//Log.info("uploaded correct feedback image");
				}

				if (incorrectImage != "")
				{
					getUploadImage("//div[div[div[@id='ckeditorContentIncorrectSAQFeedback1']]]/descendant::input[@id='incorrectFeedbackImage']");
					//String image = getRandomImage();
					//clickIdentifierXpath(".//*[@id='feedbackIncorrectImage']/div[1]/div[2]/img");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\" + image + ".jpg");
					//Log.info("uploaded incorrect feedback image");
				}

				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());

			}

			if (desktopImage != "")
			{
				getUploadImage(".//*[@id='SAQImage']/div/div[1]/div[1]");
				//String image = getRandomImage();
				//clickIdentifierXpath(".//*[@id='SAQImage']/div/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='SAQImage']/div/div[1]/input"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(5000);
				//uploadFile("\\resource\\images\\" + image + ".jpg");
				//Log.info("uploaded saq desktop image");
			}

			if (mobileImage != "")
			{
				getUploadImage(".//*[@id='SAQImage_mobileReady']/div/div[1]/div[1]");
				//String image = getRandomImage();
				//clickIdentifierXpath(".//*[@id='SAQImage_mobileReady']/div/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='SAQImage_mobileReady']/div/div[1]/input"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(8000);
				//uploadFile("\\resource\\images\\" + image + ".jpg");
				//Log.info("uploaded saq mobile image");
			}

			if (desktopImageDesc != "")
				typeTextByXpath(".//*[@id='SAQImage']/div/div[2]/input", desktopImageDesc + " " + d.toString());

			if (desktopAltText != "")
				typeTextByXpath(".//*[@id='SAQImage']/div/div[3]/input", desktopAltText + " " + d.toString());

			if (mobileImageDesc != "")
				typeTextByXpath(".//*[@id='SAQImage_mobileReady']/div/div[2]/input", mobileImageDesc + " " + d.toString());

			if (mobileAltText != "")
				typeTextByXpath(".//*[@id='SAQImage_mobileReady']/div/div[3]/input", mobileAltText + " " + d.toString());

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
			//getWaitForElementPresent("//td[text()='Page saved']",90); 
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,0)", "");

			//clickIdentifierByID("ok-button");

			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved.contains("Page saved"))
			//	Log.pass("page saved");
			///else
			//	Log.fail("page failed to save for reason: " + pageSaved);
		//}
		//catch(Exception e){  
			//Log.fail("Failed to edit SAQ template");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to edit SAQ template");
		//	e.printStackTrace();
		//	throw e;
		//}

	}


	/**
	 * to be called after selectPage or editSaq
	 * @param answerCount count of answer options
	 * @param correctAnswer is  answer correct
	 * @param answerText  answer text
	 * @param answerImage  answer image yes or blank for no
	 * @param answerDesktopImage  answer desktop image yes or blank for no
	 * @param answerImageDesc  answer image description
	 * @param answerAltText  answer alt text
	 */
	static public void addAnswerOption(int answerCount, String correctAnswer, String answerText, String answerImage, String answerDesktopImage, String answerImageDesc, String answerAltText) throws Exception
	{
			getWaitPageLoad(); 
		//try
		//{
			Date d = new Date();
			//Log.info("start adding additional answer option");
			getScrrolToWebElement("//ul[@id='SAQAns1']/descendant::label[text()='Alternative Text For the Image']");
			clickIdentifierXpath("//input[@id='multiGraphicContentContainer_addSAQAns1']");
			//clickIdentifierByID("multiGraphicContentContainer_addSAQAns1");

			int listCount =+ answerCount + 1;
			//listCount=5;
			//if (correctAnswer.toLowerCase() == "no")
			//{

			//uncheckCheckBox(".//*[@id='multiGraphicContent_add']/li[3]/descendant::label[text()='Correct']/input");
			//uncheckCheckBox(".//*[@id='multiGraphicContent_add']/li["+listCount+"]/div/div[2]/label[2]/input");
			//	Log.info("unchecked correct answer");
			//}

			if (correctAnswer.toLowerCase() == "yes")
			{	
				//clickIdentifierXpath(".//*[@id='multiGraphicContent_add']/li[3]/descendant::label[text()='Correct']/input");
				//checkCheckBox(".//*[@id='multiGraphicContent_add']/li[3]/descendant::label[text()='Correct']/input");
				System.out.println(".//*[@id='multiGraphicContent_add']/li["+listCount+"]/div/div[2]/label[2]/input");
				checkCheckBox(".//*[@id='multiGraphicContent_add']/li["+listCount+"]/div/div[2]/label[2]/input");
				//Log.info("checked correct answer");
			}

			if (answerText != "")
				typeTextById("ckeditorSAQAns1" + answerCount, answerText + " " + d.toString());

			if (answerImage.toLowerCase() == "yes")
			{
				///getScrrolToWebElement(".//*[@id='multiGraphicContent_add']/li[3]/descendant::label[text()='Answer Image']/input");
				//checkCheckBox(".//*[@id='multiGraphicContent_add']/li[3]/descendant::label[text()='Answer Image']/input");
				checkCheckBox(".//*[@id='multiGraphicContent_add']/li["+listCount+"]/div/div[2]/label[2]/input");
				//Log.info("checked answer image");
			}

			if (answerDesktopImage != "")
			{
				getUploadImage(".//*[@id='multiGraphicContent_add']/li[2]/div/div[5]/div[2]/div/div/input[1]");
				//String image = getRandomImage();
				//clickIdentifierXpath(".//*[@id='multiGraphicContent_add']/li[3]/descendant::img[@class='audioIcon set-cursor']");
				//clickIdentifierXpath(".//*[@id='multiGraphicContent_add']/li["+listCount+"]/div/div[5]/div[2]/div/div/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div[2]/div/div/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(5000);
				//uploadFile("\\resource\\images\\"+image+".jpg");
				//Log.info("uploaded answer image");
			}

			if (answerImageDesc != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div[3]/div/input", answerImageDesc + " " + d.toString());

			if (answerAltText != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div[4]/div/input", answerAltText + " " + d.toString());

			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			//getWaitForElementPresent("//td[text()='Page saved']",90);
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,0)", "");

			//clickIdentifierByID("ok-button");

			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved.contains("Page saved"))
			///	Log.pass("answer option saved");
			//else
			//	Log.fail("answer option failed to save for reason: " + pageSaved);

		}

		//catch(Exception e){  
			//Log.fail("Failed to add another answer option");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to add another answer option");
		//	e.printStackTrace();
		//	throw e;

		//}

	//}


}
