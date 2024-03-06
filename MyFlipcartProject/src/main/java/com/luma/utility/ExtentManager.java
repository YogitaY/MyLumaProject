package com.luma.utility;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.luma.base.BaseClass;


public class ExtentManager extends BaseClass {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReports;
	
	public static void setExtent() throws IOException {
		htmlReporter= new ExtentSparkReporter("ExtentReport.html");//can give path
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/ExtentReports/extent-config.xml");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Luma Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy, hh:mm a '('zzz')'");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		
		extentReports.setSystemInfo("HostName", "MyHost");
		extentReports.setSystemInfo("ProjectName", "MyFlipcartProject");
		extentReports.setSystemInfo("Tester", "Yogita");
		extentReports.setSystemInfo("OS", "Windows 11");
		extentReports.setSystemInfo("Browser", "Firefox");
	}
	
	public static void endReport() {
		extentReports.flush();
	}

}
