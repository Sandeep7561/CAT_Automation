package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class BranchingLesson extends GenericTemplateMethods {
	
	@Test(groups = { "Regression", "Sanity", "AllTopics", "ContentQA" }, testName="FLDXTWO-4715", priority=0)
	public void branchingLessonWithAllTopics() throws Exception {
		runBranchingLessonPageWithAllTopics();
		logPASS("All Topics in BranchingLesson are Completed");
	}
	
	@Test(groups = { "Regression", "Sanity", "MandatoryTopics", "NextOnly" }, testName="FLDXTWO-4715", priority=1)
	public void branchingLessonWithMandatoryTopics() throws Exception {
		// Use fresh userID to test this scenario.
		runBranchingLessonPageWithMandatoryTopics();
		logPASS("Mandatory Topics in BranchingLesson are Completed");
	}
	
	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4715", priority=2)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}
	
	@Test(groups = { "Regression", "Sanity", "NextOnly", "ContentQA" }, testName="FLDXTWO-4705", priority=3)
	public void NEXT() throws Exception {
		BranchingLesson = "Yes";
		clickNEXT();
		logPASS("Clicked on Next");
	}
	
	
	
	/*@Test
	public void testBranchingLesson() throws Exception {
		TakeScreenshot("Pass");
		checkBACKDisable();
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("BranchingTitle");
		checkTextPresent("BranchingMainContent");
		checkPageAudio();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		checkTextPresent("Course/Page-TimerIndicator");
		runBranchingLesson();
		checkBulletin();
		checkHelp();
		clickNEXTwithTimer();
	}*/
}
