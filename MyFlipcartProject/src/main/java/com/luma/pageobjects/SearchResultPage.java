package com.luma.pageobjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;

public class SearchResultPage extends BaseClass {
	static Action Action = new Action();
	
	@FindBy(xpath ="//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li[1]/div/a/span/span/img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable(){
		Action.ScrollByVisibilityOfElement(getDriver(), productResult);	
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.fluentWait(getDriver(), productResult,50);
		return new AddToCartPage();
	}

}
