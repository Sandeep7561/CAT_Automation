package com.cat.templates;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.cat.common.GenericTemplateMethods;

public class RunAnyCourse extends GenericTemplateMethods {
	@Parameters({ "XlsName", "SheetName", "StartRowNumber", "EndRowNumber" })
	@Test(groups = { "CourseCompletion" }, testName="FLDXTWO-4710", priority=0)
	public void CourseCompletion(String XlsName, String SheetName, int StartRowNumber, int EndRowNumber) throws Exception{
		runHTML5course(XlsName,SheetName,StartRowNumber,EndRowNumber);
	}
}
