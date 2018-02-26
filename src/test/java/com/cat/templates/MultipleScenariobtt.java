package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class MultipleScenariobtt extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4708", priority=0)
	public void multipleScenario() throws Exception {
		runMultipleScenarioPage();
		logPASS("All HotSpots Visited");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=1)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=1)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=3)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testMultipleScenariobtt() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle3");
		checkTextPresent("PageTitle");
		checkTextPresent("MainContent1");
		checkImagePresent("MainImage-multiplescenario");
		checkPageAudio();
		checkTextPresent("Course/Page-TimerIndicator");
		runMultipleScenario();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}