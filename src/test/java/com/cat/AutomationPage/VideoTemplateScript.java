package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.VideoTemplateUtili;
import com.cat.utility.LogerData;

public class VideoTemplateScript extends VideoTemplateUtili 
{
	@Test
	void CatLogicTC() throws Exception
	{

		logger=report.startTest("VideoTemplateScript_Cat Login TC");
		LogerData.startTestCase("VideoTemplateScript_Cat Login TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Reset Test");
		LogerData.startTestCase("VideoTemplateScript_Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		//Thread.sleep(5000);
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]", 90);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
			deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("VideoTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		//createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foudational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("VideoTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Add Topic");
		LogerData.startTestCase("VideoTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	
	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Add Page");
		LogerData.startTestCase("VideoTemplateScript_Cat Add Page");
		addPage("snr");
	}
	
	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditVideoTemplate() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Edit Video Template");
		LogerData.startTestCase("VideoTemplateScript_Cat Edit Video Template");
		//editVideoTemplate();
		
		editVideoTemplate("video title", "yes", "video content", "no", "yes", "yes", "yes", "", "panel content", "yes", "yes", "yes", "test", "test");
		//addVideoPanel(2, "test", "yes", "yes", "yes", "test", "test");
		//editNewBulletin("yes", "yes", "yes", "ouch", "bulletin title", "bulletin text");
	}
	@Test(dependsOnMethods = { "CatEditVideoTemplate" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("VideoTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("VideoTemplateScript_Cat Log Out TC");
		logout();
	}
}
