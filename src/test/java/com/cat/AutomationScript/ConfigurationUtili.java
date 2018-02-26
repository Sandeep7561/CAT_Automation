package com.cat.AutomationScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class ConfigurationUtili extends TextAndGraphicScriptUtili
{

	/**
	 * Must be called while user is on create your course tab after course has at least 1 page
	 * @param lesson lesson position of the page we are deleting, increase by 1 if landing page is present
	 * @param topic topic position of the page we are deleting
	 * @param page page position of the page we are deleting
	 */
	static public void deletePage(String lesson, String topic, String page) throws Exception
	{
			getWaitPageLoad();
		//try
		//{
			//Log.startTestCase("starting delete page test case");  
			Thread.sleep(3000);
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			// WebElement productLink11 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			Thread.sleep(2000);
			clickIdentifierXpath("html/body/ul/li[4]/a");
			//Log.info("clicked on Delete");
			Thread.sleep(1000);
			//clickIdentifierXpath("//div[@class='ui-dialog-buttonset']/button[1]");
			clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			///Log.info("clicked on yes on Delete popup");
			Thread.sleep(5000);
		//}

		//catch(Exception e){  
			//Log.fail("Failed to delete page");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			///Log.fail("Failed to delete page");
		//	e.printStackTrace();
		//	throw e;

		//}
	}


	/**
	 * to be called when user is on create your course tab after copyNode
	 * @param lesson lesson position of page we are pasting, increase by 1 if landing page is present
	 * @param topic topic position of the page
	 */
	static public void pasteNode(String lesson, String topic) throws Exception
	{
		
			getWaitPageLoad();
		////try
		///{
			//Log.startTestCase("starting paste node test case");  
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			WebElement productLink = null;
			if (lesson != "" && topic != "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/a"));
			else if (lesson != "" && topic == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/a"));
			//Log.info("found the page"); 
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			//Log.info("right clicked on the page");
			//Thread.sleep(10000);
			if (lesson != "" && topic != "")
				clickIdentifierXpath("html/body/ul/li[5]/a");
			else if (lesson != "" && topic == "")
				clickIdentifierXpath("html/body/ul/li[5]/a");
			Thread.sleep(5000);

			
			//Log.pass("clicked on paste");

			//String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			//if (publish.contains("Node paste successfull."))
			//{
			//	Log.pass("node successfully pasted");
			//}

			//else
			//	Log.fail("node did not paste for reason: " + publish);

			//Thread.sleep(20000);

		//}

		//catch(Exception e){  
			//Log.fail("Failed to paste node");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
		//	Log.fail("Failed to paste node");
		//	e.printStackTrace();
		//	throw e;

		//}
	}


	/**
	 * Must be called while user is on create your course tab
	 * @param lesson provide the lesson position you wish to copy (increase by 1 if landing page is present)
	 * @param topic provide the topic position you wish to copy
	 * @param page provide the page position you wish to copy
	 */

	static public void copyNode(String lesson, String topic, String page) throws Exception
	{
		
			getWaitPageLoad();
		//try
		//{
			//Log.startTestCase("starting copy node test case");  
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			WebElement productLink = null;
			if (lesson != "" && topic != "" && page != "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			else if (lesson != "" && topic != "" && page == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/a"));
			else if (lesson != "" && topic == "" && page == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/a"));
			//Log.info("found the page"); 
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			//Log.info("right clicked on the page");
			//getWaitForElementPresent("html/body/ul/li[1]/a", 90);
			clickIdentifierXpath("html/body/ul/li[1]/a");
			Thread.sleep(5000);

			//Log.pass("clicked on copy");
			//String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			//if (publish.contains("Node copy successfull"))
			//{
				//Log.pass("node successfully copied");
			//}
			//else
				//Log.fail("node did not copy for reason: " + publish);
			//Thread.sleep(20000);
		}

		///catch(Exception e){  
			//Log.fail("Failed to copy node");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to copy node");
		//	e.printStackTrace();
		///	throw e;

		//}
	//}



	/**
	 * to be called when user is on create your course tab and page is hidden or after hidePage
	 * @param lesson lesson position of the page we are unhiding, increase by 1 if landing page is present
	 * @param topic topic position for the page we are unhiding
	 * @param page position of page we are unhiding
	 */
	static public void unhidePage(String lesson, String topic, String page) throws Exception
	{
			getWaitPageLoad();
		//try
		//{
			//Log.startTestCase("starting unhide page test case");  
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			WebElement productLink = null;
			if (lesson != "" && topic != "" && page != "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			else if (lesson != "" && topic != "" && page == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]"));
			else if (lesson != "" && topic == "" && page == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]"));
			// WebElement productLink11 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			clickIdentifierXpath("html/body/ul/li[1]/a");
			Thread.sleep(5000);

			//Log.info("clicked on UnHide");
			//Thread.sleep(20000);

		}

		//catch(Exception e){  
			//Log.fail("Failed to unhide page");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to unhide page");
		//	e.printStackTrace();
		//	throw e;

		//}
	//}


	/**
	 * to be called when user is on create your course tab
	 * @param lesson lesson position of page we are hiding, increase by 1 if landing page is present
	 * @param topic topic position of the page
	 * @param page the position of the page
	 */
	static public void hidePage(String lesson, String topic, String page) throws Exception
	{
			getWaitPageLoad();
		//try
		//{
			//Log.startTestCase("starting hide page test case");  

			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			// WebElement productLink11 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			Actions action11= new Actions(driver);
			action11.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			clickIdentifierXpath("html/body/ul/li[2]/a");
			Thread.sleep(5000);

			//Log.info("clicked on Hide");
			//Thread.sleep(20000);

		//}

		//catch(Exception e){  
			//Log.fail("Failed to hide page");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to hide page");
		//	e.printStackTrace();
		//	throw e;

		//}
	}



	/**
	 * to be called when user is on create your course tab or after lockPage
	 * @param lesson lesson position of page we are unlocking, increase by 1 if landing page is present
	 * @param topic topic position of page we are unlocking
	 * @param page position of page we are unlocking
	 */
	static public void unlockPage(String lesson, String topic, String page) throws Exception
	{
		//try
		//{
			//Log.startTestCase("starting unlock page test case");  
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			getWaitPageLoad();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			Actions action1= new Actions(driver);
			action1.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			clickIdentifierXpath("html/body/ul/li[1]/a");
			Thread.sleep(5000);

			//Log.pass("clicked on UnLock");

		}

		//catch(Exception e){  
			//Log.fail("Failed to lock page");
		//	e.printStackTrace();
		//	throw e;                                        
		//} catch(AssertionError e)
		//{
			//Log.fail("Failed to lock page");
		//	e.printStackTrace();
		//	throw e;

		//}
	//}



	/**
	 * to be called when user is on create your course tab
	 * @param lesson lesson position of page we are locking, increase by 1 if landing page is present
	 * @param topic topic position of the page
	 * @param page the position of the page
	 */
	static public void lockPage(String lesson, String topic, String page) throws Exception
	{
		//try
		//{
			//Log.startTestCase("starting lock page test case");  
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			getWaitPageLoad();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(10000);
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			//Log.info("found the page"); 
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			//Log.info("right clicked on the page");
			getWaitForElementPresent("html/body/ul/li[3]/a", 200);
			//Thread.sleep(10000);
			clickIdentifierXpath("html/body/ul/li[3]/a");
			//Log.pass("clicked on Lock");
			Thread.sleep(5000);

		}

	//	catch(Exception e){  
			//Log.fail("Failed to lock page");
	//		e.printStackTrace();
	//		throw e;                                        
	//	} catch(AssertionError e)
	//	{
			//Log.fail("Failed to lock page");
	//		e.printStackTrace();
	//		throw e;
//
//		}
	//}

}
