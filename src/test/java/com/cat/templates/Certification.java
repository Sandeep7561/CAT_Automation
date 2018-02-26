package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Certification extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4712", priority=0)
	public void runCertIntroPage() throws Exception {
		runCertIntro();
		logPASS("Cert Intro page(s) visited");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4712", priority=1)
	public void checkCertQuestionPage() throws Exception {
		runCertQuestionPage();
		logPASS("Cert Question page(s) completed");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=2)
	public void clickNextForTileMenu() throws Exception {
		if (!verifyElementPresent("DesktopTileMenu")) {
			logSKIP("Skipping test because TileMenu button was not available");
			throw new SkipException("Skipping test because DesktopTileMenu not available.");
		}
		logINFO("DesktopTileMenu: Present");
		clickElementText("NEXTEnable");
		Thread.sleep(2000);
		logPASS("Clicked Next on TileMenu page");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=3)
	public void clickViewYourCompletionCertificateButtonOnLinearCourse() throws Exception {
		if (!verifyElementPresent("ViewCompletedCertification")) {
			logSKIP("Skipping test because ViewCompletedCertification button was not available");
			throw new SkipException("Skipping test because ViewCompletedCertification was not available.");
		}
		checkViewCertOnResultsPage();
		logPASS("ViewCompletionCert page visited");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=4)
	public void clickTakeSurveyOnLinearCourse() throws Exception {
		if (!verifyElementPresent("TakeSurvey")) {
			logSKIP("Skipping test because TakeSurvey button was not available");
			throw new SkipException("Skipping test because TakeSurvey was not available.");
		}
		clickTakeSurveyButton();
		logPASS("TakeSurvey page visited");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=5)
	public void exitCourse() throws Exception {
		String Text = driver.findElement(objmap.getLocator("CertResultPage")).getText();
		if (Text.contains("An Error has Occurred")){
			TakeScreenshot("Fail-CertResultPageShowingErrorMessage");
			logFAILED("Cert result page showing error message");
		}
		if (verifyElementPresent("TileMenu")) {
			logSKIP("Skipping test because TileMenu page was available");
			throw new SkipException("Skipping test because TileMenu was available.");
		}
		clickElement("DesktopExit");
		Thread.sleep(1000);
		logPASS("Clicked Exit button for Linear Course");
	}



	/*@Test
	public void testCertification() throws Exception {
		//Certification Introduction Pages
		if (verifyElementPresent("CertIntroPage1"))
		{
			runCertIntroPages();
		}
		//Certification Question Pages
		else if (verifyElementPresent("EocCertQuestion1") || verifyElementPresent("EmbdCertQuestion1"))
		{
			runCertQuestionPages(); 
		}

		//Certification Result Page
		if (verifyElementPresent("CertificateResultPage"))
	  	{
		  	checkCertResultPage();
		}
	}*/
}