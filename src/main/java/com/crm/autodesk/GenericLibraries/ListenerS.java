package com.crm.autodesk.GenericLibraries;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ListenerS implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		reports.flush();
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentReports/SDET21.html");
		reporter.config().setDocumentTitle("SDET21");
		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Buildno", "5.1");
		reports.setSystemInfo("Env","pre-cond");
		reports.setSystemInfo("platform","windows");
		reports.setSystemInfo("Browser","chrome");
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName() + "is failed");
		BaseClass baseclass = new BaseClass();
		try {
			String path = baseclass.getscreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
			
		
//		BaseClass baseclass = new BaseClass();
//		try {
//			baseclass.getscreenshot(result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getMethod().getMethodName() +"is skipped");
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= reports.createTest(result.getMethod().getMethodName());
	}

	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + "is passed");

//		BaseClass baseclass = new BaseClass();
//		try {
//			baseclass.getscreenshot(result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
	}
	}



