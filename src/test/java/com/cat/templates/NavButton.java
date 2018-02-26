package com.cat.templates;

import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class NavButton extends GenericTemplateMethods {

	@Test
	public void testNavButton() throws Exception {
		logINFO("execute NavButton");
		verifyElementImagePresent("DesktopCompanyLogo");
		verifyElementTextPresent("DesktopCourseTitle");
		if (verifyElementPresent("DesktopDividerArrow"))
		{
			logINFO("DesktopDividerArrow : Present");
		} else
		{
			logINFO("DesktopDividerArrow : Not-Present (error)");
			TakeScreenshot("Fail-DesktopDividerArrowNotPresent");
		}
		verifyElementTextPresent("DesktopLessonTitle");
		verifyElementPresent("DesktopExit");
		if (verifyElementPresent("DesktopMenu"))
		{
			clickElement("DesktopMenu");
			clickElementText("DesktopReturnToCourse");
		}
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		checkTextPresent("Course/Page-TimerIndicator");
		checkTextPresent("CopyrightIndicator");
		//checkAudioBehaviour();
		//checkResources();
		verifyElementTextPresent("BACKEnable");
		verifyElementTextPresent("NEXTEnable");
	}
}