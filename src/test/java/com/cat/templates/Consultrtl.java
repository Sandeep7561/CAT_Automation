package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Consultrtl extends GenericTemplateMethods {

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

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", priority=5)
	public void checkConsultOptionImages() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("Consult"+ j +""))
			{
				verifyElementImagePresent("Option"+ j +"Image");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", priority=6)
	public void checkConsultOptionHeadingTitles() throws Exception {
		if (!verifyElementPresent("Option1ImageTitle")) {
			logSKIP("Skipping test because Option1ImageTitle was not available");
			throw new SkipException("Skipping test because Option1ImageTitle was not available.");
		}
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("Consult"+ j +""))
			{
				verifyElementTextPresent("Option"+ j +"ImageTitle");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4713", priority=7)
	public void clickConsultOptions() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("Consult"+ j +""))
			{
				clickElement("Consult"+ j +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickConsultOptions" }, priority=8)
	public void checkConsultOptionRevealBoxes() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("Consult"+ j +""))
			{
				clickElement("Consult"+ j +"");
				verifyElementTextPresent("Option"+ j +"ImageRevealBox");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickConsultOptions" }, priority=9)
	public void checkConsultOptionVisitedTickMarkImages() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("Consult"+ j +""))
			{
				verifyElementImagePresent("Option"+ j +"ImageTickMark");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "clickConsultOptions" }, priority=10)
	public void PageReset() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickConsultOptions" }, priority=11)
	public void checkSaqQuestionText() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("Consult"+ j +""))
			{
				clickElement("Consult"+ j +"");
				if (verifyElementPresent("SaqQuestionText")) {
					if (verifyElementPresent("Consult"+ (j+1) +"")){
						logFAIL("FAIL");
						assertFail();
					} else {
						verifyElementTextPresent("SaqQuestionText");
					}
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", dependsOnMethods = { "checkSaqQuestionText" }, priority=12)
	public void saqQuestionAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because SaqQuestionTextAudio was not available");
			throw new SkipException("Skipping test because SaqQuestionTextAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4711", dependsOnMethods = { "clickConsultOptions" }, priority=13)
	public void selectConsultSaqCorrectoptions() throws Exception {
		clickConsultSaqCorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "selectConsultSaqCorrectoptions" }, priority=14)
	public void selectConsultSaqCorrectSubmit() throws Exception {
		clickConsultSaqCorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectConsultSaqCorrectSubmit" }, priority=15)
	public void FeedbakBoxCorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}	
		checkFeedbakBoxCorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", dependsOnMethods = { "selectConsultSaqCorrectSubmit" }, priority=16)
	public void correctFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectConsultSaqCorrectSubmit" }, priority=17)
	public void checkCorrectSelectedOptions() throws Exception {
		checkCorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectConsultSaqCorrectSubmit" }, priority=18)
	public void checkCorrectIconOnSelectedOptions() throws Exception {
		checkCorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "clickConsultOptions" }, priority=19)
	public void PageReset2() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "clickConsultOptions" }, priority=20)
	public void selectConsultSaqIncorrectoptions() throws Exception {
		clickConsultOptions();
		clickConsultSaqIncorrectOptions();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "selectConsultSaqIncorrectoptions" }, priority=21)
	public void selectConsultSaqIncorrectSubmit() throws Exception {
		clickConsultSaqIncorrectSubmit();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4717", dependsOnMethods = { "selectConsultSaqIncorrectSubmit" }, priority=22)
	public void consultSaqIncorrectAlertBox() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox")) {
			logSKIP("Skipping test because ConsultSaqIncorrectAlertBox was not available");
			throw new SkipException("Skipping test because ConsultSaqIncorrectAlertBox was not available.");
		}
		checkConsultSaqIncorrectAlertBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectConsultSaqIncorrectSubmit" }, priority=23)
	public void FeedbakBoxIncorrectTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxTitle")) {
			logSKIP("Skipping test because FeedbackBoxTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxTitle was not available.");
		}	
		checkFeedbakBoxIncorrectTitle("FeedbackBoxTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4714", dependsOnMethods = { "selectConsultSaqIncorrectSubmit" }, priority=24)
	public void incorrectFeedbackBox() throws Exception {
		checkSaqFeedbackBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectConsultSaqIncorrectSubmit" }, priority=25)
	public void checkIncorrectSelectedOptions() throws Exception {
		checkIncorrectSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "selectConsultSaqIncorrectSubmit" }, priority=26)
	public void checkIncorrectIconOnSelectedOptions() throws Exception {
		checkIncorrectIconOnSelectedOption();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=27)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=28)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=29)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=30)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=31)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testConsultrtl() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle");
		checkTextPresent("MainContent1");
		checkPageAudio();
		runConsult();
		checkPageAudio();
		runConsultSaq();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}