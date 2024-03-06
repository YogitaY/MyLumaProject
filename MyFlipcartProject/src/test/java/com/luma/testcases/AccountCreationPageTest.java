/**
 * 
 */
package com.luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.pageobjects.AccountCreationPage;
import com.luma.pageobjects.IndexPage;
import com.luma.utility.Log;

/**
 * 
 */
public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	AccountCreationPage createAccount;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity")
	public void verifyCreateAccountTitleTest() {
		Log.startTestCase("AccountCreationPage");
		indexPage = new IndexPage();
		Log.info("Click on Create Account link");
		createAccount = indexPage.CreateAccountBtnClick();
		Log.info("Verifying is AccountCreation page display");
		boolean result = createAccount.validateCreateAccountTitle();
		Assert.assertTrue(result);	
		Log.info("AccountCreation page display successfully");
		Log.endTestCase("AccountCreationPage");
	}
	
	

}
