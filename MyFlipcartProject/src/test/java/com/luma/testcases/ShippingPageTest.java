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
import com.luma.dataprovider.DataProviders;
import com.luma.pageobjects.AddToCartPage;
import com.luma.pageobjects.IndexPage;
import com.luma.pageobjects.LoginPage;
import com.luma.pageobjects.OrderPage;
import com.luma.pageobjects.SearchResultPage;
import com.luma.pageobjects.ShippingPage;
import com.luma.utility.Log;

/**
 * 
 */
public class ShippingPageTest extends BaseClass {
	
	IndexPage indexPage;
	IndexPage searchProduct;
	SearchResultPage SearchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	ShippingPage shippingPage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	

	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyOrderSummaryTest(String productName, String quantity1) throws Throwable {
		Log.startTestCase("ShippingPage");
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
		Log.info("click On AddToCart Icon");
		addToCartPage.addToCartIconClick();
		Log.info("click On AddToCart veiw link");
		orderPage = addToCartPage.veiwAddTocartPage();
		Log.info("click On procedto Checout button");
		shippingPage = orderPage.procedtoChecout1();
		Log.info("click On Signin link");
		loginPage = shippingPage.SigninClick();
		Log.info("Enter Username and Password");
		shippingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), shippingPage);
		Log.info("Verifying is order Summary display");
		boolean result = shippingPage.orderSummary();
		Assert.assertTrue(result);
		Log.info("order Summary display successfully");
		Log.endTestCase("ShippingPage");
	}

}
