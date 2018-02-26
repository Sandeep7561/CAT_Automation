package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.ConfigurationUtili;
import com.cat.utility.LogerData;

public class ConfigurationScript extends ConfigurationUtili
{

	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Logic TC");
		LogerData.startTestCase("ConfigurationScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Reset Test");
		LogerData.startTestCase("ConfigurationScript_Cat Reset Test");
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
		logger=report.startTest("ConfigurationScript_Cat Create Course TC");
		LogerData.startTestCase("Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Add Lesson");
		LogerData.startTestCase("ConfigurationScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Add Topic");
		LogerData.startTestCase("ConfigurationScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })

	void CatAddPage() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Add Page");
		LogerData.startTestCase("ConfigurationScript_Cat Add Page");
		addPage("text");
	}
	@Test(dependsOnMethods = { "CatAddPage" })

	static void CatEditTextTemplate() throws Exception
	{
	logger=report.startTest("ConfigurationScript_Cat Edit Text Template");
	LogerData.startTestCase("ConfigurationScript_Cat Edit Text Template");
	editTextTemplate("dir-rtl", "text title", "yes", "content", "yes", "yes", "yes", "test", "test");
		//previewPage("new");
	}
	

	@Test(dependsOnMethods = { "CatEditTextTemplate" })
	void CatLockPage() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Lock Page");
		LogerData.startTestCase("ConfigurationScript_Cat Lock Page");
		lockPage("1", "1", "1");
	}
	@Test(dependsOnMethods = { "CatLockPage" })
	void CatUnLockPage() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat UnLock Page");
		LogerData.startTestCase("ConfigurationScript_Cat UnLock Page");
		unlockPage("1", "1", "1");
	}
	
	@Test(dependsOnMethods = { "CatUnLockPage" })
	void CatHidePage() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Hide Page");
		LogerData.startTestCase("ConfigurationScript_Cat Hide Page");
		hidePage("1", "1", "1");
	}


	@Test(dependsOnMethods = { "CatHidePage" })
	void CatUnhidePage() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Unhide Page");
		LogerData.startTestCase("ConfigurationScript_Cat Unhide Page");
		unhidePage("1", "1", "1");
	}
	@Test(dependsOnMethods = { "CatUnhidePage" })
	void CatCopyNode() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Copy Node");
		LogerData.startTestCase("ConfigurationScript_Cat Copy Node");
		copyNode("1", "1", "1");
	}

	@Test(dependsOnMethods = { "CatCopyNode" })
	void CatPasteNode() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Paste Node");
		LogerData.startTestCase("ConfigurationScript_Cat Paste Node");
		pasteNode("1", "1");
	}
	@Test(dependsOnMethods = { "CatPasteNode" })
	void CatDeletePage() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Delete Page");
		LogerData.startTestCase("ConfigurationScript_Cat Delete Page");
		deletePage("1", "1", "1");
	}
	@Test(dependsOnMethods = { "CatDeletePage" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("ConfigurationScript_Cat Log Out TC");
		LogerData.startTestCase("ConfigurationScript_Cat Log Out TC");
		logout();
	}

}
