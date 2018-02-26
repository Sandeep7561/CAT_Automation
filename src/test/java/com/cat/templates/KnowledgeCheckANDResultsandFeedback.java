package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class KnowledgeCheckANDResultsandFeedback extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Correct", "Sanity", "NextOnly" }, testName="FLDXTWO-4710", priority=0)
	public void runKnowledgeCheckWithCorrectSelections() throws Exception {
		runQuizWithCorrectSelections();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Incorrect" }, testName="FLDXTWO-4710", priority=1)
	public void runKnowledgeCheckWithIncorrectSelections() throws Exception {
		runQuizWithIncorrectSelections();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Incorrect" }, dependsOnMethods = { "runKnowledgeCheckWithIncorrectSelections" }, testName="FLDXTWO-4710", priority=2)
	public void checkExitAlertBox() throws Exception {
		if (!verifyElementPresent("RetakeKnowledgeCheck")) {
			logSKIP("Skipping test because RetakeKnowledgeCheck was not available");
			throw new SkipException("Skipping test because RetakeKnowledgeCheck was not available.");
		}
		clickElement("DesktopExit");
		Thread.sleep(1000);
		TakeScreenshot("Pass");
		clickElementText("AlertBoxButton2");
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Incorrect" }, dependsOnMethods = { "runKnowledgeCheckWithIncorrectSelections" }, testName="FLDXTWO-4710", priority=3)
	public void clickRetakeKnowledgeCheck() throws Exception {
		if (!verifyElementPresent("RetakeKnowledgeCheck")) {
			logSKIP("Skipping test because RetakeKnowledgeCheck was not available");
			throw new SkipException("Skipping test because RetakeKnowledgeCheck was not available.");
		}
		clickElement("RetakeKnowledgeCheck");
		checkVisibilityOfElement(100, "AlertBoxButton1");
		clickElement("AlertBoxButton1");
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Incorrect" }, dependsOnMethods = { "clickRetakeKnowledgeCheck" }, testName="FLDXTWO-4710", priority=4)
	public void retakeKnowledgeCheckWithCorrectSelections() throws Exception {
		runQuizWithCorrectSelections();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4705", priority=5)
	public void checkNextDisableOnLinearCoursePage() throws Exception {
		if (!verifyElementPresent("NEXTDisable")) {
			logSKIP("Skipping test because NEXTDisable was available");
			throw new SkipException("Skipping test because NEXTDisable was available.");
		}
		logPASS("NEXTDisable : Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=6)
	public void clickNextForTileMenu() throws Exception {
		if (!verifyElementPresent("DesktopTileMenu")) {
			logSKIP("Skipping test because DesktopTileMenu not available");
			throw new SkipException("Skipping test because DesktopTileMenu not available.");
		}
		logINFO("DesktopTileMenu: Present");
		clickElementText("NEXTEnable");
		Thread.sleep(2000);
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, dependsOnMethods = { "checkNextDisableOnLinearCoursePage" }, testName="FLDXTWO-4705", priority=7)
	public void clickViewYourCompletionCertificateButtonOnLinearCourse() throws Exception {
		if (!verifyElementPresent("ViewYourCompletionCertificate")) {
			logSKIP("Skipping test because ViewYourCompletionCertificate was not available");
			throw new SkipException("Skipping test because ViewYourCompletionCertificate was not available.");
		}
		checkViewCertOnResultsPage();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, dependsOnMethods = { "checkNextDisableOnLinearCoursePage" }, testName="FLDXTWO-4705", priority=8)
	public void clickTakeSurveyOnLinearCourse() throws Exception {
		if (!verifyElementPresent("TakeSurvey")) {
			logSKIP("Skipping test because TakeSurvey was not available");
			throw new SkipException("Skipping test because TakeSurvey was not available.");
		}
		clickTakeSurveyButton();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=9)
	public void exitCourse() throws Exception {
		if (verifyElementPresent("TileMenu")) {
			logSKIP("Skipping test because TileMenu was available");
			throw new SkipException("Skipping test because TileMenu was available.");
		}
		if (verifyElementPresent("ContinuetoCertification")) {
			logSKIP("Skipping test because ContinuetoCertification was available");
			throw new SkipException("Skipping test because ContinuetoCertification was available.");
		}
		String Text = driver.findElement(objmap.getLocator("QuizResultPage")).getText();
		if (Text.contains("An Error has Occurred")){
			TakeScreenshot("Fail-CertResultPageShowingErrorMessage");
			logFAILED("Cert result page showing error message");
		}
		clickElement("DesktopExit");
		Thread.sleep(1000);
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=10)
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
	public void testKnowledgeCheckANDResultsandFeedback() throws Exception {
		//Knowledge Check - Questions
		if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
		{
			runQuiz();
		}

		//Knowledge Check - Results and Feedback
		else if (verifyElementPresent("SideBarBox"))
		{
			checkQuizFeedbackPage();
			checkQuizResultsPage();
		}
	}*/
}
