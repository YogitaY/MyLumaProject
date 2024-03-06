/**
 * 
 */
package com.luma.testcases;


import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;
import com.luma.dataprovider.DataProviders;
import com.luma.pageobjects.IndexPage;
import com.luma.utility.Log;


/**
 * 
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable{
		Log.startTestCase("IndexPage");
		Log.info("Verifying is Logo Displays");
		indexpage = new IndexPage();
		boolean result1 = indexpage.validateLogo();
		Assert.assertTrue(result1);
		Log.info("Logo Display Successfully");
		Log.endTestCase("IndexPage");
	}
	
}
