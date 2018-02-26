package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.SidebarUtili;
import com.cat.utility.LogerData;

public class SidebarTemplateScript extends SidebarUtili
{

	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SidebarTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Reset Test");
		LogerData.startTestCase("SidebarTemplateScript_Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		//Thread.sleep(5000);
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]", 100);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
			deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("SidebarTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		//createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foudational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("SidebarTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Add Topic");
		LogerData.startTestCase("SidebarTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Add Page");
		LogerData.startTestCase("SidebarTemplateScript_Cat Add Page");
		addPage("dnd");
	}

	@Test(dependsOnMethods = { "CatAddPage" })
	void SidebarPageTC() throws Exception
	{	
		logger=report.startTest("SidebarTemplateScript_Sidebar Page TC");
		LogerData.startTestCase("SidebarTemplateScript_Sidebar Page TC");
		sidebar("dir-rtl","sidebar title","yes","content","Custom","Custom config title","textforside bar","","Top1","yes","yes","yes","test","test","yammer","Bulletin Tilte","Content for bulletin");

	}
	@Test(dependsOnMethods = { "SidebarPageTC" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("SidebarTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("SidebarTemplateScript_Cat Log Out TC");
		logout();
	}
}
