package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.BranchingUtili;
import com.cat.utility.LogerData;


public class BranchingScript extends BranchingUtili 
{
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Logic TC");
		LogerData.startTestCase("Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Reset Test");
		LogerData.startTestCase("Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]",200);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
		deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Create Course TC");
		LogerData.startTestCase("BranchingScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		//createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foudational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })

	void CatAddLesson() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Add Lesson");
		LogerData.startTestCase("BranchingScript_Cat Add Lesson");
		addLesson("lesson branching");
	}
	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{	logger=report.startTest("BranchingScript_Cat Add Topic");
		LogerData.startTestCase("BranchingScript_Cat Add Topic");
		//addTopic("2", "topic1");
		addTopic("1", "topic");
	}
	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Add Page");
		LogerData.startTestCase("BranchingScript_Cat Add Page");
		addPage("text");
	}
	@Test(dependsOnMethods = { "CatAddPage" })

	static void CatEditTextTemplate() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Edit Text Template");
		LogerData.startTestCase("BranchingScript_Cat Edit Text Template");
		editTextTemplate("dir-rtl", "text title", "yes", "content", "yes", "yes", "yes", "test", "test");
		//previewPage("new");
	}

	@Test(dependsOnMethods = { "CatEditTextTemplate" })
	void CatCreateBranchingLesson() throws Exception
	{
		logger=report.startTest("BranchingScript_Cat Create Branching Lesson");
		LogerData.startTestCase("BranchingScript_Cat Create Branching Lesson");
		createBranchingLesson("1", 4, "yes", "test", "test", "yes", "yes", "1");
		//previewPage("branching");
		//configureTopic("1", "1", "test", "Fifty fifty", "yes");
		//configureTopic("1", "2", "test", "Solid", "");
	}
	
	@Test(dependsOnMethods = { "CatCreateBranchingLesson" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("CatLogOutTC_Cat Log Out TC");
		LogerData.startTestCase("CatLogOutTC_Cat Log Out TC");
		logout();
	}

}
