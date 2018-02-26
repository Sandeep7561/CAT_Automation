package com.cat.AutomationPage;
import org.testng.annotations.Test;
import com.cat.AutomationScript.ConsultTemplateUtili;
import com.cat.utility.LogerData;


public class SelectableHotspotTemplateScript extends ConsultTemplateUtili 
{

	@Test
	void CatLogicTC() throws Exception
	{

		logger=report.startTest("SelectableHotspotTemplateScript_Cat Logic TC");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat Logic TC");
		if (!configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("username"), configProperties.getProperty("password"));
		else if (configProperties.getProperty("env").contains("stg"))
			login(configProperties.getProperty("stgUser"), configProperties.getProperty("stgPass"));

	}	
	@Test(dependsOnMethods = { "CatLogicTC" })
	void CatResetTest() throws Exception
	{
		logger=report.startTest("SelectableHotspotTemplateScript_Cat Reset Test");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat Reset Test");
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
		logger=report.startTest("SelectableHotspotTemplateScript_Cat Create Course TC");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat Create Course TC");
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("", "test", "test", configProperties.getProperty("baseCat"), "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}

	@Test(dependsOnMethods = { "CatCreateCourseTC" })
	void CatAddLesson() throws Exception
	{
		logger=report.startTest("SelectableHotspotTemplateScript_Cat AddLesson");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat AddLesson");
		addLesson("lesson test out");
	}


	@Test(dependsOnMethods = { "CatAddLesson" })
	void CatAddTopic() throws Exception
	{
		logger=report.startTest("SelectableHotspotTemplateScript_Cat AddTopic");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat AddTopic");
		addTopic("1", "topic");
	}

	@Test(dependsOnMethods = { "CatAddTopic" })
	void CatAddPage() throws Exception
	{
		logger=report.startTest("SelectableHotspotTemplateScript_Cat AddPage");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat AddPage");
		addPage("binary");
	}
	@Test(dependsOnMethods = { "CatAddPage" })
	void SelectableHotspotPageTC() throws Exception
	{
		logger=report.startTest("SelectableHotspotTemplateScript_Selectable Hotspot Page TC");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Selectable Hotspot Page TC");
		//SelectableHotspot obj=new SelectableHotspot();
		selectableHotspotTemplate("dir-btt","selectable title","yes","content","Sequential","Fixed Location","DesktopSamrtphones",10,20,"HS ImageTitle","HS ImageText","yes","yes","yes","test","test","yammer","Bulletin Tilte","Content for bulletin");
	}
	@Test(dependsOnMethods = { "SelectableHotspotPageTC" })
	void CatLogOutTC() throws Exception
	{
		logger=report.startTest("SelectableHotspotTemplateScript_Cat Log Out TC");
		LogerData.startTestCase("SelectableHotspotTemplateScript_Cat Log Out TC");
		logout();
	}
}
