package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;;

public class NoQuizEndPage extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4705", priority=0)
	public void clickViewYourCompletionCertificateButtonOnLinearCourse() throws Exception {
		if (!verifyElementPresent("ViewYourCompletionCertificate")) {
			logSKIP("Skipping test because ViewYourCompletionCertificate was not available");
			throw new SkipException("Skipping test because ViewYourCompletionCertificate was not available.");
		}
		checkViewCertOnResultsPage();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4705", priority=1)
	public void clickTakeSurveyOnLinearCourse() throws Exception {
		if (!verifyElementPresent("TakeSurvey")) {
			logSKIP("Skipping test because TakeSurvey was not available");
			throw new SkipException("Skipping test because TakeSurvey was not available.");
		}
		clickTakeSurveyButton();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=2)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=3)
	public void exitCourse() throws Exception {
		if (verifyElementPresent("TileMenu")) {
			logSKIP("Skipping test because TileMenu was available");
			throw new SkipException("Skipping test because TileMenu was available.");
		}
		if (verifyElementPresent("ContinuetoCertification")) {
			logSKIP("Skipping test because ContinuetoCertification was available");
			throw new SkipException("Skipping test because ContinuetoCertification was available.");
		}
		String Text = driver.findElement(objmap.getLocator("CertResultPage")).getText();
		if (Text.contains("An Error has Occurred")){
			TakeScreenshot("Fail-CertResultPageShowingErrorMessage");
			logFAILED("Cert result page showing error message");
		}
		clickElement("DesktopExit");
		Thread.sleep(1000);
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=4)
	public void clickContinueToCertification() throws Exception {
		if (!verifyElementPresent("ContinuetoCertification")) {
			logSKIP("Skipping test because ContinuetoCertification was not available");
			throw new SkipException("Skipping test because ContinuetoCertification was not available.");
		}
		clickElementText("ContinuetoCertification");
		Thread.sleep(2000);
		logPASS("PASS");
	}



	/*@Test
	public void testNoQuizEndPage() throws Exception {
		checkBACKDisable();
		checkNEXTDisable();
		TakeScreenshot("Pass");
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle2");
		checkTextPresent("MainContent1");
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		checkTextPresent("Course/Page-TimerIndicator");
		checkNoQuizResultsPage();
	}*/
}