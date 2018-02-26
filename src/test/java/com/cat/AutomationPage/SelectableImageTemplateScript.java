package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.SelectableImageUtili;
import com.cat.utility.LogerData;

public class SelectableImageTemplateScript extends SelectableImageUtili
{


	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Reset Test");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		Thread.sleep(5000);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
			deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}
	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Add Topic");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Add Page");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Add Page");
		addPage("sidebar");
	}

	@Test(dependsOnMethods = { "CatAddPage" })
	void SelectableImagePageTC() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Selectable Image Page TC");
		LogerData.startTestCase("SelectableImageTemplateScript_Selectable Image Page TC");
		selectableimage("dir-rtl","selectable title","yes","content","Random","DesktopSamrtphones","10","15","30","50","HS ImageTitle","HS ImageText","yes","yes","yes","test","test","yammer","Bulletin Tilte","Content for bulletin");
	}
	@Test(dependsOnMethods = { "SelectableImagePageTC" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("SelectableImageTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("SelectableImageTemplateScript_Cat Log Out TC");
		logout();
	}

}
