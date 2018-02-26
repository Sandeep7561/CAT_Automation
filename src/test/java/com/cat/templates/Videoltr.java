package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;
//import org.openqa.selenium.JavascriptExecutor;

public class Videoltr extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4715", priority=0)
	public void videoPage() throws Exception {
		//CourseLaunch With - Video-ON Mode
		if (verifyElementPresent("VideoModePage"))
		{
			//Video Mode
			runVideoModePage();
			logPASS("VideoMode Page Completed");
			//Text Mode
			if (verifyElementPresent("TextModePage"))
			{
				runVideoTextModePage();
				logPASS("VideoTextMode Page Completed");
			}
		}
		//CourseLaunch With - Video-OFF Mode
		else if (verifyElementPresent("TextModePage"))
		{
			//Text Mode
			runVideoTextModePage();
			logPASS("VideoTextMode Page Completed");
			if (verifyElementPresent("VideoModePage"))
			{
				//Video Mode
				runVideoModePage();
				logPASS("VideoMode Page Completed");
			}
		}
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=1)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}
	
	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=2)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=3)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testVideoltr() throws Exception {
		//InternetExplorer = runVideoMode() method dosen't support.
		String Browser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		//logINFO("" + Browser + "");
		if (Browser.contains("MSIE"))
		{
			//CourseLaunch With - Video ON Mode
			if (verifyElementPresent("VideoModePage"))
			{
				TakeScreenshot("Pass");
				if (verifyElementPresent("SwitchToText"))
				{
					clickElement("SwitchToText");
					Thread.sleep(2000);
				}
				if (verifyElementPresent("TextModePage"))
				{
					//Text Mode
					runVideoTextMode();
				}
			}
			//CourseLaunch With - Video OFF Mode
			else if (verifyElementPresent("TextModePage"))
			{
				//Text Mode
				runVideoTextMode();
				if (verifyElementPresent("VideoModePage"))
				{
					TakeScreenshot("Pass");
					if (verifyElementPresent("SwitchToText"))
					{
						clickElement("SwitchToText");
						Thread.sleep(2000);
					}	 	
				}
			}	
		} else
		{
			//CourseLaunch With - Video ON Mode
			if (verifyElementPresent("VideoModePage"))
			{
				//Video Mode
				runVideoMode();
				//Text Mode
				if (verifyElementPresent("TextModePage"))
				{
					runVideoTextMode();
				}
			}
			//CourseLaunch With - Video OFF Mode
			else if (verifyElementPresent("TextModePage"))
			{
				//Text Mode
				runVideoTextMode();
				if (verifyElementPresent("VideoModePage"))
				{
					//Video Mode
					runVideoMode(); 
				}
			}
		}
		{
			checkTextPresent("PageNumberIndicator");
			checkElementPresent("ProgressIndicator");
			clickNEXTwithTimer();
		}	
	}*/
}












/*  //CourseLaunch With - Video ON Mode	
if (verifyElementPresent("VideoModePage"))
	{
	  	// Video Mode
	  	if (browserName.equalsIgnoreCase("InternetExplorer"))
	  	{
	  		TakeScreenshot("Pass");
	  		if (verifyElementPresent("SwitchToText"))
	  		{
	  			clickElement("SwitchToText");
			}
	  	} else
	  	{
	  		runVideoMode();
	  	}
	  	//Text Mode
	  	if (verifyElementPresent("TextModePage"))
		{
	  		runVideoTextMode();
		}
	}
//CourseLaunch With - Video OFF Mode
else if (verifyElementPresent("TextModePage"))
	{
	  	//Text Mode
	  	runVideoTextMode();
	  	//Video Mode  	
		if (verifyElementPresent("VideoModePage"))
		{
			if (browserName.equalsIgnoreCase("InternetExplorer"))
		  	{
				TakeScreenshot("Pass");
				if (verifyElementPresent("SwitchToText"))
		  		{
		  			clickElement("SwitchToText");
				}
		  	} else
		  	{
		  		runVideoMode();
		  	}
		}
	}
	{
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}
}*/