package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class NewClickToRevealHotspotfsg extends GenericTemplateMethods {

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
		if (!verifyElementPresent("MainImage-NewCTRhotspot")) {
			logSKIP("Skipping test because MainImage was not available");
			throw new SkipException("Skipping test because MainImage was not available.");
		}
		verifyElementImagePresent("MainImage-NewCTRhotspot");
		logPASS("MainImage is Present");
	}

	@Test(groups = { "Regression", "Audio" }, testName="FLDXTWO-4713", priority=5)
	public void pageAudio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity", "ContentQA" }, testName="FLDXTWO-4713", priority=6)
	public void checkHotspot1() throws Exception {
		if (!verifyElementPresent("NewCTRhotspot1"))
		{
			logFAIL("Failed test because HotSpot#1 was not available." );
			assertFail();
		}
		logPASS("PASS");
	}	

	@Test(groups = { "Regression", "Sanity", "ContentQA" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkHotspot1" }, priority=7)
	public void clickHotspots() throws Exception {
		TakeScreenshot("Pass");
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("NewCTRhotspot"+ i +""))
			{
				clickElement("NewCTRhotspot"+ i +"");
				Thread.sleep(2000);
				TakeScreenshot("Pass");
				clickElement("NewCTRHotSpotRevealBoxClosebutton");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkHotspot1" }, priority=8)
	public void checkHotspotRevealBoxes() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("NewCTRhotspot"+ i +""))
			{
				clickElement("NewCTRhotspot"+ i +"");
				Thread.sleep(2000);
				verifyElementPresent("NewCTRHotSpotRevealBox");
				checkImagePresent("NewCTRHotSpotRevealBoxImage");
				checkTextPresent("NewCTRHotSpotRevealBoxContent");
				clickElement("NewCTRhotspot"+ i +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkHotspotRevealBoxes", "pageAudio" }, priority=9)
	public void checkHotspotRevealTextAudio() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("NewCTRhotspot"+ i +""))
			{
				clickElement("NewCTRhotspot"+ i +"");
				checkPageAudio();
				clickElement("NewCTRhotspot"+ i +"");
			} else
			{
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "checkHotspot1" }, priority=10)
	public void pageReset() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4713", dependsOnMethods = { "checkHotspot1" }, priority=11)
	public void checkHopspotImages() throws Exception {
		for (int i=1; i>=1; i++){
			if (verifyElementPresent("NewCTRhotspot"+ i +""))
			{
				verifyElementImagePresent("NewCTRHotSpot"+ i +"-Normal");
				//movetoElement("NewCTRhotspot"+ i +"");
				//verifyElementImagePresent("NewCTRhotspot"+ i +"-NormalHover"); //Not working
				clickElement("NewCTRhotspot"+ i +"");
				Thread.sleep(2000);
				movetoElement("NewCTRHotSpot"+ i +"-Close");
				Thread.sleep(2000);
				verifyElementImagePresent("NewCTRHotSpot"+ i +"-Close");
				//movetoElement("NewCTRhotspot"+ i +"");
				//verifyElementImagePresent("NewCTRhotspot"+ i +"-CloseHover"); //Not working
				clickElement("NewCTRHotSpot"+ i +"-Close");
				Thread.sleep(2000);
				//movetoElement("NewCTRhotspot"+ i +"");
				//Thread.sleep(2000);
				//verifyElementImagePresent("NewCTRhotspot"+ i +"-Selected"); //Not working
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
			logSKIP("Skipping test because Help was not available");
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
	public void testNewClickToRevealHotspotfsg() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle1");
		checkTextPresent("MainContent1");
		checkImagePresent("MainImage-NewCTRhotspot");
		//TakeScreenshot("Pass");
		checkPageAudio();
		runNewClickToRevealHotSpot();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}
