package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.TestOutTemplateUtili;
import com.cat.utility.LogerData;

public class TestOutTemplateScript extends TestOutTemplateUtili
{

	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("Cat Login TC");
		LogerData.startTestCase("Cat Login TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("CatResetTest");
		LogerData.startTestCase("CatResetTest");
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
		logger=report.startTest("Cat Create Course TC");
		LogerData.startTestCase("Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		//createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foudational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
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
	static void CatEditTextTemplate() throws Exception
	{
		logger=report.startTest("Cat Edit Text Template");
		LogerData.startTestCase("Cat Edit Text Template");
		editTextTemplate("dir-rtl", "text title", "yes", "content", "yes", "yes", "yes", "test", "test");
		//previewPage("new");
	}
	@Test(dependsOnMethods = { "CatEditTextTemplate" })
	void CatCreateTestOutLesson() throws Exception
	{
		logger=report.startTest("Cat Create Test Out Lesson");
		LogerData.startTestCase("Cat Create Test Out Lesson");
		createTestOutLesson("1", "dir-rtl", "welcome title", "welcome content", "yes", "yes", "yes", "welcome test", "welcome test", "dir-rtl", "no", "yes", "yes", "yes", "pass test", "pass test", "no", "yes", "yes", "yes", "fail test", "fail test", "dir-rtl", "wrap up title", "wrap up content", "yes", "yes", "yes", "wrap up test", "wrap up test", "no");
		addTestOutQuestion("2", "test", "test", "single", "test1", "test2", "yes", "test", "test");
	}
	@Test(dependsOnMethods = { "CatCreateTestOutLesson" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("Cat Log Out TC");
		LogerData.startTestCase("Cat Log Out TC");
		logout();
	}
	
}
