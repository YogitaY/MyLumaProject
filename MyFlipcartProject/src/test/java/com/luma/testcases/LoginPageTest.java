/**
 * 
 */
package com.luma.testcases;


import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;
import com.luma.dataprovider.DataProviders;
import com.luma.pageobjects.HomePage;
import com.luma.pageobjects.IndexPage;
import com.luma.pageobjects.LoginPage;
import com.luma.utility.Log;
//import com.luma.utility.NewExcelLibrary;

/**
 * 
 */
public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void loginTest(String username, String password) throws Throwable{
//		String username, String password
//		test = extentReports.createTest("loginTest");
//		,dataProvider = "login", dataProviderClass = DataProviders.class
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User going to click on Signin");
		loginPage = indexPage.signInClick();
		Log.info("enter username and Password");
//		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(username, password,homePage);
		String actualUrl = homePage.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl ="https://magento.softwaretestingboard.com/";
		Log.info("Verifying is user able to Login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("Login Success");
		Log.endTestCase("loginTest");
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
}
