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
import com.luma.pageobjects.OrderPage;
import com.luma.pageobjects.SearchResultPage;
import com.luma.utility.Log;

/**
 * 
 */
public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	IndexPage searchProduct;
	SearchResultPage SearchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyShoppingCartTest(String productName, String quantity1) throws Throwable {
		Log.startTestCase("OrderPage");
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
		addToCartPage.validateaAddToCart();
		Log.info("click On AddToCart Icon");
		addToCartPage.addToCartIconClick();
		Log.info("Verifying is veiwAdd To cart Page Display");
		orderPage = addToCartPage.veiwAddTocartPage();
		boolean result = orderPage.validateShoppingCartTitle();
		Assert.assertTrue(result);
		Log.info("VeiwAdd To cart Page Display Successfully");
		Log.endTestCase("OrderPage");
	}
	
	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPriceTest(String productName, String quantity1) throws Throwable {
		Log.startTestCase("OrderPage 2");
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
		System.out.println("add cart clicked");
		Log.info("click On AddToCart Icon");
		addToCartPage.addToCartIconClick();
		System.out.println("add to cart icon clicked");
		Log.info("click On AddToCart veiw link");
		orderPage = addToCartPage.veiwAddTocartPage();
		System.out.println("add cart page view");
		Log.info("Verifying Total price to pay");
		double unitPrice1 = orderPage.getUnitPrice();
		System.out.println(unitPrice1);
		double totalPrice1 = orderPage.getTotalPrice();
		System.out.println(totalPrice1);
		double totalExpectedPrice = unitPrice1 *2;
		System.out.println(totalExpectedPrice);
		Assert.assertEquals(totalPrice1, totalExpectedPrice);
		Log.info("Total price to pay calculated Successfully");
		Log.endTestCase("OrderPage 2");
	}
}
