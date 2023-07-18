package com.test.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.constants.SourcePath;

public class ExtentReportsUtility {
	public static ExtentReports report ;
	public static ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	private static ExtentReportsUtility extentObject;
	
	private ExtentReportsUtility() {
		
	}
	
	public static ExtentReportsUtility getInstance() {
		if(extentObject==null) {
			extentObject = new ExtentReportsUtility();
		}
		return extentObject;
	}
	
	public void startExtentReport() {
		report= new ExtentReports();
		spark = new ExtentSparkReporter(SourcePath.HTML_REPORT_PATH);
		report.attachReporter(spark);
		
		report.setSystemInfo("Host Name", "RestAssured");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Neha");

		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("Rest Assured Testing");
		spark.config().setTheme(Theme.DARK);
	}
	
	public void startSingleTestReport(String methodName) {
		testLogger=report.createTest(methodName);
	}
	public void endReport() {
		report.flush();
	}
	
	public void logTestInfo(String text) {
		testLogger.log(Status.INFO,text);
	}
	
	public void logTestpassed(String text) {
		testLogger.log(Status.PASS,MarkupHelper.createLabel(text, ExtentColor.GREEN));
	}
	
	public void logTestFailed(String text) {
		testLogger.log(Status.FAIL,MarkupHelper.createLabel(text, ExtentColor.RED));
	}
	
	public void logTestFailedWithException(Throwable e) {
		testLogger.log(Status.FAIL,e);
	}
}