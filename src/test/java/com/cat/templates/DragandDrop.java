package com.cat.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class DragandDrop extends GenericTemplateMethods {

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
		if (!verifyElementPresent("TopicTitle")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle");
		logPASS("TopicTitle is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4700", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", priority=4)
	public void Audio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because DesktopAudio was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", priority=5)
	public void checkDnDBox() throws Exception {
		if (!verifyElementPresent("DragContainer")) {
			logSKIP("Skipping test because DragContainer was not available");
			throw new SkipException("Skipping test because DragContainer was not available.");
		}
		for (int i=1; i>=1; i++)
		{
			if (verifyElementPresent("DropItemNo" + i + ""))
			{
				//
			} else {
				logINFO("Drag and Drop without Flag Template: Present");
				logINFO("Total " + (i-1) + " Drop Box: Present");
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", priority=6)
	public void checkDnDFlag() throws Exception {
		if (!verifyElementPresent("DropBoxNo1")) {
			logSKIP("Skipping test because DropBoxNo1 was not available");
			throw new SkipException("Skipping test because DropBoxNo1 was not available.");
		}
		for (int i=1; i>=1; i++)
		{
			if (verifyElementPresent("DropBoxNo" + i + ""))
			{
				//
			} else {
				logINFO("Drag and Drop with Flag Template: Present");
				logINFO("Total " + (i-1) + " Drop Box: Present");
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox" }, priority=7)
	public void checkDropBoxHeadingTitle() throws Exception {
		if (!verifyElementPresent("DropBox1HeadingTitle")) {
			logSKIP("Skipping test because DropBox1HeadingTitle was not available");
			throw new SkipException("Skipping test because DropBox1HeadingTitle was not available.");
		}
		for (int i=1; i>=1; i++)
		{
			if (verifyElementPresent("DropBox" + i + "HeadingTitle"))
			{
				verifyElementTextPresent("DropBox" + i + "HeadingTitle");
			} else {
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox" }, priority=8)
	public void checkDropBoxHeadingImage() throws Exception {
		if (!verifyElementPresent("DropBox1HeadingImage")) {
			logSKIP("Skipping test because DropBox1HeadingImage was not available");
			throw new SkipException("Skipping test because DropBox1HeadingImage was not available.");
		}
		for (int i=1; i>=1; i++)
		{
			if (verifyElementPresent("DropBox" + i + "HeadingImage"))
			{
				verifyElementImagePresent("DropBox" + i + "HeadingImage");
			} else {
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox" }, priority=9)
	public void checkDragBoxImage() throws Exception {
		for (int i=1; i>=1; i++){
			if (!verifyElementPresent("DragItemNo"+ i +""))
			{
				//
			} else
			{
				if (!verifyElementPresent("DragBox"+ i +"Image")) {
					logSKIP("Skipping test because DragBox"+ i +"Image was not available");
					throw new SkipException("Skipping test because DragBox"+ i +"Image was not available.");
				}
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("DragBox" + i + "Image"))
					{
						verifyElementImagePresent("DragBox" + i + "Image");
						DragandDrop("DragBox" + i + "Image", "DropItemNo1");
						Thread.sleep(2000);
						i--;
					} else {
						break;
					}
				}
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "checkDnDBox" }, priority=10)
	public void pageReset1() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox" }, priority=11)
	public void checkDragBoxText() throws Exception {
		for (int i=1; i>=1; i++){
			if (!verifyElementPresent("DragItemNo"+ i +""))
			{
				//
			} else
			{
				if (!verifyElementPresent("DragBox"+ i +"Text")) {
					logSKIP("Skipping test because DragBox"+ i +"Text was not available");
					throw new SkipException("Skipping test because DragBox"+ i +"Text was not available.");
				}
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("DragBox" + i + "Text"))
					{
						verifyElementTextPresent("DragBox" + i + "Text");
						DragandDrop("DragBox" + i + "Text", "DropItemNo1");
						Thread.sleep(2000);
						i--;
					} else {
						break;
					}
				}
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "checkDnDBox" }, priority=12)
	public void pageReset2() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox" }, priority=13)
	public void dragCorrectBox() throws Exception {
		dragCorrectBoxes();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "dragCorrectBox" }, priority=14)
	public void submitCorrectBox() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitCorrectBox" }, priority=15)
	public void correctFeedbackTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxCorrectTitle")) {
			logSKIP("Skipping test because FeedbackBoxCorrectTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxCorrectTitle was not available.");
		}
		verifyElementTextPresent("FeedbackBoxCorrectTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitCorrectBox" }, priority=16)
	public void correctFeedbackText() throws Exception {
		if (!verifyElementPresent("FeedbackBoxText")) {
			logSKIP("Skipping test because FeedbackBoxText was not available");
			throw new SkipException("Skipping test because FeedbackBoxText was not available.");
		}
		verifyElementTextPresent("FeedbackBoxText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "checkDragBoxImage" }, priority=17)
	public void checkCorrectDroppedBoxesImage() throws Exception {
		checkDragImageInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "checkDragBoxText" }, priority=18)
	public void checkCorrectDroppedBoxesText() throws Exception {
		checkDragTextInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitCorrectBox" }, priority=19)
	public void checkCorrectIcon() throws Exception {
		checkCorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "checkDnDBox" }, priority=20)
	public void pageReset3() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox" }, priority=21)
	public void dragIncorrectBox() throws Exception {
		dragIncorrectBoxes();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "dragIncorrectBox" }, priority=22)
	public void submitIncorrectBox() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitIncorrectBox" }, priority=23)
	public void checkIncorrectAlertBox() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox")) {
			logSKIP("Skipping test because runSaqORGraphicalSaqRetakeAlertBox was not available");
			throw new SkipException("Skipping test because runSaqORGraphicalSaqRetakeAlertBox was not available.");
		}
		dndIncorrectAlertBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "checkDragBoxImage" }, priority=24)
	public void checkIncorrectDroppedBoxesImage() throws Exception {
		checkDragImageInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "checkDragBoxText" }, priority=25)
	public void checkIncorrectDroppedBoxesText() throws Exception {
		checkDragTextInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitIncorrectBox" }, priority=26)
	public void checkIncorrectIcon() throws Exception {
		checkIncorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitIncorrectBox" }, priority=27)
	public void clickCorrectAnswer() throws Exception {
		clickElementText("CorrectAnswersORMyAnswers");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "clickCorrectAnswer" }, priority=28)
	public void checkCorrectIcon1() throws Exception {
		checkCorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "clickCorrectAnswer" },  priority=29)
	public void clickMyAnswer() throws Exception {
		clickElementText("CorrectAnswersORMyAnswers");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "clickMyAnswer" }, priority=30)
	public void checkIncorrectIcon2() throws Exception {
		checkIncorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitIncorrectBox" }, priority=31)
	public void incorrectFeedbackTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxIncorrectTitle")) {
			logSKIP("Skipping test because FeedbackBoxIncorrectTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxIncorrectTitle was not available.");
		}
		verifyElementTextPresent("FeedbackBoxIncorrectTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDBox", "submitIncorrectBox" }, priority=32)
	public void incorrectFeedbackText() throws Exception {
		if (!verifyElementPresent("FeedbackBoxText")) {
			logSKIP("Skipping test because FeedbackBoxText was not available");
			throw new SkipException("Skipping test because FeedbackBoxText was not available.");
		}
		verifyElementTextPresent("FeedbackBoxText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag" }, priority=33)
	public void checkDragBoxImages() throws Exception {
		for (int i=1; i>=1; i++)
		{
			if (verifyElementPresent("CAT" + i + "Image"))
			{
				verifyElementImagePresent("CAT" + i + "Image");
			} else {
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag" }, priority=34)
	public void checkDropBoxText() throws Exception {
		for (int i=1; i>=1; i++)
		{
			if (verifyElementPresent("DropBoxNo" + i + ""))
			{
				verifyElementTextPresent("DropBoxNo" + i + "");
			} else {
				break;
			}
		}
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag" }, priority=35)
	public void dragCorrectFlag() throws Exception {
		dragCorrectFlagImages();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "dragCorrectFlag" }, priority=36)
	public void submitCorrectFlag() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitCorrectFlag" }, priority=37)
	public void correctFlagFeedbackTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxCorrectTitle")) {
			logSKIP("Skipping test because FeedbackBoxCorrectTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxCorrectTitle was not available.");
		}
		verifyElementTextPresent("FeedbackBoxCorrectTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitCorrectFlag" }, priority=38)
	public void correctFlagFeedbackText() throws Exception {
		if (!verifyElementPresent("FeedbackBoxText")) {
			logSKIP("Skipping test because FeedbackBoxText was not available");
			throw new SkipException("Skipping test because FeedbackBoxText was not available.");
		}
		verifyElementTextPresent("FeedbackBoxText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "checkDragBoxImages" }, priority=39)
	public void checkCorrectDroppedFlagImage() throws Exception {
		checkFlagImageInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitCorrectFlag" }, priority=40)
	public void checkFlagCorrectIcon() throws Exception {
		checkFlagCorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, dependsOnMethods = { "checkDnDFlag" }, priority=41)
	public void pageReset4() throws Exception {
		resetPage();
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag" }, priority=42)
	public void dragIncorrectFlag() throws Exception {
		dragIncorrectFlagImages();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "dragIncorrectFlag" }, priority=43)
	public void submitIncorrectFlag() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitIncorrectFlag" }, priority=44)
	public void checkFlagIncorrectAlertBox() throws Exception {
		if (!verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox")) {
			logSKIP("Skipping test because AlertBox was not available");
			throw new SkipException("Skipping test because AlertBox was not available.");
		}
		dndIncorrectAlertBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitIncorrectFlag" }, priority=45)
	public void incorrectFlagFeedbackTitle() throws Exception {
		if (!verifyElementPresent("FeedbackBoxIncorrectTitle")) {
			logSKIP("Skipping test because FeedbackBoxIncorrectTitle was not available");
			throw new SkipException("Skipping test because FeedbackBoxIncorrectTitle was not available.");
		}
		verifyElementTextPresent("FeedbackBoxIncorrectTitle");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitIncorrectFlag" }, priority=46)
	public void incorrectFlagFeedbackText() throws Exception {
		if (!verifyElementPresent("FeedbackBoxText")) {
			logSKIP("Skipping test because FeedbackBoxText was not available");
			throw new SkipException("Skipping test because FeedbackBoxText was not available.");
		}
		verifyElementTextPresent("FeedbackBoxText");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "checkDragBoxImages" }, priority=47)
	public void checkIncorrectDroppedFlagImage() throws Exception {
		checkFlagImageInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitIncorrectFlag" }, priority=48)
	public void checkFlagIncorrectIcon() throws Exception {
		checkFlagIncorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitCorrectFlag" }, priority=49)
	public void submitCorrectAnswer() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "checkDragBoxImages", "submitCorrectAnswer" }, priority=50)
	public void checkCorrectDroppedFlagImage1() throws Exception {
		checkFlagImageInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitIncorrectFlag", "submitCorrectAnswer" }, priority=51)
	public void checkFlagCorrectIcon1() throws Exception {
		checkFlagCorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitCorrectFlag" }, priority=52)
	public void submitMyAnswer() throws Exception {
		clickElementText("runSaqORGraphicalSaqSubmit");
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "checkDragBoxImages", "submitMyAnswer" }, priority=53)
	public void checkIncorrectDroppedFlagImage1() throws Exception {
		checkFlagImageInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4712", dependsOnMethods = { "checkDnDFlag", "submitIncorrectFlag", "submitMyAnswer" }, priority=54)
	public void checkFlagIncorrectIcon1() throws Exception {
		checkFlagIncorrectIconInsideDropBox();
		logPASS("PASS");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4715", dependsOnMethods = {"submitCorrectBox"}, priority=55)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression" }, testName="FLDXTWO-4716", priority=56)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=57)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=58)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "NextOnly" }, testName="FLDXTWO-4705", dependsOnMethods = {"submitCorrectBox"},  priority=59)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testDragandDrop() throws Exception {
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle2");
		checkTextPresent("MainContent1");
		checkPageAudio();
		if (verifyElementPresent("DragContainer"))
		{
			logINFO("Drag and Drop without Flag Template: Present");
			runDnDWithoutFlag();

		}
		else if (verifyElementPresent("DropBoxNo1"))
		{
			logINFO("Drag and Drop with Flag Template: Present");
			runDnDWithFlag();
		}
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}
