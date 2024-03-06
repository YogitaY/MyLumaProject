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
public class PaymentPage extends BaseClass{
	static Action Action = new Action();
	
	@FindBy(xpath ="//button[@title='Place Order']")
	private WebElement placeOrderClick;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage placeOrderClick(){
		Action.ScrollByVisibilityOfElement(getDriver(), placeOrderClick);
		Action.fluentWaitVisibility(getDriver(), placeOrderClick, 0);
		Action.JSClick(getDriver(), placeOrderClick);
		Action.JSClick(getDriver(), placeOrderClick);
		Action.JSClick(getDriver(), placeOrderClick);
//		Action.fluentWait(getDriver(), placeOrderClick, 50);
//		Action.fluentWait(getDriver(), placeOrderClick, 50);
		return new OrderConfirmationPage();
	}

}
