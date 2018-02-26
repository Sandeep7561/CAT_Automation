package com.cat.AutomationPage;

import org.testng.annotations.Test;

import com.cat.AutomationScript.CarouselTemplateUtili;
import com.cat.utility.LogerData;

public class CarouselTemplateScript extends CarouselTemplateUtili
{
	
	@Test
	void CatLogicTC() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Logic TC");
		LogerData.startTestCase("Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Reset Test");
		LogerData.startTestCase("Cat Reset Test");
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		getWaitForElementPresent(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]", 200);
		//Thread.sleep(5000);
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		if (!result.contains("No Result(s) found"))
		deleteCourse();
		navigateHome();
	}
	@Test(dependsOnMethods = { "CatResetTest" })
	void CatCreateCourseTC() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("CarouselTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Add Lesson");
		LogerData.startTestCase("CarouselTemplateScript_Cat Add Lesson");
		addLesson("lesson test out");
	}

	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Add Topic");
		LogerData.startTestCase("CarouselTemplateScript_Cat Add Topic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })

	void CatAddPage() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Add Page");
		LogerData.startTestCase("CarouselTemplateScript_Cat Add Page");
		addPage("video");
	}

	@Test(dependsOnMethods = { "CatAddPage" })
	void CatEditCarouselTemplate() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Edit Carousel Template");
		LogerData.startTestCase("CarouselTemplateScript_Cat Edit Carousel Template");
		editCarouselTemplate("carousel title", "test1", "test2", "test3", "test4", "yes", "6", "yes", "yes", "test", "test", "yes", "yes");
		//addCarouselScreen(2, "title2 carousel", "test11", "test22", "test33", "test44", "yes", "8", "yes", "yes", "test", "test");
	}
	@Test(dependsOnMethods = { "CatAddPage" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("CarouselTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("CarouselTemplateScript_Cat Log Out TC");
		logout();
	}
}
