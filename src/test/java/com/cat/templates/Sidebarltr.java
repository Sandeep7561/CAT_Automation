package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Sidebarltr extends GenericTemplateMethods {

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
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
	}

	@Test(groups = { "Regression", "DidYouKnow" }, testName="FLDXTWO-4711", priority=4)
	public void SideBarTitle() throws Exception {
		if (!verifyElementPresent("SideBarTitle")) {
			logSKIP("Skipping test because SideBarTitle was not available");
			throw new SkipException("Skipping test because SideBarTitle was not available.");
		}	
		verifyElementTextPresent("SideBarTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=5)
	public void SideBarImage() throws Exception {
		if (!verifyElementPresent("SideBarImage")) {
			logSKIP("Skipping test because SideBarImage was not available");
			throw new SkipException("Skipping test because SideBarImage was not available.");
		}	
		verifyElementImagePresent("SideBarImage");
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "FAQTopTen" }, testName="FLDXTWO-4711", priority=6)
	public void SideBarSubTitle() throws Exception {
		if (!verifyElementPresent("SideBarSubTitle")) {
			logSKIP("Skipping test because SideBarSubTitle was not available");
			throw new SkipException("Skipping test because SideBarSubTitle was not available.");
		}	
		verifyElementTextPresent("SideBarSubTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4711", priority=7)
	public void SideBarText() throws Exception {
		verifyElementTextPresent("SideBarText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "FAQTopTen" }, testName="FLDXTWO-4711", priority=8)
	public void SideBarSeeMoreHyperlink() throws Exception {
		if (!verifyElementPresent("SideBarSeeMoreHyperlink")) {
			logSKIP("Skipping test because SideBarSeeMoreHyperlink was not available");
			throw new SkipException("Skipping test because SideBarSeeMoreHyperlink was not available.");
		}	
		runSideBarSeeMoreHyperlink();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", priority=9)
	public void Audio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=10)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=11)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=12)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=13)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=14)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testSidebarltr() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle2");
		checkTextPresent("MainContent1");
		verifyElementPresent("SideBarBox");
		checkImagePresent("SideBarImage");
		checkTextPresent("SideBarSubTitle");
		verifyElementTextPresent("SideBarText");
		runSideBarSeeMoreHyperlink();
		checkPageAudio();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}