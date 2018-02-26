package com.cat.templates;

import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class Menu extends GenericTemplateMethods {

	@Test
	public void testMenu() throws Exception {
		if (verifyElementPresent("LandingPageNextButton"))
		{
			String PreviousPageURL = driver.getCurrentUrl();
			//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
			clickElement("LandingPageNextButton");
			String CurrentPageURL = driver.getCurrentUrl();
			//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
			if (PreviousPageURL.equals(CurrentPageURL))
			{
				TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
				logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
			}
		}
		logINFO("execute Menu");
		clickElement("DesktopMenu");
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("MenuTitle");
		checkTextPresent("MenuPage");
		checkImagePresent("MainImage");
		checkImagePresent("DesktopBottom-LegendNot-StartedImage");
		checkTextPresent("DesktopBottom-LegendNot-StartedText");
		checkImagePresent("DesktopBottom-LegendStartedImage");
		checkTextPresent("DesktopBottom-LegendStartedText");
		checkImagePresent("DesktopBottom-LegendCompletedImage");
		checkTextPresent("DesktopBottom-LegendCompletedText");
		clickElementText("DesktopReturnToCourse");
		//runMenu();
	}
}
