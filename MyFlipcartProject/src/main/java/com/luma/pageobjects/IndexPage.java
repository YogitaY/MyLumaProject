package com.luma.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;

public class IndexPage extends BaseClass {
	static Action Action = new Action();
	
	@FindBy(xpath = "//ul//li//a[1]")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//div[2]/header/div[1]/div/ul/li[3]/a")
	private WebElement CreateAccountBtnClick;
	
	@FindBy(xpath = "//a[@class='logo']")
	private WebElement lumaLogo;
	
	@FindBy(id = "search")
	private WebElement searchProductBox;
	
	@FindBy(xpath ="//*[@id='search_mini_form']/div[2]/button")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage signInClick() {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public AccountCreationPage CreateAccountBtnClick() {
		Action.click(getDriver(), CreateAccountBtnClick);
		return new AccountCreationPage();
	}
	
	public boolean validateLogo() throws Throwable {	
		return Action.isDisplayed(getDriver(),lumaLogo);	
	}
	
	public SearchResultPage searchProduct(String productName) throws Exception {
		Action.fluentWaitVisibility(getDriver(), searchProductBox, 80);
		Action.type(searchProductBox, productName);
		Action.fluentWait(getDriver(), searchButton,80);				
		return new SearchResultPage();
	}	

}
