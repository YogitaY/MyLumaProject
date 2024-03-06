/**
 * 
 */
package com.luma.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Throwables;
import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;

/**
 * 
 */
public class AddToCartPage extends BaseClass {
	static Action Action = new Action();
	
	@FindBy(xpath = "//ol/li[1]//img[@class='product-image-photo']")
	private WebElement clickOnProduct;
	
	@FindBy(xpath = "//*[@id=\"option-label-size-143-item-170\"]")
	private WebElement sizeSelection;
	
	@FindBy(id ="option-label-color-93-item-56")
	private WebElement colorSelection;
	
	@FindBy(id ="qty")
	private WebElement quantity;
	
	@FindBy(xpath ="//*[@id=\"product-addtocart-button\"]")
	private WebElement addToCartClick;
	
	@FindBy(xpath="//div[1]/div[2]/div/div/div/a")
	private WebElement addToCartMessage;
	
	@FindBy(xpath="//div[2]/header/div[2]/div[1]/a")
	private WebElement addToCartMessageClick;
	
	@FindBy(xpath ="//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a")
	private WebElement veiwAddTocart;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]//button[@title='Proceed to Checkout']")
	private WebElement proceedToCheckout;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//	public void clickOnProduct() throws Exception {
////		Action.click(getDriver(), clickOnProduct);
//		Action.fluentWait(getDriver(), clickOnProduct,50);
////		Thread.sleep(3000);
//	}
	
	
	public void sizeSelection1() throws Exception {
//		Thread.sleep(2000);
		
		System.out.println("before size selected");
		Action.fluentWait(getDriver(), sizeSelection,50);
//		Action.click(getDriver(),sizeSelection);
		System.out.println("after size selected");
//		JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
//		js2.executeScript("arguments[0].scrollIntoView(true);",colorSelection);
	}
	
	public void colorSelection1() throws Exception {
//		Thread.sleep(2000);
//		JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
//		js2.executeScript("arguments[0].scrollIntoView(true);",colorSelection);
		Action.ScrollByVisibilityOfElement(getDriver(), colorSelection);
		Action.fluentWait(getDriver(), colorSelection,50);
//		System.out.println("before color selected");
//		Action.click(getDriver(),colorSelection);
//		System.out.println("after color selected");
	}
	
	public void quantity1(String number) throws Exception {
//		Thread.sleep(2000);
//		Action.fluentWait(getDriver(), quantity,50);
//		System.out.println("before quantity selected");
		Action.fluentWaitVisibility(getDriver(), quantity, 50);
		Action.type(quantity,number);
//		System.out.println("after quantity selected");
//		JavascriptExecutor js3 = (JavascriptExecutor) getDriver();
//		js3.executeScript("arguments[0].scrollIntoView(true);",addToCartClick);
	}
	
	public void clickOnAddToCart() throws Exception{
		Action.ScrollByVisibilityOfElement(getDriver(), addToCartClick);
		Action.fluentWait(getDriver(), addToCartClick,50);
		System.out.println("after clicked addtocart selected");
	}
	
	public boolean validateaAddToCart() throws Exception{
		System.out.println("before addToCartMessage");
		Action.ScrollByVisibilityOfElement(getDriver(), sizeSelection);
		Thread.sleep(2000);
		Action.fluentWaitVisibility(getDriver(), addToCartMessage, 50);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public void addToCartIconClick() throws Exception {
		Action.ScrollByVisibilityOfElement(getDriver(), addToCartMessageClick);
		System.out.println("before addToCartMessageClick");
		Action.fluentWait(getDriver(), addToCartMessageClick,50);		
	}

	public OrderPage veiwAddTocartPage() {
		Action.fluentWaitVisibility(getDriver(), veiwAddTocart, 50);
		Action.JSClick(getDriver(), veiwAddTocart);
		return new OrderPage();
	}
	
}
