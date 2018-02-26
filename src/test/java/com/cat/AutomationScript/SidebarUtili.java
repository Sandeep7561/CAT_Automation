package com.cat.AutomationScript;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;



public class SidebarUtili extends ConsultTemplateUtili 
{

	static public void sidebar(String layout, String pageTitle, String showTitle, String pageContent,String sidebarType ,String sbTitle,String sbText,String sbFaq,String sbTop10,String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText,String selectbulletintype, String bulletinTitle,String bulletinText) throws Exception
	{
		
			getWaitPageLoad();
	//	try
	//	{
			Date d = new Date();
			//Log.startTestCase("Adding Sidebar Template");
			Thread.sleep(1000);
			if (layout != "")
				clickIdentifierByID("layout-" + layout + "-main");
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			if (showTitle == "no")
			{
				uncheckCheckBox("//*[@id='mz-showTitle-2']");
				//Log.info("unchecked show title");
			}
			
			if (showTitle == "yes")
			{
				checkCheckBox("//*[@id='mz-showTitle-2']");
				//Log.info("checked show title");
			}
			
			if (pageContent != "")
				typeTextById("ckeditorContentsidebar_content", pageContent + " " + d.toString());
			//if (audioFile != "")
			//{
			//	String audio = getRandomAudio();
			//	clickIdentifierXpath("//*[@id='page_uploadAudio']/img");
				//WebElement file = driver.findElement(By.xpath(".//*[@id='page_audioFile']"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			//	Thread.sleep(5000);
			//	uploadFile("\\resource\\audio\\" + audio + ".mp3");
				//Log.info("uploaded audio");
			//}
		
			String SBConfig =driver.findElement(By.xpath(".//*[@id='sidebar_type']/div[3]/div/div/label[1]")).getText();
			System.out.println("SB Config type default ="  + SBConfig); 
			String SBConfig1 =driver.findElement(By.xpath(".//*[@id='sidebar_type']/div[3]/div/div/label[2]")).getText();
			System.out.println("SB Config type1 ="  + SBConfig1);
			String SBConfig2 =driver.findElement(By.xpath(".//*[@id='sidebar_type']/div[3]/div/div/label[3]")).getText();
			System.out.println("SB Config type2 ="  + SBConfig2);
						
			if (SBConfig.equals(sidebarType))
			{
				//Log.info("Custom config type is selected");
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentSidebarTitle", sbTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentSidebarText", sbText + " " + d.toString());
				
				//if (desktopImage != "")
				//{
					//String image = getRandomImage();
				//	getScrrolToWebElement("//span[text()='Custom']");
				//	getUploadImage(".//div[@id='desktop-image-main-div-sidebar_image']/div[1]");
					//clickIdentifierXpath(".//div[@id='desktop-image-main-div-sidebar_image']/img");
					//WebElement file = driver.findElement(By.xpath(".//div[@id='desktop-image-main-div-sidebar_image']/input[2]"));
					//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\" + image + ".jpg");
					//Log.info("uploaded desktop image");
				//}
				
				//if (mobileImage != "")
				//{
					
					//getUploadImage(".//div[@id='mobile-image-main-div-sidebar_image']/div[1]");
					//String image = getRandomImage();
					//clickIdentifierXpath(".//div[@id='mobile-image-main-div-sidebar_image']/img");
					//WebElement file = driver.findElement(By.xpath(".//div[@id='mobile-image-main-div-sidebar_image']/input[2]"));
					//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//Thread.sleep(5000);
					//uploadFile("\\resource\\images\\" + image + ".jpg");
					//Log.info("uploaded mobile image");
				//}
				
				if (imageDesc != "")
					//typeTextByXpath(".//*[@id='widgetImageDescription-sidebar_image']",imageDesc + " " + d.toString());
					typeTextById("widgetImageDescription-sidebar_image", imageDesc + " " + d.toString());
				
				if (altText != "")
					
					//typeTextByXpath(".//*[@id='widgetAltTextBackgroundImage-sidebar_image']",altText + " " + d.toString());
					typeTextById("widgetAltTextBackgroundImage-sidebar_image", altText + " " + d.toString());
				
				}	
					
			else if(SBConfig1.equals(sidebarType)){
				
				clickIdentifierXpath(".//*[@id='sidebar_type']/div[3]/div/div/label[2]/div/label");
				selectDropdownValueXpathVisibleText(".//div[@id='sidebarDropdownDiv']/select",sbFaq);
				typeTextById("ckeditorContentSidebarText", sbText + " " + d.toString());
				//Log.info("FAQ config type is selected");
						
			}
			else{
				
				clickIdentifierXpath(".//*[@id='sidebar_type']/div[3]/div/div/label[3]/div/label");
				Thread.sleep(3000);
				selectDropdownValueXpathVisibleText(".//div[@id='sidebarDropdownDiv']/select",sbTop10);
				typeTextById("ckeditorContentSidebarText", sbText + " " + d.toString());
				//Log.info("TOP10 config type is selected");
				
			}
			
			//Bulletin 
			String bulletinstatus =driver.findElement(By.xpath(".//div[@id='tab1']/div/div[1]/div[2]/div/div/label[2]")).getText();
			System.out.println("Add Bulletin to pgae toggle Button Status="  + bulletinstatus); 
			
			String addBstatus = "NO";
			
			if (bulletinstatus.equals(addBstatus))
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div");
				System.out.println("Add Bulletin to pgae toggle Button Status to yes" ); 
				String largeBstatus =driver.findElement(By.xpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/label[2]")).getText();
				System.out.println("large Bulletin toggle Button Status="  + largeBstatus);
				String lbStatus = "NO";
				
				if(largeBstatus.equals(lbStatus)){
					clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div");
					System.out.println("large Bulletin toggle Button Set to yes" ); 
					
				String mBstatus =driver.findElement(By.xpath(".//div[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/label[2]")).getText();
				System.out.println("large Bulletin toggle Button Status="  + mBstatus);
				String bmand = "NO";
				if(mBstatus.equals(bmand)){
					clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]");
					System.out.println("Add Bulletin to pgae toggle Button Status to yes" ); 
					
					//clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]");
					//if (selectbulletintype != "")
					
								clickIdentifierByID(selectbulletintype);
								
								typeTextById("ckeditorContentBulletinTitle", bulletinTitle + " " + d.toString());
								//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
								typeTextById("ckeditorContentBulletin", bulletinText + " " + d.toString());
				
								addNewTemplateBackgroundImage();
			}
			else
			{
								
					
				}
				
				}
				else{
					
				}
				
			
			}
			else{
				
			}

			//clickIdentifierByID("saveIconId");
			
			//String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			//Thread.sleep(3000);
			
			//if (pageSaved.contains("Page saved"))
			//	Log.info("page saved");
			//else
			//	Log.fail("page failed to save for reason: " + pageSaved);
			
			getScrrolToWebElement("//button[@id='ok-button']");
			clickIdentifierXpath("//button[@id='ok-button']");
			//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
			
		}
		
	//	catch(Exception e){  
	//	       Log.fail("Failed to edit sidebar template");
	//	       e.printStackTrace();
	//	       throw e;                                        
	//	} catch(AssertionError e)
	//	{
	//	       Log.fail("Failed to edit sidebar template");
	//	       e.printStackTrace();
	//	       throw e;

	//	}
	//}

}
