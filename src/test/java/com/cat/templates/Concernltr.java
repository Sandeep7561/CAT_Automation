package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Concernltr extends GenericTemplateMethods {

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
		if (!verifyElementPresent("TopicTitle")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle");
		logPASS("TopicTitle is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4708", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", priority=4)
	public void pageAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4706", priority=5)
	public void concernMeterBoxHeadingTitle() throws Exception {
		if (!verifyElementPresent("MeterLevelTitle")) {
			logSKIP("Skipping test because MeterboxHeadingTitle was not available");
			throw new SkipException("Skipping test because MeterboxHeadingTitle was not available.");
		}
		verifyElementTextPresent("MeterLevelTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", priority=6)
	public void concernMeterLevelText() throws Exception {
		for (int k=1; k>=1; k++){
			if (verifyElementPresent("MeterLevel"+ k +""))
			{
				verifyElementTextPresent("MeterLevel"+ k +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4713", priority=7)
	public void dragConcernMeter() throws Exception {
		dragSlider("MeterDragPointer", 0, -50);
		TakeScreenshot("Pass");
		dragSlider("MeterDragPointer", 0, -80);
		TakeScreenshot("Pass");
		dragSlider("MeterDragPointer", 0, -120);
		TakeScreenshot("Pass");
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4713", dependsOnMethods = { "dragConcernMeter" }, priority=8)
	public void submitConcernMeterChoice() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "submitConcernMeterChoice" }, priority=9)
	public void checkTickorCross() throws Exception {
		for (int k=1; k>=1; k++){
			if (verifyElementPresent("MeterLevel"+ k +""))
			{
				if (verifyElementPresent("MeterLevel"+ k +"-TickorCrossIcon")){
					logINFO("Tick/Cross Icon : Present");
					break;
				}
			} else {
				if (!verifyElementPresent("MeterLevel"+ k +"-TickorCrossIcon")){
					logFAIL("Tick/Cross Icon : Not-Present");
					assertFail();
				}
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4708", dependsOnMethods = { "submitConcernMeterChoice" }, priority=10)
	public void concernSaqQuestionText() throws Exception {
		verifyElementTextPresent("ConcernSaqQuestionText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", priority=11)
	public void concernSaqQuestionTextAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because ConcernSaqQuestionTextAudio was not available");
			throw new SkipException("Skipping test because ConcernSaqQuestionTextAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4711",dependsOnMethods = { "submitConcernMeterChoice" }, priority=12)
	public void selectSaqCorrectoptions() throws Exception {
		clickSaqCorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "selectSaqCorrectoptions" }, priority=13)
	public void selectSaqCorrectSubmit() throws Exception {
		clickSaqCorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=14)
	public void FeedbakBoxCorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}	
		checkFeedbakBoxCorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=15)
	public void correctFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=16)
	public void checkCorrectSelectedOptions() throws Exception {
		checkCorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=17)
	public void checkCorrectIconOnSelectedOptions() throws Exception {
		checkCorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "selectSaqCorrectoptions" }, priority=18)
	public void pageReset() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4715", dependsOnMethods = { "selectSaqCorrectoptions" }, priority=19)
	public void selectSaqIncorrectoptions() throws Exception {
		dragConcernMeter();
		submitConcernMeterChoice();
		clickSaqIncorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", dependsOnMethods = { "selectSaqIncorrectoptions" }, priority=20)
	public void selectSaqIncorrectSubmit() throws Exception {
		clickSaqIncorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4717", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=21)
	public void saqIncorrectAlertBox() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox")) {
			logSKIP("Skipping test because SaqIncorrectAlertBox was not available");
			throw new SkipException("Skipping test because SaqIncorrectAlertBox was not available.");
		}
		checkSaqIncorrectAlertBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=22)
	public void FeedbakBoxIncorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}
		checkFeedbakBoxIncorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=23)
	public void incorrectFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=24)
	public void checkIncorrectSelectedOptions() throws Exception {
		checkIncorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectSaqIncorrectSubmit" }, priority=25)
	public void checkIncorrectIconOnSelectedOptions() throws Exception {
		checkIncorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=26)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=27)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=28)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=29)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", dependsOnMethods = { "selectSaqCorrectSubmit" }, priority=30)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testConcernltr() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle");
		checkTextPresent("MainContent2");
		checkPageAudio();
		runConcern();
		checkPageAudio();
		runSaq();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}