/**
 * 
 */
package com.luma.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.dataprovider.DataProviders;
import com.luma.pageobjects.AddToCartPage;
import com.luma.pageobjects.IndexPage;
import com.luma.pageobjects.SearchResultPage;
import com.luma.utility.Log;

/**
 * 
 */
public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexPage;
	IndexPage searchProduct;
	SearchResultPage SearchResultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Sanity","Regression"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void AddToCartPageBeforeClickTest(String productName, String quantity1) throws Exception {
		Log.startTestCase("AddToCartPage");
		indexPage = new IndexPage();
		Log.info("Enter productName in search box");
		SearchResultPage = indexPage.searchProduct(productName);
		Log.info("click On Product");
		addToCartPage = SearchResultPage.clickOnProduct();
		Log.info("Click on size button");
		addToCartPage.sizeSelection1();
		Log.info("click On color button");
		addToCartPage.colorSelection1();
		Log.info("Enter quantity");
		addToCartPage.quantity1(quantity1);
		Log.info("click On AddToCart button");
		addToCartPage.clickOnAddToCart();
		Log.info("Verifying is Product added in cart");
		boolean result = addToCartPage.validateaAddToCart();
		System.out.println(result);
		Assert.assertTrue(result);	
		Log.info("Product added in cart Successfully");
		Log.endTestCase("AddToCartPage");
	}
}
