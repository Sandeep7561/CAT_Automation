package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class BinaryListltr extends GenericTemplateMethods {

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

	@Test(groups = { "Regression", "Audio" }, testName="FLDXTWO-4710", priority=4)
	public void Audio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because Audio button was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", priority=5)
	public void binaryOptionColumnHeadingTitle() throws Exception {
		verifyElementTextPresent("1stColumnTitle");
		verifyElementTextPresent("2ndColumnTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", priority=6)
	public void binaryImageMask() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				if (verifyElementPresent("Mask" + i + ""))
				{
					logINFO("Mask" + i + " : Present");  
				} else
				{
					TakeScreenshot("Fail-Mask" + i + "NotPresent");
					logFAIL("Mask" + i + " : Not-Present (error)");
					assertFail();
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", priority=7)
	public void checkBinaryOptionText() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				verifyElementTextPresent("BinaryOption" + i + "");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "ContentQA" }, testName="FLDXTWO-4709", priority=8)
	public void selectCorrectBinaryOptions() throws Exception {
		TakeScreenshot("Pass");
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				clickElement("1stColumnRadioButton" + i + "");
				if (verifyElementPresent("IncorrectIcon" + i + ""))
				{
					clickElement("2ndColumnRadioButton" + i + "");
				}
				TakeScreenshot("Pass");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", dependsOnMethods = { "selectCorrectBinaryOptions" }, priority=9)
	public void checkCorrectIcons() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				verifyElementImagePresent("CorrectIcon" + i + "");
				if (verifyElementPresent("IncorrectIcon" + i + ""))
				{
					TakeScreenshot("Fail-IncorrectIcon" + i + "NotPresent");
					logFAIL("IncorrectIcon" + i + " : Not-Present (error)");
					assertFail();
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", dependsOnMethods = { "selectCorrectBinaryOptions" }, priority=10)
	public void binaryImageMaskDisappear() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				if (!verifyElementPresent("Mask" + i + ""))
				{
					logINFO("Mask" + i + "Invisible : Present");  
				} else
				{
					TakeScreenshot("Fail-Mask" + i + "InvisibleNotPresent");
					logFAIL("Mask" + i + "Invisible : Not-Present (error)");
					assertFail();
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", dependsOnMethods = { "selectCorrectBinaryOptions" }, priority=11)
	public void checkUnmaskedImage() throws Exception {
		verifyElementImagePresent("ImageBehindMask");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", dependsOnMethods = { "selectCorrectBinaryOptions" }, priority=12)
	public void selectIncorrectBinaryOptions() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				clickElement("1stColumnRadioButton" + i + "");
				if (verifyElementPresent("CorrectIcon" + i + ""))
				{
					clickElement("2ndColumnRadioButton" + i + "");
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", dependsOnMethods = { "selectIncorrectBinaryOptions" }, priority=13)
	public void binaryImageMaskReappears() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				if (verifyElementPresent("Mask" + i + ""))
				{
					logINFO("Mask" + i + " : Present");  
				} else
				{
					TakeScreenshot("Mask" + i + " : Not-Present (error)");
					logFAIL("FAIL");
					assertFail();
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4709", dependsOnMethods = { "selectIncorrectBinaryOptions" }, priority=14)
	public void checkIncorrectIcons() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("BinaryOption" + i + ""))
			{
				verifyElementImagePresent("IncorrectIcon" + i + "");
				if (verifyElementPresent("CorrectIcon" + i + ""))
				{
					TakeScreenshot("Fail-CorrectIcon" + i + "NotPresent");
					logFAIL("CorrectIcon" + i + " : Not-Present (error)");
					assertFail();
				}
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4715", priority=15)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Help" }, testName="FLDXTWO-4716", priority=16)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help button was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=17)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=18)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4705", priority=19)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testBinaryListltr() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle");
		checkTextPresent("MainContent1");
		checkPageAudio();
		runBinaryList();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}
