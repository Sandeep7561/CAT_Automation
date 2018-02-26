package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.ConsultTemplateUtili;
import com.cat.AutomationScript.TextAndGraphicScriptUtili;
import com.cat.utility.LogerData;

public class TextAndGraphicTemplateScript extends TextAndGraphicScriptUtili 
{
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Login TC");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Login TC");

		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Reset Test");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Reset Test");
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
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		//createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foudational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Add Topic");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Add Page");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Add Page");
		addPage("text");
	}
	@Test(dependsOnMethods = { "CatAddPage" })
	static void CatEditTextTemplate() throws Exception
	{ 
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Edit Text Template");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Edit Text Template");
		editTextTemplate("dir-rtl", "text title", "yes", "content", "yes", "yes", "yes", "test", "test");
		//previewPage("new");
	}
	@Test(dependsOnMethods = { "CatEditTextTemplate" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("TextAndGraphicTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("TextAndGraphicTemplateScript_Cat Log Out TC");
		logout();
	}
}
