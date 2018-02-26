package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Saqltr extends GenericTemplateMethods {

	@Test(testName="FLDXTWO-4700", priority=0)
	public void NEXTDisable() throws Exception {
		checkNEXTDisable();
		logPASS("NEXT is Disable");
	}

	@Test(testName="FLDXTWO-4705", priority=1)
	public void LessonTitle() throws Exception {
		verifyElementTextPresent("DesktopLessonTitle");
		logPASS("LessonTitle is Present");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4706", priority=2)
	public void TopicTitle() throws Exception {
		if (!verifyElementPresent("TopicTitle1")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle1");
		logPASS("TopicTitle is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4708", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", priority=4)
	public void MainImage() throws Exception {
		if (!verifyElementPresent("MainImage-ltr")) {
			logSKIP("Skipping test because MainImage was not available");
			throw new SkipException("Skipping test because MainImage-ltr was not available.");
		}	
		verifyElementImagePresent("MainImage-ltr");
		logPASS("MainImage is Present");
	}	

	@Test(groups = { "Regression", }, testName="FLDXTWO-4710", priority=5)
	public void Audio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4711", priority=6)
	public void selectSaqCorrectOptions() throws Exception {
		clickSaqCorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "selectSaqCorrectOptions" }, priority=7)
	public void selectSaqCorrectSubmit() throws Exception {
		clickSaqCorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=8)
	public void FeedbakBoxCorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}	
		checkFeedbakBoxCorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=9)
	public void correctFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=10)
	public void checkCorrectSelectedOptions() throws Exception {
		checkCorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=11)
	public void checkCorrectIconOnSelectedOptions() throws Exception {
		checkCorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "selectSaqCorrectOptions" }, priority=12)
	public void PageReset() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4715", dependsOnMethods = { "selectSaqCorrectOptions" }, priority=13)
	public void selectSaqIncorrectoptions() throws Exception {
		clickSaqIncorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", dependsOnMethods = { "selectSaqIncorrectoptions" }, priority=14)
	public void selectSaqIncorrectSubmit() throws Exception {
		clickSaqIncorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4717", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=15)
	public void saqIncorrectAlertBox() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox")) {
			logSKIP("Skipping test because SaqIncorrectAlertBox was not available");
			throw new SkipException("Skipping test because SaqIncorrectAlertBox was not available.");
		}
		checkSaqIncorrectAlertBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=16)
	public void FeedbakBoxIncorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}
		checkFeedbakBoxIncorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=17)
	public void incorrectFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=18)
	public void checkIncorrectSelectedOptions() throws Exception {
		checkIncorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=19)
	public void checkIncorrectIconOnSelectedOptions() throws Exception {
		checkIncorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=20)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=21)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=22)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=23)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=24)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testSaqltr() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle1");
		checkTextPresent("MainContent1");
		checkImagePresent("MainImage-ltr");
		checkPageAudio();
		TakeScreenshot("Pass");
		runSaq();
		checkSelectedOption();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}