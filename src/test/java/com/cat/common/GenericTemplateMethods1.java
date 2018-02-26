package com.cat.common;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import com.cat.utility.WebAppCommon;
//import com.lrn.common.WebAppCommon;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.apache.http.auth.AuthenticationException;
import org.json.JSONException;

public class GenericTemplateMethods1 extends WebAppCommon {

	/////////////////////////////////////////////// @After and @Before Methods//////////////////////////////////////////////////////////////

	@BeforeSuite(groups = { "ExtentReports" })
	public void startExtentReports() throws Exception {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy-HH.mm.ss");
		String dateTime = formatter.format(currentDate.getTime());
		//extent = new ExtentReports(System.getProperty("user.dir")+"\\HTML5Reports\\HTML5AutomationReport-"+dateTime+".html");
	}

	@AfterSuite(groups = { "ExtentReports", "Jira" })
	public void endExtentReports() throws Exception {
		//extent.flush();
		//extent.close();
	}

	//This method is for 'RunAnyCourse' script
	@Parameters({ "Browser", "PCorRemoteMachine", "IPAddress", "FullScreen", "Fast", "Screenshot", "JumpToPageNumber", "JumpToTileNumber"})
	@BeforeClass(groups = { "LaunchBrowser" })
	public void launchBrowserWindow(String Browser, String PCorRemoteMachine, String IPAddress, String FullScreen, String Fast, String Screenshot, String JumpToPageNumber, String JumpToTileNumber) throws Exception {
		launchBrowser(PCorRemoteMachine,IPAddress,Browser,FullScreen,Fast,Screenshot,JumpToPageNumber,JumpToTileNumber);
	}
	
	//This method is for 'ExportPDF' script
	@Parameters({ "Browser", "PCorRemoteMachine", "IPAddress", "FullScreen", "Fast", "Screenshot", "JumpToPageNumber", "JumpToTileNumber", "XlsName", "SheetName", "StartRowNumber", "EndRowNumber"})
	@BeforeClass(groups = { "LaunchBrowserAndCourseLogin" })
	public void LaunchBrowserAndCourseLogin(String Browser, String PCorRemoteMachine, String IPAddress, String FullScreen, String Fast, String Screenshot, String JumpToPageNumber, String JumpToTileNumber, String XlsName, String SheetName, int StartRowNumber, int EndRowNumber) throws Exception {
		//testlog = extent.startTest("Start Browser and LCEC Course Login");
		launchBrowser(PCorRemoteMachine,IPAddress,Browser,FullScreen,Fast,Screenshot,JumpToPageNumber,JumpToTileNumber);
		lcecCourseLogin(XlsName,SheetName,StartRowNumber,EndRowNumber);
		clickElement("ExportCourse");
		checkVisibilityOfElement(1000, "IAgreeCheckBox");
		clickElement("IAgreeCheckBox");
		clickElement("ContinueBtn");
		checkVisibilityOfElement(1000, "SelectPDFDropDown");
		//extent.endTest(testlog);
	}

	//This method is for 'RunTemplates' script
	@Parameters({ "Browser", "PCorRemoteMachine", "IPAddress", "FullScreen", "Fast", "Screenshot", "JumpToPageNumber", "JumpToTileNumber", "XlsName", "SheetName", "StartRowNumber", "EndRowNumber"})
	@BeforeClass(groups = { "LaunchBrowserAndCourse" })
	public void launchBrowserAndCourse(String Browser, String PCorRemoteMachine, String IPAddress, String FullScreen, String Fast, String Screenshot, String JumpToPageNumber, String JumpToTileNumber, String XlsName, String SheetName, int StartRowNumber, int EndRowNumber) throws Exception {
		//testlog = extent.startTest("Start Browser and Launch Course");
		launchBrowser(PCorRemoteMachine,IPAddress,Browser,FullScreen,Fast,Screenshot,JumpToPageNumber,JumpToTileNumber);
		runHTML5course(XlsName,SheetName,StartRowNumber,EndRowNumber);
		//extent.endTest(testlog);
	}

	@AfterClass(groups = { "End" })
	public void closeBrowser() throws Exception {
		driver.close();
		driver.quit();
		logINFO("Browser closed successfully");
	}

	@BeforeMethod(groups = { "ExtentReports", "Jira" })
	public void beforeMethod(ITestContext testContext,Method method) throws Exception {
		//testlog = extent.startTest((testContext.getName() + " :: " + this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
		//testlog = extent.startTest((testContext.getName() + " :: " + method.getName()), method.getName());
		//testlog = extent.startTest((testContext.getName()));
		//testlog.assignAuthor("Yogesh Shinkar");
		//testlog.assignCategory("CourseCompletion-ProductionEnviornment");
		//extent = extent.addSystemInfo("Browser", BrowserName);
		//extent = extent.addSystemInfo("Site", siteName+"-lcec");
		//extent = extent.addSystemInfo("Env", enviornment);
	}

	@AfterMethod(groups = { "ExtentReports" })
	public static void endTestCaseForExtentReports() throws Exception {
		//extent.endTest(testlog);
	}

	@AfterMethod(groups = { "Jira" })
	public static void postTestCaseExecution(ITestResult result,Method method) throws AuthenticationException, JSONException
	{
		//extent.endTest(testlog);
		Test test = method.getAnnotation(Test.class);
		//System.out.println(test);
		String testCaseID = test.testName();
		//System.out.println(testCaseID);
		if (testCaseID.equals(""))
		{
			System.out.println("testCaseID value is blank");
		} else {
			//String status = Integer.toString(result.getStatus());
			//System.out.println(status);
			//Execution.put(testCaseID, status);
			JiraRestUtility.updateTestStatusInJira(result, method);
			//System.out.println(testCaseID);
			//System.out.println(status);
			try{
				if(result.getStatus()==ITestResult.FAILURE)
				{
					//String c=result.getName();
					//String screenshot_path=captureScreenshot3(driver,c);
					//String image= logger.addScreenCapture(screenshot_path);
					//logger.log(LogStatus.FAIL, image);
				}
				//report.endTest(logger);
				//report.endTest(OnlineSetUP.logger);
				//report.flush();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////// Template Methods ///////////////////////////////////////////////////////

	public static void checkElementPresent(String Element) throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent(Element))
				{
					logINFO(Element + " : Present");
				} else
				{
					logINFO(Element + " : Not-Present");
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkElementPresent");
			logFAIL("The method checkElementPresent failed (error)");
			assertFail();
		}
	}

	public static void checkTextPresent(String Element) throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent(Element))
				{
					verifyElementTextPresent(Element); //TopicTitle1 //MainContent1 //MainImage
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkTextPresent");
			logFAIL("The method checkTextPresent failed (error)");
			assertFail();
		}
	}

	public static void checkImagePresent(String Element) throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent(Element))
				{
					verifyElementImagePresent(Element); 
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkImagePresent");
			logFAIL("The method checkImagePresent failed (error)");
			assertFail();
		}
	}

	public static void checkNEXTDisable() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("NEXTDisable") || verifyElementPresent("NEXTLock"))
				{
					logINFO("NEXTDisable : Present");
				} else
				{
					logFAIL("NEXTEnable : Present");
					assertFail();
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkNEXTDisable");
			logFAIL("The method checkNEXTDisable failed (error)");
			assertFail();
		}
	}

	public static void clickNEXT() throws Exception {
		try {
			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				handleConnectionLostMessageBox();
			} else
			{
				if (verifyElementPresent("NEXTDisable") || verifyElementPresent("NEXTLock"))
				{
					TakeScreenshot("Fail-NEXTDisable");
					logFAILED("NEXTDisable : Present (error)");
					clickElement("DesktopExit");
					Thread.sleep(3000);
					driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
					writeExcelData(8, ExcelRowNumber, "Fail");
					Assert.fail();
					//logFAIL("Automation ended forcefully because the 'NEXT' button found disabled on Page");
					//CloseBrowser();
				} else
				{
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElementText("NEXTEnable");
					Thread.sleep(100);
					if (verifyElementPresent("ConnectionLostMessageBox"))
					{
						handleConnectionLostMessageBox();
					}
					String CurrentPageURL = driver.getCurrentUrl();
					if (PreviousPageURL.equals(CurrentPageURL))
					{
						Thread.sleep(3000);
					}
					//Thread.sleep(3000);
					String CurrentPageURL1 = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
					if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
					{
						if (!verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAILED("PreviousPage-URL and CurrentPage-URL is Same (error)");
							clickElement("DesktopExit");
							Thread.sleep(3000);
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
							//lcecLogout();
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickNEXT");
			logFAILED("The method clickNEXT failed (error)");
			clickElement("DesktopExit");
			Thread.sleep(3000);
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			writeExcelData(8, ExcelRowNumber, "Fail");
			Assert.fail();
		}
	}

	public static void clickNEXTTimer() throws Exception {
		try {
			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				handleConnectionLostMessageBox();
			} else
			{
				if (verifyElementPresent("NEXTDisable") || verifyElementPresent("NEXTLock"))
				{
					if (verifyElementPresent("PageTimerTotal"))
					{
						if (verifyElementPresent("NEXTLock"))
						{
							checkInvisibilityOfElement(1000, "NEXTLock");
						}
						Thread.sleep(300);
						if (verifyElementPresent("NEXTDisable"))
						{
							checkInvisibilityOfElement(10, "NEXTDisable");
						}
					}
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElementText("NEXTEnable");
					Thread.sleep(100);
					if (verifyElementPresent("ConnectionLostMessageBox"))
					{
						handleConnectionLostMessageBox();
					}
					String CurrentPageURL = driver.getCurrentUrl();
					if (PreviousPageURL.equals(CurrentPageURL))
					{
						Thread.sleep(3000);
					}
					//Thread.sleep(3000);
					if (verifyElementPresent("BulletinClose"))
					{
						Thread.sleep(1000);
						clickElement("BulletinClose");
						TakeScreenshot("Fail-BulletinIconNotPresent");
						logFAIL("Bulletin Icon : Missing on Page (error)");
						assertFail();
						Thread.sleep(1000);
						clickNEXT();
						Thread.sleep(1000);
					}
					String CurrentPageURL1 = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
					if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
					{
						if (!verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAILED("PreviousPage-URL and CurrentPage-URL is Same (error)");
							clickElement("DesktopExit");
							Thread.sleep(3000);
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
							//lcecLogout();
						}
					}
				} else
				{
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElementText("NEXTEnable");
					Thread.sleep(100);
					if (verifyElementPresent("ConnectionLostMessageBox"))
					{
						handleConnectionLostMessageBox();
					}
					String CurrentPageURL = driver.getCurrentUrl();
					if (PreviousPageURL.equals(CurrentPageURL))
					{
						Thread.sleep(3000);
					}
					//Thread.sleep(3000);
					if (verifyElementPresent("BulletinClose"))
					{
						Thread.sleep(1000);
						clickElement("BulletinClose");
						Thread.sleep(1000);
						TakeScreenshot("Fail-BulletinIconNotPresent");
						logFAIL("Bulletin Icon : Missing on Page (error)");
						assertFail();
						clickNEXT();
						Thread.sleep(1000);
					}
					String CurrentPageURL1 = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
					if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
					{
						if (!verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAILED("PreviousPage-URL and CurrentPage-URL is Same (error)");
							clickElement("DesktopExit");
							Thread.sleep(3000);
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
							//lcecLogout();
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickNEXTTimer");
			logFAILED("The method clickNEXTTimer failed (error)");
			clickElement("DesktopExit");
			Thread.sleep(3000);
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			writeExcelData(8, ExcelRowNumber, "Fail");
			Assert.fail();
		}
	}

	public static void checkPageAudio() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("DesktopAudio"))
				{
					clickElementText("DesktopAudio");
					Thread.sleep(1000);
					verifyElementTextPresent("AudioTotalTime");
					clickElement("DesktopAudio");
				} else
				{
					//
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkPageAudio");
			logFAIL("The method checkPageAudio failed (error)");
			assertFail();
		}
	}

	public static void checkBulletin() throws Exception {
		try {
			if (verifyElementPresent("Bulletin"))
			{
				getAttribute("Bulletin","class");
				clickElement("Bulletin");
				checkImagePresent("BulletinImage");
				checkTextPresent("BulletinTitle");
				checkTextPresent("BulletinContent");
				TakeScreenshot("Pass");
				clickElement("BulletinClose");
			} else
			{
				//
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkBulletin");
			logFAIL("The method checkBulletin failed (error)");
			assertFail();
		}
	}

	public static void checkHelp() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("DesktopHelp"))
				{
					clickElementText("DesktopHelp");
					checkVisibilityOfElement(1000, "HelpMessageBox");
					if (verifyElementPresent("HelpMessageBox"))
					{
						logINFO("HelpMessageBox: Present");
						TakeScreenshot("Pass");
						clickElementText("HelpBoxClose");
					} else
					{
						TakeScreenshot("Fail-HelpMessageBoxNotPresent");
						logFAIL("HelpMessageBox: Not-Present (error)");
					}
				} else
				{
					//
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkHelp");
			logFAIL("The method checkHelp failed (error)");
			assertFail();
		}
	}

	public static void clickConsultSaqCorrectOptions() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
				{
					if (verifyElementPresent("ConsultSaqRadioOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("ConsultSaqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("ConsultSaqRadioOption"+ j +": Correct");
							clickElementText("ConsultSaqRadioOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("ConsultSaqRadioOption"+ j +": Incorrect");
							} else
							{
								logFAIL("ConsultSaqRadioOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("ConsultSaqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("ConsultSaqCheckboxOption"+ j +": Correct");
							clickElementText("ConsultSaqCheckboxOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("ConsultSaqCheckboxOption"+ j +": Incorrect");
							} else
							{
								logFAIL("ConsultSaqCheckboxOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else{
					break;
				}
			} 
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickConsultSaqCorrectOptions");
			logFAIL("The method clickConsultSaqCorrectOptions failed (error)");
			assertFail();
		}
	}

	public static void clickConsultSaqCorrectSubmit() throws Exception {
		try {
			if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
			{
				TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
				logFAIL("None of the anwer options are Correct (error)");
				assertFail();
				if (verifyElementPresent("ConsultSaqRadioOption1"))
				{
					clickElementText("ConsultSaqRadioOption1");
				}
				else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
				{
					clickElementText("ConsultSaqCheckboxOption1");
				}
			}
			if (verifyElementPresent("ConsultSaqSubmit"))
			{
				TakeScreenshot("Pass");
				clickElementText("ConsultSaqSubmit");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickConsultSaqCorrectSubmit");
			logFAIL("The method clickConsultSaqCorrectSubmit failed (error)");
			assertFail();
		}
	}

	public static void clickConsultSaqIncorrectOptions() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
				{
					if (verifyElementPresent("ConsultSaqRadioOption1"))
					{
						String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("ConsultSaqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("ConsultSaqRadioOption"+ j +": Incorrect");
							clickElementText("ConsultSaqRadioOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("ConsultSaqRadioOption"+ j +": Correct");
							} else
							{
								logFAIL("ConsultSaqRadioOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
					{
						String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("ConsultSaqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("ConsultSaqCheckboxOption"+ j +": Incorrect");
							clickElementText("ConsultSaqCheckboxOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("ConsultSaqCheckboxOption"+ j +": Correct");
							} else
							{
								logFAIL("ConsultSaqCheckboxOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickConsultSaqIncorrectOptions");
			logFAIL("The method clickConsultSaqIncorrectOptions failed (error)");
			assertFail();
		}
	}

	public static void clickConsultSaqIncorrectSubmit() throws Exception {
		try {
			if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
			{
				logINFO("None of the anwer options are Incorrect");
				TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
				if (verifyElementPresent("ConsultSaqRadioOption1"))
				{
					clickElementText("ConsultSaqRadioOption1");
				}
				else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
				{
					clickElementText("ConsultSaqCheckboxOption1");
				}
			}
			if (verifyElementPresent("ConsultSaqSubmit"))
			{
				TakeScreenshot("Pass");
				clickElementText("ConsultSaqSubmit");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickConsultSaqIncorrectSubmit");
			logFAIL("The method clickConsultSaqIncorrectSubmit failed (error)");
			assertFail();
		}
	}

	public static void checkConsultSaqIncorrectAlertBox() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
					clickConsultSaqIncorrectOptions();
					clickConsultSaqIncorrectSubmit();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkSaqIncorrectAlertBox");
			logFAIL("The method checkSaqIncorrectAlertBox failed (error)");
			assertFail();
		}
	}

	public static void clickGraphicalSaqCorrectOptions() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqRadioOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{	
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("saqCheckboxOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickGraphicalSaqCorrectOptions");
			logFAIL("The method clickGraphicalSaqCorrectOptions failed (error)");
			assertFail();
		}
	}

	public static void clickGraphicalSaqCorrectSubmit() throws Exception {
		try {
			if (verifyElementPresent("SaqSubmitDisable") || verifyElementPresent("CertSubmitDisable"))
			{
				TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
				logFAIL("None of the anwer options are Correct (error)");
				assertFail();
				clickElementText("runSaqORGraphicalSaqOption1");
			}
			if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
			{
				TakeScreenshot("Pass");
				clickElementText("runSaqORGraphicalSaqSubmit");
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickGraphicalSaqCorrectSubmit");
			logFAIL("The method clickGraphicalSaqCorrectSubmit failed (error)");
			assertFail();
		}
	}

	public static void clickGraphicalSaqIncorrectOptions() throws Exception {
		try{
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqRadioOption1"))
					{
						String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("saqRadioOption"+ j +"" + " = ["+ Incorrect +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("saqCheckboxOption1"))
					{
						String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Incorrect +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickGraphicalSaqIncorrectOptions");
			logFAIL("The method clickGraphicalSaqIncorrectOptions failed (error)");
			assertFail();
		}
	}

	public static void clickGraphicalSaqIncorrectSubmit() throws Exception {
		try {
			if (verifyElementPresent("SaqSubmitDisable") || verifyElementPresent("CertSubmitDisable"))
			{
				logINFO("None of the anwer options are Incorrect");
				TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
				clickElementText("runSaqORGraphicalSaqOption1");
			}
			if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
			{
				TakeScreenshot("Pass");
				clickElementText("runSaqORGraphicalSaqSubmit");
				Thread.sleep(2000);
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickGraphicalSaqIncorrectSubmit");
			logFAIL("The method clickGraphicalSaqIncorrectSubmit failed (error)");
			assertFail();
		}
	}

	public static void checkGraphicalSaqIncorrectAlertBox() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
					clickGraphicalSaqIncorrectOptions();
					clickGraphicalSaqIncorrectSubmit();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkGraphicalSaqIncorrectAlertBox");
			logFAIL("The method checkGraphicalSaqIncorrectAlertBox failed (error)");
			assertFail();
		}
	}

	public static void checkCorrectSelectedOption() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqMultipleChoice"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +""))
						{
							String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							if (Correct.equals("chVal01"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqRadioOption"+ j +": Selected & Disabled");
								} else
								{
									if (!Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logFAIL("saqRadioOption"+ j +": Un-Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqRadioOption"+ j +"Enabled");
											logFAIL("saqRadioOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							} else if (Correct.equals("chVal00"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqRadioOption"+ j +": Un-Selected & Disabled");
								} else
								{
									if (Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logFAIL("saqRadioOption"+ j +": Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqRadioOption"+ j +"Enabled");
											logFAIL("saqRadioOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							}
						}
						else if (verifyElementPresent("saqMultipleChoice"+ j +""))
						{
							String Correct = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
							if (Correct.equals("chVal01"))
							{
								String Selected2 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
								if (Selected2.contains("selected") && Selected2.contains("disabled"))
								{
									logINFO("saqMultipleChoice"+ j +": Selected & Disabled");
								} else
								{
									if (!Selected2.contains("selected") && Selected2.contains("disabled"))
									{
										logFAIL("saqMultipleChoice"+ j +": Un-Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected2.contains("disabled"))
										{
											TakeScreenshot("Fail-saqMultipleChoice"+ j +"Enabled");
											logFAIL("saqMultipleChoice"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							} else if (Correct.equals("chVal00"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqMultipleChoice"+ j +": Un-Selected & Disabled");
								} else
								{
									if (Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logFAIL("saqMultipleChoice"+ j +": Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqMultipleChoice"+ j +"Enabled");
											logFAIL("saqMultipleChoice"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
						{
							String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							if (Correct.equals("chVal01"))
							{
								String Selected2 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
								if (Selected2.contains("selected") && Selected2.contains("disabled"))
								{
									logINFO("saqCheckboxOption"+ j +": Selected & Disabled");
								} else
								{
									if (!Selected2.contains("selected") && Selected2.contains("disabled"))
									{
										logFAIL("saqCheckboxOption"+ j +": Un-Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected2.contains("disabled"))
										{
											TakeScreenshot("Fail-saqCheckboxOption"+ j +"Enabled");
											logFAIL("saqCheckboxOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							} else if (Correct.equals("chVal00"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqCheckboxOption"+ j +": Un-Selected & Disabled");
								} else
								{
									if (Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logFAIL("saqCheckboxOption"+ j +": Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqCheckboxOption"+ j +"Enabled");
											logFAIL("saqCheckboxOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkCorrectSelectedOption");
			logFAIL("The method checkCorrectSelectedOption failed (error)");
			assertFail();
		}
	}

	public static void checkIncorrectSelectedOption() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqMultipleChoice"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +""))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							if (Incorrect.equals("chVal00"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqRadioOption"+ j +": Selected & Disabled");
								} else
								{
									if (!Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logINFO("saqRadioOption"+ j +": Un-Selected & Disabled");
										//assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqRadioOption"+ j +"Enabled");
											logFAIL("saqRadioOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							} else if (Incorrect.equals("chVal01"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqRadioOption"+ j +": Un-Selected & Disabled");
								} else
								{
									if (Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logINFO("saqRadioOption"+ j +": Selected & Disabled");
										//assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqRadioOption"+ j +"Enabled");
											logFAIL("saqRadioOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							}
						}
						else if (verifyElementPresent("saqMultipleChoice"+ j +""))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
							if (Incorrect.equals("chVal00"))
							{
								String Selected2 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
								if (Selected2.contains("selected") && Selected2.contains("disabled"))
								{
									logINFO("saqMultipleChoice"+ j +": Selected & Disabled");
								} else
								{
									if (!Selected2.contains("selected") && Selected2.contains("disabled"))
									{
										logFAIL("saqMultipleChoice"+ j +": Un-Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected2.contains("disabled"))
										{
											TakeScreenshot("Fail-saqMultipleChoice"+ j +"Enabled");
											logFAIL("saqMultipleChoice"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							} else if (Incorrect.equals("chVal01"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqMultipleChoice"+ j +": Un-Selected & Disabled");
								} else
								{
									if (Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logINFO("saqMultipleChoice"+ j +": Selected & Disabled");
										//assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqMultipleChoice"+ j +"Enabled");
											logFAIL("saqMultipleChoice"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							if (Incorrect.equals("chVal00"))
							{
								String Selected2 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
								if (Selected2.contains("selected") && Selected2.contains("disabled"))
								{
									logINFO("saqCheckboxOption"+ j +": Selected & Disabled");
								} else
								{
									if (!Selected2.contains("selected") && Selected2.contains("disabled"))
									{
										logFAIL("saqCheckboxOption"+ j +": Un-Selected & Disabled");
										assertFail();
									} else
									{
										if (!Selected2.contains("disabled"))
										{
											TakeScreenshot("Fail-saqCheckboxOption"+ j +"Enabled");
											logFAIL("saqCheckboxOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							} else if (Incorrect.equals("chVal01"))
							{
								String Selected1 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqCheckboxOption"+ j +": Un-Selected & Disabled");
								} else
								{
									if (Selected1.contains("selected") && Selected1.contains("disabled"))
									{
										logINFO("saqCheckboxOption"+ j +": Selected & Disabled");
										//assertFail();
									} else
									{
										if (!Selected1.contains("disabled"))
										{
											TakeScreenshot("Fail-saqCheckboxOption"+ j +"Enabled");
											logFAIL("saqCheckboxOption"+ j +": Enabled (error)");
											assertFail();
										}
									}
								}
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkIncorrectSelectedOption");
			logFAIL("The method checkIncorrectSelectedOption failed (error)");
			assertFail();
		}
	}

	public static void checkIncorrectIconOnSelectedOption() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqMultipleChoice"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +""))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
							if (Incorrect.equals("chVal00"))
							{
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								} else if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							} else if (Incorrect.equals("chVal01"))
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								}
							}
						}
						else if (verifyElementPresent("saqMultipleChoice"+ j +""))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
							String Selected1 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
							if (Incorrect.equals("chVal00"))
							{
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultGraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								} else if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							} else if (Incorrect.equals("chVal01"))
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							String Selected1 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
							if (Incorrect.equals("chVal00"))
							{
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultGraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								} else if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							} else if (Incorrect.equals("chVal01"))
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								}
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkIncorrectIconOnSelectedOption");
			logFAIL("The method checkIncorrectIconOnSelectedOption failed (error)");
			assertFail();
		}
	}

	public static void checkCorrectIconOnSelectedOption() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqMultipleChoice"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqRadioOption"+ j +""))
						{
							String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
							if (Correct.equals("chVal01"))
							{
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								} else if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							} else if (Correct.equals("chVal00"))
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							}
						}
						else if (verifyElementPresent("saqMultipleChoice"+ j +""))
						{
							String Correct = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
							String Selected1 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
							if (Correct.equals("chVal01"))
							{
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								} else if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							} else if (Correct.equals("chVal00"))
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
						{
							String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							String Selected1 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
							if (Correct.equals("chVal01"))
							{
								if (Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
										} else if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										}
									} else {
										logFAIL("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
										assertFail();
									}
								} else if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-wrong")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							} else if (Correct.equals("chVal00"))
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									if (verifyElementPresent("SaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("SaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("GraphicalSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("GraphicalSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("ConsultSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConsultSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else if (verifyElementPresent("ConcernSaqTickCrossIconOnOption"+ j +"")){
										String TickOrCross = driver.findElement(objmap.getLocator("ConcernSaqTickCrossIconOnOption"+ j +"")).getAttribute("class");
										if (TickOrCross.contains("cs-correct")){
											logFAIL("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
											assertFail();
										} else if (TickOrCross.contains("cs-wrong")){
											logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
										}
									} else {
										logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
									}
								}
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkCorrectIconOnSelectedOption");
			logFAIL("The method checkCorrectIconOnSelectedOption failed (error)");
			assertFail();
		}
	}

	public static void clickSaqCorrectOptions() throws Exception {
		SAQYesNo ="Yes";
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					//if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +""))
				{
					if (verifyElementPresent("saqRadioOption1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("saqCheckboxOption1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickSaqCorrectOptions");
			logFAIL("The method clickSaqCorrectOptions failed (error)");
			assertFail();
		}
	}

	public static void clickSaqCorrectSubmit() throws Exception {
		try {
			if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
			{
				TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
				logFAIL("None of the anwer options are Correct (error)");
				assertFail();
				clickElementText("runSaqORGraphicalSaqOption1");
			}
			if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
			{
				TakeScreenshot("Pass");
				clickElementText("runSaqORGraphicalSaqSubmit");
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickSaqCorrectSubmit");
			logFAIL("The method clickSaqCorrectSubmit failed (error)");
			assertFail();
		}
	}

	public static void clickSaqIncorrectOptions() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqRadioOption1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("saqCheckboxOption1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					break;
				}
			} 
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickSaqIncorrectOptions");
			logFAIL("The method clickSaqIncorrectOptions failed (error)");
			assertFail();
		}
	}

	public static void clickSaqIncorrectSubmit() throws Exception {
		try {
			if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
			{
				logINFO("None of the anwer options are Incorrect");
				TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
				clickElementText("runSaqORGraphicalSaqOption1");
			}
			if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
			{
				TakeScreenshot("Pass");
				clickElementText("runSaqORGraphicalSaqSubmit");
				Thread.sleep(2000);
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickSaqIncorrectSubmit");
			logFAIL("The method clickSaqIncorrectSubmit failed (error)");
			assertFail();
		}
	}

	public static void checkSaqIncorrectAlertBox() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
					clickSaqIncorrectOptions();
					clickSaqIncorrectSubmit();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkSaqIncorrectAlertBox");
			logFAIL("The method checkSaqIncorrectAlertBox failed (error)");
			assertFail();
		}
	}

	public static void checkSaqFeedbackBox() throws Exception {
		try {
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkSaqFeedbackBox");
			logFAIL("The method checkSaqFeedbackBox failed (error)");
			assertFail();
		}
	}			

	public static void runAdaptiveSaqCorrect() throws Exception {
		SAQYesNo ="Yes";
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
						//if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Correct.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Correct.equals("chVal00"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Correct.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Correct.equals("chVal00"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
					} else {
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
						{
							TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
							logFAIL("None of the anwer options are Correct (error)");
							assertFail();
							clickElementText("runSaqORGraphicalSaqOption1");
						}
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							break;
						} else
						{
							TakeScreenshot("Fail-SubmitButtonIssue");
							logFAIL("Submit Button Issue (error)");
							assertFail();
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runAdaptiveSaqCorrect");
			logFAIL("The method runAdaptiveSaqCorrect failed (error)");
			assertFail();
		}
	}

	public static void runAdaptiveSaqIncorrect() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
					} else {
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
						{
							logINFO("None of the anwer options are Incorrect");
							TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
							clickElementText("runSaqORGraphicalSaqOption1");
						}
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							Thread.sleep(2000);
							break;
						} else
						{
							TakeScreenshot("Fail-SubmitButtonIssue");
							logFAIL("Submit Button Issue (error)");
							assertFail();
							break;
						}
					}
				}
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				} 
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runAdaptiveSaqIncorrect");
			logFAIL("The method runAdaptiveSaqIncorrect failed (error)");
			assertFail();
		}
	}
	
	public static void checkFeedbakBoxCorrectTitle(String Element) throws Exception {
		try{
			String Title = driver.findElement(objmap.getLocator(Element)).getAttribute("class");
			if (Title.contains("cs-correct"))
			{
				logINFO("checkFeedbakBoxCorrectTitle : Correct");
				verifyElementTextPresent(Element);
			} else
			{
				TakeScreenshot("Fail-checkFeedbakBoxCorrectTitleNotPresent");
				logFAIL("checkFeedbakBoxCorrectTitle : Not-Present (error)");
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkFeedbakBoxCorrectTitle");
			logFAIL("The method checkFeedbakBoxCorrectTitle failed (error)");
			assertFail();
		}
	}

	public static void checkFeedbakBoxIncorrectTitle(String Element) throws Exception {
		try{
			String Title = driver.findElement(objmap.getLocator(Element)).getAttribute("class");
			if (Title.contains("cs-incorrect"))
			{
				logINFO("checkFeedbakBoxIncorrectTitle : Incorrect");
				verifyElementTextPresent(Element);
			} else
			{
				TakeScreenshot("Fail-checkFeedbakBoxIncorrectTitleNotPresent");
				logFAIL("checkFeedbakBoxIncorrectTitle : Not-Present (error)");
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkFeedbakBoxIncorrectTitle");
			logFAIL("The method checkFeedbakBoxIncorrectTitle failed (error)");
			assertFail();
		}
	}

	public static void closeCTRHotSpotRevealBox() throws Exception {
		try
		{
			driver.findElement(objmap.getLocator("HotSpotRevealBoxClosebutton")).click();
			logINFO("HotSpotRevealBoxClosebutton: Clicked");
			Thread.sleep(500);
			if (verifyElementPresent("HotSpotRevealBox"))
			{
				clickInvisibleElement("HotSpotRevealBoxClosebutton");
				logINFO("HotSpotRevealBoxClosebutton: Invisible-Clicked");
			}
		} catch (Exception e) {
			if (verifyElementPresent("HotSpotRevealBox"))
			{
				clickInvisibleElement("HotSpotRevealBoxClosebutton");
				logINFO("HotSpotRevealBoxClosebutton: Invisible-Clicked");
			}
		}
	}

	public static void runSideBarSeeMoreHyperlink() throws Exception {
		try {
			if (verifyElementPresent("SideBarSeeMoreHyperlink"))
			{
				String winHandleBefore = driver.getWindowHandle();
				clickElementText("SideBarSeeMoreHyperlink");
				Thread.sleep(1000);
				for(String winHandle : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle);
				}
				TakeScreenshot("Pass");
				driver.close();
				driver.switchTo().window(winHandleBefore);
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runSideBarSeeMoreHyperlink");
			logFAIL("The method runSideBarSeeMoreHyperlink failed (error)");
			assertFail();
		}
	}

	public static void runMultipleScenarioPage() throws Exception {
		try {
			for (int j=1; j>=1; j++)
			{
				if (verifyElementPresent("MSHotSpot" + j + ""))
				{
					TakeScreenshot("Pass");
					clickElement("MSHotSpot" + j + "");
					logINFO("------- HotSpot " + j + " ------");
				} else
					break;

				boolean loop = true;
				do {
					if(loop){
						loop = false;
					} else {
						break;
					}

					Thread.sleep(2000);
					if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
					{
						logINFO("#### SAQ page ####: Present");
						clickSaqCorrectOptions();
						clickSaqCorrectSubmit();
						Thread.sleep(1000);
						if (verifyElementPresent("Continue-Disabled"))
						{
							checkInvisibilityOfElement(600, "Continue-Disabled");
							TakeScreenshot("Pass");
						}
						clickElementText("SAQFeedbackContinue");
						Thread.sleep(2000);
						loop = true;
					}   
					if (verifyElementPresent("BasicContinue"))
					{
						logINFO("#### Basic page ####: Present");
						TakeScreenshot("Pass");
						if (verifyElementPresent("Continue-Disabled"))
						{
							checkInvisibilityOfElement(600, "Continue-Disabled");
							TakeScreenshot("Pass");
						}
						clickElementText("BasicContinue");
						Thread.sleep(2000);
						loop = true;
					}
				}
				while
					((verifyElementPresent("runSaqORGraphicalSaqOption1")) || (verifyElementPresent("BasicContinue")));
				TakeScreenshot("Pass");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runMultipleScenarioPage");
			logFAIL("The method runMultipleScenarioPage failed (error)");
			assertFail();
		}
	}

	public static void dragCorrectBoxes() throws Exception {
		SAQYesNo = "Yes";
		try {
			TakeScreenshot("Pass");
			for (int i=1; i>=1; i++){
				if (!verifyElementPresent("DragItemNo"+ i +""))
				{
					//
				} else
				{
					for (int j=1; j>=1; j++){
						if (verifyElementPresent("DragItemNo"+ i +""))
						{
							String DropBox = driver.findElement(objmap.getLocator("DragItemNo"+ i +"")).getAttribute("idx");
							if (!isElementPresent(By.id(DropBox)))
							{
								TakeScreenshot("Fail-"+DropBox+"DropBoxNotPresent");
								logFAIL("DragItemNo"+ i +" - CorrectDropBox - "+DropBox+" Not-Present (error)");
								assertFail();
							}
							WebElement target = driver.findElement(By.id(DropBox));
							WebElement element = driver.findElement(objmap.getLocator("DragItemNo"+ i +""));
							(new Actions(driver)).dragAndDrop(element, target).perform();
							Thread.sleep(2000);
							logINFO("DragItemNo"+ i +" - DROPPPED IN - "+DropBox+"");
							TakeScreenshot("Pass");
							i--;
						} else
						{
							break;
						}
					} break;
				} 
			}
			TakeScreenshot("Pass");
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-dragCorrectBoxes");
			logFAIL("The dragCorrectBoxes method failed (error)");
			assertFail();
		}
	}			

	public static void dragIncorrectBoxes() throws Exception {
		try {
			TakeScreenshot("Pass");
			for (int i=1; i>=1; i++){
				if (!verifyElementPresent("DragItemNo"+ i +""))
				{
					//
				} else
				{
					for (int j=1; j>=1; j++){
						if (verifyElementPresent("DragItemNo"+ i +""))
						{
							for (int k=1; k>=1; k++){
								String TargetDropBox = driver.findElement(objmap.getLocator("DragItemNo"+ i +"")).getAttribute("idx");
								String DropBoxNumber = driver.findElement(objmap.getLocator("DropItemNo"+ k +"")).getAttribute("id");
								if (TargetDropBox.equals(DropBoxNumber))
								{
									if (verifyElementPresent("DropItemNo"+ (k=k+1) +""))
									{
										DragandDrop("DragItemNo"+ i +"", "DropItemNo"+ k +"");
										i--;
										break;
									}
									else if (verifyElementPresent("DropItemNo"+ (k=k-2) +""))
									{
										DragandDrop("DragItemNo"+ i +"", "DropItemNo"+ k +"");
										i--;
										break;
									}
								}
								else if (!TargetDropBox.equals(DropBoxNumber))
								{
									if (verifyElementPresent("DropItemNo"+ k +""))
									{
										DragandDrop("DragItemNo"+ i +"", "DropItemNo"+ k +"");
										i--;
										break;
									}
								}
							}
						} else
						{
							break;
						}
					} 
					break;
				} 
			}
			TakeScreenshot("Pass");
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-dragIncorrectBoxes");
			logFAIL("The dragIncorrectBoxes method failed (error)");
			assertFail();
		}
	}

	public static void dragCorrectFlagImages() throws Exception {
		SAQYesNo = "Yes";
		try {
			TakeScreenshot("Pass");
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("DropBoxNo"+ i +""))
				{
					driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
					String DragItem = driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).getAttribute("idx");
					if (!isElementPresent(By.id(DragItem)))
					{
						TakeScreenshot("Fail-"+DragItem+"DragImageNotPresent");
						logFAIL("DropBoxNo"+ i +" - Correct - "+DragItem+" Drag Image Not-Present (error)");
						assertFail();
					}
					WebElement element = driver.findElement(By.id(DragItem));
					WebElement target = driver.findElement(objmap.getLocator("DropBoxNo"+ i +""));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
					Thread.sleep(500);
					(new Actions(driver)).dragAndDrop(element, target).perform();
					Thread.sleep(2000);
					logINFO(""+DragItem+"Image - DROPPPED IN - DropBoxNo"+ i +"");
					TakeScreenshot("Pass");
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-dragCorrectFlagImages");
			logFAIL("The dragCorrectFlagImages method failed (error)");
			assertFail();
		}
	}

	public static void dragIncorrectFlagImages() throws Exception {
		try {
			TakeScreenshot("Pass");
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("DropBoxNo"+ i +""))
				{
					driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
					for (int k=1; k>=1; k++){
						String TargetDragItem = driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).getAttribute("idx");
						String DragItemNumber = driver.findElement(objmap.getLocator("DropItemNo"+ k +"")).getAttribute("id");
						if (TargetDragItem.equals(DragItemNumber))
						{
							if (verifyElementPresent("DropItemNo"+ (k=k+1) +""))
							{
								DragandDrop("DropItemNo"+ k +"", "DropBoxNo"+ i +"");
								break;
							}
							else if (verifyElementPresent("DropItemNo"+ (k=k-2) +""))
							{
								DragandDrop("DropItemNo"+ k +"", "DropBoxNo"+ i +"");
								break;
							}
						}
						else if (!TargetDragItem.equals(DragItemNumber))
						{
							if (verifyElementPresent("DropItemNo"+ k +""))
							{
								DragandDrop("DropItemNo"+ k +"", "DropBoxNo"+ i +"");
								break;
							}
						}
					}
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-dragIncorrectFlagImages");
			logFAIL("The dragIncorrectFlagImages method failed (error)");
			assertFail();
		}
	}

	public static void checkDragImageInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++)
				{
					if (verifyElementPresent("DropItemNo" + j + ""))
					{
						for (int k=1; k>=1; k++)
						{
							if(verifyElementPresent("DragBox" + k + "ImageInsideDropBox" + j + "")){
								verifyElementImagePresent("DragBox" + k + "ImageInsideDropBox" + j + "");
							} else {
								break;
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkDragImageInsideDropBox");
			logFAIL("The method checkDragImageInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkDragTextInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++)
				{
					if (verifyElementPresent("DropItemNo" + j + ""))
					{
						for (int k=1; k>=1; k++)
						{
							if(verifyElementPresent("DragBox" + k + "TextInsideDropBox" + j + "")){
								verifyElementTextPresent("DragBox" + k + "TextInsideDropBox" + j + "");
							} else {
								break;
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkDragTextInsideDropBox");
			logFAIL("The method checkDragTextInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkCorrectIconInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++)
				{
					if (verifyElementPresent("DropItemNo" + j + ""))
					{
						for (int k=1; k>=1; k++)
						{
							if (verifyElementPresent("DragBox" + k + "-TickORCross-InsideDropBox" + j + ""))
							{
								String Icon = driver.findElement(objmap.getLocator("DragBox" + k + "-TickORCross-InsideDropBox" + j + "")).getAttribute("class");
								if (Icon.contains("correct"))
								{
									logINFO("DragBox" + k + "-TickORCross-InsideDropBox" + j + " Tick/Correct Icon : Present");
								} else
								{
									if (Icon.contains("wrong"))
									{
										logFAIL("Cross/Wrong Icon : Present");
										assertFail();
									} else
									{
										TakeScreenshot("Fail-DragBox" + k + "TickORCrossInsideDropBox" + j + "NotPresent");
										logFAIL("DragBox" + k + "-TickORCross-InsideDropBox" + j + ": Not-Found on Page (error)");
										assertFail();
									}
								}
							} else {
								break;
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkCorrectIconInsideDropBox");
			logFAIL("The method checkCorrectIconInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkIncorrectIconInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++)
				{
					if (verifyElementPresent("DropItemNo" + j + ""))
					{
						for (int k=1; k>=1; k++)
						{
							if (verifyElementPresent("DragBox" + k + "-TickORCross-InsideDropBox" + j + ""))
							{
								String Icon = driver.findElement(objmap.getLocator("DragBox" + k + "-TickORCross-InsideDropBox" + j + "")).getAttribute("class");
								if (Icon.contains("wrong"))
								{
									logINFO("DragBox" + k + "-TickORCross-InsideDropBox" + j + " Cross/Wrong Icon : Present");
								} else
								{
									if (Icon.contains("correct"))
									{
										logFAIL("Tick/Correct Icon : Present");
										assertFail();
									} else
									{
										TakeScreenshot("Fail-DragBox" + k + "TickORCrossInsideDropBox" + j + "NotPresent");
										logFAIL("DragBox" + k + "-TickORCross-InsideDropBox" + j + ": Not-Found on Page (error)");
										assertFail();
									}
								}
							} else {
								break;
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkIncorrectIconInsideDropBox");
			logFAIL("The method checkIncorrectIconInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkFlagImageInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("DropBoxNo" + i + ""))
					{
						driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
						verifyElementImagePresent("FlagImageInsideDropBox" + i + "");
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkFlagImageInsideDropBox");
			logFAIL("The method checkFlagImageInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkFlagCorrectIconInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("DropBoxNo" + i + ""))
					{
						driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
						if (verifyElementPresent("TickORCross-InsideDropBox" + i + ""))
						{
							String Correct = driver.findElement(objmap.getLocator("TickORCross-InsideDropBox" + i + "")).getAttribute("class");
							if (Correct.contains("correct"))
							{
								logINFO("TickORCross-InsideDropBox" + i + " Tick/Correct Icon : Present");
							} else
							{
								if (Correct.contains("wrong"))
								{
									logFAIL("TickORCross-InsideDropBox" + i + " Cross/Wrong Icon : Present");
									assertFail();
								} else
								{
									TakeScreenshot("Fail-TickORCrossInsideDropBox" + i + "NotFound");
									logFAIL("TickORCross-InsideDropBox" + i + ": Not-Found on Page (error)");
									assertFail();
								}
							}
						} 
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkFlagCorrectIconInsideDropBox");
			logFAIL("The method checkFlagCorrectIconInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkFlagIncorrectIconInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("DropBoxNo" + i + ""))
					{
						driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
						if (verifyElementPresent("TickORCross-InsideDropBox" + i + ""))
						{
							String Correct = driver.findElement(objmap.getLocator("TickORCross-InsideDropBox" + i + "")).getAttribute("class");
							if (Correct.contains("wrong"))
							{
								logINFO("TickORCross-InsideDropBox" + i + " Cross/Wrong Icon : Present");
							} else
							{
								if (Correct.contains("correct"))
								{
									logFAIL("TickORCross-InsideDropBox" + i + " Tick/Correct Icon : Present");
									assertFail();
								} else
								{
									TakeScreenshot("Fail-TickORCrossInsideDropBox" + i + "NotFound");
									logFAIL("TickORCross-InsideDropBox" + i + ": Not-Found on Page (error)");
									assertFail();
								}
							}
						} 
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkFlagCorrectIconInsideDropBox");
			logFAIL("The method checkFlagCorrectIconInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void dndIncorrectAlertBox() throws Exception {
		try{
			for (int m=1; m>=1; m++){
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
					clickElementText("runSaqORGraphicalSaqSubmit");
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-dndIncorrectAlertBox");
			logFAIL("The dndIncorrectAlertBox method failed (error)");
			assertFail();
		}
	}

	public static void runCarouselPage() throws Exception {
		try {
			TakeScreenshot("Pass");
			//if (verifyElementPresent("CarouselAutoPlayONOFF"))
			//{
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("CarouselSlide" + i + "-Bubble"))
					{
						clickElement("CarouselSlide" + i + "-Bubble");
						Thread.sleep(200);
						if (verifyElementPresent("CarouselSlide-Next"))
						{
							clickElement("CarouselSlide-Next");
							Thread.sleep(200);
						}
						TakeScreenshot("Pass");
					} else
					{
						break;
					}
				}
			//}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCarouselPage");
			logFAIL("The method runCarouselPage failed (error)");
			assertFail();
		}
	}

	public static void runVideoModePage() throws Exception {
		try {
			TakeScreenshot("Pass");
			if (verifyElementPresent("VideoPlayButtonOnVideoScreen"))
			{
				TakeScreenshot("Pass");
				clickElement("VideoPlayButtonOnVideoScreen");
			}
			if (verifyElementPresent("VideoBufferImage"))
			{
				TakeScreenshot("Pass");
				logINFO("VideoBufferImage: Present");
				checkInvisibilityOfElement(180, "VideoBufferImage");
				if (verifyElementPresent("VideoError"))
				{
					TakeScreenshot("Fail-ErrorMessageOnVideoScreen");
					logFAIL("Video Screen Showing Error Message (error)");
				}
			}
			TakeScreenshot("Pass");
			if (!verifyElementPresent("VideoRePlayButtonOnVideoScreen"))
			{
				checkVisibilityOfElement(600, "VideoRePlayButtonOnVideoScreen");
				TakeScreenshot("Pass");
			}
			Thread.sleep(2000);
			if (verifyElementPresent("SwitchToText"))
			{
				clickElementText("SwitchToText");
				TakeScreenshot("Pass");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runVideoModePage");
			logFAIL("The method runVideoModePage failed (error)");
			assertFail();
		}
	}

	public static void runVideoTextModePage() throws Exception {
		try {
			logINFO("VideoTextSlide0/1: Present");
			TakeScreenshot("Pass");
			for (int i=2; i>=2; i++)
			{
				if (verifyElementPresent("VideoTextSlide" + i + ""))
				{
					clickElementText("VideoTextSlide" + i + "");
					TakeScreenshot("Pass");
					if (verifyElementPresent("VideoSlide-NextDisabled"))
					{
						break;
					}
				} else
				{
					break;
				}
			}
			if (verifyElementPresent("SwitchToVideo"))
			{
				clickElement("SwitchToVideo");
				TakeScreenshot("Pass");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runVideoTextModePage");
			logFAIL("The method runVideoTextModePage failed (error)");
			assertFail();
		}
	}

	public static void runBranchingLessonPageWithAllTopics() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("BranchingTile"+ j +""))
				{
					TakeScreenshot("Pass");
					clickElement("BranchingTile"+ j +"");
					if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
					{
						verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
						TakeScreenshot("Pass");
						clickElement("Start-Over");
					}
					for (int k=1; k>=1; k++){
						if (!verifyElementPresent("BranchingLesson"))
						{
							initialiseTemplates();
							handleConnectionLostMessageBox();
							runTemplatesTestNGxml();
						} else
						{
							break;
						}
					}
				} else
				{
					break;
				}
			}
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runBranchingLessonPageWithAllTopics");
			logFAIL("The method runBranchingLessonPageWithAllTopics failed (error)");
			assertFail();
		}
	}

	public static void runBranchingLessonPageWithMandatoryTopics() throws Exception {
		String BranchingStatusRequiredNumber = driver.findElement(objmap.getLocator("BranchingStausOnBottomNavbar-RequiredNumber")).getText();
		int MandatoryNumber = Integer.parseInt(BranchingStatusRequiredNumber);
		try {
			for (int j=1; j<=MandatoryNumber; j++){
				if (verifyElementPresent("BranchingTile"+ j +""))
				{
					TakeScreenshot("Pass");
					clickElement("BranchingTile"+ j +"");
					if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
					{
						verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
						TakeScreenshot("Pass");
						clickElement("Start-Over");
					}
					Thread.sleep(2000);
					for (int k=1; k>=1; k++){
						if (!verifyElementPresent("BranchingLesson"))
						{
							initialiseTemplates();
							handleConnectionLostMessageBox();
							runTemplatesTestNGxml();
						} else
						{
							break;
						}
					}
				} else
				{
					BranchingLesson = "Yes";
					assertFail();
				}
			}
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runBranchingLessonPageWithMandatoryTopics");
			logFAIL("The method runBranchingLessonPageWithMandatoryTopics failed (error)");
			assertFail();
		}
	}

	public static void runTileMenuPage() throws Exception {
		TileMenu = "Yes";
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("TileMenuLesson"+ j +""))
				{
					TakeScreenshot("Pass");
					clickElement("TileMenuLesson"+ j +"");
					if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
					{
						verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
						TakeScreenshot("Pass");
						clickElementText("Start-Over");
					}
					for (int k=1; k>=1; k++){
						String CourseURL = driver.getCurrentUrl();
						if (!verifyElementPresent("TileMenu"))
						{
							initialiseTemplates();
							if (CourseURL.contains("FluidX2.0") || CourseURL.contains("scormdriver") || CourseURL.contains("source=CAT&mode=preview"))
							{
								handleConnectionLostMessageBox();
								runTemplatesTestNGxml();
							} else
							{
								break;
							}
						} else
						{
							break;
						}
					}
				} else {
					break;
				}
			}
			TakeScreenshot("Pass");
			TileMenu = "No";
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runTileMenuPage");
			logFAIL("The method runTileMenuPage failed (error)");
			assertFail();
		}
	}

	public static void runAdaptiveLesson() throws Exception {
		try {
			AdaptiveLesson = "Yes";
			String disabled = driver.findElement(objmap.getLocator("takeAssessment")).getAttribute("class");
			if (disabled.contains("disabled"))
			{
				clickElementText("takeLesson");
				Thread.sleep(1000);
			} else {
				clickElementText("takeAssessment");
				Thread.sleep(1000);
				for (int i=1; i>=1; i++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ i +""))
					{
						runAdaptiveSaqIncorrect();
						//runAdaptiveSaqCorrect();
					} else{
						break;
					}
				}
				TakeScreenshot("Pass");
				clickElementText("viewLesson/viewWrapUp");
			}

			initialiseTemplates();
			for (int i=1; i>=1; i++) {
				if (verifyElementPresent("PageNumberIndicator"))
				{
					handleConnectionLostMessageBox();
					runTemplatesTestNGxml();
				} else
				{
					break;
				}
			}
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runAdaptiveLesson");
			logFAIL("The method runAdaptiveLesson failed (error)");
			assertFail();
		}
	}

	public static void runCertIntro() throws Exception {
		try {
			for (int j=1; j>=1;){
				if (verifyElementPresent("CertIntroPage" + j + ""))
				{
					logINFO("##### Cert Intro Page #" + j + " #####");
					TakeScreenshot("Pass");
					clickNEXT();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertIntro");
			logFAIL("The method runCertIntro failed (error)");
			assertFail();
		}
	}

	public static void runCertQuestionPage() throws Exception {
		try {
			if (verifyElementPresent("EocCertQuestion1") || verifyElementPresent("EmbdCertQuestion1"))
			{
				for (int k=1; k>=1; k++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
					{
						logINFO("##### Cert Question #"+k+" - Radio/Checkbox button #####");
						runCertRadioButtonORCheckBox();
					}
					else if (verifyElementPresent("DropDownBox"))
					{
						logINFO("##### Cert Question #"+k+" - DropDown #####");
						runCertDropDown();
					}
					else if (verifyElementPresent("EnterNumberBox"))
					{
						logINFO("##### Cert Question #"+k+" - Enter a Number #####");
						runCertEnterNumber();
					}
					else if (verifyElementPresent("EnterTextBox"))
					{
						logINFO("##### Cert Question #"+k+" - Enter Text #####");
						runCertEnterText();
					}
					else if (verifyElementPresent("SelectDateBox"))
					{
						logINFO("##### Cert Question #"+k+" - Select Date #####");
						runCertSelectDate();
					}
					if (verifyElementPresent("NEXTDisable"))
					{
						TakeScreenshot("Pass");
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(3000);
						break;
					} else
					{
						TakeScreenshot("Pass");
						clickNEXT();
					}
				} 
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertQuestion");
			logFAIL("The method runCertQuestion failed (error)");
			assertFail();
		}
	}

	public static void runCertRadioButtonORCheckBox() throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat(" MM/dd/yyyy ");
			Calendar cal = Calendar.getInstance();

			TakeScreenshot("Pass");
			for (int l=1; l>=1; l++)
			{
				if (verifyElementPresent("runSaqORGraphicalSaqOption" + l + ""))
				{
					clickElementText("runSaqORGraphicalSaqOption" + l + "");
					if (verifyElementPresent("ResponseBoxXPATH"))
					{
						TakeScreenshot("Pass");
						//verifyElementTextPresent("ResponseBoxHeadingText"); //
						//getAttribute("ResponseBoxXPATH", "placeholder");
						driver.findElement(objmap.getLocator("ResponseBoxXPATH")).sendKeys(dateFormat.format(cal.getTime()));
						//getAttribute("ResponseBoxXPATH", "value");
					}
					TakeScreenshot("Pass");
					clickElement("runSaqORGraphicalSaqOption" + l + "");
				} else
				{
					clickElement("runSaqORGraphicalSaqOption" + (l=l-1) + "");
					if (verifyElementPresent("ResponseBoxXPATH"))
					{
						//verifyElementTextPresent("ResponseBoxHeadingText"); //
						//getAttribute("ResponseBoxXPATH", "placeholder");
						driver.findElement(objmap.getLocator("ResponseBoxXPATH")).sendKeys(dateFormat.format(cal.getTime()));
						//getAttribute("ResponseBoxXPATH", "value");
					}
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertRadioButtonORCheckBox");
			logFAIL("The method runCertRadioButtonORCheckBox failed (error)");
			assertFail();
		}
	}

	public static void runCertDropDown() throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat(" MM/dd/yyyy ");
			Calendar cal = Calendar.getInstance();

			TakeScreenshot("Pass");
			//isElementPresent(objmap.getLocator("DropDownBox"), "Drop-Down");
			for (int l=1; l>=1; l++)
			{
				try {
					new Select (driver.findElement(objmap.getLocator("DropDownBox"))).selectByIndex(l);
					//isElementPresent(objmap.getLocator("DropDownBox"), "Drop-Down Option #"+ l +" Selected");
					//String DropDown = driver.findElement(objmap.getLocator("DropDownOption"+ l +"")).getText();
					//isElementPresent(objmap.getLocator("DropDownOption"+ l +""),"Drop-Down Option #"+ l +" = ["+ DropDown +"]");
					if (driver.findElement(objmap.getLocator("ResponseBoxXPATH")).isDisplayed())
					{
						TakeScreenshot("Pass");
						/*isElementPresent(objmap.getLocator("ResponseBoxXPATH"),"Option #" + l + " Response Box");
							if (isElementPresent(objmap.getLocator("ResponseBoxHeadingText")))
				  			{
				  				isElementPresent(objmap.getLocator("ResponseBoxHeadingText"), "Response Box Heading Text");  
				  			}*/
						driver.findElement(objmap.getLocator("ResponseBoxXPATH")).sendKeys(dateFormat.format(cal.getTime()));

						//String Text = driver.findElement(objmap.getLocator("ResponseBoxXPATH")).getAttribute("value");
						//isElementPresent(objmap.getLocator("ResponseBoxXPATH"),"Drop-Down Option #"+ l +" Response Text = ["+ Text +"]");
					}
					TakeScreenshot("Pass");
				} catch (Exception e)
				{
					//e.printStackTrace();
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertDropDown");
			logFAIL("The method runCertDropDown failed (error)");
			assertFail();
		}
	}

	public static void runCertEnterNumber() throws Exception {
		try {
			DateFormat Format = new SimpleDateFormat("MMddyyyyMMddyyyyMMddyyyy0");
			Calendar day = Calendar.getInstance();

			TakeScreenshot("Pass");
			//isElementPresent(objmap.getLocator("EnterNumberBox"), "Enter a Number");
			driver.findElement(objmap.getLocator("EnterNumberBox")).sendKeys(Format.format(day.getTime()));
			//String Numeric = driver.findElement(objmap.getLocator("EnterNumberBox")).getAttribute("value");
			//isElementPresent(objmap.getLocator("EnterNumberBox"),"25 Digit Numeric Number = ["+ Numeric +"]");
			if (driver.findElement(objmap.getLocator("ResponseBoxXPATH")).isDisplayed())
			{
				/*isElementPresent(objmap.getLocator("ResponseBoxXPATH"),"Response Box");
					if (isElementPresent(objmap.getLocator("ResponseBoxHeadingText")))
						{
							isElementPresent(objmap.getLocator("ResponseBoxHeadingText"), "Response Box Heading Text");  
						}*/
				driver.findElement(objmap.getLocator("ResponseBoxXPATH")).sendKeys(Format.format(day.getTime()));
				TakeScreenshot("Pass");
				//String Text = driver.findElement(objmap.getLocator("ResponseBoxXPATH")).getAttribute("value");
				//isElementPresent(objmap.getLocator("ResponseBoxXPATH"),"Response Text = ["+ Text +"]");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertEnterNumber");
			logFAIL("The method runCertEnterNumber failed (error)");
			assertFail();
		}
	}

	public static void runCertEnterText() throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat(" MM/dd/yyyy ");
			Calendar cal = Calendar.getInstance();

			TakeScreenshot("Pass");
			//isElementPresent(objmap.getLocator("EnterTextBox"), "Enter a Text");
			driver.findElement(objmap.getLocator("EnterTextBox")).sendKeys(dateFormat.format(cal.getTime()));
			//String Textual = driver.findElement(objmap.getLocator("EnterTextBox")).getAttribute("value");
			//isElementPresent(objmap.getLocator("EnterTextBox"),"Entered Text = ["+ Textual +"]");
			checkResponseBox();
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertEnterText");
			logFAIL("The method runCertEnterText failed (error)");
			assertFail();
		}
	}

	public static void runCertSelectDate() throws Exception {
		try {
			TakeScreenshot("Pass");
			//isElementPresent(objmap.getLocator("SelectDateBox"), "Select a Date");
			clickElement("SelectDateBox");
			TakeScreenshot("Pass");
			//isElementPresent(objmap.getLocator("CalenderBox"), "Calender Box");
			clickElement("SelectedTodayDate");
			//isElementPresent(objmap.getLocator("SelectedTodayDate"), "Selected Today's Date");
			//String Date = driver.findElement(objmap.getLocator("SelectDateBox")).getAttribute("value");
			//isElementPresent(objmap.getLocator("SelectDateBox"),"Selected Today's Date = ["+ Date +"]");
			checkResponseBox();
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertSelectDate");
			logFAIL("The method runCertSelectDate failed (error)");
			assertFail();
		}
	}

	public static void checkResponseBox() throws Exception {
		try {
			DateFormat dateFormat = new SimpleDateFormat(" MM/dd/yyyy ");
			Calendar cal = Calendar.getInstance();

			if (driver.findElement(objmap.getLocator("ResponseBoxNAME")).isDisplayed())
			{
				//isElementPresent(objmap.getLocator("ResponseBoxNAME"),"Response Box");
				/*if (isElementPresent(objmap.getLocator("ResponseBoxHeadingText")))
						{
							isElementPresent(objmap.getLocator("ResponseBoxHeadingText"), "Response Box Heading Text");  
						}*/
				driver.findElement(objmap.getLocator("ResponseBoxNAME")).sendKeys(dateFormat.format(cal.getTime()));
				TakeScreenshot("Pass");
				//String Text = driver.findElement(objmap.getLocator("ResponseBoxNAME")).getAttribute("value");
				//isElementPresent(objmap.getLocator("ResponseBoxNAME"),"Response Text = ["+ Text +"]");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkResponseBox");
			logFAIL("The method checkResponseBox failed (error)");
			assertFail();
		}
	}

	public static void checkLCECHistoryPage() throws Exception {
		try {
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("MMMM dd, yyyy HH");
			TimeZone.getTimeZone("PST");
			df.setTimeZone(TimeZone.getTimeZone("PST"));
			//System.out.println("Date and time in PST: " + df.format(date));
			String PresentDateTime = df.format(date);
			Thread.sleep(2000);
			clickElementText("MyPage");
			for (int i=1; i>=10; i++){ 
				if (!verifyElementPresent("HistoryTab"))
				{
					String CurrentPageURL = driver.getCurrentUrl();
					driver.get(CurrentPageURL);
				} else {
					break;
				}
			}
			TakeScreenshot("Pass");
			clickElementText("HistoryTab");
			for (int i=1; i>=10; i++){ 
				if (!verifyElementPresent("AllCompletions-DropDown"))
				{
					String CurrentPageURL = driver.getCurrentUrl();
					driver.get(CurrentPageURL);
				} else {
					break;
				}
			}
			
			String CourseCompletionHistory = driver.findElement(objmap.getLocator("CompletedCourseHistory")).getText();
			logINFO("CompletedCourseHistory = "+CourseCompletionHistory+"");
			TakeScreenshot("Pass");
			
			if (!CourseCompletionHistory.contains("No completions to display."))
			{
				String CompletionDateTime = driver.findElement(objmap.getLocator("CompletionDate/Time(PT)")).getText();
				logINFO("CompletionDate/Time(PT) = "+CompletionDateTime+"");

				if (CompletionDateTime.contains(PresentDateTime))
				{
					String CatalogID = driver.findElement(objmap.getLocator("HistoryPageCatalogID")).getText();
					if (catalogID.equals(CatalogID))
					{
						String winHandleBefore = driver.getWindowHandle();
						clickElementText("HistoryPrintBtn");
						Thread.sleep(1000);
						for(String winHandle : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle);
						}
						String Text = driver.findElement(objmap.getLocator("PageContent")).getText();
						if (Text.contains("LRN"))
						{
							TakeScreenshot("Pass");
							logINFO("ViewCompletionCertPage" + " = ["+ Text +"] : Present");
						} else if (Text.contains("unable"))
						{
							TakeScreenshot("Fail-ViewCompletionCertPage-ErrorPresent");
							logFAILED("ViewCompletionCertPage" + " = ["+ Text +"] : Error-Present");
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
						} else if (Text.contains(""))
						{
							TakeScreenshot("Fail-ViewCompletionCertPage-ErrorPresent");
							logFAILED("ViewCompletionCertPage" + " = ["+ Text +"] : Error-Present");
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
						} 
						driver.close();
						driver.switchTo().window(winHandleBefore);
						logPASS("Course Completion Recorded Successfully on LCEC History page");
					} else {
						TakeScreenshot("Fail-CourseCatalogID-NotPresent");
						logFAILED("The Course CatalogID is missing (error)");
						writeExcelData(8, ExcelRowNumber, "Fail");
						Assert.fail();
					} 
				} else {
					TakeScreenshot("Fail-CourseCompletionDateTimeIssue-ErrorPresent");
					logFAILED("The Course Completion Date/Time(PT) is not matching with present Date/Time(PT) (error)");
					writeExcelData(8, ExcelRowNumber, "Fail");
					Assert.fail();
				}
			} else {
				TakeScreenshot("Fail-CourseCompletionNotRecorded-ErrorPresent");
				logFAILED("The CourseCompletion is missing (error)");
				writeExcelData(8, ExcelRowNumber, "Fail");
				Assert.fail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkLCECHistoryPage");
			logFAILED("The method checkLCECHistoryPage failed (error)");
			writeExcelData(8, ExcelRowNumber, "Fail");
			Assert.fail();
		}
	}

	public static void runQuizWithCorrectSelections() throws Exception {
		try {
			Quiz = "Yes";
			for (int k=1; k>=1; k++)
			{ 
				if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
				{
					TakeScreenshot("Pass");
					logINFO("----------Question #"+k+"-------");
					runKCwithCorrect();
				} else 
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runQuizWithCorrectSelections");
			logFAIL("The method runQuizWithCorrectSelections failed (error)");
			assertFail();
		}
	}

	public static void runKCwithCorrect() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqMultipleChoice1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("saqCheckboxOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					if (!verifyElementPresent("runSaqORGraphicalSaqSubmit") && verifyElementPresent("NEXTDisable"))
					{
						TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
						logFAIL("None of the anwer options are Correct (error)");
						assertFail();
						clickElementText("runSaqORGraphicalSaqOption1");
					} else
					{
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled") && verifyElementPresent("NEXTDisable"))
						{
							TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
							logFAIL("None of the anwer options are Correct (error)");
							assertFail();
							clickElementText("runSaqORGraphicalSaqOption1");
						}
					}
					if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
					{
						TakeScreenshot("Pass");
						String PreviousPageURL = driver.getCurrentUrl();
						checkBulletin();
						Thread.sleep(1000);
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(2000);
						String CurrentPageURL = driver.getCurrentUrl();
						//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
						if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("scormdriver"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
							assertFail();
						}
						break;
					} else
					{
						TakeScreenshot("Pass");
						checkBulletin();
						clickNEXT();
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runKCwithCorrect");
			logFAIL("The method runKCwithCorrect failed (error)");
			assertFail();
		}
	}

	public static void runQuizWithIncorrectSelections() throws Exception {
		try {
			Quiz = "Yes";
			for (int k=1; k>=1; k++)
			{ 
				if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
				{
					TakeScreenshot("Pass");
					logINFO("----------Question "+k+"-------");
					runKCwithIncorrect();
				} else 
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runQuizWithIncorrectSelections");
			logFAIL("The method runQuizWithIncorrectSelections failed (error)");
			assertFail();
		}
	}

	public static void runKCwithIncorrect() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqMultipleChoice1"))
					{
						String Incorrect = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}	
					else if (verifyElementPresent("saqCheckboxOption1"))
					{	
						String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					if (!verifyElementPresent("runSaqORGraphicalSaqSubmit") && verifyElementPresent("NEXTDisable"))
					{
						logINFO("None of the anwer options are Incorrect");
						TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
						clickElementText("runSaqORGraphicalSaqOption1");
					} else
					{
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled") && verifyElementPresent("NEXTDisable"))
						{
							logINFO("None of the anwer options are Incorrect");
							TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
							clickElementText("runSaqORGraphicalSaqOption1");
						}
					}
					if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
					{
						TakeScreenshot("Pass");
						String PreviousPageURL = driver.getCurrentUrl();
						//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
						checkBulletin();
						Thread.sleep(1000);
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(2000);
						String CurrentPageURL = driver.getCurrentUrl();
						//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
						if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("scormdriver"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
							assertFail();
						}
						break;
					} else
					{
						TakeScreenshot("Pass");
						checkBulletin();
						checkHelp();
						clickNEXT();
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runKCwithIncorrect");
			logFAIL("The method runKCwithIncorrect failed (error)");
			assertFail();
		}
	}

	public static void checkViewCertOnResultsPage() throws Exception {
		try {
			TakeScreenshot("Pass");
			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				handleConnectionLostMessageBox();
			} else
			{
				String winHandleBefore = driver.getWindowHandle();	
				if (verifyElementPresent("Tile-ViewCertificate"))
				{
					clickElementText("Tile-ViewCertificate");
				} else if (verifyElementPresent("ViewYourCompletionCertificate"))
				{
					clickElementText("ViewYourCompletionCertificate");
				} else if (verifyElementPresent("ViewCompletedCertification"))
				{
					clickElementText("ViewCompletedCertification");
				}
				Thread.sleep(1000);
				for(String winHandle : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle);
				}
				String Text = driver.findElement(objmap.getLocator("PageContent")).getText();
				if (Text.contains("LRN"))
				{
					TakeScreenshot("Pass");
					logINFO("ViewCompletionCertPage" + " = ["+ Text +"] : Present");
				} else if (Text.contains("unable"))
				{
					TakeScreenshot("Fail-ViewCompletionCertPage-ErrorPresent");
					logFAILED("ViewCompletionCertPage" + " = ["+ Text +"] : Error-Present");
					Assert.fail();
				} else if (Text.contains(""))
				{
					TakeScreenshot("Fail-ViewCompletionCertPage-ErrorPresent");
					logFAILED("ViewCompletionCertPage" + " = ["+ Text +"] : Error-Present");
					Assert.fail();
				} 
				driver.close();
				driver.switchTo().window(winHandleBefore);
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkViewCertOnResultsPage");
			logFAIL("The method checkViewCertOnResultsPage failed (error)");
			assertFail();
		}
	}

	public static void clickTakeSurveyButton() throws Exception {
		try {
			TakeScreenshot("Pass");
			String winHandleBefore = driver.getWindowHandle();
			if (verifyElementPresent("TakeSurvey"))
			{
				clickElementText("TakeSurvey");
			} else if (verifyElementPresent("Tile-TakeSurvey"))
			{
				clickElementText("Tile-TakeSurvey");
			}
			Thread.sleep(1000);
			for(String winHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle);
			}
			String Text = driver.findElement(objmap.getLocator("PageContent")).getText();
			String PageURL = driver.getCurrentUrl();
			if (PageURL.contains("eocsurvey.lrn.com/a/TakeSurvey?id="))
			{
				logINFO("TakeSurvey URL =" + PageURL);
				logINFO("TakeSurvey" + " = ["+ Text +"] : Present");
				TakeScreenshot("Pass");
			} else if (PageURL.contains("www.questionpro.com"))
			{
				logINFO("TakeSurvey URL =" + PageURL);
				TakeScreenshot("Fail-TakeSurvey-ErrorPresent");
				logFAIL("TakeSurvey" + " = ["+ Text +"] : Error-Present");
				assertFail();
			} else if (PageURL.contains(""))
			{
				logINFO("TakeSurvey URL =" + PageURL);
				TakeScreenshot("Fail-TakeSurvey-ErrorPresent");
				logFAIL("TakeSurvey" + " = ["+ Text +"] : Error-Present");
				assertFail();
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickTakeSurveyButton");
			logFAIL("The method clickTakeSurveyButton failed (error)");
			assertFail();
		}
	}

	public static void handleConnectionLostMessageBox() throws Exception {
		try {
			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				do {
					TakeScreenshot("Fail-ConnectionLostMessageBoxPresent");
					logINFO("ConnectionLostMessageBox : Present");
					//clickElementText("ConnectionLostMessageBoxExit");
					driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]).close();
					Thread.sleep(1000);
					driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
					String LCECURL = driver.getCurrentUrl();
					driver.get(LCECURL);
					TakeScreenshot("Fail-ConnectionLostOnLCECPage");
					Thread.sleep(3000);
					do {
						driver.get(LCECURL);
					} while (!verifyElementPresent("GetStartedbtn"));
				} while (verifyElementPresent("ConnectionLostMessageBox"));
				TakeScreenshot("Pass");
				clickElementText("GetStartedbtn");
				driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
				Thread.sleep(50000);
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-handleConnectionLostMessageBox");
			logFAIL("The method handleConnectionLostMessageBox failed (error)");
			assertFail();
		}
	}

	public static void resetPage() throws Exception {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_LEFT, Keys.ARROW_RIGHT, Keys.ARROW_LEFT, Keys.ARROW_RIGHT, String.valueOf('\u0062'), String.valueOf('\u0061')).perform();
			clickElement("JumpToPage-Go");
			clickElement("JumpToPage-Close");
			logINFO("Page Reset Done");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-resetPage");
			logFAIL("The method resetPage failed (error)");
			assertFail();
		}
	}

	public static void jumpToPage(String Num) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_LEFT, Keys.ARROW_RIGHT, Keys.ARROW_LEFT, Keys.ARROW_RIGHT, String.valueOf('\u0062'), String.valueOf('\u0061')).perform();
			checkVisibilityOfElement(60, "JumpToPage-Go");
			driver.findElement(objmap.getLocator("JumpToPage-NumberBox")).clear();
			driver.findElement(objmap.getLocator("JumpToPage-NumberBox")).sendKeys(Num);
			clickElement("JumpToPage-Go");
			Thread.sleep(1000);
			clickElement("JumpToPage-Close");
			logINFO("JumpToPage #"+Num);
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-jumpToPage");
			logFAIL("The method jumpToPage failed (error)");
			assertFail();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void launchBrowser(String PCorRemoteMachine,String IPAddress,String Browser,String FullScreen,String Fast,String Screenshot,String JumpToPageNumber,String JumpToTileNumber) throws Exception {
		try {
			FullScreenYesNo = FullScreen;
			FastYesNo = Fast;
			ScreenshotYesNo = Screenshot;
			JumptoCoursePage = JumpToPageNumber;
			JumptoTileNum = JumpToTileNumber;
			BrowserName = Browser;
			//For PC
			if (PCorRemoteMachine.equalsIgnoreCase("PC"))
			{
				if (Browser.equalsIgnoreCase("FireFox"))
				{
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resource\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if (Browser.equalsIgnoreCase("Chrome"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-infobars"); //Added this to disable the infobar "Chrome is being controlled by automated test software."
					//options.addArguments("headless");
					//options.addArguments("--disable-gpu");
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resource\\drivers\\chromedriver.exe");
					driver = new ChromeDriver(options);
				}
				else if (Browser.equalsIgnoreCase("InternetExplorer"))
				{
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resource\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				else if (Browser.equalsIgnoreCase("Edge"))
				{
					//System.setProperty("webdriver.edge.driver","C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
					System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\resource\\drivers\\MicrosoftWebDriver.exe");
					driver = new EdgeDriver();
				}
			}

			//For Remote Machine = 1st needed to run 'selenium standalone server' jar file on remote machine manually.
			else if (PCorRemoteMachine.equalsIgnoreCase("RemoteMachine"))
			{
				if (Browser.equalsIgnoreCase("InternetExplorer"))
				{
					DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
					driver = new RemoteWebDriver (new URL("http://"+IPAddress+":4444/wd/hub"), capability);
				}
				else if (Browser.equalsIgnoreCase("Chrome"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-infobars"); //Added this to disable the infobar "Chrome is being controlled by automated test software."
					DesiredCapabilities capability = DesiredCapabilities.chrome();
					capability.setCapability(ChromeOptions.CAPABILITY, options);
					driver = new RemoteWebDriver (new URL("http://"+IPAddress+":4444/wd/hub"), capability);
				}
				else if (Browser.equalsIgnoreCase("FireFox"))
				{
					DesiredCapabilities capability = DesiredCapabilities.firefox();
					driver = new RemoteWebDriver (new URL("http://"+IPAddress+":4444/wd/hub"), capability);
				}
				else if (Browser.equalsIgnoreCase("Edge"))
				{
					DesiredCapabilities capability = DesiredCapabilities.edge();
					driver = new RemoteWebDriver (new URL("http://"+IPAddress+":4444/wd/hub"), capability);
				}
			}
			driver.manage().window().maximize(); // maximize the window
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-launchBrowser");
			logFAIL("The method launchBrowser failed (error)");
			//assertFail();
		}
	}

	public static void runHTML5course(String XlsName, String SheetName, int StartRowNumber, int EndRowNumber) throws Exception {
		try {
			//Run the Courses in loop from Excel
			for (int j=StartRowNumber-1; j<=EndRowNumber-1; j++)
			{
				// Read data in Excel
				readExcelData(XlsName, SheetName, j);

				// Create log files
				createLogfiles();
				BasicConfigurator.configure();

				// LCEC LogIn & Course Launch
				lcecCourseUrlLoginAndCourseLaunch();
				//runScormCloudCourseLaunch();
				runFluidXCourse();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runHTML5course");
			logFAILED("The method runHTML5course failed (error)");
			Assert.fail();
		}
	}
	
	public static void lcecCourseLogin(String XlsName, String SheetName, int StartRowNumber, int EndRowNumber) throws Exception {
		try {
			//Run the Courses in loop from Excel
			for (int j=StartRowNumber-1; j<=EndRowNumber-1; j++)
			{
				// Read data in Excel
				readExcelData(XlsName, SheetName, j);

				// Create log files
				createLogfiles();
				BasicConfigurator.configure();

				// LCEC Course LogIn
				lcecCourseUrlLogin();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runHTML5course");
			logFAILED("The method runHTML5course failed (error)");
			Assert.fail();
		}
	}
	
	public static void runFluidXCourse() throws Exception {
		try {
			for (int i=1; i<=10; i++) {
				if (verifyElementPresent("DesktopMenu") || verifyElementPresent("DesktopTileMenu") || verifyElementPresent("TileMenu") || verifyElementPresent("LandingPageltr"))
				{
					break;
				}
				Thread.sleep(1000);
			}

			if (FullScreenYesNo.equals("Yes"))
			{
				driver.manage().window().maximize(); // maximize the window
			}
			if (!JumptoCoursePage.equals("No") && !JumptoCoursePage.equals("Yes"))
			{
				if (verifyElementPresent("LandingPageltr"))
				{
					clickElement("LandingPageNextButton");
					Thread.sleep(2000);
					logINFO("Click on LandingPage's Next button");
				}
				if (!JumptoTileNum.equals("No"))
				{
					if (verifyElementPresent("BranchingLesson"))
					{
						clickElement("BranchingTile"+JumptoTileNum+"");
						Thread.sleep(2000);
						logINFO("Click on BranchingTile #"+JumptoTileNum+"");
						if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
						{
							verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
							clickElement("Start-Over");
							Thread.sleep(500);
						}
					}
					else if (verifyElementPresent("TileMenu"))
					{
						clickElement("TileMenuLesson"+JumptoTileNum+"");
						Thread.sleep(200);
						logINFO("Click on TileMenu's Lesson #"+JumptoTileNum+"");
						if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
						{
							verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
							clickElement("Start-Over");
							Thread.sleep(500);
						}
					}
				}
				jumpToPage(JumptoCoursePage);
				Thread.sleep(2000);
			} else 
			{
				// Write data in Excel
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
				String dateTime = formatter.format(currentDate.getTime());
				writeExcelData(6, ExcelRowNumber, dateTime);
				writeExcelData(8, ExcelRowNumber, "InProgress");
				
				if (verifyElementPresent("LandingPageltr"))
				{
					logINFO("-----LandingPageltr(Start)-----");
					TestNG testng = new TestNG();
					List<String> suites = Lists.newArrayList();
					suites.add(System.getProperty("user.dir")+"\\resource\\TestNGxml\\Sanity\\LandingPageltr.xml");
					testng.setTestSuites(suites);
					testng.run();
					Thread.sleep(200);
					logINFO("-----LandingPageltr(End)-----");
				}
				
				// Jump to Lesson or Topic
				if (verifyElementPresent("DesktopMenu"))
				{
					logINFO("Jump to Lesson/Topic #1");
					clickElement("DesktopMenu");
					Thread.sleep(200);
					clickElementText("Lesson1");
					Thread.sleep(200);
					if (verifyElementPresent("Topic1"))
					{
						try {
							driver.findElement(objmap.getLocator("Topic1")).click();
							logINFO("Topic1: Clicked");
						} catch (Exception e) {
							//
						}
						Thread.sleep(200);
					}
				}

				// Landing Page Template	
				else if (verifyElementPresent("LandingPageltr"))
				{
					logINFO("-----LandingPageltr(Start)-----");
					TestNG testng = new TestNG();
					List<String> suites = Lists.newArrayList();
					suites.add(System.getProperty("user.dir")+"\\resource\\TestNGxml\\Sanity\\LandingPageltr.xml");
					testng.setTestSuites(suites);
					testng.run();
					Thread.sleep(200);
					logINFO("-----LandingPageltr(End)-----");
				}

				// Jump to TileMenu
				if (verifyElementPresent("DesktopTileMenu"))
				{
					logINFO("-----------------------------------------------------------");
					logINFO("Jump to TileMenu page");
					clickElement("DesktopTileMenu");
					Thread.sleep(200);
				}
				
				//run Course
				initialiseTemplatesAndrunCourse();
				
				// Write data in Excel
				Calendar currentDate1 = Calendar.getInstance();
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
				String dateTime1 = formatter1.format(currentDate1.getTime());
				writeExcelData(7, ExcelRowNumber, dateTime1);
				writeExcelData(8, ExcelRowNumber, "Done");

				//writeUserName(j);

				//Check Course Completion on LCEC History page
				checkLCECHistoryPage();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runFluidXCourse");
			logFAILED("The method runFluidXCourse failed (error)");
			Assert.fail();
		}
	}
	
	public static void initialiseTemplatesAndrunCourse() throws Exception {
		try {
			//Log.info("entered initialiase templates and run course method");
			
			initialiseTemplates();
			
			//Log.info("templates initialized");
			
			for (int i=1; i>=1; i++) {
				//Log.info("entered the for loop");
				String CurrentUrl = driver.getCurrentUrl();
				//Log.info(CurrentUrl);
				if (CurrentUrl.contains("FluidX2.0") || CurrentUrl.contains("scormdriver")  || CurrentUrl.contains("source=CAT&mode=preview"))
				{
					//Log.info("detected CAT");
					handleConnectionLostMessageBox();
					//Log.info("handled the connection message box");
					runTemplatesTestNGxml();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-initialiseTemplatesAndrunCourse");
			logFAILED("The method initialiseTemplatesAndrunCourse failed (error)");
			Assert.fail();
		}
	}
	

	public static void runScormCloudCourseLaunch() throws Exception {
		try {
			if (enviornment.equals("scorm"))
			{
				String CourseURL = "https://cloud.scorm.com/sc/guest/SignInForm";
				driver.get(CourseURL);
				logINFO("" + CourseURL +"");
			}
			driver.findElement(objmap.getLocator("ScormUserName")).clear();
			driver.findElement(objmap.getLocator("ScormUserName")).sendKeys(userName);
			driver.findElement(objmap.getLocator("ScormPassword")).clear();
			driver.findElement(objmap.getLocator("ScormPassword")).sendKeys(password);
			TakeScreenshot("Pass");
			clickElement("ScormLogIn");
			clickElement("ScormChangeRealm");
			clickElement("ScormYogeshRealm");
			clickElement("ScormCourseNo1");
			clickElement("ScormLaunchBtn");
			Thread.sleep(15000);
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
			driver.switchTo().frame(0);
			Thread.sleep(15000);
			if (verifyElementPresent("ScormVideoOff"))
			{
				clickElement("ScormVideoOff");
			}
			/*if (verifyElementPresent("ScormVideoOn"))
				{
				    clickElement("ScormVideoOn");
				}*/
			TakeScreenshot("Pass");
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			logINFO("" + uAgent + "");
			clickElement("ScormGetStartedBtn");
			Thread.sleep(15000);
			String CourseURL = driver.getCurrentUrl();
			logINFO("" + catalogID + " URL = " + CourseURL + "");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-scormCloudCourseLaunch");
			logFAIL("The method scormCloudCourseLaunch failed (error)");
			assertFail();
		}
	}

	public static void lcecCourseUrlLoginAndCourseLaunch() throws Exception {
		try {
			if (enviornment.equals("cdv") || enviornment.equals("qa2") || enviornment.equals("qa7") || enviornment.equals("qa10") || enviornment.equals("qa12") )
			{
				String CourseURL = "https://"+siteName+"-lcec."+enviornment+".lrn.com/app/courseinfo/"+systemID+"";
				driver.get(CourseURL);
				logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
			} else if (enviornment.equals("prod"))
			{
				String CourseURL = "https://"+siteName+"-lcec.lrn.com/app/courseinfo/"+systemID+"";
				driver.get(CourseURL);
				logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
			}
			for (int i=1; i>=20; i++){ 
				if (!verifyElementPresent("UserName"))
				{
					String CurrentPageURL = driver.getCurrentUrl();
					driver.get(CurrentPageURL);
				} else {
					break;
				}
			}
			driver.findElement(objmap.getLocator("UserName")).clear();
			driver.findElement(objmap.getLocator("UserName")).sendKeys(userName);
			driver.findElement(objmap.getLocator("Password")).clear();
			driver.findElement(objmap.getLocator("Password")).sendKeys(password);
			TakeScreenshot("Pass");
			clickElement("LogIn");
			Thread.sleep(500);
			if (verifyElementPresent("CurrentPassword"))
			{
				driver.findElement(objmap.getLocator("CurrentPassword")).clear();
				driver.findElement(objmap.getLocator("CurrentPassword")).sendKeys(password);
				driver.findElement(objmap.getLocator("NewPassword")).clear();
				driver.findElement(objmap.getLocator("NewPassword")).sendKeys("123Abcd");
				driver.findElement(objmap.getLocator("Re-enterNewPassword")).clear();
				driver.findElement(objmap.getLocator("Re-enterNewPassword")).sendKeys("123Abcd");
				clickElement("ChangePassword");
				if (enviornment.equals("cdv") || enviornment.equals("qa2") || enviornment.equals("qa7") || enviornment.equals("qa10") || enviornment.equals("qa12") )
				{
					String CourseURL = "https://"+siteName+"-lcec."+enviornment+".lrn.com/app/courseinfo/"+systemID+"";
					driver.get(CourseURL);
					logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
				} else if (enviornment.equals("prod"))
				{
					String CourseURL = "https://"+siteName+"-lcec.lrn.com/app/courseinfo/"+systemID+"";
					driver.get(CourseURL);
					logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
				}
			}
			for (int i=1; i>=20; i++){ 
				if (!verifyElementPresent("GetStartedbtn"))
				{
					String CurrentPageURL = driver.getCurrentUrl();
					driver.get(CurrentPageURL);
				} else {
					TakeScreenshot("Fail-SiteLoginIssue");
					logFAIL("The site login failed (error)");
					Assert.fail();
				}
			}
			if (verifyElementPresent("VideoOff"))
			{
				clickElement("VideoOff");
			}
			/*if (verifyElementPresent("VideoOn"))
			{
				clickElement("VideoOn");
			}*/
			TakeScreenshot("Pass");
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			logINFO("" + uAgent + "");
			clickElement("GetStartedbtn");
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
			Thread.sleep(15000);
			String CourseURL = driver.getCurrentUrl();
			logINFO("" + catalogID + " URL = " + CourseURL + "");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-lcecCourseUrlLoginAndLaunchCourse");
			logFAILED("The method lcecCourseUrlLoginAndLaunchCourse failed (error)");
			Assert.fail();
		}
	}
	
	public static void lcecCourseUrlLogin() throws Exception {
		try {
			if (enviornment.equals("cdv") || enviornment.equals("qa2") || enviornment.equals("qa7") || enviornment.equals("qa10") || enviornment.equals("qa12") )
			{
				String CourseURL = "https://"+siteName+"-lcec."+enviornment+".lrn.com/app/courseinfo/"+systemID+"";
				driver.get(CourseURL);
				logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
			} else if (enviornment.equals("prod"))
			{
				String CourseURL = "https://"+siteName+"-lcec.lrn.com/app/courseinfo/"+systemID+"";
				driver.get(CourseURL);
				logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
			}
			for (int i=1; i>=20; i++){ 
				if (!verifyElementPresent("UserName"))
				{
					String CurrentPageURL = driver.getCurrentUrl();
					driver.get(CurrentPageURL);
				} else {
					break;
				}
			}
			driver.findElement(objmap.getLocator("UserName")).clear();
			driver.findElement(objmap.getLocator("UserName")).sendKeys(userName);
			driver.findElement(objmap.getLocator("Password")).clear();
			driver.findElement(objmap.getLocator("Password")).sendKeys(password);
			TakeScreenshot("Pass");
			clickElement("LogIn");
			Thread.sleep(500);
			if (verifyElementPresent("CurrentPassword"))
			{
				driver.findElement(objmap.getLocator("CurrentPassword")).clear();
				driver.findElement(objmap.getLocator("CurrentPassword")).sendKeys(password);
				driver.findElement(objmap.getLocator("NewPassword")).clear();
				driver.findElement(objmap.getLocator("NewPassword")).sendKeys("123Abcd");
				driver.findElement(objmap.getLocator("Re-enterNewPassword")).clear();
				driver.findElement(objmap.getLocator("Re-enterNewPassword")).sendKeys("123Abcd");
				clickElement("ChangePassword");
				if (enviornment.equals("cdv") || enviornment.equals("qa2") || enviornment.equals("qa7") || enviornment.equals("qa10") || enviornment.equals("qa12") )
				{
					String CourseURL = "https://"+siteName+"-lcec."+enviornment+".lrn.com/app/courseinfo/"+systemID+"";
					driver.get(CourseURL);
					logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
				} else if (enviornment.equals("prod"))
				{
					String CourseURL = "https://"+siteName+"-lcec.lrn.com/app/courseinfo/"+systemID+"";
					driver.get(CourseURL);
					logINFO(""+ BrowserName +"_"+ catalogID + "_"+ userName + "_"+ password + " = " + CourseURL +"");
				}
			}
			for (int i=1; i>=20; i++){ 
				if (!verifyElementPresent("GetStartedbtn"))
				{
					String CurrentPageURL = driver.getCurrentUrl();
					driver.get(CurrentPageURL);
				} else {
					TakeScreenshot("Fail-SiteLoginIssue");
					logFAIL("The site login failed (error)");
					Assert.fail();
				}
			}
			TakeScreenshot("Pass");
			String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			logINFO("" + uAgent + "");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-lcecCourseUrlLogin");
			logFAILED("The method lcecCourseUrlLogin failed (error)");
			Assert.fail();
		}
	}

	//To run Templates for Linear Courses
	ArrayList<String> templateType = new ArrayList<String>();

	static HashMap<String, String> templateTypeHashMap = new HashMap<String, String>();
	public static void initialiseTemplates() throws Exception {
		templateTypeHashMap.put("Certification", "Certification");
		templateTypeHashMap.put("LandingPageltr", "LandingPageltr");
		templateTypeHashMap.put("TileMenu", "TileMenu");
		templateTypeHashMap.put("BranchingLesson", "BranchingLesson");
		templateTypeHashMap.put("Basicltr", "Basicltr");
		templateTypeHashMap.put("Basicrtl", "Basicrtl");
		templateTypeHashMap.put("Basicto", "Basicto");
		templateTypeHashMap.put("Basicttb", "Basicttb");
		templateTypeHashMap.put("Basicbtt", "Basicbtt");
		templateTypeHashMap.put("Basicfsg", "Basicfsg");
		templateTypeHashMap.put("Saqltr", "Saqltr");
		templateTypeHashMap.put("Saqrtl", "Saqrtl");
		templateTypeHashMap.put("GraphicalSaq", "GraphicalSaq");
		templateTypeHashMap.put("Sidebarltr", "Sidebarltr");
		templateTypeHashMap.put("Sidebarrtl", "Sidebarrtl");
		templateTypeHashMap.put("ClickToRevealBox", "ClickToRevealBox");
		templateTypeHashMap.put("ClickToRevealHotspotltr", "ClickToRevealHotspotltr");
		templateTypeHashMap.put("ClickToRevealHotspotrtl", "ClickToRevealHotspotrtl");
		templateTypeHashMap.put("ClickToRevealHotspotttb", "ClickToRevealHotspotttb");
		templateTypeHashMap.put("ClickToRevealHotspotbtt", "ClickToRevealHotspotbtt");
		templateTypeHashMap.put("ClickToRevealHotspotfsg", "ClickToRevealHotspotfsg");
		templateTypeHashMap.put("ClickToRevealSelectableImageltr", "ClickToRevealSelectableImageltr");
		templateTypeHashMap.put("ClickToRevealSelectableImagertl", "ClickToRevealSelectableImagertl");
		templateTypeHashMap.put("ClickToRevealSelectableImagettb", "ClickToRevealSelectableImagettb");
		templateTypeHashMap.put("ClickToRevealSelectableImagebtt", "ClickToRevealSelectableImagebtt");
		templateTypeHashMap.put("ClickToRevealSelectableImagefsg", "ClickToRevealSelectableImagefsg");
		templateTypeHashMap.put("NewClickToRevealHotspotltr", "NewClickToRevealHotspotltr");
		templateTypeHashMap.put("NewClickToRevealHotspotrtl", "NewClickToRevealHotspotrtl");
		templateTypeHashMap.put("NewClickToRevealHotspotttb", "NewClickToRevealHotspotttb");
		templateTypeHashMap.put("NewClickToRevealHotspotbtt", "NewClickToRevealHotspotbtt");
		templateTypeHashMap.put("NewClickToRevealHotspotfsg", "NewClickToRevealHotspotfsg");
		templateTypeHashMap.put("Videoltr", "Videoltr");
		templateTypeHashMap.put("Consentltr", "Consentltr");
		templateTypeHashMap.put("BinaryListltr", "BinaryListltr");
		templateTypeHashMap.put("DragandDrop", "DragandDrop");
		templateTypeHashMap.put("MultipleScenarioltr", "MultipleScenarioltr");
		templateTypeHashMap.put("MultipleScenariortl", "MultipleScenariortl");
		templateTypeHashMap.put("MultipleScenariottb", "MultipleScenariottb");
		templateTypeHashMap.put("MultipleScenariobtt", "MultipleScenariobtt");
		templateTypeHashMap.put("MultipleScenariofsg", "MultipleScenariofsg");
		templateTypeHashMap.put("BranchingScenario", "BranchingScenario");
		templateTypeHashMap.put("Consultltr", "Consultltr");
		templateTypeHashMap.put("Consultrtl", "Consultrtl");
		templateTypeHashMap.put("Concernltr", "Concernltr");
		templateTypeHashMap.put("Concernrtl", "Concernrtl");
		templateTypeHashMap.put("Adaptiveltr", "Adaptiveltr");
		templateTypeHashMap.put("Adaptivertl", "Adaptivertl");
		templateTypeHashMap.put("Adaptiveto", "Adaptiveto");
		templateTypeHashMap.put("Adaptivebtt", "Adaptivebtt");
		templateTypeHashMap.put("Adaptivettb", "Adaptivettb");
		templateTypeHashMap.put("Adaptivefsg", "Adaptivefsg");
		templateTypeHashMap.put("Carouselfsg", "Carouselfsg");
		templateTypeHashMap.put("PLAssessmentltr", "PLAssessmentltr");
		templateTypeHashMap.put("KnowledgeCheckANDResultsandFeedback", "KnowledgeCheckANDResultsandFeedback");
		templateTypeHashMap.put("NoQuizEndPage", "NoQuizEndPage");
	}

	public static void runTemplatesTestNGxml() throws Exception {
		try {
			for (String key : templateTypeHashMap.keySet()) {
				//Log.info("entered the run templates for loop " + key);
				if(checkVisibilityOfTemplate(0, key)){
					//Log.info("inside the if statement for template visibility");
					logINFO("-----"+key+"(Start)-----");
					
					//templateTypeHashMap.get(key).execute();
					TestNG testng = new TestNG();
					List<String> suites = Lists.newArrayList();
					suites.add("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\TestNGxml\\Sanity\\"+key+".xml");
					//suites.add(System.getProperty("user.dir")+"\\resource\\TestNGxml\\NextOnly\\"+key+".xml");
					//suites.add(System.getProperty("user.dir")+"\\resource\\TestNGxml\\Regression\\"+key+".xml");
					testng.setTestSuites(suites);
					testng.run();
					logINFO("-----"+key+"(End)-----");
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runTemplateTestNGxml");
			logFAILED("The method runTemplateTestNGxml failed for template (error)");
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]).close();
			Thread.sleep(1000);
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			writeExcelData(8, ExcelRowNumber, "Fail");
			Assert.fail();
		}
	}


	public static void readExcelData(String XlsName, String SheetName, int j) throws Exception {
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\testData\\"+XlsName+".xls");
			Workbook workbook = Workbook.getWorkbook(fs);
			Sheet sheet = workbook.getSheet(SheetName);
			String SiteName = sheet.getCell(0,j).getContents(); //logINFO("SiteName---"+SiteName);
			String Enviornment = sheet.getCell(1,j).getContents(); //logINFO("Enviornment---"+Enviornment);
			String UserName = sheet.getCell(2,j).getContents(); //logINFO("UserName---"+UserName);
			String Password = sheet.getCell(3,j).getContents(); //logINFO("Password---"+Password);
			String CatalogID = sheet.getCell(4,j).getContents(); //logINFO("CatalogID---"+CatalogID);
			String SystemID = sheet.getCell(5,j).getContents(); //logINFO("SystemID---"+SystemID);
			siteName = SiteName;
			enviornment = Enviornment;
			userName = UserName;
			password = Password;
			systemID = SystemID;
			catalogID = CatalogID;
			ExcelSheetName = SheetName;
			ExcelRowNumber = j;
			ExcelName = XlsName;
		} catch (Exception e) {
			logFAIL("Excel data Not-Available to read");
		}
	}

	public static void writeExcelData(int ColumnNumber, int RowNumber, String Label) throws Exception {
		try {
			FileInputStream fs = new FileInputStream("C:\\github\\CAT_fx_integration\\CAT_integration\\testData\\"+ExcelName+".xls");
			Workbook existingWorkbook = Workbook.getWorkbook(fs);
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File("C:\\github\\CAT_fx_integration\\CAT_integration\\testData\\"+ExcelName+".xls"), existingWorkbook);
			WritableSheet sheetToEdit = workbookCopy.getSheet(ExcelSheetName);
			sheetToEdit.addCell(new Label(ColumnNumber, RowNumber, Label));
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		} catch (Exception e) {
			logFAIL("Excel Write data Not-Available");
		}
	}

	public static void writeUserName(int j) throws Exception {
		try {
			String[] part = userName.split("(?<=\\D)(?=\\d)");
			String Name = part[0]+Integer.toString(Integer.parseInt(part[1])+1);
			writeExcelData(2,j,Name);
		} catch (Exception e) {
			logFAIL("The method writeUserName failed (error)");
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
