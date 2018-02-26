package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.ConsentAutomationUtili;
import com.cat.utility.LogerData;

public class ConsentAutomationTemplateScript extends ConsentAutomationUtili{


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
		addPage("hotspot");
	}

	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditConsentTemplate() throws Exception
	{
		logger=report.startTest("Cat Edit Consent Template");
		LogerData.startTestCase("Cat Edit Consent Template");
		editConsentTemplate("consent title", "yes", "", "content", "consent button", "yes", "yes", "test", "test", "test", "test", "yes", "yes");
	}

	@Test(dependsOnMethods = { "CatEditConsentTemplate" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("Cat Log Out TC");
		LogerData.startTestCase("Cat Log Out TC");
		logout();
	}
}
