package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class LandingPageltr extends GenericTemplateMethods {

	@Test(groups = { "Regression" }, testName="FLDXTWO-4708", priority=0)
	public void LandingPageCourseTitle() throws Exception {
		verifyElementTextPresent("LandingPageCourseTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", priority=1)
	public void TimerIconImage() throws Exception {
		verifyElementImagePresent("TimerIconImage");
		logPASS("PASS");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", priority=2)
	public void TotalTime() throws Exception {
		verifyElementTextPresent("TotalTime");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=3)
	public void MobileIconImage() throws Exception {
		if (!verifyElementPresent("MobileIconImage")) {
			logSKIP("Skipping test because MobileIconImage was not available");
			throw new SkipException("Skipping test because MobileIconImage was not available.");
		}	
		verifyElementImagePresent("MobileIconImage");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=4)
	public void TabletIconImage() throws Exception {
		if (!verifyElementPresent("TabletIconImage")) {
			logSKIP("Skipping test because TabletIconImage was not available");
			throw new SkipException("Skipping test because TabletIconImage was not available.");
		}	
		verifyElementImagePresent("TabletIconImage");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=5)
	public void DesktopIconImage() throws Exception {
		if (!verifyElementPresent("DesktopIconImage")) {
			logSKIP("Skipping test because DesktopIconImage was not available");
			throw new SkipException("Skipping test because DesktopIconImage was not available.");
		}	
		verifyElementImagePresent("DesktopIconImage");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=6)
	public void MainImage() throws Exception {
		if (verifyElementPresent("LandingPageMainImage1")) {
			verifyElementImagePresent("LandingPageMainImage1");
		} else if (verifyElementPresent("LandingPageMainImage2")) {
			verifyElementImagePresent("LandingPageMainImage2");
		} else {
			logSKIP("Skipping test because LandingPageMainImage was not available");
			throw new SkipException("Skipping test because LandingPageMainImage was not available.");
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=7)
	public void CaptionText() throws Exception {
		if (!verifyElementPresent("LandingPageCaptionText")) {
			logSKIP("Skipping test because LandingPageCaptionText was not available");
			throw new SkipException("Skipping test because LandingPageCaptionText was not available.");
		}	
		verifyElementTextPresent("LandingPageCaptionText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=8)
	public void NextButtonImage() throws Exception {
		verifyElementImagePresent("LandingPageNextButton");
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4711", priority=9)
	public void NextButton() throws Exception {
		String PreviousPageURL = driver.getCurrentUrl();
		clickElement("LandingPageNextButton");
		Thread.sleep(2000);
		String CurrentPageURL = driver.getCurrentUrl();
		if (PreviousPageURL.equals(CurrentPageURL))
		{
			if (!verifyElementPresent("TileMenu"))
			{
				TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
				logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
				assertFail();
			}
		}
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testLandingPageltr() throws Exception {
		checkTextPresent("LandingPageCourseTitle");
		checkImagePresent("TimerIconImage");
		checkTextPresent("TotalTime");
		checkImagePresent("MobileIconImage");
		checkImagePresent("TabletIconImage");
		checkImagePresent("DesktopIconImage");
		checkImagePresent("LandingPageMainImage");
		checkImagePresent("LandingPageNextButton");
		TakeScreenshot("Pass");
		String PreviousPageURL = driver.getCurrentUrl();
		//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
		clickElement("LandingPageNextButton");
		Thread.sleep(2000);
		String CurrentPageURL = driver.getCurrentUrl();
		//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
		if (PreviousPageURL.equals(CurrentPageURL))
		{
			logINFO("PreviousPage-URL and CurrentPage-URL is Same (error)");
			TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
		}
		handleConnectionLostMessageBox();
	}*/
}
