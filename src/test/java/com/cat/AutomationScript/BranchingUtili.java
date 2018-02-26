package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cat.utility.LogerData;



public class BranchingUtili extends TextAndGraphicScriptUtili {

	
	/**
	 * Must be called after addLesson and addTopic, preferably with 2 topics
	 * @param lessonPosition position of the lesson you wish to configure (if landing page is present increase by 1)
	 * @param tilesPerRow1 how many tiles per row (cannot be more than 5 or less than 2)
	 * @param lessonAudio add audio to the lesson, leave blank for no
	 * @param lessonWelcome welcome message for branching lesson
	 * @param lessonCompletion  completion message for branching lesson, if left blank will set to no
	 * @param lessonImage add image to lesson, leave blank for no
	 * @param topicMandatory set first topic to mandatory yes/no
	 * @param completeTopics how many topics to complete
	 */
	
	static public void createBranchingLesson(String lessonPosition, int tilesPerRow1, String lessonAudio, String lessonWelcome, String lessonCompletion, String lessonImage, String topicMandatory, String completeTopics) throws Exception
	{
		//try
		//{
			//Log.startTestCase("start creating branching lesson");
			getWaitPageLoad();
			Date d = new Date();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(5000);
			clickIdentifierXpath("//*[@id='courseTree']/ul/li/ul/li["+ lessonPosition + "]/a");
		
			clickIdentifierByID("layout-adp-lsn-typ-branching-main");
			//Thread.sleep(1000);
			String tilesPerRow = Integer.toString(tilesPerRow1);
			if (tilesPerRow1 < 5 && tilesPerRow1 > 2)
				clickIdentifierXpath(".//*[@id='branchingInfo']/div[1]/div[2]/div[" + tilesPerRow + "]/img");
			//if (lessonAudio != "")
			//{
			//	String audio = getRandomAudio();
			//	clickIdentifierXpath(".//*[@id='branchingInfo']/div[2]/div[2]/div[2]/input[1]");
			//	Thread.sleep(2000);
			//	clickIdentifierXpath(".//*[@id='audBtn_1']");
			//	Thread.sleep(2000);
			//	WebElement file = driver.findElement(By.xpath(".//*[@id='audFile_1']"));
			//	file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			//	Thread.sleep(13000);
			//	clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
			//	Thread.sleep(2000);
				//Log.info("uploaded lesson audio");
			//}
			typeTextById("branchingLessonEditorContent", lessonWelcome + " " + d.toString());
			if (lessonCompletion != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("completionMsg"));
				Boolean value = check1.isSelected();
				//Log.info("lesson completion is " + value);
				
				if (value && lessonCompletion == "")
				{
					clickIdentifierXpath(".//*[@id='branchingInfo']/div[2]/div[4]/div[2]/div/div/span");
					//Log.info("turned off completion message");
				}
				
				if (!value && lessonCompletion != "")
				{
					clickIdentifierXpath(".//*[@id='branchingInfo']/div[2]/div[4]/div[2]/div/div/span");
					//Log.info("turned on completion message");
					typeTextById("branchingLessonEditorContent1", lessonCompletion + " " + d.toString());
				}
				Thread.sleep(1000);
			}
			
			if (lessonImage != "")
			{
				//String image = getRandomImage();
				//getScrrolToWebElement("//input[@id='Upload']");
				getUploadImage("//input[@id='Upload']");
				//clickIdentifierXpath(".//*[@id='branchingLessonBackgroundImage']/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='branchingLessonBackgroundImage']/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(60000);
				//Log.info("uploaded lesson image");
			}
			
			if (topicMandatory != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.xpath(".//*[@id='branchingInfo']/div[6]/div[4]/div/input"));
				Boolean value = check1.isSelected();
				//Log.info("mandatory topic is " + value);
				
				if (value && topicMandatory =="no")
				{
					clickIdentifierXpath(".//*[@id='branchingInfo']/div[6]/div[4]/div/div/span");
					//Log.info("turned off mandatory topic");
				}
				
				if (!value && topicMandatory =="yes")
				{
					clickIdentifierXpath(".//*[@id='branchingInfo']/div[6]/div[4]/div/div/span");
					//Log.info("turned on mandatory topic");
				}
				
				Thread.sleep(1000);
			}
			
			if (completeTopics == "1" || completeTopics == "2")
				selectDropdownValueXpathVisibleText(".//*[@id='totalTopicNeedsTobeCovered']", completeTopics);
			
			
			getScrrolToWebElement("//button[@id='lessonSave']");
			clickIdentifierXpath("//button[@id='lessonSave']");
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Lesson saved']")).isDisplayed());
			//try{
			//clickIdentifierXpath("//button[text()='OK']");
			//}catch(Exception e)
			//{
				//System.out.println("locater not found ");
			//	LogerData.info("Ok Buttion not found.");
			//}
			//Thread.sleep(1000);
			
			//clickIdentifierByID("saveIconId");
			
			//Log.info("clicked on save button");
			
			//String lessonSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			//Thread.sleep(3000);
			
			//if (lessonSaved1.contains("Lesson saved"))
				//Log.pass("lesson saved");
			//else
				//Log.fail("lesson failed to save for reason: " + lessonSaved1);
		//}
		
		//catch(Exception e){  
		      // Log.fail("Failed to create branching lesson");
		//       e.printStackTrace();
		//       throw e;                                        
		//} catch(AssertionError e)
		//{
		       //Log.fail("Failed to create branching lesson");
		//       e.printStackTrace();
		//       throw e;
		//}
	}
	
	/**
	 * Must be called after createBranchingLesson
	 * @param lessonPosition lesson position that contains the topics (if landing page is present increase by 1)
	 * @param topicPosition topic position you wish you edit
	 * @param topicDesc add topic description
	 * @param topicLayout set tile layout
	 * @param topicImage add tile image, leave blank if no
	 */
	
	static public void configureTopic(String lessonPosition, String topicPosition, String topicDesc, String topicLayout, String topicImage) throws Exception
	{
			getWaitPageLoad();
		//try
		//{
			Date d = new Date();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			//Log.info("start configuring topic " + topicPosition);
			getWaitForElementPresent(".//*[@id='courseTree']/ul/li/ul/li[" + lessonPosition + "]/ul/li[" + topicPosition + "]/a", 300);
			clickIdentifierXpath(".//*[@id='courseTree']/ul/li/ul/li[" + lessonPosition + "]/ul/li[" + topicPosition + "]/a");
			//Thread.sleep(10000);
			if(topicDesc != "")
				typeTextById("branchingTopicEditorContent", topicDesc + " " + d.toString());
			if (topicLayout == "Full image" || topicLayout == "Fifty fifty" || topicLayout == "Solid")
				selectDropdownValueXpathVisibleText(".//*[@id='topicLayoutId']", topicLayout);
			if (topicImage != "")
			{
				String image = getRandomImage();
				getUploadImage("//input[@id='Upload']");
				//clickIdentifierXpath(".//*[@id='branchingTopicBackgroundImage']/div[1]/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='branchingTopicBackgroundImage']/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//Thread.sleep(60000);
				//Log.info("uploaded topic image");
			}
			
			getScrrolToWebElement("//button[@id='topicSave']");
			clickIdentifierXpath("//button[@id='topicSave']");
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Topic saved']")).isDisplayed());
			
			
			
			//Thread.sleep(1000);
			
			//clickIdentifierByID("topicSave");
			
			//Log.info("clicked on save button");
			
			//String lessonSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			//Thread.sleep(3000);
			
			//if (lessonSaved1.contains("Topic saved"))
				//Log.pass("topic " + topicPosition + " saved");
			//else
				//Log.fail("topic " + topicPosition + " failed to save for reason: " + lessonSaved1);
		//}
		
		//catch(Exception e){  
		       //Log.fail("Failed to configure topic " + topicPosition);
		//       e.printStackTrace();
		//       throw e;                                        
		//} catch(AssertionError e)
		//{
		      // Log.fail("Failed to configure topic " + topicPosition);
		//       e.printStackTrace();
		//       throw e;
		//}
	}


	
}
