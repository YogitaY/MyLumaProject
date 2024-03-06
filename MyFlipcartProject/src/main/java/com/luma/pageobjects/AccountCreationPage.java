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
public class AccountCreationPage extends BaseClass {
	static Action Action = new Action();
	
	@FindBy(xpath ="//span[@class='base']")
	private WebElement createAccountTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateCreateAccountTitle() {
		return Action.isDisplayed(getDriver(), createAccountTitle);
	}
	
	

}
