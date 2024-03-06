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
public class LoginPage extends BaseClass{
	static Action Action = new Action();
	
	@FindBy(id = "email")
	private WebElement userName;
	
	@FindBy(id = "pass")
	private WebElement password;
	
	@FindBy(id = "send2")
	private WebElement signinBtn;
	
	@FindBy(id = "login-email")
	private WebElement userName2;
	
	@FindBy(id = "login-password")
	private WebElement password2;
	
	@FindBy(xpath = "//div[3]/form/div[2]/div[1]/button")
	private WebElement signinBtn2;
	
	@FindBy(xpath = "//a[@class='action create primary']")
	private WebElement createAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uName, String psward, HomePage homePage) {
		Action.type(userName, uName);
		Action.type(password, psward);
		Action.fluentWait(getDriver(), signinBtn, 50);
		homePage=new HomePage();
		return homePage;
	}

	public ShippingPage login(String uName, String psward, ShippingPage shippingPage){
		Action.fluentWaitVisibility(getDriver(), userName2, 50);
		Action.type(userName2, uName);
		Action.type(password2, psward);
		Action.JSClick(getDriver(), signinBtn2);
		Action.JSClick(getDriver(), signinBtn2);
		shippingPage = new ShippingPage();
		return shippingPage;
	}
	
	public HomePage createNewAccount() {
		Action.fluentWait(getDriver(), createAccountBtn, 50);
		return new HomePage();
	}

}
