package com.cat.AutomationScript;

import java.util.Date;



public class SelectAndRevealUtili extends ConsultTemplateUtili
{


	/**
	 * to be called after addPage or selectPage
	 * @param pageTitle page title
	 * @param showTitle show title yes/no
	 * @param layoutReveal either: "Left To Right" or "Right To Left" or "Bottom To Top" or "Full Screen Graphic"
	 * @param snrText text for content
	 * @param revealOrder Random or Sequential
	 * @param revealText first reveal text
	 * @param revealTitle first reveal title
	 * @param revealImage first reveal image yes or blank for no
	 * @param revealImageDesc first image description
	 * @param revealAltText first alt text
	 * @param revealAudio first audio yes or blank for no
	 * @param pageAudio add audio to page yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 */
	static public void editSelectAndRevealTemplate(String pageTitle, String showTitle, String layoutReveal, String snrText, String revealOrder, String revealText, String revealTitle, String revealImage, String revealImageDesc, String revealAltText, String revealAudio, String pageAudio, String backgroundImage) throws Exception
	{
		getWaitPageLoad();
		//try
		//{
			Date d = new Date();
			//Log.startTestCase("start editing select and reveal");
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

			if (layoutReveal == "Left To Right" || layoutReveal == "Right To Left" || layoutReveal == "Bottom To Top" || layoutReveal == "Top To Bottom" || layoutReveal == "Full Screen Graphic")
				selectDropdownValueXpathVisibleText(".//*[@id='selectAndRevealLayout']/div[1]/div/select", layoutReveal);

			if (snrText != "")
				typeTextById("ckeditorContentselectAndRevealContent", snrText + " " + d.toString());

			if (revealOrder == "Random" || revealOrder == "Sequential")
				selectDropdownValueXpathVisibleText(".//*[@id='selectAndRevealTypeLayout']/div[1]/div/select", revealOrder);

			if  (revealText != "")
				typeTextById("ckeditorselectAndRevealText", revealText + " " + d.toString());

			if (revealTitle != "")
				typeTextById("desc_richTextselectAndRevealText", revealTitle + " " + d.toString());

			if (revealImage != "")
			{
				getUploadImage(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[2]/div[1]/div[1]/input[1]");
				//String image = getRandomHotSpotImage();
				//clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[2]/div[1]/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[2]/div[1]/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(8000);
				//uploadFile("\\resource\\images\\"+image+".jpg");
				//Log.info("uploaded reveal 1 image");
			}

			if (revealImageDesc != "")
				typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[3]/div/input", revealImageDesc + " " + d.toString());

			if (revealAltText != "")
				typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[4]/div/input", revealAltText + " " + d.toString());

			//if (pageAudio.toLowerCase() == "yes")
			//{

			//	uploadPageAudio();			
			//}

			if (backgroundImage.toLowerCase() == "yes")
			{

				uploadBackgroundImage();
			}

			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,0)", "");

			//Thread.sleep(1000);

			//clickIdentifierByID("ok-button");

			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved.contains("Page saved"))
			//	Log.pass("page saved");
			//else
			//	Log.fail("page failed to save for reason: " + pageSaved);

			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			//getWaitForElementPresent("//td[text()='Page saved']",90);
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

			//if (revealAudio != "")
			//{
			//	String audio = getRandomAudio();
			//	getScrrolToWebElement(".//*[@id='selectAndRevealText']/ul/li[1]/descendant::label[text()='Alternative Text For the Image']");
			//	getWaitForElementPresent(".//*[@id='selectAndRevealText']/ul/li[1]/descendant::div/input[@id='sltAudio']",90);
			//	clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul/li[1]/descendant::div/input[@id='sltAudio']");
				//Thread.sleep(1000);
				//getWaitForElementPresent(".//*[@id='audBtn_1']",90);
			//	clickIdentifierXpath(".//*[@id='audBtn_1']");
				//Thread.sleep(1000);
				//WebElement file = driver.findElement(By.xpath(".//*[@id='audFile_1']"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			//	Thread.sleep(5000);
			//	uploadFile("\\resource\\audio\\"+audio+".mp3");
			//	clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
				//Log.info("uploaded reveal 1 audio");
			//}

			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
			//JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			//jse1.executeScript("window.scrollTo(0,0)", "");

			//Thread.sleep(1000);

			//clickIdentifierByID("ok-button");

			//String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved1.contains("Page saved"))
			//	Log.pass("page saved");
			//else
			//	Log.fail("page failed to save for reason: " + pageSaved1);

		}

		//catch(Exception e){  
			//Log.fail("Failed to edit select and reveal page");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to edit select and reveal page");
		//	e.printStackTrace();
		//	throw e;

		//}
	//}

	/**
	 * to be called after selectPage or editSelectAndReveal
	 * @param revealPosition1 the position of the reveal panel you are adding
	 * @param revealText first reveal text
	 * @param revealTitle first reveal title
	 * @param revealImage first reveal image yes or blank for no
	 * @param revealImageDesc first image description
	 * @param revealAltText first alt text
	 * @param revealAudio first audio yes or blank for no
	 */
	static public void editRevealPanel(int revealPosition1, String revealText, String revealTitle, String revealImage, String revealImageDesc, String revealAltText, String revealAudio) throws Exception
	{
		try
		{
			Date d = new Date();
			String revealPosition = Integer.toString(revealPosition1);
			int revealPosition2 = revealPosition1 - 1;
			String revealPosition3 = Integer.toString(revealPosition2);
			///Log.info("start editing reveal panel " + revealPosition);
			if (revealText != "" || revealTitle != "" || revealImage != "" || revealImageDesc != "" || revealAltText != "" || revealAudio != "")
			{
				if (revealPosition1 >= 5)
					clickIdentifierByID("multiGraphicContentContainer_addselectAndRevealText");
				if  (revealText != "")
					typeTextById("ckeditorselectAndRevealText" + revealPosition3, revealText + " " + d.toString());

				if (revealTitle != "")
					typeTextById("desc_richTextselectAndRevealText" + revealPosition3, revealTitle + " " + d.toString());

				if (revealImage != "")
				{
					String image = getRandomHotSpotImage();

					//clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul/li["+revealPosition+"]/descendant::div/input[@id='sltAudio']");
					clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[2]/div[1]/div[1]/img");
					//WebElement file = driver.findElement(By.xpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[2]/div[1]/div[1]/input[2]"));
					//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					uploadFile("\\resource\\images\\"+image+".jpg");
					//Log.info("uploaded reveal " + revealPosition + " image");
				}

				if (revealImageDesc != "")
					typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[3]/div/input", revealImageDesc + " " + d.toString());

				if (revealAltText != "")
					typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[4]/div/input", revealAltText + " " + d.toString());

				if (revealAudio != "")
				{
					String audio = getRandomAudio();
					clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[7]/div[2]/input");
					//Thread.sleep(1000);
					getWaitForElementPresent(".//*[@id='audBtn_1']",90);
					clickIdentifierXpath(".//*[@id='audBtn_1']");
					Thread.sleep(1000);
					//WebElement file = driver.findElement(By.xpath(".//*[@id='audFile_1']"));
					//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
					uploadFile("\\resource\\audio\\"+audio+".mp3");
					Thread.sleep(5000);
					clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
					//Log.info("uploaded reveal " + revealPosition + " audio");
				}
			}

			else
			{
				clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[1]");
				//Log.info("deleted reveal panel " + revealPosition);
			}

			getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
			clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

			//JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			//jse1.executeScript("window.scrollTo(0,0)", "");

			//Thread.sleep(1000);

			//clickIdentifierByID("ok-button");

			//String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			//Thread.sleep(3000);

			//if (pageSaved1.contains("Page saved"))
			//	Log.pass("page saved");
			//else
			//	Log.fail("page failed to save for reason: " + pageSaved1);

		}

		catch(Exception e){  
			//Log.fail("Failed to edit select and reveal page");
			e.printStackTrace();
			throw e;                                        
		} catch(AssertionError e)
		{
			//Log.fail("Failed to edit select and reveal page");
			e.printStackTrace();
			throw e;

		}
	}


}
