package com.cat.AutomationScript;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import com.cat.utility.CATAppCommon;
public class ConsultTemplateUtili extends CATAppCommon 
{

	/**
	 * must be called first, be sure to update the function based on the environment the test will run in
	 * @param userName supply the user name
	 * @param passWord supply the password
	 */
	static public void login(String userName,String passWord) throws Exception
	{
		getWaitPageLoad();
		typeTextByName("userName", userName);
		typeTextByName("passWord", passWord);
		clickIdentifierXpath("//div[@class='loginBtnWrapper']/input");
		getWaitForElementPresent("//div[@class='iconsTopContainer']/a[1]/p/span", 200);
		softAssertEquals("//div[@class='iconsTopContainer']/a[1]/p/span", "Create a Course");
	}



	/**
	 * Can be called any time after logOn
	 * @param courseName provide the full catalog ID of the course you wish to interact
	 * @param courseContent must be one of the following: "Catalog ID" (can be left blank as this is default value in application), "Course Content", "Course Information", "Bulletins", "Tags" or "Videos"
	 * @param courseType must be one of the following: "All" (can be left blank as this is default value in application), "Library" or "Custom"
	 * 
	 */

	static public void searchcourse(String courseName, String courseContent, String courseType) throws Exception
	{
		getWaitPageLoad();
		//navigateHome();
		getWaitForElementPresent("//th[text()='Catalog ID']",200);
		typeTextById("courseName", courseName);
		if (courseContent != "")
			selectDropdownValueVisibleText("courseContent", courseContent);
		if (courseType != "")
			selectDropdownValueVisibleText("courseType", courseType);
		Thread.sleep(5000);
		getWaitForElementPresent("//input[@id='courseSearchBtn']",90);
		clickIdentifierXpath("//input[@id='courseSearchBtn']");
		Thread.sleep(5000);
	}

	/**
	 * Must be called after searchCourse with full catalog ID as it will click on the first delete icon it see's
	 * 
	 */

	static public void deleteCourse() throws Exception
	{
		getWaitPageLoad();
		clickIdentifierXpath(".//*[@id='deleteACourse']/span/i");
		clickIdentifierXpath("//*[@aria-describedby='dialogArea']/div[3]/div/button[1]");
		getWaitForElementPresent("//*[@id='messageDialog']/tr/td[2]",200);
	}


	/**
	 * Must be called after logOn or cloneCourse
	 * @param clonedCourse leave blank if you did not call cloneCourse
	 * @param CourseTitle provide the course title here
	 * @param Description provide course description
	 * @param BaseCat provide the base catalog id here
	 * @param CourseType must be one of the following: "Custom" or "Library"
	 * @param CourseFormat must be one of the following: "Awareness Vignette", "Experiential Learning", "Foundational", "Refresher", "Standalone Certification"
	 * @param CourseProgression  must be any letter of US alphabet capitalized (ex: "A" or "B")
	 * @param CourseTopic must be one of the course topics in list, must be provided if CourseType is Library (ex: "HOW" or "Fraud")
	 * @param Site must be one of the partners name in the list, must be provided if CourseType is custom
	 * @param Partner must be one of the partners name in the list, must be provided if CourseType is custom
	 * @param Language must be any language
	 * @param Mobile must be yes/no
	 * @param Video must be yes/no
	 * @param Audio must be yes/no
	 * @param CourseDuration must be a number, does not need to be provided
	 */
	public static void createCourse(String clonedCourse, String CourseTitle, String Description, String BaseCat, String CourseType, String CourseFormat, String CourseProgression, String CourseTopic, String Site, String Partner, String Language, String Mobile, String Video, String Audio, String CourseDuration) throws Exception {
		getWaitPageLoad();
		Date d = new Date();	
		
		Thread.sleep(9000);			
		if (clonedCourse == "")
		{
			clickIdentifierXpath("//a[p[span[text()='Create a Course']]]");
			//getWaitForElementPresent("//div[3]//a[1]",90);
			//clickIdentifierXpath("//div[3]//a[1]");
		}	
		getWaitForElementPresent("//label[text()='Course Name']", 200);
		typeTextById("title", "Course title " + d.toString());
		selectDropdownValueVisibleText("courseTypeDropDown", CourseType);	
		//Thread.sleep(5000);	
		if (CourseType == "Custom")
		{
			typeTextById("partnerName", Partner);		
			selectDropdownValueVisibleText("siteId", Site);
			String mobileReady_Xpath="//label[text()='Mobile Ready']";
			getScrrolToWebElement(mobileReady_Xpath);
			typeTextById("ckeditorContentShort", Description + " "  + d.toString());
			typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
		}	
		if (CourseType == "Library")
		{
			selectDropdownValueVisibleText("topicArea", CourseTopic);
			typeTextById("ckeditorContentShort", Description + " "  + d.toString());
			typeTextById("ckeditorContentLong", Description + " "  + d.toString());
			typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
		}	
		selectDropdownValueVisibleText("courseFormatDropDown", CourseFormat);	
		if (CourseProgression != "")
		{
			selectDropdownValueVisibleText("courseProgression", CourseProgression);
		}
		selectDropdownValueVisibleText("lang", Language);
		typeTextById("baseCatalogId", BaseCat);
		//Log.info("base catalog id and course format selected");
		selectDropdownValueVisibleText("hasMobileReady", Mobile);
		selectDropdownValueVisibleText("hasVideo", Video);
		selectDropdownValueVisibleText("hasAudio", Audio);
		typeTextById("courseDuration", CourseDuration);
		//Log.info("mobile, video, audio and duration configured");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		clickIdentifierXpath("//*[@id='editedCourse']/div[1]/button");
		//getScrrolToWebElement("//div[@class='row action']/button[text()='Create']");
		//clickIdentifierXpath("//div[@class='row action']/button[text()='Create']");
		//Thread.sleep(5000);
		getWaitForElementPresent("//*[@id='messageDialog']/tr/td[2]", 200);
		//String courseSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
		//String passed = "Course saved";
		//if (courseSaved.contains(passed))
		//{
		//	String sysID = driver.findElement(By.xpath(".//*[@id='systemId']")).getAttribute("value");
		//	String catID = driver.findElement(By.xpath(".//*[@id='catalogId']")).getAttribute("value");
		//	clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]"); 
			
		//}
		//else {
		
		//}
	}



	/**
	 * Must be called after createCourse or editGetStarted
	 * @param lessonName provide the lesson name
	 */

	static public void addLesson(String lessonName) throws Exception
	{
		getWaitPageLoad();
		Date d = new Date();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		clickIdentifierXpath("//p[text()='Create Your Course']");
		getWaitForElementPresent("//*[@id='courseTree']/ul/li/a", 200);
		clickIdentifierXpath("//*[@id='courseTree']/ul/li/a");
		getWaitForElementPresent("//h1[text()='Tile Menu']", 90);
		clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[1]");
		getWaitForElementPresent("//*[@id='note_pag']/ul/li/input", 90);
		typeTextByXpath("//*[@id='note_pag']/ul/li/input", lessonName + " " + d.toString());
		clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
	}
	/**
	 * Must be called after addLesson or any template
	 * @param lessonPosition provide the lesson position we are adding the topic to (increase by 1 if landing page is present)
	 * @param topicName provide the topic name
	 */
	static public void addTopic(String lessonPosition, String topicName) throws Exception
	{
		getWaitPageLoad();
		Date d = new Date();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		clickIdentifierXpath("//*[@id='courseTree']/ul/li/ul/li["+ lessonPosition + "]/a");
		getWaitForElementPresent("//*[@id='courseTreeOperationIcons']/li[2]",90);
		clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[2]");
		typeTextByXpath("//*[@id='note_pag']/ul/li/input", topicName + " " + d.toString());
		clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
	}


	/**
	 * Must be called after addLesson or addTopic or any template
	 * @param template provide the template either: "consult", "text", "consent", "hotspot, "binary", "selectable", "sidebar, "dnd, "saq", "carousel", "video", "snr", "concern" or "multiple"
	 */

	static public void addPage(String template) throws Exception
	{
		getWaitPageLoad();
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		String template1 = "";
		if (template == "consult")
			template1 = "0-0";
		if (template == "text")
			template1 = "0-1";
		if (template == "consent")
			template1 = "0-2";
		if (template == "hotspot")
			template1 = "0-3";
		if (template == "binary")
			template1 = "0-4";
		if (template == "selectable")
			template1 = "1-0";
		if (template == "sidebar")
			template1 = "1-1";
		if (template == "dnd")
			template1 = "1-2";
		if (template == "saq")
			template1 = "1-3";
		if (template == "carousel")
			template1 = "1-4";
		if (template == "video")
			template1 = "2-0";
		if (template == "snr")
			template1 = "2-1";
		if (template == "concern")
			template1 = "2-2";
		if (template == "multiple")
			template1 = "2-3";

		getWaitForElementPresent("//*[@id='courseTreeOperationIcons']/li[3]",100);
		clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[3]");
		clickIdentifierXpath("//*[@id='template-row-column-image-" + template1 + "']/img");
		clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");

	}



	/**
	 * to be called after addPage or selectPage
	 * @param showTitle show title yes/no
	 * @param pageTitle supply page content
	 * @param layoutConsult Left to Right or Right to Left
	 * @param consultContent content for the page
	 * @param consultClickText first consult image click text
	 * @param consultClickTitle first consult image click title
	 * @param consultImage first consult image yes or blank for no
	 * @param consultImageDesc first consult image description
	 * @param consultAltText first consult alt text
	 * @param consultQuestion consult question text
	 * @param consultQuestionAudio consult question audio yes or blank for no
	 * @param consultQuestionType consult question type either: "Two or More Correct Answers" or "One Correct Answer"
	 * @param consultAnswerCorrect is the first answer correct yes/no
	 * @param consultAnswer first answer text
	 * @param consultAnswerImage first answer image yes/no
	 * @param consultAnswerDesktopImage first answer desktop image yes or blank for no
	 * @param consultAnswerImageDesc first answer image description
	 * @param consultAnswerAltText first answer alt text
	 * @param consultRetryNumber number of retry attempts, leave blank to configure
	 * @param consultRetryTitle title for retry prompt, leave blank to configure
	 * @param consultRetryMessage message for retry prompt, leave blank to configure
	 * @param consultRetryButton button text for retry prompt, leave blank to configure
	 * @param feedbackOption "single" or "multiple"
	 * @param singleFeedback feedback text for single feedback
	 * @param singleImage single feedback image yes or blank for no
	 * @param singleImageDesc single feedback image description
	 * @param singleAltText single feedback alt text
	 * @param correctTitle multiple feedback correct tile
	 * @param correctContent multiple feedback correct text
	 * @param correctImage multiple feedback image yes or blank for no
	 * @param correctImageDesc multiple feedback image description
	 * @param correctAltText  multiple feedback alt text
	 * @param incorrectTitle multiple feedback  incorrect title
	 * @param incorrectContent multiple feedback incorrect text
	 * @param incorrectImage multiple feedback incorrect image yes or blank for no
	 * @param incorrectImageDesc multiple feedback image description
	 * @param incorrectAltText multiple feedback alt text
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 */
	static public void editConsult(String showTitle, String pageTitle, String layoutConsult, String consultContent, String consultClickText, String consultClickTitle, String consultImage, String consultImageDesc, String consultAltText, String consultQuestion, String consultQuestionAudio, String consultQuestionType, String consultAnswerCorrect, String consultAnswer, String consultAnswerImage, String consultAnswerDesktopImage, String consultAnswerImageDesc, String consultAnswerAltText, String consultRetryNumber, String consultRetryTitle, String consultRetryMessage, String consultRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String pageAudio, String backgroundImage) throws Exception
	{
		getWaitPageLoad();
		Date d = new Date();
		if (pageTitle != "")
			typeTextById("pageTitle", pageTitle + " " + d.toString());
		if (showTitle.toLowerCase() == "no")
		{
			uncheckCheckBox(".//input[@name='titleVisible']");
		}

		if (showTitle.toLowerCase() == "yes")
		{
			checkCheckBox(".//input[@name='titleVisible']");
		}

		if (layoutConsult == "Left To Right" || layoutConsult == "Right To Left")
			selectDropdownValueXpathVisibleText(".//*[@id='consultLayout']/div[1]/div/select", layoutConsult);

		if (consultContent != "")
			typeTextById("ckeditorContentconsultContent", consultContent + " " + d.toString());

		if (consultClickText != "")
			typeTextById("ckeditorconsultClickReveal", consultClickText + " " + d.toString());

		if (consultClickTitle != "")
			typeTextById("desc_richTextconsultClickReveal", consultClickTitle + " " + d.toString());

		if (consultImage != "")
		{
			getScrrolToWebElement("//label[text()='Content :']");
			getUploadImage(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[2]/div/div/input[1]");
		}

		if (consultImageDesc != "")
			typeTextByXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[3]/div/input", consultImageDesc + " " + d.toString());

		if (consultAltText != "")
			typeTextByXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[4]/div/input", consultAltText + " " + d.toString());

		if (consultQuestion != "")
			typeTextById("ckeditorContentconsultQuestion", consultQuestion + " " + d.toString());

		if (consultQuestionType == "One Correct Answer" || consultQuestionType == "Two or More Correct Answers")
			selectDropdownValueXpathVisibleText(".//*[@id='consultQuestionType']/div[1]/div/select", consultQuestionType);

		if (consultAnswerCorrect.toLowerCase() == "no")
		{
			uncheckCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div/label[2]/input");
			///Log.info("unchecked correct answer");
		}

		if (consultAnswerCorrect.toLowerCase() == "yes")
		{
			checkCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div/label[2]/input");
			//Log.info("checked correct answer");
		}

		if (consultAnswer != "")
			typeTextById("ckeditorconsultAnswer", consultAnswer + " " + d.toString());

		if (consultAnswerImage.toLowerCase() == "yes")
		{
			checkCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[1]/label/input");
			//Log.info("checked answer image");
		}

		if (consultAnswerDesktopImage != "")
		{
			getScrrolToWebElement("//label[text()='Answer :']");
			getUploadImage(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[2]/div/div[1]/input[1]");
		}

		if (consultAnswerImageDesc != "")
			typeTextByXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[3]/div/input", consultAnswerImageDesc + " " + d.toString());

		if (consultAnswerAltText != "")
			typeTextByXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[4]/div/input", consultAnswerAltText + " " + d.toString());

		if (consultRetryNumber != "")
			typeTextById("titleTextconsultRetryAttempt", consultRetryNumber);

		if (consultRetryTitle != "")
			typeTextById("titleTextconsultRetryAlertTitle", consultRetryTitle + " " + d.toString());

		if (consultRetryMessage != "")
			typeTextById("ckeditorContentconsultRetryAlertText", consultRetryMessage + " " + d.toString());

		if (consultRetryButton != "")
			typeTextById("titleTextconsultRetryAlertButtonTitle", consultRetryButton + " " + d.toString());

		if (feedbackOption.toLowerCase() == "single")
		{
			clickIdentifierXpath(".//*[@id='consultFeedback']/div/div/input[1]");

			if (singleFeedback != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());

			if (singleImage != "")
			{
				getUploadImage(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div/div[1]/input[1][@id='singleFeedbackImage']");
			}

			if (singleImageDesc != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());

			if (singleAltText != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
		}

		if (feedbackOption.toLowerCase() == "multiple")
		{
			clickIdentifierXpath(".//*[@id='consultFeedback']/div/div/input[2]");

			if (correctTitle != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[1]/input", correctTitle + " " + d.toString());

			if (incorrectTitle != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/input", incorrectTitle + " " + d.toString());

			if (correctContent != "")
				typeTextById("ckeditorContentCorrectconsultFeedback1", correctContent + " " + d.toString());

			if (incorrectContent != "")
				typeTextById("ckeditorContentIncorrectconsultFeedback1", incorrectContent + " " + d.toString());

			if (correctImage != "")
			{
				getUploadImage(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1]");
			}

			if (incorrectImage != "")
			{
				getUploadImage(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1]");
			}

			if (correctImageDesc != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());

			if (correctAltText != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());

			if (incorrectImageDesc != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());

			if (incorrectAltText != "")
				typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());

		}

		if (backgroundImage.toLowerCase() == "yes")
		{

			uploadBackgroundImage();
		}
		getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
	}

	/**
	 * to be called after editConsult or selectPage
	 * @param consultPosition the position of the consult image
	 * @param consultClickText consult image text
	 * @param consultClickTitle consult image title
	 * @param consultImage consult image yes or blank for no
	 * @param consultImageDesc consult image description
	 * @param consultAltText consult alt text
	 */
	static public void addConsult(int consultPosition, String consultClickText, String consultClickTitle, String consultImage, String consultImageDesc, String consultAltText) throws Exception
	{
		getWaitPageLoad();
		Date d = new Date();
		int consultCount = consultPosition + 1;
		getScrrolToWebElement(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[2]/div/div/input[1]");
		clickIdentifierByID("multiGraphicContentContainer_addconsultClickReveal");

		if (consultClickText != "")
			typeTextById("ckeditorconsultClickReveal" + consultPosition, consultClickText + " " + d.toString());

		if (consultClickTitle != "")
			typeTextById("desc_richTextconsultClickReveal" + consultPosition, consultClickTitle + " " + d.toString());

		if (consultImage != "")
		{
			getScrrolToWebElement("//ul[@id='consultClickReveal']/ul/li[2]/div/descendant::label[text()='Consult Click Text :']");
			getUploadImage("//ul[@id='consultClickReveal']/ul/li[2]/div/descendant::input[@value='Desktop Image']");
		}

		if (consultImageDesc != "")
			typeTextByXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[3]/div/input", consultImageDesc + " " + d.toString());

		if (consultAltText != "")
			typeTextByXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[4]/div/input", consultAltText + " " + d.toString());


		getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
	}

	/**
	 * to be called after selectPage or editConsult
	 * @param answerPosition the answer position for the added answer
	 * @param consultAnswerCorrect is the answer correct yes/no
	 * @param consultAnswer answer text
	 * @param consultAnswerImage answer image yes or blank for no
	 * @param consultAnswerDesktopImage answer desktop image yes or blank for no
	 * @param consultAnswerImageDesc answer image description
	 * @param consultAnswerAltText answer alt text
	 */
	static public void addAnswerOption(String answerPosition, String consultAnswerCorrect, String consultAnswer, String consultAnswerImage, String consultAnswerDesktopImage, String consultAnswerImageDesc, String consultAnswerAltText) throws Exception
	{
		
		
		getWaitPageLoad();
		Date d = new Date();
		//Log.info("start adding additional consult answer option");
		getScrrolToWebElement("//label[text()='Answer :']");
		clickIdentifierByID("multiGraphicContentContainer_addconsultAnswer");
		if (consultAnswerCorrect.toLowerCase() == "no")
		{
			uncheckCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
			//Log.info("unchecked correct answer");
		}

		if (consultAnswerCorrect.toLowerCase() == "yes")
		{
			checkCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
			//Log.info("checked correct answer");
		}

		if (consultAnswer != "")
			typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/div/div", consultAnswer + " " + d.toString());

		if (consultAnswerImage.toLowerCase() == "yes")
		{
			checkCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[1]/label/input");
			//Log.info("checked answer image");
		}

		if (consultAnswerDesktopImage != "")
		{
			getUploadImage(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[2]/div/div[1]/input[1]");
		}

		if (consultAnswerImageDesc != "")
			typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[3]/div/input", consultAnswerImageDesc + " " + d.toString());

		if (consultAnswerAltText != "")
			typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[4]/div/input", consultAnswerAltText + " " + d.toString());
		getScrrolToWebElement("//div[@class='row action']/button[@id='ok-button']");
		clickIdentifierXpath("//div[@class='row action']/button[@id='ok-button']");
		
	}



	/**
	 * can be called at any time after logOn, course window is closed as well
	 */
	static public void logout() throws Exception
	{		
		getWaitPageLoad();
		clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
		clickIdentifierXpath(".//*[@id='logout']/span");
	}


	public void selectableHotspotTemplate(String layout, String pageTitle, String showTitle, String pageContent,String selectionOrder,String RevealBox,String imagePlacement, int placementX, int placementY,String siTitle,String siText,String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText,String selectbulletintype, String bulletinTitle,String bulletinText) throws Exception
	{
		getWaitPageLoad();
		String glPlacementX=String.valueOf(placementX);
		String glPlacementY=String.valueOf(placementY);
		Date d = new Date();
		getWaitForElementPresent(".//div[@id='desktop-image-main-div-hotspot_pageImage']/img", 200);
		if (layout != "")
			clickIdentifierByID("layout-" + layout + "-main");
		if (pageTitle != "")
			typeTextById("pageTitle", pageTitle + " " + d.toString());
		if (showTitle == "no")
		{

			uncheckCheckBox("//*[@id='mz-showTitle-2']");
			//Log.info("unchecked show title");
		}

		if (showTitle == "yes")
		{
			checkCheckBox("//*[@id='mz-showTitle-2']");
			//Log.info("checked show title");
		}
		if (pageContent != "")
			typeTextById("ckeditorContentrevealHotspot_content", pageContent + " " + d.toString());
		if (desktopImage != "")
		{
			getUploadImage(".//div[@id='desktop-image-main-div-hotspot_pageImage']/div[1]");
		}

		if (mobileImage != "")
		{
			String image = getRandomImage();

			getUploadImage(".//div[@id='mobile-image-main-div-hotspot_pageImage']/div[1]");
			
		}

		if (imageDesc != "")
			//typeTextByXpath(".//*[@id='widgetImageDescription-sidebar_image']",imageDesc + " " + d.toString());
			typeTextById("widgetImageDescription-hotspot_pageImage", imageDesc + " " + d.toString());

		if (altText != "")

			//typeTextByXpath(".//*[@id='widgetAltTextBackgroundImage-sidebar_image']",altText + " " + d.toString());
			typeTextById("widgetAltTextBackgroundImage-hotspot_pageImage", altText + " " + d.toString());

		getScrrolToWebElement(".//div[@id='selection-order-option-div']/div/div[2]/span");
		String CISettings =driver.findElement(By.xpath(".//div[@id='selection-order-option-div']/div/div[2]/span")).getText();
		//System.out.println("Selection order default setting is "  + CISettings); 

		String RBsettings=driver.findElement(By.xpath("//div[@class='reveal-box-fixed']/label")).getText();
		//System.out.println("Reveal Box default setting is" + RBsettings);
		getUploadImage(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/div[1]");
		getUploadImage(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/div[1]");
		getUploadImage(".//div[@id='hotspot-active-image-main-div-hotspot_image']/div[1]");
		getUploadImage(".//div[@id='hotspot-close-image-main-div-hotspot_image']/div[1]");
		getUploadImage(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/div[1]");
		typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
		typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
		if(imagePlacement =="DesktopSamrtphones")
		{	
			placementX=1+placementX;
			String PlacementX=String.valueOf(placementX);
			typeTextById("hotSpotDesktopPositionX0", PlacementX);
			//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
			placementY=1+placementY;
			String PlacementY=String.valueOf(placementY);
			typeTextById("hotSpotDesktopPositionY0", PlacementY);
			typeTextById("hotSpotSmartphonePositionX0", glPlacementX);
			//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
			typeTextById("hotSpotSmartphonePositionY0", glPlacementY);
		}
		else{
			/*--POPUP desktop or tablets Placement--*/
			clickIdentifierXpath(".//*[@id='placeDesktopHotSpot0']");
			typeTextById("popUpX", glPlacementX);
			typeTextById("popUpY", glPlacementY);
			//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
			clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
			//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
			clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
			//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
			/*--POPUP SmartPhone Placement--*/
			clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot0']");
			typeTextById("popUpX", glPlacementX);
			typeTextById("popUpY", glPlacementY);
			clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
			clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
		}


		getUploadImage(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot0']/div[1]");
		getScrrolToWebElement(".//*[@id='placeSmartphoneHotSpot0']");
		getUploadImage(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/div[1]");
		getUploadImage(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/div[1]");
		getUploadImage(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot0']/div[1]");
		getUploadImage("//div[@id='hotspot-close-image-div-revealHotspot_hotspot0']");
		getUploadImage(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/div[1]");
		getScrrolToWebElement("//button[@id='ok-button']");
		clickIdentifierXpath("//button[@id='ok-button']");
		//getWaitForElementPresent("//td[text()='Page saved']",90);
		//Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Page saved']")).isDisplayed());
	}



}
