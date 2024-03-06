/**
 * 
 */
package com.luma.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;

/**
 * 
 */
public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath ="//div//h1/span[text()='Thank you for your purchase!']")
	private WebElement orderCompletedMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String placeOrderClick() {
		String confirmation = orderCompletedMsg.getText();
		return confirmation ;
		
	}

}
