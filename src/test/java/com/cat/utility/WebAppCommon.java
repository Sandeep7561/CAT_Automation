
package com.cat.utility;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;		
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import com.relevantcodes.extentreports.LogStatus;		
import org.testng.asserts.SoftAssert;

import com.cat.common.ObjectMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WebAppCommon 
{
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ObjectMap objmap = new ObjectMap ("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\objects\\CommonMethods.properties");
	//public static Logger logger = Logger.getLogger(WebAppCommon.class.getName());
	public static final String logProperttFilePath = "C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\objects\\log4j.properties";
	//public static ExtentReports extent;		
	//public static ExtentTest testlog;
	public static String catalogID;		
	public static String failImagePath = null;		
	public static String siteName;		
	public static String enviornment;		
	public static String userName;		
	public static String password;		
	public static String systemID;		
	public static String ExcelName;		
	public static String ExcelSheetName;		
	public static int ExcelRowNumber;		
	public static String BrowserName = "Chrome";		
	public static String FullScreenYesNo = "No";		
	public static String FastYesNo = "Yes";		
	public static String ScreenshotYesNo = "No";		
	public static String Quiz = "No";		
	public static String BranchingLesson = "No";		
	public static String AdaptiveLesson = "No";		
	public static String TileMenu = "No";		
	public static String SAQYesNo = "No";		
	public static String JumptoCoursePage = "No";		
	public static String JumptoTileNum = "1";		
	public static String baseUrl;		
	public static StringBuffer verificationErrors = new StringBuffer();		
	//public static ATUTestRecorder recorder;
	
	
	public static WebDriver driver = null;
	public static Properties configProperties = readPropertyFile("//resource//config//FrameworkConfig.properties");

	
//	public static ExtentReports report=new ExtentReports("C:\\Report\\PPTExecutionReport.html");
	//public static ExtentReports report=new ExtentReports("C:\\Jenkins\\workspace\\CAT_fx_integration-master\\CATExecutionReport.html", true);
	
	// Get the DB environment to be connected to
	String connectToDB = configProperties.getProperty("connectToDB");
	private Connection connection;
	private Statement stmt;
	public static  ExtentTest logger1;	
	private static int timeoutSeconds = 10;
	public static String BROWSER_NAME = "";
	public static String BROWSER_VERSION = "";
	public static String PLATFORM = "";
	private static WebDriverWait wait = null;
	public static SoftAssert softA = new SoftAssert();
//	protected static Screen screen = new Screen();


//	protected String logs = appPath()+ "//src//log4j.xml";

	public static String backGroundImage = appPath()+ "\\resource\\SiteCustomizationImage\\Favicon.jpg";
	//C:/Users/ravi.jaiswar/Desktop/LocalDriver/CatalystAutomation/src/com/lrn/catalyst/logs/log4j.xml
	//String logs = "C:/Users/ravi.jaiswar/Desktop/LocalDriver/CatalystAutomation/src/com/lrn/catalyst/logs/log4j.xml";

	//private String URL = "http://www.xyz.com";
	//@Parameters("browser")C:\Users\ravi.jaiswar\Desktop\LRN_Automation\LCECAutomation\testdata\bulkload-file\qacustomize05\LRNADD112315.txt
	public static void getWaitPageLoad()
	{
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES) ;
	}
	public static   String  getErrorMessage(String errorMessage,String imageName) throws IOException, AWTException
	{
		String screenshot_path=gettakeScreenShot(imageName);
		String image=logger.addScreenCapture(screenshot_path);
		return image;
	}
	public static String gettakeScreenShot(String imageName) throws IOException, AWTException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String filename =imageName+".png";
		String workingDirectory = System.getProperty("user.dir");
		String imagepath ="./screenshots/"+ filename;
		FileUtils.copyFile(scrFile, new File(imagepath));
		return imagepath;
	}
	
	public static void getScrrolToWebElement(String ScroolLocater)
	{
		WebElement element = driver.findElement(By.xpath(ScroolLocater));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	public static void logINFO(String message) { 	
		//Log.info("entered log info");
		//logger.info(message);
		//Log.info("entered log info1");
		logger1.log(LogStatus.INFO, message);
		//Log.info("entered log info2");
	}
	
	public static void logPASS(String message) { 		
		//logger.info(message);		
		//logger1.log(LogStatus.PASS, message);
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		//logger.info(methodName + " :: " + message);
		logger1.log(LogStatus.PASS, methodName + " :: " + message);
	}
	
	public static void logFAIL(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		if (JumptoCoursePage.equals("No"))
		{
			//logger.info(methodName + " :: " + message);
			logger1.log(LogStatus.INFO, methodName + " :: " + message);
		}
		else
		{
			if ((ScreenshotYesNo.contains("Yes")) || (ScreenshotYesNo.contains("Fail")) && !ScreenshotYesNo.equals("No"))
			{
				if (failImagePath.equals("") || failImagePath.equals("null") || failImagePath.equals("undefined"))		
				{		
				//	logger.info(methodName + " :: " + message);		
					logger1.log(LogStatus.FAIL, methodName + " :: " + message);		
				} else		
				{		
				//	logger.info(methodName + " :: " + message);		
					logger1.log(LogStatus.FAIL, message + logger1.addScreenCapture(failImagePath));		
				}		
			} 
			else {		
				//	logger.info(methodName + " :: " + message);		
					logger1.log(LogStatus.FAIL, methodName + " :: " + message);		
				}		
		} 
	}
	
	public static void logFAILED(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		if ((ScreenshotYesNo.contains("Yes")) || (ScreenshotYesNo.contains("Fail")) && !ScreenshotYesNo.equals("No"))
		{
			if (failImagePath.equals("") || failImagePath.equals("null") || failImagePath.equals("undefined"))
			{
			//	logger.info(methodName + " :: " + message);
				logger1.log(LogStatus.FAIL, methodName + " :: " + message);
			}
			else
			{
			//	logger.info(methodName + " :: " + message);
				logger1.log(LogStatus.FAIL, message + logger1.addScreenCapture(failImagePath));
			}
		}
		
		else
		{
			//logger.info(methodName + " :: " + message);
			logger1.log(LogStatus.FAIL, methodName + " :: " + message);
		}
	}
	
	public static void logSKIP(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		if (JumptoCoursePage.equals("No") || JumptoCoursePage.equals("Yes"))
		{
		//	logger.info(methodName + " :: " + message);
			logger1.log(LogStatus.INFO, methodName + " :: " + message);
		}
		else
		{
			//logger.info(methodName + " :: " + message);		
			logger1.log(LogStatus.INFO, methodName + " :: " + message);
		}
	}
		
	public static void assertFail() throws Exception {		
		if (!JumptoCoursePage.equals("No") && !JumptoCoursePage.equals("Yes"))
		{
			Assert.fail();
		}
		else if (BranchingLesson.equals("Yes"))
		{
			Assert.fail();
		}	
	}
	
	public static void waitforElement(String Element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objmap.getLocator(Element)));
	}
	
	public static boolean verifyElementPresent(String Element) throws Exception {
		try {
			waitforElement(Element);
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			isElementPresent1(objmap.getLocator(Element));
			driver.findElement(objmap.getLocator(Element)).isDisplayed();
			//logINFO(Element + " : Present");
		} catch (Exception e) {
			//TakeScreenshot("Fail-"+Element+"-Method-verifyElementPresent");
			//logFAIL(Element + ": The method verifyElementPresent failed (error)");
			return false;
		}
		return true;
	}
	
	protected static boolean isElementPresent1(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean verifyElementTextPresent(String Element) throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				waitforElement(Element);
				WebElement element = driver.findElement(objmap.getLocator(Element));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				String Text = driver.findElement(objmap.getLocator(Element)).getText();
				if (Text.equals("") || Text.equals("null") || Text.equals("undefined") || Text.equals("00:00"))
				{
					TakeScreenshot("Fail-"+Element+"-TextNotPresent");
					logFAIL(Element + " = ["+ Text +"] : Not-Present (error)");
					assertFail();
				} else
				{
					//logINFO(Element + " = ["+ Text +"] : Present");
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-verifyElementTextPresent");
			logFAIL(Element + ": The method verifyElementTextPresent failed (error)");
			assertFail();
			return false;
		}
		return true;
	}
	
	public static void verifyElementImagePresent(String Element) throws Exception {
		try{
			if (FastYesNo.equals("No"))
			{
				waitforElement(Element);
				WebElement element = driver.findElement(objmap.getLocator(Element));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				String Image = driver.findElement(objmap.getLocator(Element)).getAttribute("src");
				if (Image.contains("placeholder") || Image.equals("null") || Image.equals("") || Image.contains("errorSource") || Image.contains("dnd_icons"))
				{
					logINFO(Element + " = ["+ Image +"] Plcaeholder-Image: Present");
					WebElement ImageFile = driver.findElement(objmap.getLocator(Element));
					Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
					if (ImagePresent)
					{
						TakeScreenshot("Fail-"+Element+"-PlcaeholderImageLoaded");	
						logFAIL(Element + " Plcaeholder-Image: Loaded (error)");
						assertFail();
					} else
					{
						TakeScreenshot("Fail-"+Element+"-PlcaeholderImageNotLoaded");
						logFAIL(Element + " Plcaeholder-Image: Not-Loaded (error)");
						assertFail();
					}
				} else
				{
					//logINFO(Element + " = ["+ Image +"] : Present");
					WebElement ImageFile = driver.findElement(objmap.getLocator(Element));
					Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
					if (ImagePresent)
					{
						//logINFO(Element + " Image: Loaded");
					} else
					{
						TakeScreenshot("Fail-"+Element+"-ImageNotLoaded");
						logFAIL(Element + " Image: Not-Loaded (error)");
						assertFail();
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-verifyElementImagePresent");
			logFAIL(Element + ": The method verifyElementImagePresent failed (error)");
			assertFail();
		}
	}
	
	public static void clickElementText(String Element) throws Exception {
		try {
			verifyElementTextPresent(Element);

			movetoElement(Element);

			WebElement element1 = driver.findElement(objmap.getLocator(Element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500);

			WebElement element2 = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element2).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();

			String Disabled = driver.findElement(objmap.getLocator(Element)).getText();
			String disabled = driver.findElement(objmap.getLocator(Element)).getAttribute("class");
			if (Disabled.contains("dimmed") || disabled.contains("disabled"))
			{
				TakeScreenshot("Fail-"+Element+"-ButtonDisabled");
				logFAIL(Element + ": Button Disabled  (error)");
				assertFail();
			} else
			{
				//logINFO(Element + ": Button Enabled");
				driver.findElement(objmap.getLocator(Element)).click();
				//logINFO(Element + ": Clicked");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-clickElementText");
			logFAIL(Element + ": The method clickElementText failed (error)");
			assertFail();
		}
	}
	
	public static void clickElement(String Element) throws Exception {
		try {
			waitforElement(Element);

			movetoElement(Element);

			WebElement element1 = driver.findElement(objmap.getLocator(Element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500);

			WebElement element2 = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element2).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();

			String Disabled = driver.findElement(objmap.getLocator(Element)).getText();
			String disabled = driver.findElement(objmap.getLocator(Element)).getAttribute("class");
			if (Disabled.contains("dimmed") || disabled.contains("disabled"))
			{
				TakeScreenshot("Fail-"+Element+"-ButtonDisabled");
				logFAIL(Element + ": Button Disabled (error)");
				//CloseBrowser();
				assertFail();
			} else
			{
				//logINFO(Element + ": Button Enabled");
				driver.findElement(objmap.getLocator(Element)).click();
				//logINFO(Element + ": Clicked");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-clickElement");
			logFAIL(Element + ": The method clickElement failed (error)");
			assertFail();
		}
	}
	
	public static void clickInvisibleElement(String Element) throws Exception {
		//Clicking an invisible or hidden Element on page
		//style="Display:none;" | style="Display:block;" | style="visibility:hidden;" | type="hidden"
		try {
			WebElement invisibleelement= driver.findElement(objmap.getLocator(Element)); 
			JavascriptExecutor executor = (JavascriptExecutor)driver;  
			executor.executeScript("arguments[0].click();", invisibleelement);
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-clickInvisibleElement");
			logFAIL(Element + ": The method clickInvisibleElement failed (error)");
			assertFail();
		}
	}
	
	public static void getAttribute(String Element, String Attribute) throws Exception {
		try {
			waitforElement(Element);
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			String AttributeValue = driver.findElement(objmap.getLocator(Element)).getAttribute(Attribute);
			if (AttributeValue.equals("") || AttributeValue.equals("null"))
			{
				TakeScreenshot("Fail-"+Element+"-AttributeValueNotPresent");
				logFAIL(Element + " = ["+ AttributeValue +"] : Not-Present (error)");
				assertFail();
			} else
			{
				//logINFO(Element + " = ["+ AttributeValue +"] : Present");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-getAttribute");
			logFAIL(Element + ": The method getAttribute failed (error)");
			assertFail();
		}
	} 
	
	public static boolean verifyElementTextDisplayed(String Element) throws Exception {
		try {
			waitforElement(Element);
			driver.findElement(objmap.getLocator(Element)).isDisplayed();
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			String Text = driver.findElement(objmap.getLocator(Element)).getText();
			if (Text.equals("") || Text.equals("null") || Text.equals("00:00") || Text.equals("  ") || Text.contains("   "))
			{
				TakeScreenshot("Fail-"+Element+"-TextNotDisplayed");	
				logFAIL(Element + " = ["+ Text +"] : Not-Displayed (error)");
				assertFail();
			} else
			{
				//logINFO(Element + " = ["+ Text +"] : Displayed");
			}

		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-verifyElementTextDisplayed");
			logFAIL(Element + ": The method verifyElementTextDisplayed failed (error)");
			assertFail();
			return false;
		}
		return true;
	}
	
	public static void DragandDrop(String Element, String Target) throws Exception {
		try {
			WebElement ELEMENT = driver.findElement(objmap.getLocator(Element));
			WebElement TARGET = driver.findElement(objmap.getLocator(Target));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TARGET);
			Thread.sleep(500);
			(new Actions(driver)).dragAndDrop(ELEMENT, TARGET).perform();
			Thread.sleep(2000);
			//logINFO(""+Element+" - DROPPPED IN - "+ Target +"");
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-DragandDrop");
			logFAIL(Element + ": The method DragandDrop failed (error)");
			assertFail();
		}
	}

	public static void dragSlider(String Element, int X, int Y) throws Exception {
		try {
			waitforElement(Element);
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			WebElement Slider = driver.findElement(objmap.getLocator(Element));
			Actions moveSlider = new Actions(driver);
			Action action = moveSlider.dragAndDropBy(Slider, X, Y).build();
			action.perform();
			//logINFO(Element + "Slider Drag " + X +" to " + Y +" Position");
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-dragSlider");
			logFAIL(Element + ": The method dragSlider failed (error)");
			assertFail();
		}
	}
	
	
	public static void checkInvisibilityOfElement(int X, String Element) throws Exception {
		try {
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			WebDriverWait wait = new WebDriverWait(driver, X);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(objmap.getLocator(Element)));
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-checkInvisibilityOfElement");
			logFAIL(Element + ": The method checkInvisibilityOfElement failed (error)");
			assertFail();
		}
	}

	public static void checkVisibilityOfElement(int X, String Element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, X);
			wait.until(ExpectedConditions.visibilityOfElementLocated(objmap.getLocator(Element)));
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-checkVisibilityOfElement");
			logFAIL(Element + ": The method checkVisibilityOfElement failed (error)");
			assertFail();
		}
	}

	public static boolean checkVisibilityOfTemplate(int X, String Element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, X);
			wait.until(ExpectedConditions.visibilityOfElementLocated(objmap.getLocator(Element)));
			//Log.info(Element + " is visible");
		} catch (Exception e) {
			//TakeScreenshot("Fail-"+Element+"-Method-checkVisibilityOfTemplate");
			//logFAIL(Element + ": The method checkVisibilityOfTemplate failed (error)");
			//assertFail();
			return false;
		}
		//Log.info("returning true for " + Element);
		return true;
		
	}

	public static void movetoElement(String Element) throws Exception {
		try{
			WebElement HotSpot = driver.findElement(objmap.getLocator(Element));
			Actions action = new Actions(driver);
			action.moveToElement(HotSpot).perform();
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-movetoElement");
			logFAIL(Element + ": The method movetoElement failed (error)");
			assertFail();
		}
	}

	public static void TakeScreenshot(String PassORFail) throws Exception {
		String path = null;
		try {
			if ((PassORFail.contains(ScreenshotYesNo) || ScreenshotYesNo.contains("Yes")) && !ScreenshotYesNo.equals("No"))
			{
				Thread.sleep(2000);
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Calendar currentDate = Calendar.getInstance();
				java.io.File currentDir = new java.io.File("");                
				//String workingDirectory = System.getProperty("user.dir");
				//get today's date without Time stamp
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				Date today = dateFormat.parse(dateFormat.format(new Date()));
				String todaysDate = dateFormat.format(today).replace("/", "");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy_HH:mm:ss");
				//Get Full Class name 
				//String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
				//Get Method name 
				//String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
				//Get Class short name 
				//int firstChar = fullClassName.lastIndexOf('.') +1;
				//int firstChar1 = methodName.lastIndexOf('.') +1;
				//String className = fullClassName.substring(firstChar);
				String dateN = formatter.format(currentDate.getTime()).replace("/","_");
				String dateNow = dateN.replace(":",".");
				//logINFO("printing datenow---------"+dateNow);
				String strAppPath = "C:/github/CAT_fx_integration/CAT_integration/testresult/screenshots/"+catalogID+"_"+BrowserName+"_"+todaysDate; // Screenshots in Local Machine
				//String strAppPath = "Q:/ContentQA-FluidX-Automation-Results/screenshots/"+catalogID+"_"+BrowserName+"_"+todaysDate; // Screenshots in Q drive
				String strAppPathPass = strAppPath+"/Passed";
				String strAppPathFail = strAppPath+"/Failed";
				//     String strAppPath = currentDir.getAbsolutePath();
				//     int count = 1;
				String fileName = catalogID+"_"+BrowserName+"_"+PassORFail+"_"+dateNow+".jpeg"; 
				//     count++;
				//     String fileName = dateNow+".png"; 
				//String snapShotDirectory = strAppPath;
				String snapShotDirectoryPass = strAppPathPass;
				String snapShotDirectoryFail = strAppPathFail;
				//logINFO("Im here-------------"+snapShotDirectory);
				File Pass = new File(snapShotDirectoryPass);
				File Fail = new File(snapShotDirectoryFail);
				//check for snapshot having folder with today date if not then create one
				if (PassORFail.contains("Pass"))
				{
					if(Pass.exists()){
						//logINFO("SnapshotDirectory Already Exists");
					}
					else {
						Pass.mkdir();
					}                     
					path = Pass.getAbsolutePath() + "\\" + fileName;
					//logINFO("Path------------------"+path);
					FileUtils.copyFile(source, new File(path));
				}
				else if (PassORFail.contains("Fail"))
				{
					if(Fail.exists()){
						//logINFO("SnapshotDirectory Already Exists");
					}
					else {
						Fail.mkdir();
					}                     
					path = Fail.getAbsolutePath() + "\\" + fileName;
					failImagePath = path;
					//logINFO("Path------------------"+path);
					FileUtils.copyFile(source, new File(path));
				}
			}
		}
		catch(IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
			logINFO("The method TakeScreenshot failed (error)");
			assertFail();
		}
	}
	
	public static void createLogfiles() throws Exception {
		try {
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy_HH.mm.ss");
			String dateTime = formatter.format(currentDate.getTime());
			String FileName = catalogID + "-" + BrowserName + "-" + dateTime + ".log";
			File file = new File("C:\\github\\CAT_fx_integration\\CAT_integration\\testresult\\logs\\" + FileName); // Logs on Local Machine
			//File file = new File("Q:/ContentQA-FluidX-Automation-Results/logs/" + FileName); // Logs on Q drive for ContentQA team


			if (file.createNewFile()) {
				Properties props = new Properties();
				props.load(new FileInputStream(logProperttFilePath));
				//props.setProperty("log4j.appender.R.File", "Q:/ContentQA-FluidX-Automation-Results/logs/" + FileName); // Logs on Q drive for ContentQA team
				props.setProperty("log4j.appender.R.File", "C:\\github\\CAT_fx_integration\\CAT_integration\\testresult\\logs\\" + FileName); // Logs on Local Machine
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				logINFO("logs =" + FileName);
				//System.out.print("logs = Q:/ContentQA-FluidX-Automation-Results/logs/" + FileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("IO Exception in static method of Logger Class. " + e.getMessage());
			logINFO("The method createLogfiles failed (error)");
			//System.exit(-1);
		}
	}
	
	

	/*	public static WebDriver getDriver() throws Exception {
		if (driver == null) {
			String browser = FrameWorkConfig.getBrowser();
			timeoutSeconds = FrameWorkConfig.getBrowserTimeOut();

			if (browser.equals("FF")) {
				getFFDriver();
			} else if (browser.equals("IE")) {
				getIEDriver();
			} else if (browser.equals("GC")) {
				getChromeDriver();
			}

			// Get actualCapabilities
			Capabilities actualCapabilities = ((RemoteWebDriver) driver)
					.getCapabilities();
			BROWSER_NAME = actualCapabilities.getBrowserName().toUpperCase();
			BROWSER_VERSION = actualCapabilities.getVersion();
			PLATFORM = actualCapabilities.getPlatform().toString()
					.toUpperCase();
		}
		return driver;
	}*/
	
	
	public static void softAssertEquals(String xpath, String expectedValue)
	{
		try 
		{
			softA.assertEquals(getValueByXpath(xpath),expectedValue);
			
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}

	
	public void connectToDB() 
	{
		try 
		{
			if (connectToDB.equals("QA")) 
			{
				Class driverClass = Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("","","");
				stmt = connection.createStatement();

			}
			else if (connectToDB.equals("DEV")) 
			{
				Class driverClass = Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@10.103.30.30:1526/lcecbq5","lcec", "lcec");
				stmt = connection.createStatement();
				System.out.println("Connected to DB");
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Name - getStmt*/
	public Statement getStmt() throws  SQLException 
	{
			return connection.createStatement();
			
		
		
	}
	
	
	//select * from course_lookup where system_id='LRNL0384';
	
	
	
	public void keyDown() throws Exception {
		try 
		{
			Actions a = new Actions(driver);
			a.keyDown(Keys.DOWN).build().perform();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}


	public void moveByOffset(int xOffset, int yOffset) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.moveByOffset(xOffset, yOffset).build().perform();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}


	/*public static void sikuliExecute(String ImagePath ) throws Exception{
		try {
			ImagePath = appPath() + ImagePath; 

			Pattern image1 = new Pattern(ImagePath);

			if(screen.exists(image1) != null){
				//DO YOUR ACTIONS
				screen.wait(image1, 10);
				screen.click(image1);
				System.out.println("Sikuli operation successful");
			} else
				System.out.println("Outside sikuli loop, operation Un-successful");
		} catch (Exception e) {
			Log.info("Error: Failed in Sikuli, not able to perform action on Image");
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
	}

	public static void sikuliVerifyImage(String ImagePath, String Comment ) throws Exception{
		try {
			ImagePath = appPath() + ImagePath; 
			Pattern image1 = new Pattern(ImagePath);
			if(screen.exists(image1) != null){
				screen.wait(image1, 10);
				screen.exists(image1);
				Log.info("Verification of "+ Comment +" Image is successfull");
			} else
				Log.info("Error: Verification of "+ Comment +" Image Failed");
		} catch (Exception e) {
			Log.info("Error: Verification of "+ Comment +" Image Failed");
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
	}*/

	public boolean waitForWindow(String title){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(70, TimeUnit.SECONDS) //How long should WebDriver wait for new window
				.pollingEvery(5, TimeUnit.SECONDS)  //How often should it check if a searched window is present
				.ignoring(NoSuchWindowException.class);

		wait.until(new Open_PopUp(title)); //Here 'title' is an actual title of the window, we are trying to find and switch to.
		return true;
	}

	private class Open_PopUp implements ExpectedCondition<String> {
		private String windowTitle;

		public Open_PopUp(String windowTitle){
			this.windowTitle = windowTitle;
		}
		public String apply(WebDriver driver) {

			for(String windowHandle: driver.getWindowHandles()){
				driver.switchTo().window(windowHandle);
				if (driver.getTitle().equalsIgnoreCase(windowTitle))
					return driver.getWindowHandle();
			}

			return null;
		}
	}

	public static WebDriver getIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
		.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/resource/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver(capabilities);
		//driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
		Capabilities actualCapabilities = ((RemoteWebDriver) driver)
				.getCapabilities();
		BROWSER_NAME = actualCapabilities.getBrowserName().toUpperCase();
		BROWSER_VERSION = actualCapabilities.getVersion();
		PLATFORM = actualCapabilities.getPlatform().toString()
				.toUpperCase();

		return driver;
	}

	//openURL
	public void openURL(String URL) throws Exception 
	{
		try {
			driver.get(URL);
		} catch (Exception e) {
			throw e;
		}
		
	}

	protected static WebDriver getFFDriver() {

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		// Disable auto update
		firefoxProfile.setPreference("app.update.enabled", false); 
		// Disable the default browser check certificate
		firefoxProfile.setPreference("browser.shell.checkDefaultBrowser", false); 
		firefoxProfile.setAcceptUntrustedCertificates(true); // Accept certificates
		firefoxProfile.setPreference("browser.tabs.autoHide", true); // Hide tabs
		firefoxProfile.setPreference("browser.tabs.warnOnClose", false); // Disable warning on tab open
		firefoxProfile.setPreference("browser.tabs.warnOnOpen", false); // Disable warning on tab close

		firefoxProfile.setPreference("browser.rights.3.shown", true); // Disable know your right options

		driver = new FirefoxDriver(firefoxProfile);
		driver.manage().window().maximize();
		//	driver.get(URL);		
		driver.manage().timeouts()
		.implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);

		return driver;
	}

	protected static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver","../CATAutomation/resource/drivers/chromedriver.exe");
		//System.getProperty("user.dir")+ "/resource/drivers/chromedriver.exe");
		//System.getProperty("user.dir")+ "/resource/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		//driver.get(URL);		

		return driver;
	}
	public static void getfileAfterDownlod(String FileNamePath)
	{
		String chromeDriverData="/CATAutomation/resource/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverData); 
		String workingDirectory = System.getProperty("user.dir");
		String downloadFilepath = workingDirectory+FileNamePath;

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); //to disable browser extension popup

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
	}
	
	

	public static WebDriverWait getWait() {
		if (wait == null) {
			wait = new WebDriverWait(driver, timeoutSeconds);
		}
		return wait;
	}

	public static void setWait(int timeoutSecs) {
		timeoutSeconds = timeoutSecs;
		wait = new WebDriverWait(driver, timeoutSeconds);
	}

	public static void setImplicitWait(int timeoutSeconds) {
		if (driver != null)
			driver.manage().timeouts()
			.implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
	}

	public static void closeDriver() throws Exception {
		try {
			if (driver != null)
				driver.quit();

			driver = null;
			wait = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}


	public void closeWindow() throws Exception{
		try {
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void launchBrowser(String browser) throws Exception
	{
	//	DOMConfigurator.configure(logs);
	
		try{
			if (browser.equalsIgnoreCase("firefox"))
			{
				getFFDriver();
			
				/*Log.info("Exceuting on FireFox");
				System.out.println(" Executing on FireFox");
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();*/
			}
			else if (browser.equalsIgnoreCase("chrome"))
			{
				getChromeDriver();
				//getfileAfterDownlod("\\resource");
				/*Log.info("Executing on Chrome");
				System.out.println(" Executing on CHROME");
				System.out.println("Executing on IE");
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();*/
			}
			else if (browser.equalsIgnoreCase("ie"))
			{
				getIEDriver();
		
				/*Log.info("Executing on Internet Explorer");
				System.out.println("Executing on IE");
				System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();*/
			}
			else
			{
				throw new IllegalArgumentException("The Browser Type is Undefined");
			} }
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
		//read table data
	public String[][] readExcelData(String xlFilePath, String sheetName,String tableName1, String tableend1) throws Exception {
		String[][] tabArray1 = null;
		try{

			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart1 = sheet.findCell(tableName1);
			startRow = tableStart1.getRow();
			startCol = tableStart1.getColumn();

			Cell tableEnd = sheet.findCell(tableend1);
			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
					+ "startCol=" + startCol + ", endCol=" + endCol);
			tabArray1 = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;


			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray1[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}

		} catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return (tabArray1);
	}


	//read table data
	public String[][] readExcelData12(String xlFilePath, String sheetName) throws Exception {
		String[][] tabArray1 = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getRows();
		System.out.println(rows);
		int cols =sheet.getColumns();
		int ci =0;
		for(int row=0; row<sheet.getRows(); row++)
		{
			System.out.println(row);
			int cj=0;
			for(int col=0;col<sheet.getColumns();col++){
				tabArray1[ci][cj] = sheet.getCell(col, row).getContents();	
			}
			System.out.print(sheet.getCell(0,0).getContents());
			System.out.print(":::");
			System.out.println(sheet.getCell(1,1).getContents());
		}
		return tabArray1;
	}

	public void verifyLableByXpath(String strXpathActualValue, String ExpectedValue) throws Exception
	{
		strXpathActualValue =strXpathActualValue.trim();
		ExpectedValue = ExpectedValue.trim();
		try 
		{
			if (waitForElementPresentByXpath(strXpathActualValue))
			{
				String actualLableValue= driver.findElement(By.xpath(strXpathActualValue)).getText();
				String expectedLableValue = ExpectedValue;
				if(actualLableValue.equalsIgnoreCase(expectedLableValue))
				{
					//Log.info("Presence of Lable verified on the webpage : " +actualLableValue );
				}
				else
				{
					//Log.fail("Error in verifying label : " +actualLableValue+ " is not present on Webpage"  );
				}
			}
		} 
		catch (Exception e) 
		{
			throw e;

		}
	}

	//clickIdentifierLinkText
	public void clickIdentifierLinkText(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByLinkText(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.linkText(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}


	//clickIdentifierLinkText
	public static void clickIdentifierPartialLinkText(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByPartialLinkText(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.partialLinkText(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	public void clickIdentifierCssSelector(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByCssSelector(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.cssSelector(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	public static void uploadFile(String filePath) throws Exception 
	{
		try
		{
			filePath = appPath() + filePath; 
			System.out.println("--------------------------" +filePath);
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();
			robot.delay(7000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(7000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(7000);
		}
		catch(AWTException  e)
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE); 
		}
	}


	//clickIdentifier xpath
	public static void clickIdentifierXpath(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		//try
		//{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.xpath(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.release();
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		//}
		//catch (Exception e) 
		//{
		//	e.printStackTrace();
		////	throw e;
		//}
	}

	

	
	/*public String getElementTextById(String strHTMLID) throws Exception
	{
		try 
		{
			if(waitForElementPresentByID(strHTMLID))
			{
				
				
			}
		
			
			
			
		} catch (Exception e) 
		
		{
		
		
		}
	}
*/

	//clickIdentifierLinkText
	public static void clickIdentifierByID(String strHTMLID) throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//driver.findElement(By.id(strHTMLID)).click();
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.id(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
		e.printStackTrace();
			throw e;
		}
	}

	//wait for element to visible
	public static boolean waitForElementPresentByID(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}
	
	public static boolean waitForElementPresentByName(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}

	//waitForElementPresentByxpath
	public static boolean waitForElementPresentByXpath(String element) throws Exception
	{
		WebElement strElement = null;
		//try
		//{
			strElement= new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		//}
		//catch(Exception e)
		//{
		//	e.printStackTrace();
		//}
		return strElement.isDisplayed();
	}


	public boolean waitForElementPresentByCssSelector(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	//waitForElementPresentByLinkText
	public static boolean waitForElementPresentByLinkText(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	//waitForElementPresentByPartialLinkText
	public static boolean waitForElementPresentByPartialLinkText(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	public static List<String> getAllDropDownOptions(By by) {
		List<String> options = new ArrayList<String>();
		for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
			String txt = option.getText();
			//Log.info("Languages available in dropDown : "  +txt);
			if (option.getAttribute("value") != "") options.add(option.getText());
		}
		return options;
	}




	/*	Name  - readPropertyFile*/
	public static Properties readPropertyFile(String pFileName) 
	{   
		FileInputStream fileSource = null;
		Properties propertyLoad = null;
		try 
		{
			pFileName = appPath() + pFileName; 
			//	System.out.println("Äbsolute path of WorkSpace---"+appPath());
			//	System.out.println("Absolute path of file---"+pFileName);
			propertyLoad = new Properties();
			propertyLoad.load(new FileInputStream(pFileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(fileSource!=null)
			{
				try 
				{
					fileSource.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}	
		}
		return propertyLoad;	
	}

	//appPath
	public static String appPath() 
	{
		String strAppPath = null;
		try
		{
			java.io.File currentDir = new java.io.File("");
			strAppPath = currentDir.getAbsolutePath();
		}
		catch (Exception e)
		{
			strAppPath = "-1";
			e.printStackTrace();
		}
		return strAppPath;
	}

	public void mouseHoverAndClick(String mouseHover, String strElement) throws Exception
	{
		mouseHover = mouseHover.trim();
		strElement = strElement.trim();
		try
		{
			Actions builder = new Actions(driver);
			//	builder.moveToElement(driver.findElement(By.xpath(mouseHover))).moveToElement(driver.findElement(By.xpath(strElement))).click().perform();
			builder.moveToElement(driver.findElement(By.xpath(mouseHover))).perform();
			//		Thread.sleep(5000);
			builder.moveToElement(driver.findElement(By.xpath(strElement))).click().perform();
		}
		catch (Exception e) 
		{
			Reporter.log("Could not click on " + strElement + " because it was not found.");
			e.printStackTrace();
			throw e;
		}
	}



	public static void typeTextById(String strHTMLID, String strString) throws Exception
	{
		//strHTMLID = strHTMLID.trim();
		//strString = strString.trim();
		//try 
		//{
			if (waitForElementPresentByID(strHTMLID))
			{
				driver.findElement(By.id(strHTMLID)).clear();
				Thread.sleep(2000);
				driver.findElement(By.id(strHTMLID)).sendKeys(strString);
			}
			else
			{
				//Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				//failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		//} 
		//catch (Exception e)
		//{
		//	e.printStackTrace();
		//	throw e;
		//}
	}
	
	public static void typeTextByiframe(String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			
			if (waitForElementPresentByXpath("//iframe[@title='" + strHTMLID + "']"))
			{
				WebElement frame = driver.findElement(By.xpath("//iframe[@title='" + strHTMLID + "']"));
				driver.switchTo().frame(frame);
				WebElement body = driver.findElement(By.tagName("body"));
				body.clear();
				body.sendKeys(strString);
				
				driver.switchTo().defaultContent();
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	
	public static void typeTextByName(String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			if (waitForElementPresentByName(strHTMLID))
			{
				driver.findElement(By.name(strHTMLID)).clear();
				driver.findElement(By.name(strHTMLID)).sendKeys(strString);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public static void typeTextByXpath(String strHTMLID, String strString) throws Exception
	{
		//strHTMLID = strHTMLID.trim();
		//strString = strString.trim();
		//try 
		//{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				driver.findElement(By.xpath(strHTMLID)).clear();
				driver.findElement(By.xpath(strHTMLID)).sendKeys(strString);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
	//	} 
	//	catch (Exception e)
	//	{
	//		e.printStackTrace();
	//		throw e;
	//	}
	}
	
	public static void getWaitForElementPresent(String elementXpath,int time)
    {      
           WebDriverWait wt = new WebDriverWait(driver,time);
           wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
    }
   
	public static void getWaitForID(String elementXpath,int time)
    {      
           WebDriverWait wt = new WebDriverWait(driver,time);
           wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementXpath)));
    }

	
	/*************Module Manger**************/
	public String getTextValueByXpath(String element,String strHTMLID)
    {
           String strValue = null;
           try
           {
                  if (waitForElementPresentByXpath(element,strHTMLID))
                  {
                        strValue = driver.findElement(By.xpath(strHTMLID)).getText();
                        strValue=strValue.trim();
                  }
                  else
                  {
                        Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
                        failTestcase("Could not click on " + strHTMLID + " because it was not found.");
                  }
           }
           catch(Exception e)
           {
                  e.printStackTrace();
           }
           return strValue;

    }

	public static boolean waitForElementPresentByXpath(String element, String xpath1) throws Exception
	{
	       WebElement strElement = null;
	
	       strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
	       //Log.info(strElement +  " is present");
	       highLightElement(driver, strElement);
	       Assert.assertTrue(strElement.isDisplayed(),element + "is not prsenet");
	       return strElement.isDisplayed();
	}

	
	public  static void getDroupDown(WebElement element,String value)
	    {
	           Select select=new Select(element);
	           //select.deselectAll();
	           select.selectByVisibleText(value);
	    }


	
	
	
	
	// Method created selectDropdownValue Index
		public static void selectDropdownValueByIndex(String strHTMLID, int strValue)
				throws Exception {
			strHTMLID = strHTMLID.trim();
			// strValue = strValue.trim();
			try {
				if (waitForElementPresentByID(strHTMLID)) {
					Select drpdown = new Select(
							driver.findElement(By.id(strHTMLID)));
					drpdown.selectByIndex(strValue);
				} else {
					Reporter.log("Could not click on " + strHTMLID
							+ " because it was not found.");
					failTestcase("Could not click on " + strHTMLID
							+ " because it was not found.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	//selectDropdownValue
	public static void selectDropdownValueVisibleText(String strHTMLID, String strValue) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strValue = strValue.trim();
		try
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				Select drpdown = new Select(driver.findElement (By.id(strHTMLID)));
				drpdown.selectByVisibleText(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void selectDropdownValueNameVisibleText(String strHTMLID, String strValue) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strValue = strValue.trim();
		try
		{
			if (waitForElementPresentByName(strHTMLID))
			{
				Select drpdown = new Select(driver.findElement (By.name(strHTMLID)));
				drpdown.selectByVisibleText(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void selectDropdownValueXpathVisibleText(String strHTMLID, String strValue) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strValue = strValue.trim();
		try
		{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				Select drpdown = new Select(driver.findElement (By.xpath(strHTMLID)));
				drpdown.selectByVisibleText(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	//failTestcase
	public static void failTestcase(String e)
	{
		Reporter.log(" Failed because " + e);
		//	Assert.fail("--------- FAILED ----------");
	}


	//assert2Strings
	public void assert2Strings(String strString1, String strString2)
	{
		Assert.assertEquals(strString1,strString2);        	
	}

	//assert title bar
	public void assertTitleBar(String strString1, String strString2)
	{
		Assert.assertEquals(strString1,strString2);        	
	}


	//getValuebyid changed to static
	public static String getValueByID(String strHTMLID)
	{
		String strValue = null;
		try
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				strValue = driver.findElement(By.id(strHTMLID)).getAttribute("value");
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}
	//getValuebyid
	public static String getValueByXpath(String strHTMLID)
	{
		String strValue = null;
		try
		{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				strValue = driver.findElement(By.xpath(strHTMLID)).getText();
				System.out.println(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}

	//getTitlebar
	public static String getTitleBar()
	{
		String strValue = null;
		try
		{
			strValue = driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}
	
	
	public static String getCurrentURL()
	{
		String strValue = null;
		try
		{
			strValue = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}

	public void switchToFrame(String frameName)
	{
		try
		{
			driver.switchTo().frame(frameName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void switchToParentWindow(String frameName) throws Exception
	{
		try
		{
			driver.switchTo().window(frameName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}

	}

	public static boolean isElementPresent(By by, String elementName) {
		try {
			driver.findElement(by);
			System.out.println(elementName + ": Present");
			return true;

		} catch (NoSuchElementException e) {
			System.out.println(elementName + ": Not-Present");
			return false;
		}
	}

	static public boolean isElementPresent(By by) {
		try {
			WebElement	strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(by));
			//		driver.findElement(by);
			if(strElement.isDisplayed())	return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}



	public void waitForModalBoxToDisappear() throws Exception
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'messageModal')]")));
			System.out.println("here-11111111111111111111111111111111");
		} 
		catch (Exception e) 
		{
			System.out.println("catch catch catch ------------------------------");
			// TODO: handle exception
		}
	}
	
	
	public static void checkCheckBox(String xpath) throws Exception{
		WebElement checkbox = driver.findElement(By.xpath(xpath));
		if(!checkbox.isSelected()){
			clickIdentifierXpath(xpath);
		}
	}

	public static void uncheckCheckBox(String xpath) throws Exception{
		WebElement checkbox = driver.findElement(By.xpath(xpath));
		if(checkbox.isSelected()){
			clickIdentifierXpath(xpath);
		}
	}

	//public static void typeTextTinyMceEditor()

	public void typeTextTinyMceEditor(String frameName, String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			driver.switchTo().defaultContent();
			WebElement frame = driver.findElement(By.xpath(frameName));
			driver.switchTo().frame(frame);
			driver.findElement(By.id(strHTMLID)).clear();
			driver.findElement(By.id(strHTMLID)).sendKeys(strString);
			driver.switchTo().defaultContent();
		} 
		catch (Exception e)
		{
			Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
			failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			e.printStackTrace();
			throw e;
		}
	}
	/*	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}*/

	public void refreshWebPage()
	{
		try
		{
			driver.navigate().refresh();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	//wait for element to visible
	public boolean waitForElementToVisible(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return strElement.isDisplayed();
	}
	
	//Call this method when you want to highlight Element
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 

	}

	//capture screenshots
	public static void CaptureScreenshot(String fileNameStart) throws Exception{
		String path = null;
		try {
			System.out.println("Capturing Snapshot");
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Calendar currentDate = Calendar.getInstance();
			java.io.File currentDir = new java.io.File("");		        
			String workingDirectory = System.getProperty("user.dir");
			//get today's date without Time stamp
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date today = dateFormat.parse(dateFormat.format(new Date()));
			String todaysDate = dateFormat.format(today).replace("/", "_");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
			//Get Full Class name 
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			//Get Method name 
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			//Get Class short name 
			int firstChar = fullClassName.lastIndexOf('.') +1; 
			String className = fullClassName.substring(firstChar);
			String dateN = formatter.format(currentDate.getTime()).replace("/","_");
			String dateNow = dateN.replace(":","_");
			//			System.out.println("printing datenow---------"+dateNow);
			String strAppPath = currentDir.getAbsolutePath()+ "/testresult/screenshots"+"_"+methodName+"_"+todaysDate;
			//	String strAppPath = currentDir.getAbsolutePath();

			String fileName = fileNameStart+"."+className+"."+methodName+"."+dateNow+".jpeg"; 
			//			String fileName = dateNow+".png"; 
			String snapShotDirectory = strAppPath;
			//			System.out.println("Im here-------------"+snapShotDirectory);
			File f = new File(snapShotDirectory);
			//check for snapshot having folder with today date if not then create one
			if(f.exists()){
				System.out.println("SnapshotDirectory Already Exists");
			}
			else{
				f.mkdir();
			}		        
			path = f.getAbsolutePath() + "/" + fileName ;
			//			System.out.println("Path------------------"+path);
			FileUtils.copyFile(source, new File(path));
			//			Reporter.log("<img src=\"file:///" + path + "\" alt=\"testPic\" " + "height=\"600\" width=\"600\"" + " /><br />"); //working
			//		Reporter.log("<a href=" +path+ "/a>");
			//			Reporter.log("<img src=\"file:///" + path + "\" alt=\"\"/><br />"); // printing in report
			//		Reporter.log("<a href='" + path+ "'>heloo</a>");
			//	Reporter.log("<a href='" + f.getAbsolutePath() + "'>click to open screenshot</a>");  //Working
			//Reporter.log("<a href='" + path + "'><p align=\"left\">Error screenshot at " + new Date()+ "</p>"); //working
			//Reporter.log("<p><img width=\"1024\" src=\"" + path + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); //working

			//	Reporter.log("Path of the Snapshot : " + path);
			/*//		Reporter.log("<a href='" + screenshotFile.getAbsolutePath() + "'>screenshot</a>")
			Reporter.log("<a href='" + path + "' >  path  </a>");
			Reporter.log("<a href=" + path + "> </a>"); 
			Reporter.log("<a href='"+path+".png'> </a>");*/

		}
		catch(IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
			throw e;
		}
	}
	public void deleteFile(String ClearFile) 
	{
		String path=ClearFile; 
		File file = new File(path);
		File[] files = file.listFiles(); 
		for (File f:files) 
		{
			if (f.isFile() && f.exists()) 
			{ 
				f.delete();
				//system.out.println("successfully deleted");
			}
			else
			{
				//system.out.println("cant delete a file due to open or error");
			} 
		}  
	}
	static public void getUploadImage(String Image_Xpath) throws Exception
	{
		getWaitPageLoad();
		//input[@id='UploadbinaryListImage']
		clickIdentifierXpath(Image_Xpath);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		String  childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		
		try
		{
		getWaitForElementPresent("//div[@id='fileExplorer']/div[2]/div[2]/div[1]/label",200);
		clickIdentifierXpath("//div[@id='fileExplorer']/div[2]/div[2]/div[1]/label");
		}
		catch(TimeoutException e)
		{
		e.printStackTrace();
		clickIdentifierXpath("//label[text()='Upload Files']");
		Set<String> Subhandles = driver.getWindowHandles();
		Iterator<String> Subiterator = Subhandles.iterator();
		String  SubchildWindow = Subiterator.next();
		driver.switchTo().window(SubchildWindow);
		String workingDirectory = System.getProperty("user.dir");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys(workingDirectory+"\\resource\\images\\Hydrangeas.jpg");
		//typeTextByXpath("//input[@id='fileToUpload']","../CATAutomation/resource/images/bns999_p18.jpg");
		clickIdentifierXpath("//div[span[text()='Upload Multiple Files']]/button/span[1]");
		}
		getWaitForElementPresent("//button[span[text()='OK']]", 200);
		//getWaitForElementPresent("//div[@class='imageTitle col-md-12']", 300);
		getScrrolToWebElement("//button[span[text()='OK']]");
		//clickIdentifierXpath("//button[span[text()='OK']]");
		driver.findElement(By.xpath("//button[span[text()='OK']]")).click();
	}
	
	static public void getUploadVideo(String Image_Xpath) throws Exception
	{
		//input[@id='UploadbinaryListImage']
		clickIdentifierXpath(Image_Xpath);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		String  childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		
		try
		{
		getWaitForElementPresent("//div[@id='fileExplorer']/div[2]/div[2]/div[1]/label",300);
		clickIdentifierXpath("//div[@id='fileExplorer']/div[2]/div[2]/div[1]/label");
		}
		catch(TimeoutException e)
		{
		e.printStackTrace();
		clickIdentifierXpath("//label[text()='Upload Files']");
		Set<String> Subhandles = driver.getWindowHandles();
		Iterator<String> Subiterator = Subhandles.iterator();
		String  SubchildWindow = Subiterator.next();
		driver.switchTo().window(SubchildWindow);
		String workingDirectory = System.getProperty("user.dir");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys(workingDirectory+"\\resource\\video\\clipcanvas_14348_H264_640x360.mp4");
		//typeTextByXpath("//input[@id='fileToUpload']","../CATAutomation/resource/images/bns999_p18.jpg");
		
		clickIdentifierXpath("//div[span[text()='Upload Multiple Files']]/button/span[1]");
		}
		getWaitForElementPresent("//button[span[text()='OK']]", 200);
		//getWaitForElementPresent("//div[@class='imageTitle col-md-12']", 200);
		getScrrolToWebElement("//button[span[text()='OK']]");
		//clickIdentifierXpath("//button[span[text()='OK']]");
		driver.findElement(By.xpath("//button[span[text()='OK']]")).click();
	}
	
	
}