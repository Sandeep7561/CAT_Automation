package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.SelectAndRevealUtili;
import com.cat.utility.LogerData;

public class SelectAndRevealTemplateScript extends SelectAndRevealUtili
{
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Reset Test");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]", 90);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");

		if (!result.contains("No Result(s) found"))
			deleteCourse();

		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Add Topic");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Add Page");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Add Page");
		addPage("concern");
	}
	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditSelectAndRevealTemplate() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Edit Select And Reveal Template");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Edit Select And Reveal Template");
		editSelectAndRevealTemplate("snr title", "yes", "Top To Bottom", "test", "Random", "test", "test", "yes", "test", "test", "yes", "yes", "yes");
		//editRevealPanel(2, "test2", "test2", "yes", "test2", "test2", "yes");
		//editRevealPanel(3, "test3", "test3", "yes", "test3", "test3", "yes");
		//editRevealPanel(4, "test4", "test4", "yes", "test4", "test4", "yes");
	}
	@Test(dependsOnMethods = { "CatEditSelectAndRevealTemplate" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("SelectAndRevealTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("SelectAndRevealTemplateScript_Cat Log Out TC");
		logout();
	}
}
