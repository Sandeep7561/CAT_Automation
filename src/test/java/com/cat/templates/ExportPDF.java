package com.cat.templates;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class ExportPDF extends GenericTemplateMethods {
	
	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4708", priority=0)
	public void Tutorial() throws Exception {
		// Write data in Excel
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String dateTime = formatter.format(currentDate.getTime());
		writeExcelData(6, ExcelRowNumber, dateTime);
		writeExcelData(8, ExcelRowNumber, "InProgress");
		
		new Select (driver.findElement(objmap.getLocator("SelectPDFDropDown"))).selectByIndex(0);
		clickElement("ExportPDF");
		Thread.sleep(500);
		checkInvisibilityOfElement(10000, "PDFGeneratingSpinningIcon");
		String ExportPackageMessage = driver.findElement(objmap.getLocator("PDFPackageExportedPopup")).getText();
		if (ExportPackageMessage.contains("click"))
		{
			String PDFurl = driver.findElement(objmap.getLocator("PDFClickHere")).getAttribute("href");
			((JavascriptExecutor)driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.get(PDFurl);
		    Thread.sleep(15000);
		   // Assert.assertTrue(verifyPDFContent(driver.getCurrentUrl(), "2 	/"));
		    driver.close();
		    driver.switchTo().window(tabs.get(0));
		} else if (ExportPackageMessage.contains("fail"))
		{
			TakeScreenshot("Fail-PDFPackageFailedToGenerate");
			logFAILED("PDF Package Failed To Generate");
		}
	}
	
	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4708", priority=1)
	public void FAQ() throws Exception {
		new Select (driver.findElement(objmap.getLocator("SelectPDFDropDown"))).selectByIndex(1);
		clickElement("ExportPDF");
		Thread.sleep(500);
		checkInvisibilityOfElement(10000, "PDFGeneratingSpinningIcon");
		String ExportPackageMessage = driver.findElement(objmap.getLocator("PDFPackageExportedPopup")).getText();
		if (ExportPackageMessage.contains("click"))
		{
			String PDFurl = driver.findElement(objmap.getLocator("PDFClickHere")).getAttribute("href");
			((JavascriptExecutor)driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.get(PDFurl);
		    Thread.sleep(5000);
		   // Assert.assertTrue(verifyPDFContent(driver.getCurrentUrl(), "2 	/"));
		    driver.close();
		    driver.switchTo().window(tabs.get(0));
		} else if (ExportPackageMessage.contains("fail"))
		{
			TakeScreenshot("Fail-PDFPackageFailedToGenerate");
			logFAILED("PDF Package Failed To Generate");
		}
	}
	
	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4708", priority=2)
	public void TopTen() throws Exception {
		new Select (driver.findElement(objmap.getLocator("SelectPDFDropDown"))).selectByIndex(2);
		clickElement("ExportPDF");
		Thread.sleep(500);
		checkInvisibilityOfElement(10000, "PDFGeneratingSpinningIcon");
		String ExportPackageMessage = driver.findElement(objmap.getLocator("PDFPackageExportedPopup")).getText();
		if (ExportPackageMessage.contains("click"))
		{
			String PDFurl = driver.findElement(objmap.getLocator("PDFClickHere")).getAttribute("href");
			((JavascriptExecutor)driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.get(PDFurl);
		    Thread.sleep(5000);
		    //Assert.assertTrue(verifyPDFContent(driver.getCurrentUrl(), "2 	/"));
		    driver.close();
		    driver.switchTo().window(tabs.get(0));
		} else if (ExportPackageMessage.contains("fail"))
		{
			TakeScreenshot("Fail-PDFPackageFailedToGenerate");
			logFAILED("PDF Package Failed To Generate");
		}
	}
	
	@Test(groups = { "Regression", "Sanity" }, testName="FLDXTWO-4708", priority=3)
	public void AnswerGuide() throws Exception {
		clickElement("AnswerGuideBtn");
		Thread.sleep(500);
		checkInvisibilityOfElement(10000, "PDFGeneratingSpinningIcon");
		String ExportPackageMessage = driver.findElement(objmap.getLocator("PDFPackageExportedPopup")).getText();
		if (ExportPackageMessage.contains("click"))
		{
			String PDFurl = driver.findElement(objmap.getLocator("PDFClickHere")).getAttribute("href");
			((JavascriptExecutor)driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.get(PDFurl);
		    Thread.sleep(15000);
		    //Assert.assertTrue(verifyPDFContent(driver.getCurrentUrl(), "2 	/"));
		    driver.close();
		    driver.switchTo().window(tabs.get(0));
		} else if (ExportPackageMessage.contains("fail"))
		{
			TakeScreenshot("Fail-PDFPackageFailedToGenerate");
			logFAILED("PDF Package Failed To Generate");
		}
		
		// Write data in Excel
		Calendar currentDate1 = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String dateTime1 = formatter1.format(currentDate1.getTime());
		writeExcelData(7, ExcelRowNumber, dateTime1);
		writeExcelData(8, ExcelRowNumber, "Done");
	}
}
