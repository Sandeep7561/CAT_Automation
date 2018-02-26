package com.cat.AutomationPage;
import org.testng.annotations.Test;

import com.cat.AutomationScript.BinaryListUtili;
import com.cat.utility.LogerData;


public class BinaryListTemplateScript extends BinaryListUtili
{
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Logic TC");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));
	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Reset Test");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]",300);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
		deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Add Topic");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}
	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Add Page");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Add Page");
		addPage("selectable");
	}

	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditBinaryTemplate() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Edit Binary Template");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Edit Binary Template");
		editBinaryTemplate("yes", "binary test", "test", "test", "test", "yes", "test", "test", "yes", "test", "test", "yes", "yes");
		//edit2binaryPanels("2", "test", "Choice 1", "0", "test2", "Choice 2", "1");
		//addBinaryCategory(3, "test1");
	}
	@Test(dependsOnMethods = { "CatEditBinaryTemplate" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("BinaryListTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("BinaryListTemplateScript_Cat Log Out TC");
		logout();
	}
}
