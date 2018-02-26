package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.SAQTemplateUtili;
import com.cat.utility.LogerData;

public class SAQTemplateScript extends SAQTemplateUtili
{
	
	
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		//Thread.sleep(5000);
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]",200);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
			deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		addTopic("1", "topic");
	}

	
	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		addPage("carousel");
	}

	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditSAQ() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");

		editSAQ("saq title", "yes", "Graphical SAQ", "Right To Left", "test", "Check All", "yes", "test", "yes", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "test", "test", "yes", "test", "test", "yes", "yes");
		//addAnswerOption(1, "yes", "test", "yes", "yes", "test", "test");
	}
	@Test(dependsOnMethods = { "CatEditSAQ" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("SAQTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SAQTemplateScript_Cat Logic TC");
		logout();
	}
}
