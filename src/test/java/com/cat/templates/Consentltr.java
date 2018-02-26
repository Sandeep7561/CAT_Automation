package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Consentltr extends GenericTemplateMethods {
	
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
		if (!verifyElementPresent("TopicTitle1")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle1");
		logPASS("TopicTitle is Present");
	}
		
	@Test(groups = { "Regression" }, testName="FLDXTWO-4700", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
	}
	
	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=4)
	public void MainImage() throws Exception {
		if (!verifyElementPresent("MainImage-ltr")) {
			logSKIP("Skipping test because MainImage was not available");
			throw new SkipException("Skipping test because MainImage-ltr was not available.");
		}	
		verifyElementImagePresent("MainImage-ltr");
		logPASS("MainImage is Present");
	}
	
	@Test(groups = { "Regression", "Audio" }, testName="FLDXTWO-4712", priority=5)
	public void pageAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}
	
	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4712", priority=6)
	public void selectSingleOption() throws Exception {
		TakeScreenshot("Pass");
		if (verifyElementPresent("OptionAlreadySelected"))
		{
			verifyElementTextPresent("OptionAlreadySelected");
		} else
		{
			checkNEXTDisable();
			clickElementText("OptionUnselected");
		}
		TakeScreenshot("Pass");
		logPASS("PASS");
	}
		
	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4715", priority=7)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}
		
	@Test(groups = { "Regression", "Help" }, testName="FLDXTWO-4716", priority=8)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}
		
	@Test(testName="FLDXTWO-4717", priority=9)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}
		
	@Test(testName="FLDXTWO-4706", priority=10)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}
		
	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4705", priority=11)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}
	
	
	
	/*@Test
	public void testConsentltr() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle1");
		checkTextPresent("MainContent1");
		checkImagePresent("MainImage-ltr");
		checkPageAudio();
		if (verifyElementPresent("OptionAlreadySelected"))
		{
			verifyElementTextPresent("OptionAlreadySelected");
		} else
		{
			clickElementText("OptionUnselected");
		}
		TakeScreenshot("Pass");
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}