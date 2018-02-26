package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class ClickToRevealBox extends GenericTemplateMethods {

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
		if (!verifyElementPresent("TopicTitle2")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle2");
		logPASS("TopicTitle is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4700", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent3");
		logPASS("MainContent is Present");
	}

	@Test(groups = { "Regression", "Audio" }, testName="FLDXTWO-4713", priority=4)
	public void pageAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because Audio button was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity", "ContentQA" }, testName="FLDXTWO-4713", priority=5)
	public void checkClickOption1() throws Exception {
		if (!verifyElementPresent("CTRImageOption1"))
		{
			logFAIL("Failed test because CTRImageOption1 was not available." );
			assertFail();
		}
		logPASS("PASS");
	}	

	@Test(groups = { "Regression", "ContentQA" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkClickOption1" }, priority=6)
	public void checkClickOptionImages() throws Exception {
		TakeScreenshot("Pass");
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("ImageOption"+ j +""))
			{
				verifyElementImagePresent("ImageOption"+ j +"");
				TakeScreenshot("Pass");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkClickOption1" }, priority=7)
	public void clickOptionImages() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("ImageOption"+ j +""))
			{
				clickElement("ImageOption"+ j +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickOptionImages" }, priority=8)
	public void checkClickOptionRevealBoxes() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("ImageOption"+ j +""))
			{
				clickElement("ImageOption"+ j +"");
				verifyElementTextPresent("RevealBox"+ j +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickOptionImages" }, priority=9)
	public void checkClickOptionVisitedTickMarkImages() throws Exception {
		for (int j=1; j>=1; j++){
			if (verifyElementPresent("ImageOption"+ j +""))
			{
				verifyElementImagePresent("TickMarkImageOption"+ j +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkClickOptionRevealBoxes", "pageAudio" }, priority=10)
	public void checkRevealTextAudio() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("NewCTRhotspot"+ i +""))
			{
				clickElement("NewCTRhotspot"+ i +"");
				checkPageAudio();
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4715", priority=11)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Help" }, testName="FLDXTWO-4716", priority=12)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help button was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=13)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=14)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4705", dependsOnMethods = { "checkClickOption1" }, priority=15)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testClickToRevealBox() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle2");
		checkTextPresent("MainContent3");
		checkPageAudio();
		TakeScreenshot("Pass");
		runClickToRevealBox();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}

