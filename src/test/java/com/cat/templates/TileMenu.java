package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class TileMenu extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4712", priority=0)
	public void runTiles() throws Exception {
		runTileMenuPage();
		logPASS("All Tiles Completed");
	}

	@Test(groups = { "Regression", "Sanity" }, dependsOnMethods = { "runTiles" }, testName="FLDXTWO-4705", priority=1)
	public void clickViewYourCompletionCertificateButtonOnTileMenuCourse() throws Exception {
		if (!verifyElementPresent("Tile-ViewCertificate")) {
			logSKIP("Skipping test because Tile-ViewCertificate was not available");
			throw new SkipException("Skipping test because Tile-ViewCertificate was not available.");
		}
		checkViewCertOnResultsPage();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, dependsOnMethods = { "runTiles" }, testName="FLDXTWO-4705", priority=2)
	public void clickTakeSurveyOnTileMenuCourse() throws Exception {
		if (!verifyElementPresent("Tile-TakeSurvey")) {
			logSKIP("Skipping test because Tile-TakeSurvey was not available");
			throw new SkipException("Skipping test because Tile-TakeSurvey was not available.");
		}
		clickTakeSurveyButton();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", priority=3)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=4)
	public void exitCourse() throws Exception {
		clickElement("DesktopExit");
		Thread.sleep(1000);
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		logPASS("PASS");
	}




	/*@Test
	public void testTileMenu() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("BranchingTitle");
		checkTextPresent("BranchingMainContent");
		checkPageAudio();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		checkTextPresent("Course/Page-TimerIndicator");
		runTileMenu();
	}*/
}