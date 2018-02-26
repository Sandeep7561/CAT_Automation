package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.ConsultTemplateUtili;
import com.cat.utility.LogerData;

public class ConsultTemplate extends ConsultTemplateUtili
{

	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("Cat Logic TC");
		LogerData.startTestCase("Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("Cat Reset Test");
		LogerData.startTestCase("Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]", 200);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
		deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("Cat Create Course TC");
		LogerData.startTestCase("Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("Cat Add Lesson");
		LogerData.startTestCase("Cat Add Lesson");
		
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("Cat Add Topic");
		LogerData.startTestCase("Cat Add Topic");
		addTopic("1", "topic");
	}


	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("Cat Add Page");
		LogerData.startTestCase("Cat Add Page");
		addPage("consult");
	}


	@Test(dependsOnMethods = { "CatAddPage" })
	public void CatEditConsult() throws Exception
	{
		logger=report.startTest("Cat Edit Consult ");
		LogerData.startTestCase("Cat Edit Consult");
		editConsult("yes", "consult test", "Left to Right", "test", "test", "test", "yes", "test", "test", "test", "yes", "One Correct Answer", "yes", "test", "yes", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "yes");
	
		//addConsult(1, "test", "test", "yes", "test", "test");
		
		//addAnswerOption("2", "", "test", "yes", "yes", "test", "test");
	
	}
	@Test(dependsOnMethods = { "CatEditConsult" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("Cat Log Out TC");
		LogerData.startTestCase("Cat Log Out TC");
		logout();
	}
}
