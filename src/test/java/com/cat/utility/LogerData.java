package com.cat.utility;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import com.relevantcodes.extentreports.LogStatus;


public class LogerData extends WebAppCommon {

	// Initialize Log4j logs 
	private static Logger Log = Logger.getLogger(LogerData.class.getName());// 
	//This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite 
	public static void startTestCase(String sTestCaseName)
	{    
		//Log.info("***********************************************************************"); 
		Log.info("$$$$$$$$$$$$$$$$$$$$$		"+sTestCaseName+ "		$$$$$$$$$$$$$$"); 
		//Log.info("************************************************************************"); 
		//logger.log(LogStatus.INFO, "***********************************************************************");
		//logger.log(LogStatus.INFO, "$$$$$$$$$$$$$$$$$$$$$		"+sTestCaseName+ "		$$$$$$$$$$$$$$");
		//logger.log(LogStatus.INFO, "***********************************************************************");
	
	}
	//This is to print log for the ending of the test case 
	public static void endTestCase(String sTestCaseName)
	{ 
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX    "+"-E---N---D-"+"   XXXXXXXXXX"); 
		Log.info("X"); 
		Log.info("X"); 
		logger.log(LogStatus.INFO, "XXXXXXXXXXXXXXXXXXXXXXX    "+"-E---N---D-"+"   XXXXXXXXXX");
		logger.log(LogStatus.INFO, "X");
		logger.log(LogStatus.INFO, "X");
	}
	// Need to create these methods, so that they can be called  
	public static void info(String message) 
	{ 
		Log.info(message);
		logger.log(LogStatus.INFO, message);
		
	}
	public static void warn(String errorMessage,String image) throws IOException, AWTException 
	{
		Log.warn(errorMessage);
		String PathOFImage =getErrorMessage(errorMessage,image);
		logger.log(LogStatus.WARNING,errorMessage,PathOFImage);
	}
	public static void error(String errorMessage,String image) throws IOException, AWTException 
	{ 
		Log.error(errorMessage,null);
		//logger.log(LogStatus.ERROR, message);
		String PathOFImage =getErrorMessage(errorMessage,image);
		logger.log(LogStatus.ERROR,errorMessage,PathOFImage);
	}
	public static void fatal(String errorMessage,String image) throws IOException, AWTException 
	{ 
		Log.fatal(errorMessage,null);
		//logger.log(LogStatus.FATAL, message);
		String PathOFImage =getErrorMessage(errorMessage,image);
		logger.log(LogStatus.FATAL,errorMessage,PathOFImage);
	}
	public static void debug(String message) 
	{ 
		Log.debug(message);
	} 

	public static void fail(String errorMessage,String image) throws IOException, AWTException
	{
		//logger.log(LogStatus.FAIL, errorMessage);
		
		String PathOFImage =getErrorMessage(errorMessage,image);
		logger.log(LogStatus.FAIL,errorMessage,PathOFImage);
	}
	
	public static void failWithCompare(String message,String input,String exceptedValue,String actualValue) throws IOException, AWTException
	{
		//ATUReports.add(message,input,exceptedValue, actualValue, LogAs.FAILED,  null);
		fail(message,null);
		
	}
	
	public static void skip(String errorMessage,String image) throws IOException, AWTException
	{
		String PathOFImage =getErrorMessage(errorMessage,image);
		logger.log(LogStatus.SKIP,errorMessage,PathOFImage);
		 //logger.log(LogStatus.SKIP, "Test skipped " + image);
	}
	
	public static void pass(String message)
	{
		logger.log(LogStatus.PASS, message);
		
	}
	public static void passWithCompare(String message,String input,String exceptedValue,String actualValue)
	{
		
		pass(message);
	}
}
