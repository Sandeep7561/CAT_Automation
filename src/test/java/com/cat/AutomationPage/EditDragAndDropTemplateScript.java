package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.EditDragAndDropUtili;
import com.cat.utility.LogerData;

public class EditDragAndDropTemplateScript extends EditDragAndDropUtili
{
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Logic TC");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Reset Test");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Reset Test");
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
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Add Topic");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Add Page");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Add Page");
		addPage("saq");
	}
	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditDragAndDropTemplate() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Edit Drag And Drop Template");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Edit Drag And Drop Template");
		editDragAndDropTemplate("dnd title", "yes", "Drag and Drop Without Flags", "test", "test1", "yes", "test", "test", "test11", "CAT1", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "yes");
		//addCategory("2", "test2", "yes", "test", "test");
		//addLineItem("2", "test22", "CAT2", "yes", "test", "test");
	}
	@Test(dependsOnMethods = { "CatEditDragAndDropTemplate" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("EditDragAndDropTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("EditDragAndDropTemplateScript_Cat Log Out TC");
		logout();
	}
}
