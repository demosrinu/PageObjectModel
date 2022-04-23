package com.pom.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.base.TestBase;

public class Listeners extends TestBase implements ITestListener{
	
	ExtentReports extentreport = ExtentReporterNG.ExtentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestStart(result);
		test = extentreport.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "This Test is Skipped");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		ITestListener.super.onTestFailure(result);
		extentTest.get().fail(result.getThrowable());
		Object testObj = result.getInstance();
		Class clazz = result.getTestClass().getRealClass();
		
		try {
			driver = (WebDriver)clazz.getDeclaredField("driver").get(testObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(TestUtil.CaptureScreenshot(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		
		ITestListener.super.onFinish(context);
		extentreport.flush();
		try {
			Desktop.getDesktop().browse(new File("report.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
