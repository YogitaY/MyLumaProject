package com.luma.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.dataprovider.DataProviders;
import com.luma.pageobjects.HomePage;
import com.luma.pageobjects.IndexPage;
import com.luma.pageobjects.LoginPage;
import com.luma.utility.Log;

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void WhatsNewElementTest(String username,String password ) throws Exception {
		Log.startTestCase("HomePage");
		indexPage = new IndexPage();
		Log.info("Click on Signin link");
		loginPage = indexPage.signInClick();
		Log.info("Enter Username and Password");
//		homePage =loginPage.login(prop.getProperty(username), prop.getProperty(password));
		homePage = loginPage.login(username, password,homePage);
		Log.info("Verifying is homePage Displays");
		boolean result = homePage.validateWhatsNewElement();
		Assert.assertTrue(result);	
		Log.info("HomePage Display Successfully");
		Log.endTestCase("HomePage");
	}
	
}
