/**
 * 
 */
package com.luma.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;

/**
 * 
 */
public class ShippingPage extends BaseClass {
	static Action Action = new Action();
	
	@FindBy(xpath = "//*[@id=\"checkout\"]/div[1]/button")
	private WebElement SigninShipping;
	
	@FindBy(xpath ="//button[@class='button action continue primary']/span")
	private WebElement nextBtnClick;
	
	@FindBy(xpath ="//div/span[text()='Order Summary']")
	private WebElement orderSummary;
	
	@FindBy(xpath="//input[@type='radio'][1]")
	private WebElement fixedRate;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage SigninClick() throws Exception {
		Action.fluentWait(getDriver(), SigninShipping, 50);
		return new LoginPage();
	}
	
	public boolean orderSummary() {
		Action.fluentWaitVisibility(getDriver(), orderSummary, 50);
		return Action.isDisplayed(getDriver(), orderSummary);
	}
	
	public PaymentPage sizeSelection1() throws InterruptedException{
		Thread.sleep(4000);
		Action.ScrollByVisibilityOfElement(getDriver(), nextBtnClick);
		Action.fluentWaitVisibility(getDriver(), nextBtnClick, 50);   
		Action.JSClick(getDriver(), nextBtnClick);
		Action.JSClick(getDriver(), nextBtnClick);
//		Action.JSClick(getDriver(), nextBtnClick);
		return new PaymentPage();
	}

}
