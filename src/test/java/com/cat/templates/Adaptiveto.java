package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Adaptiveto extends GenericTemplateMethods {

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4705", priority=0)
	public void runAdaptivePage() throws Exception {
		runAdaptiveLesson();
		logPASS("Adaptive Lesson Completed");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4715", priority=1)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", priority=2)
	public void NEXT() throws Exception {
		clickNEXT();
		logPASS("Clicked on Next");
	}
}