package com.cat.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.testng.Assert;

public class ContentQATemplateMethods extends GenericTemplateMethods {
	
	public static void runSaqCorrect() throws Exception {
		SAQYesNo ="Yes";
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
						//if (verifyElementPresent("saqRadioOption"+ j +"") || verifyElementPresent("saqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Correct.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Correct.equals("chVal00"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Correct.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Correct.equals("chVal00"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
					} else {
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
						{
							TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
							logFAIL("None of the anwer options are Correct (error)");
							assertFail();
							clickElementText("runSaqORGraphicalSaqOption1");
						}
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							break;
						} else
						{
							assertFail();
							break;
						}
					}
				}
			}
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			} else
			{
				assertFail();
			} 
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runSaqCorrect");
			logFAIL("The method runSaqCorrect failed (error)");
			assertFail();
		}
	}
	
	public static void runSaqIncorrect() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption1"))
						{
							//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								}
							}
						}
					} else {
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
						{
							logINFO("None of the anwer options are Incorrect");
							TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
							clickElementText("runSaqORGraphicalSaqOption1");
						}
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							Thread.sleep(2000);
							break;
						} else
						{
							TakeScreenshot("Fail-SubmitButtonIssue");
							logFAIL("Submit Button Issue (error)");
							assertFail();
							break;
						}
					}
				}
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				} 
			}
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runSaqIncorrect");
			logFAIL("The method runSaqIncorrect failed (error)");
			assertFail();
		}
	}
	
	public static void runCertQuestion() throws Exception {
		try {
			if (verifyElementPresent("EocCertQuestion1") || verifyElementPresent("EmbdCertQuestion1"))
			{
				for (int k=1; k>=1; k++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
					{
						runCertRadioButtonORCheckBox();
					}
					else if (verifyElementPresent("DropDownBox"))
					{
						runCertDropDown();
					}
					else if (verifyElementPresent("EnterNumberBox"))
					{
						runCertEnterNumber();
					}
					else if (verifyElementPresent("EnterTextBox"))
					{
						runCertEnterText();
					}
					else if (verifyElementPresent("SelectDateBox"))
					{
						runCertSelectDate();
					}
					if (verifyElementPresent("NEXTDisable"))
					{
						checkTextPresent("PageNumberIndicator");
						checkElementPresent("ProgressIndicator");
						checkTextPresent("Course/Page-TimerIndicator");
						TakeScreenshot("Pass");
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(3000);
						break;
					} else
					{
						checkTextPresent("PageNumberIndicator");
						checkElementPresent("ProgressIndicator");
						checkTextPresent("Course/Page-TimerIndicator");
						TakeScreenshot("Pass");
						clickNEXT();
					}
				} 
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertQuestion");
			logFAIL("The method runCertQuestion failed (error)");
			assertFail();
		}
	}

	public static void runClickToRevealBox() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (FastYesNo.equals("No"))
				{
					for (int i=j; i>=j; i++){
						if (verifyElementPresent("ImageOption"+ i +""))
						{
							String Disabled = driver.findElement(objmap.getLocator("ImageOption"+ i +"")).getAttribute("class");
							if (Disabled.contains("disabled"))
							{
								logINFO("ImageOption"+ i +": Disabled");
							} else
							{
								logINFO("ImageOption"+ i +": Enabled");
							}
						} else
						{
							break;
						}
					}
				}

				if (verifyElementPresent("ImageOption"+ j +""))
				{
					verifyElementImagePresent("ImageOption"+ j +"");
					clickElement("ImageOption"+ j +"");
					verifyElementImagePresent("TickMarkImageOption"+ j +"");
					verifyElementTextPresent("RevealBox"+ j +"");
					WebElement element = driver.findElement(objmap.getLocator("RevealBox"+ j +""));
					Coordinates coordinate = ((Locatable)element).getCoordinates(); 
					coordinate.inViewPort();
					Thread.sleep(2000);
					TakeScreenshot("Pass");
					checkPageAudio();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runClickToRevealBox");
			logFAIL("The method runClickToRevealBox failed (error)");
			assertFail();
		}
	}

	public static void runMultipleScenarioSAQIncorrect(String Element) throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				clickElement(Element);
				boolean loop1 = true;
				do {
					if(loop1){
						loop1 = false;
					} else {
						break;
					}

					Thread.sleep(2000);
					if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
					{
						logINFO("#### SAQ page ####: Present");
						TakeScreenshot("Pass");
						runSaqIncorrect();
						if (verifyElementPresent("Continue-Disabled"))
						{
							checkInvisibilityOfElement(600, "Continue-Disabled");
							TakeScreenshot("Pass");
						}
						clickElementText("SAQFeedbackContinue");
						Thread.sleep(2000);
						loop1 = true;
					}   
					if (verifyElementPresent("BasicContinue"))
					{
						logINFO("#### Basic page ####: Present");
						//TakeScreenshot("Pass");
						if (verifyElementPresent("Continue-Disabled"))
						{
							checkInvisibilityOfElement(600, "Continue-Disabled");
							TakeScreenshot("Pass");
						}
						clickElementText("BasicContinue");
						Thread.sleep(2000);
						loop1 = true;
					}
				}
				while
					((verifyElementPresent("runSaqORGraphicalSaqOption1")) || (verifyElementPresent("BasicContinue")));
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runMultipleScenarioSAQIncorrect");
			logFAIL("The method runMultipleScenarioSAQIncorrect failed (error)");
			assertFail();
		}
	}

	public static void runConsult() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("Option" + j + "Image"))
				{
					verifyElementImagePresent("Option" + j + "Image");
					checkTextPresent("Option" + j + "ImageTitle");
					clickElement("Option" + j + "Image");
					verifyElementImagePresent("Option" + j + "ImageTickMark");
					verifyElementTextPresent("Option" + j + "ImageRevealBox");
					WebElement element = driver.findElement(objmap.getLocator("Option" + j + "ImageRevealBox"));
					Coordinates coordinate = ((Locatable)element).getCoordinates(); 
					coordinate.inViewPort();
					TakeScreenshot("Pass");
				} else
				{
					break;
				}
			}
			verifyElementTextPresent("SaqQuestionText");
		} 
		catch (Exception e) {
			TakeScreenshot("Fail-Method-runConsult");
			logFAIL("The method runConsult failed (error)");
			assertFail();
		}
	}

	public static void runNewClickToRevealHotSpot() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (FastYesNo.equals("No"))
				{
					for (int i=j; i>=j; i++){
						if (verifyElementPresent("NewCTRhotspot"+ i +""))
						{
							String Disabled = driver.findElement(objmap.getLocator("NewCTRhotspot"+ i +"")).getAttribute("class");
							if (Disabled.contains("disabled"))
							{
								logINFO("NewCTRhotspot"+ i +": Disabled");
							} else
							{
								logINFO("NewCTRhotspot"+ i +": Enabled");
							}
						} else
						{
							break;
						}
					}
				}

				if (verifyElementPresent("NewCTRhotspot"+ j +""))
				{
					/*
				    	verifyElementImagePresent("NewCTRHotSpot"+ j +"-Normal");
				    	moveoElement("NewCTRHotSpot"+ j +"-Normal");
				    	Thread.sleep(500);
						verifyElementImagePresent("NewCTRHotSpot"+ j +"-NormalHover");
					 */

					TakeScreenshot("Pass");
					clickElement("NewCTRhotspot"+ j +"");
					verifyElementPresent("NewCTRHotSpotRevealBox");
					checkImagePresent("NewCTRHotSpotRevealBoxImage");
					verifyElementTextPresent("NewCTRHotSpotRevealBoxContent");
					TakeScreenshot("Pass");
					checkPageAudio();

					/*
				    	verifyElementImagePresent("NewCTRHotSpot"+ j +"-Close");
				    	moveoElement("NewCTRHotSpot"+ j +"-Close");
				    	Thread.sleep(500);
						verifyElementImagePresent("NewCTRHotSpot"+ j +"-CloseHover");
				    	TakeScreenshot("Pass");
					 */

					clickElement("NewCTRHotSpotRevealBoxClosebutton");
					//verifyElementImagePresent("NewCTRHotSpot"+ j +"-Selected");
				} else
				{
					TakeScreenshot("Pass");	
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runNewClickToRevealHotSpot");
			logFAIL("The method runNewClickToRevealHotSpot failed (error)");
			assertFail();
		}
	}

	public static void runClickToRevealHotSpot() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (FastYesNo.equals("No"))
				{
					for (int i=j; i>=j; i++){
						if (verifyElementPresent("ctrhotspot"+ i +""))
						{
							String Disabled = driver.findElement(objmap.getLocator("ctrhotspot"+ i +"")).getAttribute("class");
							if (Disabled.contains("disabled"))
							{
								logINFO("ctrhotspot"+ i +": Disabled");
							} else
							{
								logINFO("ctrhotspot"+ i +": Enabled");
							}
						} else
						{
							break;
						}
					}
				}

				if (verifyElementPresent("ctrhotspot"+ j +""))
				{
					verifyElementImagePresent("HotSpot"+ j +"-Normal");
					movetoElement("ctrhotspot"+ j +"");
					verifyElementImagePresent("HotSpot"+ j +"-Hover");
					TakeScreenshot("Pass");
					clickElement("ctrhotspot"+ j +"");
					verifyElementTextPresent("HotSpotRevealBox");
					checkPageAudio();
					TakeScreenshot("Pass");
					Thread.sleep(2000);
					closeCTRHotSpotRevealBox();
					Thread.sleep(2000);
					verifyElementImagePresent("HotSpot"+ j +"-Selected");
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runClickToRevealHotSpot");
			logFAIL("The method runClickToRevealHotSpot failed (error)");
			assertFail();
		}
	}

	public static void runBinaryList() throws Exception {
		try {
			verifyElementTextPresent("1stColumnTitle");
			verifyElementTextPresent("2ndColumnTitle");
			if (FastYesNo.equals("No"))
			{
				for (int i=1; i>=1; i++){
					if (verifyElementPresent("Mask" + i + ""))
					{
						String Mask = driver.findElement(objmap.getLocator("Mask" + i + "")).getAttribute("class");
						//logINFO("Mask"+ i +"" + " = ["+ Mask +"] : Present");
						if (!Mask.contains("invisible"))
						{
							logINFO("Mask" + i + " : Present");  
						} else
						{
							TakeScreenshot("Fail-Mask" + i + "NotPresent");
							logFAIL("Mask" + i + " : Not-Present (error)");
						}
					} else
					{
						break;
					}
				}
				if (!verifyElementPresent("Mask1"))
				{
					if (verifyElementPresent("MaskOnImage"))
					{
						logINFO("MaskOnImage : Present");
					} else
					{
						TakeScreenshot("Fail-MaskOnImageNotPresent");
						logFAIL("MaskOnImage : Not-Present (error)");
					}
				}
			}

			for (int j=1; j>=1; j++)
			{
				if (verifyElementPresent("BinaryOption" + j + ""))
				{
					TakeScreenshot("Pass");
					verifyElementTextPresent("BinaryOption" + j + "");
					clickElement("1stColumnRadioButton" + j + "");
					if (verifyElementPresent("IncorrectIcon" + j + ""))
					{
						verifyElementImagePresent("IncorrectIcon" + j + "");
						clickElement("2ndColumnRadioButton" + j + "");
						verifyElementImagePresent("CorrectIcon" + j + "");
					} else
					{
						verifyElementImagePresent("CorrectIcon" + j + "");
					}
				} else
				{
					break;
				}
			}

			verifyElementImagePresent("ImageBehindMask");

			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++)
				{
					if (verifyElementPresent("CorrectIcon" + j + ""))
					{
						TakeScreenshot("Pass");
						String RadioButton = driver.findElement(objmap.getLocator("1stColumnRadioButton" + j + "")).getAttribute("class");
						//logINFO("1stColumnRadioButton" + j + "" + " = ["+ RadioButton +"] : Present");
						if (!RadioButton.contains("active"))
						{
							clickElement("1stColumnRadioButton" + j + ""); 
						} else
						{
							clickElement("2ndColumnRadioButton" + j + "");
							verifyElementImagePresent("IncorrectIcon" + j + "");
						}
					} else
					{
						break;
					}
				}

				for (int i=1; i>=1; i++){
					if (verifyElementPresent("Mask" + i + ""))
					{
						String Mask = driver.findElement(objmap.getLocator("Mask" + i + "")).getAttribute("class");
						//logINFO("Mask"+ i +"" + " = ["+ Mask +"] : Present");
						if (!Mask.contains("invisible"))
						{
							logINFO("Mask" + i + " : Present");  
						} else
						{
							TakeScreenshot("Fail-Mask" + i + "NotPresent");
							logFAIL("Mask" + i + " : Not-Present (error)");
						}
					} else
					{
						break;
					}
				}
			}

			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runBinaryList");
			logFAIL("The method runBinaryList failed (error)");
			assertFail();
		}
	}

	public static void runClickToRevealSelectableImage() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (FastYesNo.equals("No"))
				{
					for (int i=j; i>=j; i++){
						if (verifyElementPresent("ctrSi"+ i +""))
						{
							String Disabled = driver.findElement(objmap.getLocator("ctrSi"+ i +"")).getAttribute("class");
							if (Disabled.contains("disabled"))
							{
								logINFO("ctrSi"+ i +": Disabled");
							} else
							{
								logINFO("ctrSi"+ i +": Enabled");
							}
						} else
						{
							break;
						}
					}
				}

				if (verifyElementPresent("ctrSi"+ j +""))
				{
					verifyElementImagePresent("Si"+ j +"-Normal");
					movetoElement("ctrSi"+ j +"");
					verifyElementImagePresent("Si"+ j +"-Hover");
					TakeScreenshot("Pass");
					clickElement("ctrSi"+ j +"");
					verifyElementTextPresent("HotSpotRevealBox");
					checkPageAudio();
					TakeScreenshot("Pass");
					Thread.sleep(2000);
					try
					{
						driver.findElement(objmap.getLocator("HotSpotRevealBoxClosebutton")).click();
						logINFO("HotSpotRevealBoxClosebutton: Clicked");
						Thread.sleep(500);
						if (verifyElementPresent("HotSpotRevealBox"))
						{
							clickInvisibleElement("HotSpotRevealBoxClosebutton");
							logINFO("HotSpotRevealBoxClosebutton: Invisible-Clicked");
						}
					} catch (Exception e) {
						if (verifyElementPresent("HotSpotRevealBox"))
						{
							clickInvisibleElement("HotSpotRevealBoxClosebutton");
							logINFO("HotSpotRevealBoxClosebutton: Invisible-Clicked");
						}
					}
					Thread.sleep(2000);
					verifyElementImagePresent("Si"+ j +"-Selected");
					movetoElement("ctrSi"+ j +"");
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runClickToRevealSelectableImage");
			logFAIL("The method runClickToRevealSelectableImage failed (error)");
			assertFail();
		}
	}

	public static void runBranchingScenario() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +"")){
					for (int k=1; k>=1; k++){
						if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
						{
							logINFO("Question page #"+ k +": Present");
							verifyElementImagePresent("MainImage-fsg");
							verifyElementTextPresent("QuestionText");
							checkPageAudio();
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							break; 
						}
					}
					logINFO("Feedback page: Present");		
					verifyElementImagePresent("MainImage-fsg");
					verifyElementTextPresent("FeedbackBox");
					checkPageAudio();
					clickElementText("Replay");
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runBranchingScenario");
			logFAIL("The method runBranchingScenario failed (error)");
			assertFail();
		}
	}

	public static void runMultipleScenario() throws Exception {
		try {
			String SAQPresent = null;
			for (int j=1; j>=1; j++)
			{
				if (FastYesNo.equals("No"))
				{
					for (int i=j; i>=j; i++){
						if (verifyElementPresent("MSHotSpot" + i + ""))
						{
							String Disabled = driver.findElement(objmap.getLocator("MSHotSpot" + i + "")).getAttribute("class");
							if (Disabled.contains("disabled"))
							{
								logINFO("MSHotSpot" + i + ": Disabled");
							} else
							{
								logINFO("MSHotSpot" + i + ": Enabled");
							}
						} else
						{
							break;
						}
					}
				}

				if (verifyElementPresent("MSHotSpot" + j + ""))
				{
					verifyElementImagePresent("MSHotSpot"+ j +"-Normal");
					movetoElement("MSHotSpot"+ j +"-Normal");
					verifyElementImagePresent("MSHotSpot"+ j +"-Hover");
					TakeScreenshot("Pass");
					clickElement("MSHotSpot" + j + "");
					logINFO("------- HotSpot " + j + " ------");
				} else
					break;

				boolean loop = true;
				do {
					if(loop){
						loop = false;
					} else {
						break;
					}

					Thread.sleep(2000);
					if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
					{
						//String SAQPresent = "Yes";
						SAQPresent = "Yes";
						logINFO("#### SAQ page ####: Present");
						checkBACKDisable();
						checkNEXTDisable();
						checkTextPresent("TopicTitle-multiplescenarioSAQandBasic");
						checkTextPresent("PageTitle-multiplescenarioSAQandBasic");
						verifyElementTextPresent("MainContent-multiplescenarioSAQandBasic");
						checkImagePresent("MainImage-ltr");
						checkImagePresent("MainImage-rtl");
						checkPageAudio();
						TakeScreenshot("Pass");
						runSaqCorrect();
						if (verifyElementPresent("Continue-Disabled"))
						{
							checkInvisibilityOfElement(600, "Continue-Disabled");
							TakeScreenshot("Pass");
						}
						clickElementText("SAQFeedbackContinue");
						Thread.sleep(2000);
						loop = true;
					}   
					if (verifyElementPresent("BasicContinue"))
					{
						logINFO("#### Basic page ####: Present");
						checkBACKDisable();
						checkNEXTDisable();
						checkTextPresent("TopicTitle-multiplescenarioSAQandBasic");
						checkTextPresent("PageTitle-multiplescenarioSAQandBasic");
						verifyElementTextPresent("MainContent-multiplescenarioSAQandBasic");
						checkImagePresent("MainImage-ltr");
						checkImagePresent("MainImage-rtl");
						checkPageAudio();
						TakeScreenshot("Pass");
						if (verifyElementPresent("Continue-Disabled"))
						{
							checkInvisibilityOfElement(600, "Continue-Disabled");
							TakeScreenshot("Pass");
						}
						clickElementText("BasicContinue");
						Thread.sleep(2000);
						loop = true;
					}
				}
				while
					((verifyElementPresent("runSaqORGraphicalSaqOption1")) || (verifyElementPresent("BasicContinue")));
				if (SAQPresent.equals("Yes"))
				{
					runMultipleScenarioSAQIncorrect("MSHotSpot" + j + "");
					SAQPresent = "No";
				}
				verifyElementImagePresent("MSHotSpot"+ j +"-Selected");
				TakeScreenshot("Pass");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runMultipleScenario");
			logFAIL("The method runMultipleScenario failed (error)");
			assertFail();
		}
	}

	public static void checkBACKDisable() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("BACKDisable") || verifyElementPresent("BACKLock"))
				{
					logINFO("BACKDisable : Present");
				} else
				{
					logFAIL("BACKEnable : Present");
					assertFail();
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkBACKDisable");
			logFAIL("The method checkBACKDisable failed (error)");
			assertFail();
		}
	}

	public static void clickBACK() throws Exception {
		try {
			if (verifyElementPresent("BACKDisable"))
			{
				//
			} else
			{
				String PreviousPageURL = driver.getCurrentUrl();
				//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
				clickElementText("BACKEnable");
				Thread.sleep(100);
				String CurrentPageURL = driver.getCurrentUrl();
				if (PreviousPageURL.equals(CurrentPageURL))
				{
					Thread.sleep(3000);
				}
				//Thread.sleep(2000);
				String CurrentPageURL1 = driver.getCurrentUrl();
				//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
				if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
				{
					TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
					logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
					assertFail();
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickBACK");
			logFAIL("The method clickBACK failed (error)");
			assertFail();
		}
	}

	public static void checkResources() throws Exception {
		try {
			if (verifyElementPresent("DesktopResourcesButton"))
			{
				clickElementText("DesktopResourcesButton");
				Thread.sleep(5000);
				TakeScreenshot("Pass");
				clickElement("DesktopResourcesClose");

				/*for (int i=2; i>=2; i++){
							String winHandleBefore = driver.getWindowHandle();
							clickElementText("DesktopResourcesButton");
							Thread.sleep(5000);
							if (verifyElementPresent("DesktopResourcesHyperlink" + i + ""))
							{
							  //String winHandleBefore = driver.getWindowHandle();
							  clickElementText("DesktopResourcesHyperlink" + i + "");
							  Thread.sleep(5000);
							  for(String winHandle : driver.getWindowHandles())
							  {
								  driver.switchTo().window(winHandle);
							  }
							  Thread.sleep(5000);
							  String url = driver.getCurrentUrl();
							  logINFO("DesktopResourcesHyperlink" + i + " URL : " + url + "");
							  TakeScreenshot("Pass");
							  driver.close();
							  driver.switchTo().window(winHandleBefore);
							} else
							{
							  clickElement("DesktopResourcesClose");
							  break;
							}
						}*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkResources");
			logFAIL("The method checkResources failed (error)");
			assertFail();
		}
	}

	public static void checkAudioBehaviour() throws Exception {
		try {
			if (verifyElementPresent("DesktopAudio"))
			{
				clickElementText("DesktopAudio");
				//verifyElementPresent("AudioControlPanel");
				TakeScreenshot("Pass");
				String AudioOnOff = driver.findElement(objmap.getLocator("AudioOnOff")).getAttribute("aria-label");
				if (AudioOnOff.equals("Off"))
				{
					logINFO("AudioOnOff = ["+ AudioOnOff +"] : Present");
					clickElement("AudioOnOff");
					getAttribute("AudioOnOff","aria-label");
				} else
				{
					clickElement("AudioOnOff");
					getAttribute("AudioOnOff","aria-label");
					clickElement("AudioOnOff");
					getAttribute("AudioOnOff","aria-label");
				}
				TakeScreenshot("Pass");
				if (verifyElementPresent("AudioSpeed"))
				{
					verifyElementTextPresent("AudioSpeed");
					clickElement("AudioSpeed");
					verifyElementTextPresent("AudioSpeed");
				}
				if (verifyElementPresent("AudioPlay"))
				{
					clickElement("AudioPlay");
					clickElement("AudioPause");
					clickElement("AudioPlay");
				} else
				{
					clickElement("AudioPause");
					clickElement("AudioPlay");
				}
				Thread.sleep(2000);
				verifyElementTextPresent("AudioCurrentTime");

				dragSlider("AudioSlider", 50, 0);
				Thread.sleep(2000);
				verifyElementTextPresent("AudioCurrentTime");
				TakeScreenshot("Pass");

				dragSlider("AudioSlider", -50, 0);
				Thread.sleep(2000);
				verifyElementTextPresent("AudioCurrentTime");
				TakeScreenshot("Pass");

				String TotalTime = driver.findElement(objmap.getLocator("AudioTotalTime")).getText();
				logINFO("AudioTotalTime = ["+ TotalTime +"] : Present");
				if (TotalTime.equals("00:00"))
				{
					TakeScreenshot("Fail-AudioFileNotPresent");
					logFAIL("Audio File: Not-Present (error)");
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkAudioBehaviour");
			logFAIL("The method checkAudioBehaviour failed (error)");
			assertFail();
		}
	}

	public static void runQuizCorrect() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqMultipleChoice1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Correct = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
						//logINFO("saqMultipleChoice"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("saqCheckboxOption1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					if (!verifyElementPresent("runSaqORGraphicalSaqSubmit") && verifyElementPresent("NEXTDisable"))
					{
						TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
						logFAIL("None of the anwer options are Correct (error)");
						clickElementText("runSaqORGraphicalSaqOption1");
					} else
					{
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled") && verifyElementPresent("NEXTDisable"))
						{
							TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
							logFAIL("None of the anwer options are Correct (error)");
							clickElementText("runSaqORGraphicalSaqOption1");
						}
					}
					if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
					{
						TakeScreenshot("Pass");
						String PreviousPageURL = driver.getCurrentUrl();
						//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
						checkBulletin();
						checkHelp();
						Thread.sleep(1000);
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(2000);
						String CurrentPageURL = driver.getCurrentUrl();
						//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
						if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("scormdriver"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
						}
						break;
					} else
					{
						TakeScreenshot("Pass");
						checkBulletin();
						checkHelp();
						clickNEXT();
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runQuizCorrect");
			logFAIL("The method runQuizCorrect failed (error)");
			assertFail();
		}
	}

	public static void runQuizIncorrect() throws Exception {
		try {
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
				{
					if (verifyElementPresent("saqMultipleChoice1"))
					{
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Incorrect = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("idx");
						//logINFO("saqMultipleChoice"+ j +"" + " = ["+ Incorrect +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}	
					else if (verifyElementPresent("saqCheckboxOption1"))
					{	
						//verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Incorrect +"] : Present");
						if (Incorrect.equals("chVal00"))
						{
							logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
							clickElementText("runSaqORGraphicalSaqOption"+ j +"");
						} else
						{
							if (Incorrect.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
							} else
							{
								logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					if (!verifyElementPresent("runSaqORGraphicalSaqSubmit") && verifyElementPresent("NEXTDisable"))
					{
						logINFO("None of the anwer options are Incorrect");
						TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
						clickElementText("runSaqORGraphicalSaqOption1");
					} else
					{
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled") && verifyElementPresent("NEXTDisable"))
						{
							logINFO("None of the anwer options are Incorrect");
							TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
							clickElementText("runSaqORGraphicalSaqOption1");
						}
					}
					if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
					{
						TakeScreenshot("Pass");
						String PreviousPageURL = driver.getCurrentUrl();
						//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
						checkBulletin();
						checkHelp();
						Thread.sleep(1000);
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(2000);
						String CurrentPageURL = driver.getCurrentUrl();
						//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
						if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("scormdriver"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
						}
						break;
					} else
					{
						TakeScreenshot("Pass");
						checkBulletin();
						checkHelp();
						clickNEXT();
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runQuizIncorrect");
			logFAIL("The method runQuizIncorrect failed (error)");
			assertFail();
		}
	}

	public static void runConsultSaq() throws Exception {
		try {
			runConsultSaqCorrect();
			if (FastYesNo.equals("No"))
			{
				resetPage();
				runConsult();
				runConsultSaqIncorrect();
				/*if (BranchingLesson.equals("No") && TileMenu.equals("No"))
						{
							clickBACK();
							if (verifyElementPresent("NEXTDisable"))
							{
								if (verifyElementPresent("takeLesson"))
								{
									clickElementText("takeLesson");
								} else {
									initialiseTemplates();
									runTemplates();
								}
							} else {
								clickNEXT();
								Thread.sleep(1000);
								runConsult();
								runConsultSaqIncorrect();
						}*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runConsultSaq");
			logFAIL("The method runConsultSaq failed (error)");
			assertFail();
		}
	}

	public static void runConsultSaqCorrect() throws Exception {
		SAQYesNo ="Yes";
		try {
			//for (int i=1; i>=1; i++){
			for (int j=1; j>=1; j++){
				if (verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
				{
					if (verifyElementPresent("ConsultSaqRadioOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
						//logINFO("ConsultSaqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("ConsultSaqRadioOption"+ j +": Correct");
							clickElementText("ConsultSaqRadioOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("ConsultSaqRadioOption"+ j +": Incorrect");
							} else
							{
								logFAIL("ConsultSaqRadioOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
					else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
					{
						String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
						//logINFO("ConsultSaqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
						if (Correct.equals("chVal01"))
						{
							logINFO("ConsultSaqCheckboxOption"+ j +": Correct");
							clickElementText("ConsultSaqCheckboxOption"+ j +"");
						} else
						{
							if (Correct.equals("chVal00"))
							{
								logINFO("ConsultSaqCheckboxOption"+ j +": Incorrect");
							} else
							{
								logFAIL("ConsultSaqCheckboxOption"+ j +": Attribute value of 'idx' is missing");
								assertFail();
							}
						}
					}
				} else {
					if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
					{
						TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
						logFAIL("None of the anwer options are Correct (error)");
						assertFail();
						if (verifyElementPresent("ConsultSaqRadioOption1"))
						{
							clickElementText("ConsultSaqRadioOption1");
						}
						else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
						{
							clickElementText("ConsultSaqCheckboxOption1");
						}
					}
					if (verifyElementPresent("ConsultSaqSubmit"))
					{
						TakeScreenshot("Pass");
						clickElementText("ConsultSaqSubmit");
						break;
					} else
					{
						break;
					}
				}
			} //break;
			//}
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runConsultSaqCorrect");
			logFAIL("The method runConsultSaqCorrect failed (error)");
			assertFail();
		}
	}

	public static void runConsultSaqIncorrect() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("ConsultSaqRadioOption"+ j +"") || verifyElementPresent("ConsultSaqCheckboxOption"+ j +""))
					{
						if (verifyElementPresent("ConsultSaqRadioOption1"))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("ConsultSaqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("ConsultSaqRadioOption"+ j +": Incorrect");
								clickElementText("ConsultSaqRadioOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("ConsultSaqRadioOption"+ j +": Correct");
								} else
								{
									logFAIL("ConsultSaqRadioOption"+ j +": Attribute value of 'idx' is missing");
									assertFail();
								}
							}
						}
						else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
						{
							String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("ConsultSaqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("ConsultSaqCheckboxOption"+ j +": Incorrect");
								clickElementText("ConsultSaqCheckboxOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("ConsultSaqCheckboxOption"+ j +": Correct");
								} else
								{
									logFAIL("ConsultSaqCheckboxOption"+ j +": Attribute value of 'idx' is missing");
									assertFail();
								}
							}
						}
					} else {
						if (verifyElementPresent("runSaqORGraphicalSaqSubmitDisabled"))
						{
							logINFO("None of the anwer options are Incorrect");
							TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
							if (verifyElementPresent("ConsultSaqRadioOption1"))
							{
								clickElementText("ConsultSaqRadioOption1");
							}
							else if (verifyElementPresent("ConsultSaqCheckboxOption1"))
							{
								clickElementText("ConsultSaqCheckboxOption1");
							}
						}
						if (verifyElementPresent("ConsultSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("ConsultSaqSubmit");
							Thread.sleep(2000);
							break;
						} else
						{
							break;
						}
					}
				}
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				} 
			}
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runConsultSaqIncorrect");
			logFAIL("The method runConsultSaqIncorrect failed (error)");
			assertFail();
		}
	}

	public static void runGraphicalSaqCorrect() throws Exception {
		SAQYesNo = "Yes";
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption1"))
						{
							verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							verifyElementImagePresent("runSaqORGraphicalSaqOption"+ j +"Image");
							String Correct = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("saqRadioOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Correct.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{	
								if (Correct.equals("chVal00"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
									assertFail();
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption1"))
						{
							verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							verifyElementImagePresent("runSaqORGraphicalSaqOption"+ j +"Image");
							String Correct = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Correct +"] : Present");
							if (Correct.equals("chVal01"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Correct.equals("chVal00"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
									assertFail();
								}
							}
						}
					} else {
						if (verifyElementPresent("SaqSubmitDisable") || verifyElementPresent("CertSubmitDisable"))
						{
							TakeScreenshot("Fail-NoneOfTheAnwerOptionsAreCorrect");
							logFAIL("None of the anwer options are Correct (error)");
							assertFail();
							clickElementText("runSaqORGraphicalSaqOption1");
						}
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							break;
						} else
						{
							assertFail();
							break;
						}
					}
				} 
			}
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runGraphicalSaqCorrect");
			logFAIL("The method runGraphicalSaqCorrect failed (error)");
			assertFail();
		}
	}

	public static void runGraphicalSaq() throws Exception {
		try {
			runGraphicalSaqCorrect();
			if (FastYesNo.equals("No"))
			{
				resetPage();
				runGraphicalSaqIncorrect();

				/*if (BranchingLesson.equals("No") && TileMenu.equals("No"))
						{
							clickBACK();
							if (verifyElementPresent("NEXTDisable"))
							{
								if (verifyElementPresent("takeLesson"))
								{
									clickElementText("takeLesson");
								} else {
									initialiseTemplates();
									runTemplates();
								}
							} else {
								clickNEXT();
							}
							runGraphicalSaqIncorrect();
						}*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runGraphicalSaq");
			logFAIL("The method runGraphicalSaq failed (error)");
			assertFail();
		}
	}

	public static void runGraphicalSaqIncorrect() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					{
						if (verifyElementPresent("saqRadioOption1"))
						{
							verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							verifyElementImagePresent("runSaqORGraphicalSaqOption"+ j +"Image");
							String Incorrect = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("idx");
							//logINFO("saqRadioOption"+ j +"" + " = ["+ Incorrect +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
									assertFail();
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption1"))
						{
							verifyElementTextPresent("runSaqORGraphicalSaqOption"+ j +"");
							verifyElementImagePresent("runSaqORGraphicalSaqOption"+ j +"Image");
							String Incorrect = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("idx");
							//logINFO("saqCheckboxOption"+ j +"" + " = ["+ Incorrect +"] : Present");
							if (Incorrect.equals("chVal00"))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +": Incorrect");
								clickElementText("runSaqORGraphicalSaqOption"+ j +"");
							} else
							{
								if (Incorrect.equals("chVal01"))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +": Correct");
								} else
								{
									logFAIL("runSaqORGraphicalSaqOption"+ j +": Attribute value of 'idx' is missing");
									assertFail();
								}
							}
						}
					} else {
						if (verifyElementPresent("SaqSubmitDisable") || verifyElementPresent("CertSubmitDisable"))
						{
							logINFO("None of the anwer options are Incorrect");
							TakeScreenshot("Pass-NoneOfTheAnwerOptionsAreIncorrect");
							clickElementText("runSaqORGraphicalSaqOption1");
						}
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							Thread.sleep(2000);
							break;
						} else
						{
							assertFail();
							break;
						}
					}
				}
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				} 
			}
			if (verifyElementPresent("runSaqORGraphicalSaqFeedbackBox"))
			{
				checkTextPresent("runSaqORGraphicalSaqFeedbackBox");
				WebElement element = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqFeedbackBox"));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				TakeScreenshot("Pass");
				//checkSelectedOption();
			} else
			{
				assertFail();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runGraphicalSaqIncorrect");
			logFAIL("The method runGraphicalSaqIncorrect failed (error)");
			assertFail();
		}
	}

	public static void runSaqORGraphicalSaq() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					{
						checkTextPresent("runSaqORGraphicalSaqOption"+ j +"");
						checkImagePresent("runSaqORGraphicalSaqOption"+ j +"Image");
						clickElement("runSaqORGraphicalSaqOption"+ j +"");
					} else {
						if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
						{
							TakeScreenshot("Pass");
							clickElementText("runSaqORGraphicalSaqSubmit");
							break;
						} else
						{
							break;
						}
					}
				}
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				} 
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runSaqORGraphicalSaq");
			logFAIL("The method runSaqORGraphicalSaq failed (error)");
			assertFail();
		}
	}

	public static void checkSelectedOption() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ j +""))
					{
						String CorrectORWrong = driver.findElement(objmap.getLocator("runSaqORGraphicalSaqOption"+ j +"")).getText();
						if (verifyElementPresent("saqRadioOption"+ j +""))
						{
							String Selected1 = driver.findElement(objmap.getLocator("saqRadioOption"+ j +"")).getAttribute("class");
							if (Selected1.contains("selected") && Selected1.contains("disabled"))
							{
								logINFO("saqRadioOption"+ j +": Selected & Disabled");
							} else
							{
								if (!Selected1.contains("selected") && Selected1.contains("disabled"))
								{
									logINFO("saqRadioOption"+ j +": Un-Selected & Disabled");
								} else
								{
									if (!Selected1.contains("disabled"))
									{
										TakeScreenshot("Fail-saqRadioOption"+ j +"Enabled");
										logFAIL("saqRadioOption"+ j +": Enabled (error)");
										assertFail();
									}
								}
							}
							if (CorrectORWrong.contains("Correct."))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
							} else
							{
								if (CorrectORWrong.contains("Wrong."))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
								} else
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
								}
							}
						}
						else if (verifyElementPresent("saqMultipleChoice"+ j +""))
						{
							String Selected2 = driver.findElement(objmap.getLocator("saqMultipleChoice"+ j +"")).getAttribute("class");
							if (Selected2.contains("selected") && Selected2.contains("disabled"))
							{
								logINFO("saqMultipleChoice"+ j +": Selected & Disabled");
							} else
							{
								if (!Selected2.contains("selected") && Selected2.contains("disabled"))
								{
									logINFO("saqMultipleChoice"+ j +": Un-Selected & Disabled");
								} else
								{
									if (!Selected2.contains("disabled"))
									{
										TakeScreenshot("Fail-saqMultipleChoice"+ j +"Enabled");
										logFAIL("saqMultipleChoice"+ j +": Enabled (error)");
										assertFail();
									}
								}
							}
							if (CorrectORWrong.contains("Correct."))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
							} else
							{
								if (CorrectORWrong.contains("Wrong."))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
								} else
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
								}
							}
						}
						else if (verifyElementPresent("saqCheckboxOption"+ j +""))
						{
							String Selected3 = driver.findElement(objmap.getLocator("saqCheckboxOption"+ j +"")).getAttribute("class");
							if (Selected3.contains("selected") && Selected3.contains("disabled"))
							{
								logINFO("saqCheckboxOption"+ j +": Selected & Disabled");
							} else
							{
								if (!Selected3.contains("selected") && Selected3.contains("disabled"))
								{
									logINFO("saqCheckboxOption"+ j +": Un-Selected & Disabled");
								} else
								{
									if (!Selected3.contains("disabled"))
									{
										TakeScreenshot("Fail-saqCheckboxOption"+ j +"Enabled");
										logFAIL("saqCheckboxOption"+ j +": Enabled (error)");
										assertFail();
									}
								}
							}
							if (CorrectORWrong.contains("Correct."))
							{
								logINFO("runSaqORGraphicalSaqOption"+ j +" - Tick/Correct Icon: Present");
							} else
							{
								if (CorrectORWrong.contains("Wrong."))
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +" - Cross/Wrong Icon: Present");
								} else
								{
									logINFO("runSaqORGraphicalSaqOption"+ j +" - No-CorrectORWrong Icon: Present");
								}
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkSelectedOption");
			logFAIL("The method checkSelectedOption failed (error)");
			assertFail();
		}
	}

	public static void runSaq() throws Exception {
		try {
			runSaqCorrect();
			if (FastYesNo.equals("No"))
			{
				resetPage();
				if (verifyElementPresent("Consultltr") || verifyElementPresent("Consultrtl"))
				{
					runConsult();
				}
				if (verifyElementPresent("Concernltr") || verifyElementPresent("Concernrtl"))
				{
					runConcern();
				}
				runSaqIncorrect();

				/*if (BranchingLesson.equals("No") && TileMenu.equals("No"))
						{
							clickBACK();
							if (verifyElementPresent("NEXTDisable"))
							{
								if (verifyElementPresent("takeLesson"))
								{
									clickElementText("takeLesson");
								} else {
									initialiseTemplates();
									runTemplates();
								}
							} else {
								clickNEXT();
								Thread.sleep(1000);
								if (verifyElementPresent("Consultltr") || verifyElementPresent("Consultrtl"))
								{
									runConsult();
								}
								else if (verifyElementPresent("Concernltr") || verifyElementPresent("Concernrtl"))
								{
									runConcern();
								}
							}
							runSaqIncorrect();
						}*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runSaq");
			logFAIL("The method runSaq failed (error)");
			assertFail();
		}
	}

	public static void runConcern() throws Exception {
		try {
			if (verifyElementPresent("MeterLevelBox"))
			{
				checkTextPresent("MeterLevelTitle"); 
				for (int k=1; k>=1; k++){
					if (verifyElementPresent("MeterLevel"+ k +""))
					{
						verifyElementTextPresent("MeterLevel"+ k +"");
					} else
					{
						break;
					}
				}
			}
			dragSlider("MeterDragPointer", 0, -50);
			TakeScreenshot("Pass");
			dragSlider("MeterDragPointer", 0, -80);
			TakeScreenshot("Pass");
			dragSlider("MeterDragPointer", 0, -120);
			TakeScreenshot("Pass");
			clickElementText("runSaqORGraphicalSaqSubmit");
			for (int i=1; i<=10; i++){
				if (verifyElementPresent("MeterLevel"+ i +"-TickorCrossIcon"))
				{
					String Correct = driver.findElement(objmap.getLocator("MeterLevel"+ i +"-TickorCrossIcon")).getAttribute("class");
					if(Correct.contains("correct"))
					{
						logINFO("Tick Icon : Present");
					} else
					{
						logINFO("Cross Icon : Present");
					}
				}
			}
			verifyElementTextPresent("ConcernSaqQuestionText");
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runConcern");
			logFAIL("The method runConcern failed (error)");
			assertFail();
		}
	}

	public static void checkMENULessonStatus() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("LandingPageNextButton"))
				{
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElement("LandingPageNextButton");
					String CurrentPageURL = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
					if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("scormdriver"))
					{
						TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
						logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
					}
				}
				if (verifyElementPresent("DesktopMenu"))
				{
					clickElement("DesktopMenu");
					TakeScreenshot("Pass");
					for (int i=1; i>=1; i++)
					{
						if (verifyElementPresent("Lesson" + i + ""))
						{
							getAttribute("Lesson" + i + "Status","alt");
						} else
						{
							clickElementText("DesktopReturnToCourse");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkMENULessonStatus");
			logFAIL("The method checkMENULessonStatus failed (error)");
			assertFail();
		}
	}

	public static void runMenu() throws Exception {
		try {
			for (int i=1; i>=1; i++)
			{
				if (verifyElementPresent("DesktopMenu"))
				{
					clickElement("DesktopMenu");
					TakeScreenshot("Pass");
				} else
				{
					if (verifyElementPresent("LandingPageNextButton"))
					{
						clickElement("LandingPageNextButton");
						clickElement("DesktopMenu");
						TakeScreenshot("Pass");
					}
				}
				if (verifyElementPresent("Lesson" + i + ""))
				{
					try {
						getAttribute("Lesson" + i + "Status","alt");
						checkTextPresent("Lesson" + i + "");
						String PreviousPageURL = driver.getCurrentUrl();
						//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
						driver.findElement(objmap.getLocator("Lesson" + i + "")).click();
						logINFO("Lesson" + i + ": Clicked");
						if (verifyElementPresent("LandingPageNextButton"))
						{
							TakeScreenshot("Pass");
							clickElement("LandingPageNextButton");
							String CurrentPageURL = driver.getCurrentUrl();
							//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
							if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("/page/0") && !CurrentPageURL.contains("scormdriver")) // Condition of "/page/0" is used for the very 1st visit of module where the Previous & Current URl is same.
							{
								TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
								logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
							}
							logINFO("Lesson" + i + " - Landing Page Template: Present");
						} else
						{
							if (verifyElementPresent("PageNumberIndicator") || verifyElementPresent("CopyrightIndicator"))
							{
								TakeScreenshot("Pass");
								checkTextPresent("PageNumberIndicator");
								String CurrentPageURL = driver.getCurrentUrl();
								//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
								if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("/page/0") && !CurrentPageURL.contains("scormdriver"))
								{
									TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
									logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
								}
							}
						}
						for (int j=1; j>=1; j++)
						{
							if (verifyElementPresent("Topic" + j + ""))
							{
								TakeScreenshot("Pass");
								getAttribute("Topic" + j + "Status","alt");
								clickElementText("Topic" + j + "");
								String CurrentPageURL = driver.getCurrentUrl();
								//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
								if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("/page/0") && !CurrentPageURL.contains("scormdriver"))
								{
									TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
									logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
								}
								TakeScreenshot("Pass");
								checkTextPresent("PageNumberIndicator");
								clickElement("DesktopMenu");
								driver.findElement(objmap.getLocator("Lesson" + i + "")).click();
							} else
							{
								break;
							}
						}
					} catch (Exception e)
					{
						//e.printStackTrace();
						logFAIL("Lesson" + i + " - Inactive");
						break;
					}
				} else
				{
					break;
				}
			}
			clickElement("Lesson1");
			Thread.sleep(2000);
			if (verifyElementPresent("Topic1"))
			{
				clickElement("Topic1");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runMenu");
			logFAIL("The method runMenu failed (error)");
			assertFail();
		}
	}

	public static void checkDropBoxHeadingTitleAndImage() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("DropItemNo" + i + ""))
					{
						checkImagePresent("DropBox" + i + "HeadingImage");
						checkTextPresent("DropBox" + i + "HeadingTitle");
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkDropBoxHeadingTitleAndImage");
			logFAIL("The method checkDropBoxHeadingTitleAndImage failed (error)");
			assertFail();
		}
	}

	public static void checkDragBoxInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int j=1; j>=1; j++)
				{
					if (verifyElementPresent("DropItemNo" + j + ""))
					{
						for (int k=1; k>=1; k++)
						{
							if (verifyElementPresent("DragBox" + k + "InsideDropBox" + j + ""))
							{
								checkImagePresent("DragBox" + k + "ImageInsideDropBox" + j + "");
								checkTextPresent("DragBox" + k + "TextInsideDropBox" + j + "");
								if (verifyElementPresent("DragBox" + k + "-TickORCross-InsideDropBox" + j + ""))
								{
									String Correct = driver.findElement(objmap.getLocator("DragBox" + k + "-TickORCross-InsideDropBox" + j + "")).getAttribute("class");
									if (Correct.contains("correct"))
									{
										logINFO("Tick/Correct Icon : Present");
									} else
									{
										if (Correct.contains("wrong"))
										{
											logINFO("Cross/Wrong Icon : Present");
										} else
										{
											TakeScreenshot("Fail-DragBox" + k + "TickORCrossInsideDropBox" + j + "NotPresent");
											logFAIL("DragBox" + k + "-TickORCross-InsideDropBox" + j + ": Not-Found on Page (error)");
										}
									}
								}
							} else
							{
								break;
							}
						}
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkDragBoxInsideDropBox");
			logFAIL("The method checkDragBoxInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void checkFlagImageandTickCrossInsideDropBox() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("DropBoxNo" + i + ""))
					{
						driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
						verifyElementImagePresent("FlagImageInsideDropBox" + i + "");
						if (verifyElementPresent("TickORCross-InsideDropBox" + i + ""))
						{
							String Correct = driver.findElement(objmap.getLocator("TickORCross-InsideDropBox" + i + "")).getAttribute("class");
							if (Correct.contains("correct"))
							{
								logINFO("Tick/Correct Icon : Present");
							} else
							{
								if (Correct.contains("wrong"))
								{
									logINFO("Cross/Wrong Icon : Present");
								} else
								{
									TakeScreenshot("Fail-TickORCrossInsideDropBox" + i + "NotFound");
									logFAIL("TickORCross-InsideDropBox" + i + ": Not-Found on Page (error)");
								}
							}
						} 
					} else
					{
						break;
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkFlagImageandTickCrossInsideDropBox");
			logFAIL("The method checkFlagImageandTickCrossInsideDropBox failed (error)");
			assertFail();
		}
	}

	public static void runDnDWithoutFlagIncorrect() throws Exception {
		try {
			TakeScreenshot("Pass");
			checkDropBoxHeadingTitleAndImage();
			for (int i=1; i>=1; i++){
				if (!verifyElementPresent("DragItemNo"+ i +""))
				{
					//
				} else
				{
					for (int j=1; j>=1; j++){
						if (verifyElementPresent("DragItemNo"+ i +""))
						{
							checkImagePresent("DragBox" + i + "Image");
							checkTextPresent("DragBox" + i + "Text");
							for (int k=1; k>=1; k++){
								String TargetDropBox = driver.findElement(objmap.getLocator("DragItemNo"+ i +"")).getAttribute("idx");
								String DropBoxNumber = driver.findElement(objmap.getLocator("DropItemNo"+ k +"")).getAttribute("id");
								if (TargetDropBox.equals(DropBoxNumber))
								{
									if (verifyElementPresent("DropItemNo"+ (k=k+1) +""))
									{
										DragandDrop("DragItemNo"+ i +"", "DropItemNo"+ k +"");
										i--;
										break;
									}
									else if (verifyElementPresent("DropItemNo"+ (k=k-2) +""))
									{
										DragandDrop("DragItemNo"+ i +"", "DropItemNo"+ k +"");
										i--;
										break;
									}
								}
								else if (!TargetDropBox.equals(DropBoxNumber))
								{
									if (verifyElementPresent("DropItemNo"+ k +""))
									{
										DragandDrop("DragItemNo"+ i +"", "DropItemNo"+ k +"");
										i--;
										break;
									}
								}
							}
						} else
						{
							break;
						}
					} 
					break;
				} 
			}
			checkDragBoxInsideDropBox();
			TakeScreenshot("Pass");
			checkDDwithoutFlagSubmit();
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-runDnDWithoutFlagIncorrect");
			logFAIL("The runDnDWithoutFlagIncorrect method failed (error)");
			assertFail();
		}
	}

	public static void runDnDWithoutFlag() throws Exception {
		try {
			runDnDWithoutFlagCorrect();
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("DropItemNo1"))
				{
					resetPage();
					runDnDWithoutFlagIncorrect();
				}

				/*if (verifyElementPresent("DropItemNo1") && BranchingLesson.equals("No") && TileMenu.equals("No"))
						{
							clickBACK();
							if (verifyElementPresent("NEXTDisable"))
							{
								if (verifyElementPresent("takeLesson"))
								{
									clickElementText("takeLesson");
								} else {
									initialiseTemplates();
									runTemplates();
								}
							} else {
								clickNEXT();
							}
							runDnDWithoutFlagIncorrect();
						}*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runDnDWithoutFlag");
			logFAIL("The method runDnDWithoutFlag failed (error)");
			assertFail();
		}
	}

	public static void runDnDWithoutFlagCorrect() throws Exception {
		SAQYesNo = "Yes";
		try {
			TakeScreenshot("Pass");
			checkDropBoxHeadingTitleAndImage();
			for (int i=1; i>=1; i++){
				if (!verifyElementPresent("DragItemNo"+ i +""))
				{
					//
				} else
				{
					for (int j=1; j>=1; j++){
						if (verifyElementPresent("DragItemNo"+ i +""))
						{
							checkImagePresent("DragBox" + i + "Image");
							checkTextPresent("DragBox" + i + "Text");

							String DropBox = driver.findElement(objmap.getLocator("DragItemNo"+ i +"")).getAttribute("idx");
							if (!isElementPresent(By.id(DropBox)))
							{
								TakeScreenshot("Fail-"+DropBox+"DropBoxNotPresent");
								logFAIL("DragItemNo"+ i +" - Correct - "+DropBox+" Not-Present (error)");
							}
							WebElement target = driver.findElement(By.id(DropBox));
							WebElement element = driver.findElement(objmap.getLocator("DragItemNo"+ i +""));
							(new Actions(driver)).dragAndDrop(element, target).perform();
							Thread.sleep(2000);
							logINFO("DragItemNo"+ i +" - DROPPPED IN - "+DropBox+"");
							TakeScreenshot("Pass");
							i--;
						} else
						{
							break;
						}
					} break;
				} 
			}
			checkDragBoxInsideDropBox();
			TakeScreenshot("Pass");
			checkDDwithoutFlagSubmit();
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-runDnDWithoutFlagCorrect");
			logFAIL("The runDnDWithoutFlagCorrect method failed (error)");
			assertFail();
		}
	}

	public static void checkDDwithoutFlagSubmit() throws Exception {
		try {
			for (int m=1; m>=1; m++){
				clickElementText("runSaqORGraphicalSaqSubmit");
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				}
			}
			checkTextPresent("FeedbackBox");
			WebElement element = driver.findElement(objmap.getLocator("FeedbackBox"));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			TakeScreenshot("Pass");
			checkDragBoxInsideDropBox();
			if (verifyElementPresent("CorrectAnswersORMyAnswers"))
			{
				clickElementText("CorrectAnswersORMyAnswers");
				checkDragBoxInsideDropBox();
				TakeScreenshot("Pass");
				if (verifyElementPresent("CorrectAnswersORMyAnswers"))
				{
					clickElementText("CorrectAnswersORMyAnswers");
					checkDragBoxInsideDropBox();
					TakeScreenshot("Pass");
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-checkDDwithoutFlagSubmit");
			logFAIL("The checkDDwithoutFlagSubmit method failed (error)");
			assertFail();
		}
	}

	public static void runDnDWithFlagIncorrect() throws Exception {
		try {
			TakeScreenshot("Pass");
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("DropBoxNo"+ i +""))
				{
					driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
					verifyElementTextPresent("DropBoxNo"+ i +"");
					for (int k=1; k>=1; k++){
						String TargetDragItem = driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).getAttribute("idx");
						String DragItemNumber = driver.findElement(objmap.getLocator("DropItemNo"+ k +"")).getAttribute("id");
						if (TargetDragItem.equals(DragItemNumber))
						{
							if (verifyElementPresent("DropItemNo"+ (k=k+1) +""))
							{
								verifyElementImagePresent("DropItemNo"+ k +"Image");
								DragandDrop("DropItemNo"+ k +"", "DropBoxNo"+ i +"");
								break;
							}
							else if (verifyElementPresent("DropItemNo"+ (k=k-2) +""))
							{
								verifyElementImagePresent("DropItemNo"+ k +"Image");
								DragandDrop("DropItemNo"+ k +"", "DropBoxNo"+ i +"");
								break;
							}
						}
						else if (!TargetDragItem.equals(DragItemNumber))
						{
							if (verifyElementPresent("DropItemNo"+ k +""))
							{
								verifyElementImagePresent("DropItemNo"+ k +"Image");
								DragandDrop("DropItemNo"+ k +"", "DropBoxNo"+ i +"");
								break;
							}
						}
					}
				} else
				{
					break;
				}
			}
			checkDDwithFlagSubmit();
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-runDnDWithFlagIncorrect");
			logFAIL("The runDnDWithFlagIncorrect method failed (error)");
			assertFail();
		}
	}

	public static void runDnDWithFlag() throws Exception {
		try {
			runDnDWithFlagCorrect();
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("DropItemNo1"))
				{
					resetPage();
					runDnDWithFlagIncorrect();
				}

				/*if (verifyElementPresent("DropItemNo1") && BranchingLesson.equals("No") && TileMenu.equals("No"))
						{
							clickBACK();
							if (verifyElementPresent("NEXTDisable"))
							{
								if (verifyElementPresent("takeLesson"))
								{
									clickElementText("takeLesson");
								} else {
									initialiseTemplates();
									runTemplates();
								}
							} else {
								clickNEXT();
							}
							runDnDWithFlagIncorrect();
						}*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runDnDWithoutFlag");
			logFAIL("The method runDnDWithoutFlag failed (error)");
			assertFail();
		}
	}

	public static void runDnDWithFlagCorrect() throws Exception {
		SAQYesNo = "Yes";
		try {
			TakeScreenshot("Pass");
			for (int i=1; i>=1; i++){
				if (verifyElementPresent("DropBoxNo"+ i +""))
				{
					driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).click();
					verifyElementTextPresent("DropBoxNo"+ i +"");
					String DragItem = driver.findElement(objmap.getLocator("DropBoxNo"+ i +"")).getAttribute("idx");
					if (!isElementPresent(By.id(DragItem)))
					{
						TakeScreenshot("Fail-"+DragItem+"DragImageNotPresent");
						logFAIL("DropBoxNo"+ i +" - Correct - "+DragItem+" Drag Image Not-Present (error)");
					}
					verifyElementImagePresent(""+DragItem+"Image");
					WebElement element = driver.findElement(By.id(DragItem));
					WebElement target = driver.findElement(objmap.getLocator("DropBoxNo"+ i +""));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
					Thread.sleep(500);
					(new Actions(driver)).dragAndDrop(element, target).perform();
					Thread.sleep(2000);
					logINFO(""+DragItem+"Image - DROPPPED IN - DropBoxNo"+ i +"");
					TakeScreenshot("Pass");
				} else
				{
					break;
				}
			}
			checkDDwithFlagSubmit();
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-runDnDWithFlagCorrect");
			logFAIL("The runDnDWithFlagCorrect method failed (error)");
			assertFail();
		}
	}

	public static void checkDDwithFlagSubmit() throws Exception {
		try {
			for (int m=1; m>=1; m++){
				clickElementText("runSaqORGraphicalSaqSubmit");
				if (verifyElementPresent("runSaqORGraphicalSaqRetakeAlertBox"))
				{
					verifyElementTextPresent("runSaqORGraphicalSaqRetakeAlertBox");
					TakeScreenshot("Pass");
					clickElementText("runSaqORGraphicalSaqRetakeAlertBoxClose");
				} else
				{
					break;
				}
			}
			checkTextPresent("FeedbackBox");
			WebElement element = driver.findElement(objmap.getLocator("FeedbackBox"));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			TakeScreenshot("Pass");
			checkFlagImageandTickCrossInsideDropBox();
			if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
			{
				clickElementText("runSaqORGraphicalSaqSubmit");
				checkFlagImageandTickCrossInsideDropBox();
				TakeScreenshot("Pass");
				if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
				{
					clickElementText("runSaqORGraphicalSaqSubmit");
					checkFlagImageandTickCrossInsideDropBox();
					TakeScreenshot("Pass");
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			TakeScreenshot("Fail-Method-checkDDwithFlagSubmit");
			logFAIL("The checkDDwithFlagSubmit method failed");
			assertFail();
		}
	}

	public static void runCarousel() throws Exception {
		try {
			if (verifyElementPresent("CarouselMusicONOFF"))
			{
				clickElement("CarouselMusicONOFF");
				logINFO("Music On/Off button: Present" );
			} else
			{
				logINFO("Music On/Off button: Not-Present" ); 
			}

			if (verifyElementPresent("CarouselAutoPlayONOFF"))
			{
				clickElement("CarouselAutoPlayONOFF");
				clickElement("CarouselAutoPlayONOFF");
				for (int i=1; i>=1; i++)
				{
					if (verifyElementPresent("CarouselSlide" + i + "-Bubble"))
					{
						clickElement("CarouselSlide" + i + "-Bubble");
						Thread.sleep(200);
						if (verifyElementPresent("CarouselSlide-Next"))
						{
							clickElement("CarouselSlide-Next");
							Thread.sleep(200);
							clickElement("CarouselSlide-Back");
							Thread.sleep(200);
						}
						TakeScreenshot("Pass");
						checkTextPresent("CarouselSlide" + i + "-Title");
						checkTextPresent("CarouselSlide" + i + "-MainContent1");
						checkTextPresent("CarouselSlide" + i + "-MainContent2");
						checkTextPresent("CarouselSlide" + i + "-MainContent3");
						checkImagePresent("CarouselSlide" + i + "-MainImage");
						checkPageAudio();
					} else
					{
						break;
					}
				}
			} else
			{
				checkTextPresent("CarouselSlide1-Title");
				checkTextPresent("CarouselSlide1-MainContent1");
				checkTextPresent("CarouselSlide1-MainContent2");
				checkTextPresent("CarouselSlide1-MainContent3");
				checkImagePresent("CarouselSlide1-MainImage");
				checkPageAudio();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCarousel");
			logFAIL("The method runCarousel failed (error)");
			assertFail();
		}
	}

	public static void runVideoMode() throws Exception {
		try {
			checkNEXTDisable();
			checkTextPresent("DesktopLessonTitle");
			checkTextPresent("TopicTitle2");

			TakeScreenshot("Pass");
			if (verifyElementPresent("VideoPlayButtonOnVideoScreen"))
			{
				TakeScreenshot("Pass");
				clickElement("VideoPlayButtonOnVideoScreen");
			}
			if (verifyElementPresent("VideoBufferImage"))
			{
				TakeScreenshot("Pass");
				logINFO("VideoBufferImage: Present");
				checkInvisibilityOfElement(180, "VideoBufferImage");
				if (verifyElementPresent("VideoError"))
				{
					TakeScreenshot("Fail-ErrorMessageOnVideoScreen");
					logFAIL("Video Screen Showing Error Message (error)");
				}
			}
			TakeScreenshot("Pass");
			if (!verifyElementPresent("VideoRePlayButtonOnVideoScreen"))
			{
				checkVisibilityOfElement(600, "VideoRePlayButtonOnVideoScreen");
				TakeScreenshot("Pass");
			}
			Thread.sleep(2000);
			if (verifyElementPresent("SwitchToText"))
			{
				clickElementText("SwitchToText");
				TakeScreenshot("Pass");
			}

			Thread.sleep(2000);
			if (FastYesNo.equals("No"))
			{
				clickElement("VideoScreen-Chrome");
				//clickElement("VideoScreen-FF");
				if (verifyElementPresent("VideoError"))
				{
					TakeScreenshot("Fail-ErrorMessageOnVideoScreen");
					logFAIL("Video Screen Showing Error Message (error)");
				}

				if (verifyElementPresent("Video-CCbuttonOFF"))
				{
					clickElement("Video-CCbuttonOFF");
					clickElement("VideoScreen-Chrome");
					checkVisibilityOfElement(180, "ClosedCaption(CC)");
					verifyElementTextPresent("ClosedCaption(CC)");
					TakeScreenshot("Pass");
					clickElement("VideoScreen-Chrome");
				} else if (verifyElementPresent("Video-CCbuttonON"))
				{
					clickElement("Video-CCbuttonON");
					clickElement("Video-CCbuttonOFF");
					clickElement("VideoScreen-Chrome");
					checkVisibilityOfElement(180, "ClosedCaption(CC)");
					verifyElementTextPresent("ClosedCaption(CC)");
					TakeScreenshot("Pass");
					clickElement("VideoScreen-Chrome");
				}

				String VideoTotalTime = driver.findElement(objmap.getLocator("Video-TotalTime")).getText();
				logINFO("Video-TotalTime = "+ VideoTotalTime +"");
				if (VideoTotalTime.equals("00:00") || VideoTotalTime.equals(""))
				{
					TakeScreenshot("Fail-VideoFileNotPresent");
					logFAIL("Video File: Not-Present (error)");
				} else
				{
					logINFO("Video File: Present");
				}

				String VideoPlayTime = driver.findElement(objmap.getLocator("Video-PlayTime")).getText();
				logINFO("Video-PlayTime = "+ VideoPlayTime +"");
				if (VideoPlayTime.equals("00:00") || VideoPlayTime.equals(""))
				{
					TakeScreenshot("Fail-VideoNotPlaying");
					logFAIL("Video Playing: Not-Present (error)");
				} else
				{
					logINFO("Video Playing: Present");
				}
				//verifyElementPresent("Video-Scrubber");
				//verifyElementPresent("Video-ScrubberDragPointer");
				if (verifyElementPresent("Video-VolumeButton"))
				{
					clickElement("Video-VolumeButton");
					verifyElementPresent("Video-VolumeButton");
					verifyElementPresent("Video-VolumeScrubber");
					verifyElementPresent("Video-VolumeScrubberDragPointer");
				}

				if (verifyElementPresent("Video-FullScreenButton"))
				{
					clickElement("Video-FullScreenButton");
					TakeScreenshot("Pass");
					clickElement("Video-FullScreenButton");
				}

				checkBulletin();
				checkHelp();
			}
			if (verifyElementPresent("SwitchToText"))
			{
				clickElementText("SwitchToText");
				TakeScreenshot("Pass");
			}

		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runVideoMode");
			logFAIL("The method runVideoMode failed (error)");
			assertFail();
		}
	}

	public static void runVideoTextMode() throws Exception {
		try {
			logINFO("VideoTextSlide0/1: Present");
			checkNEXTDisable();
			TakeScreenshot("Pass");
			checkTextPresent("DesktopLessonTitle");
			checkTextPresent("TopicTitle-VideoTextSlide1");
			checkTextPresent("MainContent-VideoTextSlide1");
			checkImagePresent("MainImage-VideoTextSlide1");
			checkPageAudio();
			for (int i=2; i>=2; i++)
			{
				if (verifyElementPresent("VideoTextSlide" + i + ""))
				{
					clickElementText("VideoTextSlide" + i + "");
					checkNEXTDisable();
					TakeScreenshot("Pass");
					checkTextPresent("DesktopLessonTitle");
					checkTextPresent("TopicTitle-VideoTextSlide" + i + "");
					checkTextPresent("MainContent-VideoTextSlide" + i + "");
					checkImagePresent("MainImage-VideoTextSlide" + i + "");
					checkPageAudio();
					clickElementText("VideoSlide-Previous");	
					clickElementText("VideoSlide-Next");
					if (verifyElementPresent("VideoSlide-NextDisabled"))
					{
						break;
					}
				} else
				{
					break;
				}
			}
			checkBulletin();
			//checkHelp();
			if (verifyElementPresent("SwitchToVideo"))
			{
				clickElement("SwitchToVideo");
				TakeScreenshot("Pass");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runVideoTextMode");
			logFAIL("The method runVideoTextMode failed (error)");
			assertFail();
		}
	}

	public static void rerunBranchingLessonORTileMenuForSAQIncorrect() throws Exception {
		try {
			for (int i=1; i>=1; i++){
				if (!verifyElementPresent("BranchingLesson") && !verifyElementPresent("TileMenu"))
				{
					if (verifyElementPresent("Saqltr") || verifyElementPresent("Saqrtl"))
					{
						runSaqIncorrect();
						clickNEXT();
					}
					else if (verifyElementPresent("GraphicalSaq"))
					{
						runGraphicalSaqIncorrect();
						clickNEXT();
					}
					else if (verifyElementPresent("DragandDrop"))
					{
						if (verifyElementPresent("DragContainer"))
						{
							logINFO("Drag and Drop without Flag Template: Present");
							runDnDWithoutFlagIncorrect();
							clickNEXT();
						}
						else if (verifyElementPresent("DropBoxNo1"))
						{
							logINFO("Drag and Drop with Flag Template: Present");
							runDnDWithFlagIncorrect();
							clickNEXT();
						}
					}
					else if (verifyElementPresent("Consultltr") || verifyElementPresent("Consultrtl"))
					{
						runConsult();
						runSaqIncorrect();
						clickNEXT();
					}
					else if (verifyElementPresent("Concernltr") || verifyElementPresent("Concernrtl"))
					{
						runConcern();
						runSaqIncorrect();
						clickNEXT();
					}
					else if (verifyElementPresent("Adaptiveltr") && verifyElementPresent("takeLesson"))
					{
						clickElementText("takeLesson");
					} else
					{
						clickNEXT();
						Thread.sleep(300); 
					}
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runBranchingLessonForSAQIncorrect");
			logFAIL("The method runBranchingLessonForSAQIncorrect failed (error)");
			assertFail();
		}
	}

	public static void clickNEXTwithTimer() throws Exception {
		try {
			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				handleConnectionLostMessageBox();
			} else
			{
				if (verifyElementPresent("NEXTDisable") || verifyElementPresent("NEXTLock"))
				{
					if (BranchingLesson.equals("Yes"))
					{
						checkBranchingLessonStausOnBottomNavbar();
					}
					if (AdaptiveLesson.equals("Yes"))
					{
						checkAdaptiveLessonStausOnBottomNavbar();
					}						
					if (verifyElementPresent("PageTimerTotal"))
					{
						checkTextPresent("PageTimerTotal");
						checkTextPresent("PageTimerRunning");
						if (verifyElementPresent("NEXTLock"))
						{
							checkInvisibilityOfElement(1000, "NEXTLock");
						}
						Thread.sleep(200);
						if (verifyElementPresent("NEXTDisable"))
						{
							checkInvisibilityOfElement(1000, "NEXTDisable");
						}
						checkTextPresent("PageTimerCompleted");
					}
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElementText("NEXTEnable");
					Thread.sleep(100);
					if (verifyElementPresent("ConnectionLostMessageBox"))
					{
						handleConnectionLostMessageBox();
					}
					String CurrentPageURL = driver.getCurrentUrl();
					if (PreviousPageURL.equals(CurrentPageURL))
					{
						Thread.sleep(3000);
					}
					//Thread.sleep(3000);
					if (verifyElementPresent("BulletinClose"))
					{
						Thread.sleep(1000);
						clickElement("BulletinClose");
						TakeScreenshot("Fail-BulletinIconNotPresent");
						logFAIL("Bulletin Icon : Missing on Page (error)");
						assertFail();
						Thread.sleep(1000);
						clickNEXT();
						Thread.sleep(1000);
					}
					String CurrentPageURL1 = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
					if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
					{
						if (!verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAILED("PreviousPage-URL and CurrentPage-URL is Same (error)");
							clickElement("DesktopExit");
							Thread.sleep(3000);
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
							//lcecLogout();
						}
					}
				} else
				{
					if (BranchingLesson.equals("Yes"))
					{
						checkBranchingLessonStausOnBottomNavbar();
					}
					if (AdaptiveLesson.equals("Yes"))
					{
						checkAdaptiveLessonStausOnBottomNavbar();
					}
					checkTextPresent("Course/Page-TimerIndicator");
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElementText("NEXTEnable");
					Thread.sleep(100);
					if (verifyElementPresent("ConnectionLostMessageBox"))
					{
						handleConnectionLostMessageBox();
					}
					String CurrentPageURL = driver.getCurrentUrl();
					if (PreviousPageURL.equals(CurrentPageURL))
					{
						Thread.sleep(3000);
					}
					//Thread.sleep(3000);
					if (verifyElementPresent("BulletinClose"))
					{
						Thread.sleep(1000);
						clickElement("BulletinClose");
						Thread.sleep(1000);
						TakeScreenshot("Fail-BulletinIconNotPresent");
						logFAIL("Bulletin Icon : Missing on Page (error)");
						assertFail();
						clickNEXT();
						Thread.sleep(1000);
					}
					String CurrentPageURL1 = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
					if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
					{
						if (!verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAILED("PreviousPage-URL and CurrentPage-URL is Same (error)");
							clickElement("DesktopExit");
							Thread.sleep(3000);
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
							//lcecLogout();
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickNEXTwithTimer");
			logFAILED("The method clickNEXTwithTimer failed (error)");
			clickElement("DesktopExit");
			Thread.sleep(3000);
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			writeExcelData(8, ExcelRowNumber, "Fail");
			Assert.fail();
		}
	}

	public static void clickNEXTbutton() throws Exception {
		try {
			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				handleConnectionLostMessageBox();
			} else
			{
				if (verifyElementPresent("NEXTDisable") || verifyElementPresent("NEXTLock"))
				{
					TakeScreenshot("Fail-NEXTDisable");
					logFAILED("NEXTDisable : Present (error)");
					clickElement("DesktopExit");
					Thread.sleep(3000);
					driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
					writeExcelData(8, ExcelRowNumber, "Fail");
					Assert.fail();
					//logFAIL("Automation ended forcefully because the 'NEXT' button found disabled on Page");
					//CloseBrowser();
				} else
				{
					if (BranchingLesson.equals("Yes"))
					{
						checkBranchingLessonStausOnBottomNavbar();
					}
					if (AdaptiveLesson.equals("Yes"))
					{
						checkAdaptiveLessonStausOnBottomNavbar();
					}
					String PreviousPageURL = driver.getCurrentUrl();
					//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
					clickElementText("NEXTEnable");
					Thread.sleep(100);
					if (verifyElementPresent("ConnectionLostMessageBox"))
					{
						handleConnectionLostMessageBox();
					}
					String CurrentPageURL = driver.getCurrentUrl();
					if (PreviousPageURL.equals(CurrentPageURL))
					{
						Thread.sleep(3000);
					}
					//Thread.sleep(3000);
					String CurrentPageURL1 = driver.getCurrentUrl();
					//logINFO("CurrentPage-URL = " + CurrentPageURL1 + "");
					if (PreviousPageURL.equals(CurrentPageURL1) && !CurrentPageURL1.contains("scormdriver"))
					{
						if (!verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAILED("PreviousPage-URL and CurrentPage-URL is Same (error)");
							clickElement("DesktopExit");
							Thread.sleep(3000);
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							writeExcelData(8, ExcelRowNumber, "Fail");
							Assert.fail();
							//lcecLogout();
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickNEXTbutton");
			logFAILED("The method clickNEXTbutton failed (error)");
			clickElement("DesktopExit");
			Thread.sleep(3000);
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			writeExcelData(8, ExcelRowNumber, "Fail");
			Assert.fail();
		}
	}

	public static void checkBranchingLessonStausOnBottomNavbar() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("BranchingStausOnBottomNavbar-BranchingIcon") && verifyElementPresent("BranchingStausOnBottomNavbar-Number"))
				{
					String BranchingStatus = driver.findElement(objmap.getLocator("BranchingStausOnBottomNavbar-Number")).getText();
					String BranchingStatusRequiredNumber = driver.findElement(objmap.getLocator("BranchingStausOnBottomNavbar-RequiredNumber")).getText();
					String BranchingStatusTotalNumber = driver.findElement(objmap.getLocator("BranchingStausOnBottomNavbar-TotalNumber")).getText();
					if (BranchingStatus.equals("") || BranchingStatusRequiredNumber.equals("") || BranchingStatusTotalNumber.equals(""))
					{
						TakeScreenshot("Fail-BranchingStausOnBottomNavbarNotPresent");
						logFAIL("BranchingStausOnBottomNavbar: Not-Present");
					} else
					{
						verifyElementTextPresent("BranchingStausOnBottomNavbar-Number");
					}
				}

				else if (verifyElementPresent("BranchingStausOnBottomNavbar-CompletedIcon"))
				{
					logINFO("BranchingStausOnBottomNavbar-CompletedIcon: Present");
					verifyElementTextPresent("BranchingStausOnBottomNavbar-CompletedText");
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkBranchingLessonStausOnBottomNavbar");
			logFAIL("The method checkBranchingLessonStausOnBottomNavbar failed (error)");
			assertFail();
		}
	}

	public static void checkAdaptiveLessonStausOnBottomNavbar() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				if (verifyElementPresent("AdaptiveStausOnBottomNavbar-AdaptiveIcon") || verifyElementPresent("AdaptiveStausOnBottomNavbar-Number") || verifyElementPresent("AdaptiveStausOnBottomNavbar-LessonText"))
				{
					if (verifyElementPresent("AdaptiveStausOnBottomNavbar-AdaptiveIcon"))
					{
						logINFO("AdaptiveStausOnBottomNavbar-AdaptiveIcon: Present");
					} else {
						TakeScreenshot("Fail-AdaptiveStausOnBottomNavbarAdaptiveIconNotPresent");
						logFAIL("AdaptiveStausOnBottomNavbar-AdaptiveIcon: Not-Present");
					}

					if (verifyElementPresent("AdaptiveStausOnBottomNavbar-Number"))
					{
						String AdaptiveStatus = driver.findElement(objmap.getLocator("AdaptiveStausOnBottomNavbar-Number")).getText();
						String AdaptiveStatusRequiredNumber = driver.findElement(objmap.getLocator("AdaptiveStausOnBottomNavbar-RequiredNumber")).getText();
						String AdaptiveStatusTotalNumber = driver.findElement(objmap.getLocator("AdaptiveStausOnBottomNavbar-TotalNumber")).getText();
						if (AdaptiveStatus.equals("") || AdaptiveStatusRequiredNumber.equals("") || AdaptiveStatusTotalNumber.equals(""))
						{
							TakeScreenshot("Fail-AdaptiveStausOnBottomNavbarNumberNotPresent");
							logFAIL("AdaptiveStausOnBottomNavbarNumber: Not-Present");
						} else
						{
							verifyElementTextPresent("AdaptiveStausOnBottomNavbar-Number");
						}
					}
					else if (verifyElementPresent("AdaptiveStausOnBottomNavbar-LessonText"))
					{
						checkTextPresent("AdaptiveStausOnBottomNavbar-LessonText");
					} else {
						TakeScreenshot("Fail-AdaptiveStausOnBottomNavbarLessonTextNotPresent");
						logFAIL("AdaptiveStausOnBottomNavbar-LessonText: Not-Present");
					}

				}

				else if (verifyElementPresent("AdaptiveStausOnBottomNavbar-CompletedIcon") || verifyElementPresent("AdaptiveStausOnBottomNavbar-CompletedText"))
				{
					logINFO("AdaptiveStausOnBottomNavbar-CompletedIcon: Present");
					verifyElementTextPresent("AdaptiveStausOnBottomNavbar-CompletedText");
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkAdaptiveLessonStausOnBottomNavbar");
			logFAIL("The method checkAdaptiveLessonStausOnBottomNavbar failed (error)");
			assertFail();
		}
	}

	public static void runAdaptive() throws Exception {
		try {
			AdaptiveLesson = "Yes";
			checkAdaptiveLessonStausOnBottomNavbar();
			TakeScreenshot("Pass");
			checkBulletin();
			checkHelp();
			checkPageAudio();

			String disabled = driver.findElement(objmap.getLocator("takeAssessment")).getAttribute("class");
			if (disabled.contains("disabled"))
			{
				clickElementText("takeLesson");
				Thread.sleep(1000);
			} else {
				clickElementText("takeAssessment");
				Thread.sleep(1000);
				for (int i=1; i>=1; i++){
					if (verifyElementPresent("runSaqORGraphicalSaqOption"+ i +""))
					{
						checkBulletin();
						checkHelp();
						checkPageAudio();
						checkAdaptiveLessonStausOnBottomNavbar();
						runSaqIncorrect();
						//runSaqCorrect();
					} else{
						break;
					}
				}
				TakeScreenshot("Pass");
				checkPageAudio();
				checkAdaptiveLessonStausOnBottomNavbar();
				checkBulletin();
				checkHelp();
				clickElementText("viewLesson/viewWrapUp");
			}

			initialiseTemplates();
			for (int i=1; i>=1; i++) {
				if (verifyElementPresent("PageNumberIndicator"))
				{
					handleConnectionLostMessageBox();
					runTemplatesTestNGxml();
				} else
				{
					break;
				}
			}

			TakeScreenshot("Pass");
			checkPageAudio();
			checkBulletin();
			//checkHelp();
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runAdaptive");
			logFAIL("The method runAdaptive failed (error)");
			assertFail();
		}
	}

	public static void runCertIntroPages() throws Exception {
		try {
			checkBACKDisable();
			for (int j=1; j>=1;){
				if (verifyElementPresent("CertIntroPage" + j + ""))
				{
					logINFO("##### Cert Intro Page #" + j + " #####");
					checkNEXTDisable();
					TakeScreenshot("Pass");
					checkTextPresent("DesktopLessonTitle");
					checkTextPresent("TopicTitle2");
					checkTextPresent("MainContent1");
					checkTextPresent("PageNumberIndicator");
					checkElementPresent("ProgressIndicator");
					checkTextPresent("Course/Page-TimerIndicator");
					TakeScreenshot("Pass");
					clickNEXT();
				} else
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertIntroPages");
			logFAIL("The method runCertIntroPages failed (error)");
			assertFail();
		}
	}

	public static void clickExit() throws Exception {
		try {
			clickElement("DesktopExit");
			if (Quiz.equals("Yes"))
			{
				if (verifyElementPresent("ExitAlertBox"))
				{
					verifyElementTextPresent("ExitAlertMessage");
					TakeScreenshot("Pass");
					clickElementText("ExitButtonAlertBox");
				} else
				{
					logINFO("ExitAlertBox : Not-Present (No-Quiz Course)");
				}
			}
			Quiz = "No";
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-clickExit");
			logFAIL("The method clickExit failed (error)");
			assertFail();
		}
	}

	public static void runQuiz() throws Exception {
		try {
			//String KC = "Present";
			Quiz = "Yes";
			for (int k=1; k>=1; k++)
			{ 
				if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
				{
					checkBACKDisable();
					checkNEXTDisable();
					TakeScreenshot("Pass");
					checkTextPresent("DesktopLessonTitle");
					checkTextPresent("TopicTitle3");
					checkTextPresent("MainContent1");
					checkImagePresent("MainImage-Quiz");
					checkTextPresent("PageNumberIndicator");
					checkElementPresent("ProgressIndicator");
					checkTextPresent("Course/Page-TimerIndicator");
					runQuizCorrect();
					//runQuizIncorrect();
				} else 
				{
					break;
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runQuiz");
			logFAIL("The method runQuiz failed (error)");
			assertFail();
		}
	}

	public static void checkQuizFeedbackPage() throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				TakeScreenshot("Pass");
				//Feedback pages
				for (int k=1; k>=1; k++)
					if (verifyElementPresent("QuizCorrectIncorrectLink" + k + ""))
					{
						String PreviousPageURL = driver.getCurrentUrl();
						//logINFO("PreviousPage-URL = " + PreviousPageURL + "");
						clickElementText("QuizCorrectIncorrectLink" + k + "");
						TakeScreenshot("Pass");
						checkTextPresent("DesktopLessonTitle");
						checkTextPresent("TopicTitle3");
						checkTextPresent("MainContent1");
						checkSelectedOption();
						checkTextPresent("FeedbackBox");
						checkBulletin();
						checkTextPresent("PageNumberIndicator");
						checkElementPresent("ProgressIndicator");
						checkTextPresent("Course/Page-TimerIndicator");
						String CurrentPageURL = driver.getCurrentUrl();
						//logINFO("CurrentPage-URL = " + CurrentPageURL + "");
						if (PreviousPageURL.equals(CurrentPageURL) && !CurrentPageURL.contains("scormdriver"))
						{
							TakeScreenshot("Fail-PreviousPageURLandCurrentPageURLisSame");
							logFAIL("PreviousPage-URL and CurrentPage-URL is Same (error)");
						}
						clickElementText("ReturnToResults");
					} else
					{
						break;
					}



				//Click Next on every Feedback page
				/*clickElementText("QuizCorrectIncorrectLink1");
							do {
									if (verifyElementPresent("ReturnToResults"))
							  		{
										if (verifyElementPresent("NEXTEnable"))
								   		{
											TakeScreenshot("Pass");
											checkTextPresent("TopicTitle3");
									  		checkTextPresent("MainContent1");
									  		checkTextPresent("FeedbackBox");
									  		verifyElementTextPresent("ReturnToResults");
									  		checkBulletin();
									  		checkTextPresent("PageNumberIndicator");
						  					checkElementPresent("ProgressIndicator");
						  					checkTextPresent("Course/Page-TimerIndicator");
						  					clickNEXT();	
										}   
							   		} else
							   			break;
							 	}	
							 		while (verifyElementPresent("NEXTEnable"));*/
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkQuizFeedbackPage");
			logFAIL("The method checkQuizFeedbackPage failed (error)");
			assertFail();
		}
	}

	public static void runBranchingLesson() throws Exception {
		BranchingLesson = "Yes";
		try {
			if (FastYesNo.equals("No"))
			{
				/*for (int i=1; i>=1; i++){
					 	if (verifyElementPresent("BranchingTile"+ i +""))
						  {
							  String Locked = driver.findElement(objmap.getLocator("BranchingTopic"+ i +"MainImage")).getAttribute("src");
							  if (Locked.contains("lock"))
						    	{
								  verifyElementImagePresent("BranchingTopic"+ i +"MainImage");
								  logINFO("Type1BranchingTopic"+ i +"MainImage: Locked");
						    	} else
						    	{
						    		String Complete = driver.findElement(objmap.getLocator("BranchingTopic"+ i +"MainImage")).getAttribute("src");
									if (Complete.contains("complete"))
								    {
										verifyElementImagePresent("BranchingTopic"+ i +"MainImage");
										logINFO("BranchingTopic"+ i +"MainImage: Completed");
								    }
						    	}
						  } else
						  {
							  break;
						  }
					  }*/
			}

			for (int j=1; j>=1; j++){
				if (verifyElementPresent("BranchingTile"+ j +""))
				{
					checkImagePresent("BranchingTopic"+ j +"MainImage");
					//checkTextPresent("BranchingTopic"+ j +"Title");
					//checkTextPresent("BranchingTopic"+ j +"Description");
					//checkImagePresent("BranchingTopic"+ j +"StatusIcon");
					//checkTextPresent("BranchingTopic"+ j +"StatusText");
					TakeScreenshot("Pass");
					checkBranchingLessonStausOnBottomNavbar();
					checkNEXTDisable();
					clickElement("BranchingTile"+ j +"");
					if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
					{
						verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
						TakeScreenshot("Pass");
						clickElement("Start-Over");
					}
					for (int k=1; k>=1; k++){
						if (!verifyElementPresent("BranchingLesson"))
						{
							initialiseTemplates();
							handleConnectionLostMessageBox();
							runTemplatesTestNGxml();
						} else
						{
							break;
						}
					}

					/*if (FastYesNo.equals("No"))
						  {
							  if (SAQYesNo.equals("Yes"))
							  {
								  clickElement("BranchingTile"+ j +"");
								  if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
								  {
									  verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
									  TakeScreenshot("Pass");
									  clickElement("Start-Over");
								  }
								  rerunBranchingLessonORTileMenuForSAQIncorrect();
								  SAQYesNo = "No";
							  }
						  }*/

					/*String Complete = driver.findElement(objmap.getLocator("BranchingTopic"+ j +"MainImage")).getAttribute("src");
						  if (Complete.contains("complete"))
						  {
							  verifyElementImagePresent("BranchingTopic"+ j +"MainImage");
							  logINFO("BranchingTopic"+ j +"MainImage: Completed");
						  }*/
				} else
				{
					break;
				}
			}
			TakeScreenshot("Pass");
			BranchingLesson = "No";
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runBranchingLesson");
			logFAIL("The method runBranchingLesson failed (error)");
			assertFail();
		}
	}

	public static void checkQuizResultsPage() throws Exception {
		try {
			checkTextPresent("SideBarBox");
			checkBACKDisable();
			checkNEXTDisable();
			checkTextPresent("DesktopLessonTitle");
			checkTextPresent("TopicTitle3");
			checkTextPresent("MainContent1");
			checkTextPresent("ViewYourCompletionCertificate");
			checkTextPresent("RetakeKnowledgeCheck");
			checkTextPresent("ContinuetoCertification");
			TakeScreenshot("Pass");
			checkBulletin();
			checkHelp();
			TakeScreenshot("Pass");
			checkTextPresent("PageNumberIndicator");
			checkElementPresent("ProgressIndicator");
			checkTextPresent("Course/Page-TimerIndicator");

			if (verifyElementPresent("ConnectionLostMessageBox"))
			{
				handleConnectionLostMessageBox();
			} else
			{
				if (verifyElementPresent("SideBarBox"))
				{
					if (verifyElementPresent("NEXTDisable") && verifyElementPresent("ViewYourCompletionCertificate"))
					{
						if (verifyElementPresent("ViewYourCompletionCertificate"))
						{
							String winHandleBefore = driver.getWindowHandle();	
							clickElementText("ViewYourCompletionCertificate");
							Thread.sleep(1000);
							for(String winHandle : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle);
							}
							TakeScreenshot("Pass");
							driver.close();
							driver.switchTo().window(winHandleBefore);
						}
						if (verifyElementPresent("TakeSurvey"))
						{
							String winHandleBefore = driver.getWindowHandle();	
							clickElementText("TakeSurvey");
							Thread.sleep(1000);
							for(String winHandle : driver.getWindowHandles())
							{
								driver.switchTo().window(winHandle);
							}
							TakeScreenshot("Pass");
							driver.close();
							driver.switchTo().window(winHandleBefore);
						}
						//checkTextPresent("RetakeKnowledgeCheck");
						if (verifyElementPresent("ConnectionLostMessageBox"))
						{
							handleConnectionLostMessageBox();
						} else
						{
							checkMENULessonStatus();
							clickExit();
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							checkLCECHistoryPage();
							lcecLogout();
							writeExcelData(8, ExcelRowNumber, "Done");
						}
					}

					else if (!verifyElementPresent("NEXTDisable") || verifyElementPresent("ContinuetoCertification"))
					{
						if (verifyElementPresent("ConnectionLostMessageBox"))
						{
							handleConnectionLostMessageBox();
						} else
						{
							if (verifyElementPresent("ContinuetoCertification"))
							{
								clickElementText("ContinuetoCertification");
							} else
							{
								clickNEXT();
							}
						}
					}

					else if (!verifyElementPresent("ViewYourCompletionCertificate") || !verifyElementPresent("NEXTEnable") || !verifyElementPresent("ContinuetoCertification"))
					{
						if (verifyElementPresent("ConnectionLostMessageBox"))
						{
							handleConnectionLostMessageBox();
						} else
						{
							TakeScreenshot("Fail-ViewYourCompletionCertificateORContinuetoCertificationbuttonNotPresent");
							logFAIL("Not-Found 'View Your Completion Certificate' OR 'Continue to Certification' button on Page (error)");
							checkMENULessonStatus();
							clickExit();
							driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
							checkLCECHistoryPage();
							lcecLogout();
							writeExcelData(8, ExcelRowNumber, "Fail");
						}
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkQuizResultsPage");
			logFAIL("The method checkQuizResultsPage failed (error)");
			assertFail();
		}
	}

	public static void checkNoQuizResultsPage() throws Exception {
		try {
			if (verifyElementPresent("ViewYourCompletionCertificate"))
			{
				String winHandleBefore = driver.getWindowHandle();	
				clickElementText("ViewYourCompletionCertificate");
				Thread.sleep(1000);
				for(String winHandle : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle);
				}
				TakeScreenshot("Pass");
				driver.close();
				driver.switchTo().window(winHandleBefore);
				if (verifyElementPresent("TakeSurvey"))
				{
					String winHandleBefore1 = driver.getWindowHandle();	
					clickElementText("TakeSurvey");
					Thread.sleep(1000);
					for(String winHandle : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle);
					}
					TakeScreenshot("Pass");
					driver.close();
					driver.switchTo().window(winHandleBefore1);
				}
				if (verifyElementPresent("ConnectionLostMessageBox"))
				{
					handleConnectionLostMessageBox();
				} else
				{
					checkMENULessonStatus();
					clickElement("DesktopExit");
					Thread.sleep(3000);
					driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
					checkLCECHistoryPage();
					lcecLogout();
					writeExcelData(8, ExcelRowNumber, "Done");
				}
			} else 
			{
				if (verifyElementPresent("ConnectionLostMessageBox"))
				{
					handleConnectionLostMessageBox();
				} else
				{
					if (verifyElementPresent("ContinuetoCertification"))
					{
						if (verifyElementPresent("ContinuetoCertification"))
						{
							TakeScreenshot("Pass");
							clickElementText("ContinuetoCertification");
						} else
						{
							TakeScreenshot("Pass");
							clickNEXT();
						}
					} else
					{
						TakeScreenshot("Pass");
						checkMENULessonStatus();
						clickElement("DesktopExit");
						Thread.sleep(3000);
						driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
						checkLCECHistoryPage();
						lcecLogout();
						writeExcelData(8, ExcelRowNumber, "Done");
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkNoQuizResultsPage");
			logFAIL("The method checkNoQuizResultsPage failed (error)");
			assertFail();
		}
	}

	public static void runCertQuestionPages() throws Exception {
		try {
			//checkBACKDisable();
			if (verifyElementPresent("EocCertQuestion1") || verifyElementPresent("EmbdCertQuestion1"))
			{
				for (int k=1; k>=1; k++){
					//if (verifyElementPresent("EocCertQuestion" + k + "") || verifyElementPresent("EmbdCertQuestion" + k + ""))
					//{
					/*checkNEXTDisable();
						    	checkTextPresent("DesktopLessonTitle");
						    	checkTextPresent("CertQuestionTopicTitle");
						  		checkTextPresent("CertInstruction");//
					  			checkTextPresent("CertQuestion");//
					  			if (verifyElementPresent("runSaqORGraphicalSaqSubmit"))
					    		{
					    			if (verifyElementPresent("CertSubmitDisable"))
					    			{
					    				logINFO("Submit Disable: Present");
					    			} else
					    			{
					    				TakeScreenshot("Fail-SubmitDisableNotPresent");
					    				logFAIL("Submit Disable: Not-Present (error)");
					    			}
					    		}*/
					if (verifyElementPresent("runSaqORGraphicalSaqOption1"))
					{
						runCertRadioButtonORCheckBox();
					}
					else if (verifyElementPresent("DropDownBox"))
					{
						runCertDropDown();
					}
					else if (verifyElementPresent("EnterNumberBox"))
					{
						runCertEnterNumber();
					}
					else if (verifyElementPresent("EnterTextBox"))
					{
						runCertEnterText();
					}
					else if (verifyElementPresent("SelectDateBox"))
					{
						runCertSelectDate();
					}
					if (verifyElementPresent("NEXTDisable"))
					{
						checkTextPresent("PageNumberIndicator");
						checkElementPresent("ProgressIndicator");
						checkTextPresent("Course/Page-TimerIndicator");
						TakeScreenshot("Pass");
						clickElementText("runSaqORGraphicalSaqSubmit");
						Thread.sleep(3000);
						//checkCertResultPage();
						break;
					} else
					{
						checkTextPresent("PageNumberIndicator");
						checkElementPresent("ProgressIndicator");
						checkTextPresent("Course/Page-TimerIndicator");
						TakeScreenshot("Pass");
						clickNEXT();
					}
					/*} else
							{
								checkCertResultPage();
								break;
							}*/
				} 
				checkCertResultPage();
				//break;
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCertQuestionPages");
			logFAIL("The method runCertQuestionPages failed (error)");
			assertFail();
		}
	}

	public static void checkCertResultPage() throws Exception {
		try {
			logINFO("##### Certificate Result Page #####");
			/*checkBACKDisable();
				checkNEXTDisable();
				checkTextPresent("DesktopLessonTitle");
				if (isElementPresent(objmap.getLocator("TopicTitle2")))
				{
					isElementPresent(objmap.getLocator("TopicTitle2"), "Topic Title");
				}
				checkTextPresent("MainContent1");*/
			checkBulletin();
			TakeScreenshot("Pass");
			if (verifyElementPresent("ViewCompletedCertification"))
			{
				String winHandleBefore = driver.getWindowHandle();	
				clickElementText("ViewCompletedCertification");
				Thread.sleep(1000);
				for(String winHandle : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle);
				}
				TakeScreenshot("Pass");
				driver.close();
				driver.switchTo().window(winHandleBefore);
				if (verifyElementPresent("TakeSurvey"))
				{
					String winHandleBefore1 = driver.getWindowHandle();	
					clickElementText("TakeSurvey");
					Thread.sleep(1000);
					for(String winHandle : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle);
					}
					TakeScreenshot("Pass");
					driver.close();
					driver.switchTo().window(winHandleBefore1);
				}
				checkMENULessonStatus();
				if (verifyElementPresent("ConnectionLostMessageBox"))
				{
					handleConnectionLostMessageBox();
				} else
				{
					clickExit();
					driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
					checkLCECHistoryPage();
					lcecLogout();
					writeExcelData(8, ExcelRowNumber, "Done");
				}
			} else
			{
				if (verifyElementPresent("ConnectionLostMessageBox"))
				{
					handleConnectionLostMessageBox();
				} else
				{
					if (verifyElementPresent("TakeSurvey"))
					{
						String winHandleBefore1 = driver.getWindowHandle();	
						clickElementText("TakeSurvey");
						Thread.sleep(1000);
						for(String winHandle : driver.getWindowHandles())
						{
							driver.switchTo().window(winHandle);
						}
						TakeScreenshot("Pass");
						driver.close();
						driver.switchTo().window(winHandleBefore1);
					}
					if (!verifyElementPresent("ViewCompletedCertification") && verifyElementPresent("NEXTDisable"))
					{
						checkMENULessonStatus();
						clickExit();
						driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
						checkLCECHistoryPage();
						lcecLogout();
						writeExcelData(8, ExcelRowNumber, "Done");
					} 

					else if (!verifyElementPresent("ViewCompletedCertification") && verifyElementPresent("NEXTEnable"))
					{
						clickNEXT();
						Thread.sleep(10000);
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-checkCertResultPage");
			logFAIL("The method checkCertResultPage failed (error)");
			assertFail();
		}
	}

	public static void runTileMenu() throws Exception {
		TileMenu = "Yes";
		try {
			checkBulletin();
			if (FastYesNo.equals("No"))
			{
				/*for (int i=1; i>=1; i++){
					  if (verifyElementPresent("TileMenuLesson"+ i +""))
					  {
						  String Locked = driver.findElement(objmap.getLocator("TileMenuLesson"+ i +"MainImage")).getAttribute("src");
						  if (Locked.contains("lock"))
					    	{
							  verifyElementImagePresent("TileMenuLesson"+ i +"MainImage");
							  logINFO("Type1TileMenuLesson"+ i +"MainImage: Locked");
					    	} else
					    	{
					    		String Complete = driver.findElement(objmap.getLocator("TileMenuLesson"+ i +"MainImage")).getAttribute("src");
								if (Complete.contains("complete"))
							    {
									verifyElementImagePresent("TileMenuLesson"+ i +"MainImage");
									logINFO("TileMenuLesson"+ i +"MainImage: Completed");
							    }
					    	}
					  } else
					  {
						  break;
					  }
				  }*/
			}

			for (int j=1; j>=1; j++){
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains("FluidX2.0") || CurrentURL.contains("scormdriver"))
				{
					if (verifyElementPresent("TileMenuLesson"+ j +""))
					{
						/*checkImagePresent("TileMenuLesson"+ j +"MainImage");
							  checkTextPresent("TileMenuLesson"+ j +"Title");
							  checkTextPresent("TileMenuLesson"+ j +"Description");
							  checkImagePresent("TileMenuLesson"+ j +"StatusIcon");
							  checkTextPresent("TileMenuLesson"+ j +"StatusText");
							  checkNEXTDisable();*/
						checkHelp();
						TakeScreenshot("Pass");
						clickElement("TileMenuLesson"+ j +"");
						if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
						{
							verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
							TakeScreenshot("Pass");
							clickElementText("Start-Over");
						}
						for (int k=1; k>=1; k++){
							String CourseURL = driver.getCurrentUrl();
							if (!verifyElementPresent("TileMenu"))
							{
								if (CourseURL.contains("FluidX2.0") || CourseURL.contains("scormdriver"))
								{
									initialiseTemplates();
									handleConnectionLostMessageBox();
									runTemplatesTestNGxml();
								} else
								{
									break;
								}
							} else
							{
								break;
							}
						}

						/*if (FastYesNo.equals("No"))
							  {
								  if (SAQYesNo.equals("Yes"))
								  {
									  clickElement("TileMenuLesson"+ j +"");
									  if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
									  {
										  verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
										  TakeScreenshot("Pass");
										  clickElement("Start-Over");
									  }
									  if (!verifyElementPresent("BranchingLesson"))
									  {
										  rerunBranchingLessonORTileMenuForSAQIncorrect();
										  SAQYesNo = "No";
									  } else
									  {
										  clickNEXT();
										  Thread.sleep(300);
									  }
								  }
							  }*/
					} else
					{
						if (verifyElementPresent("TileMenu"))
						{
							TakeScreenshot("Pass");
							if (verifyElementPresent("Tile-ViewCertificate"))
							{
								String winHandleBefore = driver.getWindowHandle();	
								clickElementText("Tile-ViewCertificate");
								for(String winHandle : driver.getWindowHandles())
								{
									driver.switchTo().window(winHandle);
								}
								Thread.sleep(10000);
								TakeScreenshot("Pass");
								driver.close();
								driver.switchTo().window(winHandleBefore);
							}
							if (verifyElementPresent("Tile-TakeSurvey"))
							{
								String winHandleBefore1 = driver.getWindowHandle();	
								clickElementText("Tile-TakeSurvey");
								Thread.sleep(1000);
								for(String winHandle : driver.getWindowHandles())
								{
									driver.switchTo().window(winHandle);
								}
								TakeScreenshot("Pass");
								driver.close();
								driver.switchTo().window(winHandleBefore1);
							}
							TakeScreenshot("Pass");
							if (verifyElementPresent("ConnectionLostMessageBox"))
							{
								handleConnectionLostMessageBox();
							} else
							{
								clickExit();
								driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
								checkLCECHistoryPage();
								lcecLogout();
								writeExcelData(8, ExcelRowNumber, "Done");
							}
						}
					}
				} else
				{
					break;
				}
			}
			TakeScreenshot("Pass");
			TileMenu = "No";
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runTileMenu");
			logFAIL("The method runTileMenu failed (error)");
			assertFail();
		}
	}

	/*public static void startVideoRecord() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\testresult\\videos\\","Video"+"-"+catalogID+"-"+BrowserName+"-"+dateFormat.format(date),false);
		recorder.start();
	}

	public static void stopVideoRecord() throws Exception {
		recorder.stop();
	}*/

	public static void runCoursePage() throws Exception {
		try {
			for (int i=1; i<=10; i++) {
				if (verifyElementPresent("DesktopMenu") || verifyElementPresent("DesktopTileMenu") || verifyElementPresent("TileMenu") || verifyElementPresent("LandingPageltr"))
				{
					break;
				}
				Thread.sleep(1000);
			}

			if (FullScreenYesNo.equals("Yes"))
			{
				driver.manage().window().maximize(); // maximize the window
			}

			if (verifyElementPresent("DesktopMenu") || verifyElementPresent("DesktopTileMenu") || verifyElementPresent("TileMenu") || verifyElementPresent("LandingPageltr"))
			{
				// Jump to Page Number
				if (verifyElementPresent("LandingPageltr"))
				{
					clickElement("LandingPageNextButton");
					Thread.sleep(2000);
					logINFO("Click on LandingPage's Next button");
				}
				if (!JumptoTileNum.equals("No"))
				{
					if (verifyElementPresent("BranchingLesson"))
					{
						clickElement("BranchingTile"+JumptoTileNum+"");
						Thread.sleep(2000);
						logINFO("Click on BranchingTile #"+JumptoTileNum+"");
						if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
						{
							verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
							clickElement("Start-Over");
							Thread.sleep(500);
						}
					}
					else if (verifyElementPresent("TileMenu"))
					{
						clickElement("TileMenuLesson"+JumptoTileNum+"");
						Thread.sleep(200);
						logINFO("Click on TileMenu's Lesson #"+JumptoTileNum+"");
						if (verifyElementPresent("runGraphicalSaqRetakeAlertBox"))
						{
							verifyElementTextPresent("runGraphicalSaqRetakeAlertBox");
							clickElement("Start-Over");
							Thread.sleep(500);
						}
					}
				}
				if (!JumptoCoursePage.equals("No"))
				{
					jumpToPage(JumptoCoursePage);
					logINFO("Jump to Page #"+JumptoCoursePage);
					Thread.sleep(2000);
					//extent.endTest(testlog);
					/*initialiseTemplates();
					handleConnectionLostMessageBox();
					runTemplatesTestNGxml();*/
				}
			} else
			{
				TakeScreenshot("Fail-FluidXCourseNotLoading");
				driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]).close();
				Thread.sleep(1000);
				driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
				writeExcelData(8, ExcelRowNumber, "Fail");
				lcecLogout();
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-runCoursePage");
			logFAIL("The method runCoursePage failed (error)");
			assertFail();
		}
	}
	
	public static void lcecLogout() throws Exception {
		try {
			clickElement("Logout");
			//driver.findElement(objmap.getLocator("Logout")).click();
		} catch (Exception e) {
			TakeScreenshot("Fail-Method-lcecLogout");
			logFAIL("The method lcecLogout failed (error)");
			assertFail();
		}
	}

}
