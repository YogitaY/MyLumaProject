
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
import com.luma.pageobjects.SearchResultPage;
import com.luma.utility.Log;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
//	LoginPage loginPage;
//	HomePage homePage;
	IndexPage searchProduct;
	SearchResultPage SearchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke", dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailibilityTest(String searchProductName) throws Throwable {
		Log.startTestCase("SearchResultPage");
		indexPage = new IndexPage();
		Log.info("Enter productName in search box");
		SearchResultPage = indexPage.searchProduct(searchProductName);
		Log.info("Verifying is product available");
		boolean result = SearchResultPage.isProductAvailable();
		Assert.assertTrue(result);	
		Log.info("Product is available");
		Log.endTestCase("SearchResultPage");
	}

}
