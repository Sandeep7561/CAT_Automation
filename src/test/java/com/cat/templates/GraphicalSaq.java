package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class GraphicalSaq extends GenericTemplateMethods {

	@Test(testName="FLDXTWO-4708", priority=0)
	public void NEXTDisable() throws Exception {
		checkNEXTDisable();
		logPASS("NEXT is Disable");
	}

	@Test(testName="FLDXTWO-4709", priority=1)
	public void LessonTitle() throws Exception {
		verifyElementTextPresent("DesktopLessonTitle");
		logPASS("LessonTitle is Present");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", priority=2)
	public void TopicTitle() throws Exception {
		if (!verifyElementPresent("TopicTitle4")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle4");
		logPASS("TopicTitle is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4700", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", priority=4)
	public void Audio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", priority=5)
	public void checkGraphicalSaqOptionsImage() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqOption1Image")) {
			logSKIP("Skipping test because Image of Option#1 was not available");
			throw new SkipException("Skipping test because Image of Option#1 was not available.");
		}
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +"")){
				verifyElementImagePresent("runSaqORGraphicalSaqOption"+ j +"Image");
			} else{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4713", priority=6)
	public void selectGraphicalSaqCorrectOptions() throws Exception {
		clickGraphicalSaqCorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqCorrectOptions" }, priority=7)
	public void selectGraphicalSaqCorrectSubmit() throws Exception {
		clickGraphicalSaqCorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqCorrectSubmit" }, priority=8)
	public void FeedbakBoxCorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}	
		checkFeedbakBoxCorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqCorrectSubmit" }, priority=9)
	public void correctFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqCorrectSubmit" }, priority=10)
	public void checkCorrectSelectedOptions() throws Exception {
		checkCorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqCorrectSubmit" }, priority=11)
	public void checkCorrectIconOnSelectedOptions() throws Exception {
		checkCorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "selectGraphicalSaqCorrectoptions" }, priority=12)
	public void PageReset() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", priority=13)
	public void selectGraphicalSaqIncorrectoptions() throws Exception {
		clickGraphicalSaqIncorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", dependsOnMethods = { "selectGraphicalSaqIncorrectoptions" }, priority=14)
	public void selectGraphicalSaqIncorrectSubmit() throws Exception {
		clickGraphicalSaqIncorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", dependsOnMethods = { "selectGraphicalSaqIncorrectSubmit" }, priority=15)
	public void graphicalsaqIncorrectAlertBox() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox")) {
			logSKIP("Skipping test because SaqIncorrectAlertBox was not available");
			throw new SkipException("Skipping test because SaqIncorrectAlertBox was not available.");
		}
		checkGraphicalSaqIncorrectAlertBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqIncorrectSubmit" }, priority=16)
	public void FeedbakBoxIncorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}
		checkFeedbakBoxIncorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqIncorrectSubmit" }, priority=17)
	public void incorrectFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqIncorrectSubmit" }, priority=18)
	public void checkIncorrectSelectedOptions() throws Exception {
		checkIncorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectGraphicalSaqIncorrectSubmit" }, priority=19)
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

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", dependsOnMethods = { "selectGraphicalSaqCorrectSubmit" }, priority=24)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testGraphicalSaq() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle4");
		checkTextPresent("MainContent1");
		checkPageAudio();
		runGraphicalSaq();
		checkSelectedOption();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}