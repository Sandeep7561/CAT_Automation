package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class TextAndGraphicScriptUtili  extends ConsultTemplateUtili 
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
		//Thread.sleep(1000);
		getWaitForElementPresent("//*[@id='courseTreeOperationIcons']/li[3]", 200);
		clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[3]");
		//Thread.sleep(300);
		getWaitForElementPresent("//*[@id='template-row-column-image-" + template1 + "']/img", 200);
		clickIdentifierXpath("//*[@id='template-row-column-image-" + template1 + "']/img");
		//Log.info("selected the " + template + " template");
		//System.out.println("added the " + template + " template");
		//clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
		clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
		//Log.pass(template + " page added");
		//Thread.sleep(10000);
		//}

		//catch(Exception e){  
		//       Log.fail("Failed to add page");
		//      e.printStackTrace();
		//       throw e;                                        
		//} catch(AssertionError e)
		//{
		//       Log.fail("Failed to add page");
		//       e.printStackTrace();
		//       throw e;

		//}

	}


	/**
	 * to be called after addPage or selectPage
	 * @param pageTitle title for page
	 * @param showTitle show title yes/no
	 * @param pageContent page content
	 * @param autoPlay autoplay video yes/no
	 * @param fullScreen fullscreen video yes/no
	 * @param addVideo add video yes/no
	 * @param addSrt add SRT yes/no
	 * @param webLink supply weblink if not adding video
	 * @param panelContent first panel content
	 * @param panelAudio first panel audio yes or blank for no
	 * @param desktopImage first panel desktop image yes or blank for no
	 * @param mobileImage first panel mobile image yes or blank for no
	 * @param imageDesc first panel image description
	 * @param altText first panel alt text
	 * @throws Exception
	 */
	static public void editVideoTemplate(String pageTitle, String showTitle, String pageContent, String autoPlay, String fullScreen, String addVideo, String addSrt, String webLink, String panelContent, String panelAudio, String desktopImage, String mobileImage, String imageDesc, String altText) throws Exception
	{
		//try
		//{  
		Date d = new Date();
		//Log.startTestCase("start editing video template");
		//Thread.sleep(5000);
		//need to make dynamic
		//typeTextById("pageTitle", "page title " + d.toString());
		//typeTextById("ckeditorContentvideoContent", "video content " + d.toString());
		//Thread.sleep(8000);
		if (pageTitle != "")
			typeTextById("pageTitle", pageTitle + " " + d.toString());
		if (showTitle == "no")
		{
			uncheckCheckBox("//*[@id='pageTitleId']/div/div/div/div/input");
			//Log.info("unchecked show title");
		}

		if (showTitle == "yes")
		{
			checkCheckBox("//*[@id='pageTitleId']/div/div/div/div/input");
			//Log.info("checked show title");
		}

		if (pageContent != "")
			typeTextById("ckeditorContentvideoContent", pageContent + " " + d.toString());

		if (autoPlay != "")
		{
			//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
			WebElement check1 = driver.findElement(By.id("videoAutoplayFlag"));
			Boolean value = check1.isSelected();
			//Log.info("autoplay is " + value);	
			if (value && autoPlay =="no")
			{
				clickIdentifierXpath("//div[div[label[contains(text(),'Do you want to activate video autoplay?')]]]//descendant::label[text()='Yes']");
				//clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/div/label[2]");
				//Log.info("turned off autoplay");
			}

			if (!value && autoPlay =="yes")
			{
				clickIdentifierXpath("//div[div[label[contains(text(),'Do you want to activate video autoplay?')]]]//descendant::label[text()='No']");
				//clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/div/label[2]");
				//Log.info("turned on autoplay");
			}

		}

		if (fullScreen != "")
		{
			//clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/label[2]");
			WebElement check1 = driver.findElement(By.id("data-video-size"));
			Boolean value = check1.isSelected();
			//Log.info("video fullscreen is " + value);
			if (value && fullScreen =="no")
			{
				clickIdentifierXpath("//div[div[label[contains(text(),'Do you want the video to open full screen?')]]]//descendant::label[text()='Yes']");
				//clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/label[2]");
				//Log.info("turned off fullscreen");
			}
			if (!value && fullScreen =="yes")
			{
				clickIdentifierXpath("//div[div[label[contains(text(),'Do you want the video to open full screen?')]]]//descendant::label[text()='No']");

				//clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/label[2]");
				//Log.info("turned on fullscreen");
			}
		}


		//driver.findElement(By.xpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/span")).click();
		//Log.info("Clicked on toggle button to YES");

		if (addVideo == "yes")
		{

			getScrrolToWebElement(".//*[@id='videoUpload']/div/div[2]/label[1]/div/label");
			clickIdentifierXpath(".//*[@id='videoUpload']/div/div[2]/label[1]/div/label");
			clickIdentifierXpath("//div[@id='jw-player-video1-div']");
			Thread.sleep(3000);


			//Log.info("Clicked on Video field to open Image libary");
			clickIdentifierXpath(".//*[@id='uploadAMedia']/label");
			Thread.sleep(3000);

			clickIdentifierByID("fileToUpload");
			Thread.sleep(3000);

			//WebElement file = driver.findElement(By.xpath(".//*[@id='fileToUpload']"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\video\\clipcanvas_14348_H264_640x360.mp4");
			uploadFile("\\resource\\video\\clipcanvas_14348_H264_640x360.mp4");
			//driver.findElement(By.id("fileToUpload")).sendKeys("../CAT_fx_integrationjenkins/resource/video/clipcanvas_14348_H264_640x360.mp4");

			Thread.sleep(30000);
			clickIdentifierXpath(".//div[@aria-describedby='uploadDialogArea']/div/button");
			Thread.sleep(3000);
			clickIdentifierXpath(".//div[@id='fileList']/div[2]/div[1]");
			//Log.info("selecting video");

			clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			//Log.info("clicked on Ok");


		}

		if (webLink != "")
		{
			clickIdentifierByID(".//*[@id='videoUpload']/div/div[2]/label[2]/div/label");
			typeTextById("webUrl", webLink);
		}
		//clickIdentifierXpath("//div[@id='srt-div']");
		//Log.info("selecting SRT");

		if (panelContent != "")
			typeTextById("ckeditorContentTextViewText0", panelContent + " " + d.toString());

		if (desktopImage != "")
		{
			String image = getRandomImage();
			clickIdentifierXpath(".//*[@id='desktop-image-main-div-0-videoUploadPanel']/img");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='desktop-image-main-div-0-videoUploadPanel']/input[2]"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			Thread.sleep(6000);
			uploadFile("\\resource\\images\\" + image + ".jpg");
			//Log.info("uploaded desktop image");
		}

		if (mobileImage != "")
		{
			String image = getRandomImage();
			clickIdentifierXpath(".//*[@id='mobile-image-main-div-0-videoUploadPanel']/img");
			///WebElement file = driver.findElement(By.xpath(".//*[@id='mobile-image-main-div-0-videoUploadPanel']/input[2]"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			Thread.sleep(6000);
			uploadFile("\\resource\\images\\" + image + ".jpg");
			//Log.info("uploaded mobile image");
		}

		if (imageDesc != "")
			typeTextById("widgetImageDescription-0-videoUploadPanel", imageDesc + " " + d.toString());

		if (altText != "")
			typeTextById("widgetAltTextBackgroundImage-0-videoUploadPanel", altText + " " + d.toString());

		Thread.sleep(5000);


		//clickIdentifierXpath(".//*[@id='ok-button']");

		//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

		/*Thread.sleep(3000);

			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);*/
		//clickIdentifierXpath("//img[@id='saveIconId']");
		//getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		//clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		getScrrolToWebElement("//button[@id='ok-button']");
		clickIdentifierXpath("//button[@id='ok-button']");
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

		if (addSrt == "yes")
		{
			getScrrolToWebElement("//div[@id='srt-div']");
			clickIdentifierByID("srt-div");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='srt-div']/input"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\srt\\vsshort-en.srt");
			Thread.sleep(5000);
			uploadFile("\\resource\\srt\\vsshort-en.srt");
			Thread.sleep(5000);
			//Log.info("uploaded SRT file");
		}

		if (panelAudio != "")
		{
			String audio = getRandomAudio();
			clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='widget1_audioFile']"));
			///file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			Thread.sleep(5000);
			uploadFile("\\resource\\audio\\" + audio + ".mp3");
			///Log.info("uploaded audio");

		}

		//addNewTemplateBackgroundImage();

		/*clickIdentifierXpath(".//*[@id='ok-button']");

			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

			Thread.sleep(3000);

			if (pageSaved1.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);*/
		//getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		//clickIdentifierXpath("//img[@id='saveIconId']");

		//getWaitForElementPresent("//td[text()='Page saved']",90);
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

		getScrrolToWebElement("//button[@id='ok-button']");
		clickIdentifierXpath("//button[@id='ok-button']");
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

	}

	//catch(Exception e){  
	//       Log.fail("Failed to edit video template");
	//       e.printStackTrace();
	//       throw e;                                        
	///} catch(AssertionError e)
	//{
	//       Log.fail("Failed to edit video template");
	//       e.printStackTrace();
	//       throw e;

	//}
	//}


	/**
	 * to be called after selectPage or editVideoTemplate
	 * @param panelNumber number of panel being added
	 * @param panelContent first panel content
	 * @param panelAudio first panel audio yes or blank for no
	 * @param desktopImage first panel desktop image yes or blank for no
	 * @param mobileImage first panel mobile image yes or blank for no
	 * @param imageDesc first panel image description
	 * @param altText first panel alt text
	 */
	static public void addVideoPanel(int panelNumber, String panelContent, String panelAudio, String desktopImage, String mobileImage, String imageDesc, String altText) throws Exception
	{
		//try
		//{
		Date d = new Date();	
		//String panels = Integer.toString(panelNumber);

		int panelPosition = panelNumber - 1;

		clickIdentifierXpath(".//*[@id='videoUploadPanel']/div[3]/div[1]");

		//Log.info("start adding video panel " + panelNumber);

		if (panelContent != "")
			typeTextById("ckeditorContentTextViewText" + panelPosition, panelContent + " " + d.toString());

		if (desktopImage != "")
		{
			String image = getRandomImage();
			clickIdentifierXpath(".//*[@id='desktop-image-main-div-" + panelPosition + "-videoUploadPanel']/img");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='desktop-image-main-div-" + panelPosition + "-videoUploadPanel']/input[2]"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			Thread.sleep(5000);
			uploadFile("\\resource\\images\\" + image + ".jpg");
			//Log.info("uploaded desktop image");
		}

		if (mobileImage != "")
		{
			String image = getRandomImage();
			clickIdentifierXpath(".//*[@id='mobile-image-main-div-" + panelPosition + "-videoUploadPanel']/img");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='mobile-image-main-div-" + panelPosition + "-videoUploadPanel']/input[2]"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			Thread.sleep(5000);
			uploadFile("\\resource\\images\\" + image + ".jpg");
			//Log.info("uploaded mobile image");
		}

		if (imageDesc != "")
			typeTextById("widgetImageDescription-" + panelPosition + "-videoUploadPanel", imageDesc + " " + d.toString());

		if (altText != "")
			typeTextById("widgetAltTextBackgroundImage-" + panelPosition + "-videoUploadPanel", altText + " " + d.toString());

		if (panelAudio != "")
		{
			String audio = getRandomAudio();
			clickIdentifierXpath(".//*[@id='widget" + panelNumber + "_uploadAudio']/img");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='widget" + panelNumber + "_audioFile']"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			uploadFile("\\resource\\audio\\" + audio + ".mp3");
			//Log.info("uploaded audio");
			Thread.sleep(5000);
		}


		getScrrolToWebElement("//button[@id='ok-button']");
		clickIdentifierXpath("//button[@id='ok-button']");
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
		//clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");

		//getWaitForElementPresent("//td[text()='Page saved']", 90);
		//	Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
		//clickIdentifierXpath(".//*[@id='ok-button']");

		//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

		//Thread.sleep(3000);

		//if (pageSaved.contains("Page saved"))
		//	Log.pass("panel saved");
		//else
		//	Log.fail("panel failed to save for reason: " + pageSaved);
	}

	//	catch(Exception e){  
	//	       Log.fail("Failed to add video panel");
	//	       e.printStackTrace();
	//	       throw e;                                        
	//	} catch(AssertionError e)
	//	{
	//	       Log.fail("Failed to add video panel");
	//	       e.printStackTrace();
	//	       throw e;

	//	}
	//}

	/**
	 * to be called after addPage for template with new layout
	 * @param enableBulletin enable bulletin yes/no
	 * @param bulletinLarge enable large bulletin yes/no
	 * @param bulletinMandatory enable mandatory bulletin yes/no
	 * @param bulletinType supply bulletin type by name
	 * @param bulletinTitle bulletin title
	 * @param bulletinText bulletin text
	 */
	static public void editNewBulletin(String enableBulletin, String bulletinLarge, String bulletinMandatory, String bulletinType, String bulletinTitle, String bulletinText) throws Exception
	{
		//try
		//{
		Date d = new Date();

		//Log.info("start adding new bulletin");



		if (enableBulletin != "")
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0, 500)", "");


			clickIdentifierXpath(".//*[@id='tabs']/ul/li[1]");

			//clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span");
			//Log.info("bulletin enabled");

			WebElement check1 = driver.findElement(By.id("bulletinVisible"));
			Boolean value = check1.isSelected();
			//Log.info("bulletin is " + value);

			if (value && enableBulletin =="no")
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span");
				//	Log.info("turned off bulletin");
			}

			if (!value && enableBulletin =="yes")
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span");
				//	Log.info("turned on bulletin");
			}
		}

		if (bulletinLarge != "")
		{
			//clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span");
			WebElement check1 = driver.findElement(By.id("bulletinSize"));
			Boolean value = check1.isSelected();
			//Log.info("bulletin large is " + value);

			if (value && bulletinLarge =="no")
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span");
				//	Log.info("turned off bulletin large");
			}

			if (!value && bulletinLarge =="yes")
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span");
				//	Log.info("turned on bulletin large");
			}
		}

		if (bulletinMandatory != "")
		{
			//clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/span");
			//Log.info("bulletin is now optional");

			WebElement check1 = driver.findElement(By.id("bulletinOption"));
			Boolean value = check1.isSelected();
			//Log.info("bulletin mandatory is " + value);

			if (value && bulletinMandatory =="no")
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/span");
				//	Log.info("turned off bulletin mandatory");
			}

			if (!value && bulletinMandatory =="yes")
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/span");
				//	Log.info("turned on bulletin mandatory");
			}
		}

		//driver.findElement(By.xpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span")).click();
		//Log.info("Clicked on toggle button Yes for bulletin");

		//driver.findElement(By.xpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span")).click();
		//Log.info("Clicked on toggle button Yes for Large bulletin");
		//Thread.sleep(5000);  
		// typeTextByXpath(".//div[@id='ckeditorContentBulletin']","Bulletin Title");

		if (bulletinType != "")
			clickIdentifierByID(bulletinType);

		if (bulletinTitle != "")
			typeTextById("ckeditorContentBulletinTitle", bulletinTitle + " " + d.toString());
		//Log.info("Entered bulletin title");
		//Thread.sleep(500);

		if (bulletinText != "")
			typeTextById("ckeditorContentBulletin", bulletinText + " " + d.toString());




		//clickIdentifierXpath("//img[@id='saveIconId']");
		//getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		//clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());

		//Log.info("Entered bulletin text");

		//driver.findElement(By.xpath(".//*[@id='tab1']/div/div[3]/div[5]/div[2]/div/div/span")).click();

		//clickIdentifierXpath(".//*[@id='ok-button']");

		//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");

		//Thread.sleep(3000);

		//if (pageSaved.contains("Page saved"))
		//	Log.pass("bulletin saved");
		//else
		//	Log.fail("bulletin failed to save for reason: " + pageSaved);
		//}

		//catch(Exception e){  
		//      Log.fail("Failed to edit bulletin");
		//     e.printStackTrace();
		//     throw e;                                        
		//} catch(AssertionError e)
		//{
		//      Log.fail("Failed to edit bulletin");
		//      e.printStackTrace();
		//      throw e;

		//}
	}


	/**
	 * to be called after addPage or selectPage
	 * @param layout either: "text-only", "dir-ltr, "dir-rtl", "dir-ttb", "dir-btt" or "dir-fsg"
	 * @param pageTitle page title
	 * @param showTitle show title yes/no
	 * @param pageContent the content for the page
	 * @param desktopImage show desktop image yes or blank for no
	 * @param mobileImage show mobile image yes or blank for no
	 * @param audioFile add audio yes or blank for no
	 * @param imageDesc image description
	 * @param altText alt text
	 */
	static public void editTextTemplate(String layout, String pageTitle, String showTitle, String pageContent, String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText) throws Exception
	{
		getWaitPageLoad();
		//try
		//{
		Date d = new Date();
		//Log.startTestCase("editing text and graphic");
		Thread.sleep(1000);
		getWaitForElementPresent("//div[text()='Text and Graphic']",90);
		if (layout != "")
			clickIdentifierByID("layout-" + layout + "-main");
		if (pageTitle != "")
			typeTextById("pageTitle", pageTitle + " " + d.toString());
		if (showTitle == "no")
		{
			uncheckCheckBox("//*[@id='pageTitleId']/div/div/div/div/input");
			//	Log.info("unchecked show title");
		}

		if (showTitle == "yes")
		{
			checkCheckBox("//*[@id='pageTitleId']/div/div/div/div/input");
			//	Log.info("checked show title");
		}

		if (pageContent != "")
			typeTextById("ckeditorContenttextGraphic_content", pageContent + " " + d.toString());


		//if (audioFile != "")
		//{
		//	String audio = getRandomAudio();
			//clickIdentifierXpath("//*[@id='page_uploadAudio']/img");
			//WebElement file = driver.findElement(By.xpath("//*[@id='page_uploadAudio']/img"));
			//file.sendKeys(appPath()+"\\resource\\audio\\" + audio + ".mp3");
			//WebElement file = driver.findElement(By.xpath(".//*[@id='page_audioFile']"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			//Thread.sleep(900);
			///CAT_fx_integrationjenkins/resource/audio/Ambianica.mp3
			//uploadFile("\\resource\\audio\\Ambianica.mp3");
			//uploadFile("\\CAT_fx_integrationjenkins\\resource\\audio\\"+audio+".mp3");
			//Log.info("uploaded audio");
	//	}

		//if (desktopImage != "")
		//{
		//getScrrolToWebElement("//*[@id='page_uploadAudio']/img");
		//String image = getRandomImage();
		//WebElement file = driver.findElement(By.xpath("//*[@id='page_uploadAudio']/img"));
		//file.sendKeys(appPath()+"\\resource\\images\\"+image+".jpg");
		//clickIdentifierXpath("//*[@id='desktop-image-main-div-textGraphic_image']/img");
		//WebElement file = driver.findElement(By.xpath("//*[@id='desktop-image-main-div-textGraphic_image']/input[2]"));
		//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
		//Thread.sleep(5000);
		//uploadFile("\\resource\\images\\"+image+".jpg");

		//Log.info("uploaded desktop image");
		//}

		//if (mobileImage != "")
		//{
			//String image = getRandomImage();
			//clickIdentifierXpath("//*[@id='mobile-image-main-div-textGraphic_image']/img");
			//WebElement file = driver.findElement(By.xpath("//*[@id='mobile-image-main-div-textGraphic_image']/input[2]"));
			//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			//Thread.sleep(5000);
			//uploadFile("\\resource\\images\\"+image+".jpg");
			//Log.info("uploaded mobile image");
			//clickIdentifierXpath("//p[text()='Background Image']");
			//getUploadImage("//div[@id='tab-desktop-image-div']");
		//}
		CSSAdd(altText + " " + d.toString());
		BackGroundImage(altText + " " + d.toString());
		addBulletin( altText + " " + d.toString());
	
		//if (imageDesc != "")
		//	typeTextById("widgetImageDescription-textGraphic_image", imageDesc + " " + d.toString());

		//if (altText != "")
		//	typeTextById("widgetAltTextBackgroundImage-textGraphic_image", altText + " " + d.toString());

		//addNewTemplateBackgroundImage();
		//
		//clickIdentifierXpath("//*[@id='mobile-image-main-div-textGraphic_image']/img");
		getScrrolToWebElement("//button[@id='ok-button']");
		clickIdentifierXpath("//button[@id='ok-button']");
		//getWaitForElementPresent("//td[text()='Page saved']",90);
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
		//clickIdentifierByID("saveIconId");

		//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
		//System.out.println("pageSaved::"+pageSaved);
		//Thread.sleep(3000);

		//if (pageSaved.contains("Page saved"))
		//Log.pass("page saved");
		//else
		//Log.fail("page failed to save for reason: " + pageSaved);
	}

	//catch(Exception e){  
	//       Log.fail("Failed to edit text template");
	//       e.printStackTrace();
	//       throw e;                                        
	///} catch(AssertionError e)
	//{
	//	       Log.fail("Failed to edit text template");
	//	       e.printStackTrace();
	//       throw e;

	//	}
	//}

	public static void addBulletin(String message) throws Exception
	{
		String NoLocater_Xpath="//div[div[label[text()='Do you want to add a bulletin to this page?']]]/descendant::div[label[text()='No']]/span";
		clickIdentifierXpath("//p[text()='Bulletin']");
		getWaitForElementPresent(NoLocater_Xpath,90);
		clickIdentifierXpath(NoLocater_Xpath);
		getScrrolToWebElement("//div[@id='ckeditorContentBulletinTitle']");
		//div[label[text()='Bulletin Title']]/descendant::div[@id='ckeditorContentBulletinTitle']
		typeTextById("ckeditorContentBulletinTitle",message);
		typeTextById("ckeditorContentBulletin",message);
	}
	public static void CSSAdd(String message) throws Exception
	{
		clickIdentifierXpath("//p[text()='CSS']");
		typeTextById("custom-css-section",message);
	}
	public static void BackGroundImage(String message) throws Exception
	{
		clickIdentifierXpath("//p[text()='Background Image']");
		getUploadImage("//div[@id='tab-desktop-image-div']");
		//clickIdentifierByID("graphicDescription");
		typeTextByXpath("//input[@name='backgroundImageGraphicDescription']", message);
		//typeTextById("graphicDescription",message);
	} 
}
