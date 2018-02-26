package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class ClickToRevealSelectableImagebtt extends GenericTemplateMethods {

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

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", priority=4)
	public void MainImage() throws Exception {
		if (!verifyElementPresent("MainImage-ctrSelectabelImage")) {
			logSKIP("Skipping test because MainImage was not available");
			throw new SkipException("Skipping test because MainImage was not available.");
		}
		verifyElementImagePresent("MainImage-ctrSelectabelImage");
		logPASS("MainImage is Present");
	}

	@Test(groups = { "Regression", "Audio" }, testName="FLDXTWO-4713", priority=5)
	public void pageAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because Audio button was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity", "ContentQA" }, testName="FLDXTWO-4713", priority=6)
	public void checkSelectableImage1() throws Exception {
		if (!verifyElementPresent("ctrSi1"))
		{
			logFAIL("Failed test because SelectableImage#1 was not available." );
			assertFail();
		}
		logPASS("PASS");
	}	

	@Test(groups = { "Regression", "Sanity", "ContentQA" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkSelectableImage1" }, priority=7)
	public void clickSelectableImages() throws Exception {
		TakeScreenshot("Pass");
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("ctrSi"+ i +""))
			{
				clickElement("ctrSi"+ i +"");
				TakeScreenshot("Pass");
				closeCTRHotSpotRevealBox();
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickSelectableImages" }, priority=8)
	public void checkSelectableImageRevealBoxes() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("ctrSi"+ i +""))
			{
				clickElement("ctrSi"+ i +"");
				verifyElementTextPresent("HotSpotRevealBox");
				closeCTRHotSpotRevealBox();
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkSelectableImageRevealBoxes", "pageAudio" }, priority=9)
	public void checkHotspotRevealTextAudio() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("ctrSi"+ i +""))
			{
				clickElement("ctrSi"+ i +"");
				checkPageAudio();
				closeCTRHotSpotRevealBox();
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "clickSelectableImages" }, priority=10)
	public void pageReset() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "clickSelectableImages" }, priority=11)
	public void checkSelectableImages() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("ctrSi"+ i +""))
			{
				verifyElementImagePresent("Si"+ i +"-Normal");
				movetoElement("ctrSi"+ i +"");
				verifyElementImagePresent("Si"+ i +"-Hover");
				clickElement("ctrSi"+ i +"");
				closeCTRHotSpotRevealBox();
				verifyElementImagePresent("Si"+ i +"-Selected");
				movetoElement("ctrSi"+ i +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4715", priority=12)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Help" }, testName="FLDXTWO-4716", priority=13)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help button was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=14)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=15)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4705", priority=16)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testClickToRevealSelectableImagebtt() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle1");
		checkTextPresent("MainContent1");
		checkImagePresent("MainImage-ctrSelectabelImage");
		TakeScreenshot("Pass");
		checkPageAudio();
		runClickToRevealSelectableImage();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}