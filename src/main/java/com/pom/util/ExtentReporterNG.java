package com.pom.util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pom.base.TestBase;

public class ExtentReporterNG extends TestBase{
	
	public static ExtentReports ExtentReportGenerator() {
		
		ExtentReports extentreport = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(SparkReporter);
		return extentreport;
	}

}
