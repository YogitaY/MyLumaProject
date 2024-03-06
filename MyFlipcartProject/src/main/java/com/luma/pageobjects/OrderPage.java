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
public class OrderPage extends BaseClass {
	static Action Action = new Action();
	
	@FindBy(xpath="//span[@class='base']")
	private WebElement shoppingCartTitle;
	
	@FindBy(xpath ="//td[@class='col price']/span/span/span")
	private WebElement unitPrice;
	
	@FindBy(xpath ="//td[@class='amount']/strong/span")
	private WebElement totalPrice;
	
	@FindBy(xpath ="//button[@type='button' and @data-role='proceed-to-checkout']")
	private WebElement procedtoChecout;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateShoppingCartTitle() {
		Action.fluentWaitVisibility(getDriver(), shoppingCartTitle,50);
		return Action.isDisplayed(getDriver(), shoppingCartTitle);
	}
	
	public double getUnitPrice() {
		Action.fluentWaitVisibility(getDriver(), unitPrice,50);
		String unitPrice1 = unitPrice.getText();
		String unit1=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit1);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		Action.fluentWaitVisibility(getDriver(), totalPrice,50);
		String TotalPrice1 = totalPrice.getText();
		String total1=TotalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total1);
		return finalTotalPrice/100;
	}
	
	
	public ShippingPage procedtoChecout1() throws Exception  {
		Action.ScrollByVisibilityOfElement(getDriver(), procedtoChecout);
		Action.fluentWaitVisibility(getDriver(), procedtoChecout,50);
		Action.JSClick(getDriver(),procedtoChecout);
		Thread.sleep(1000);
		Action.JSClick(getDriver(),procedtoChecout);
		Thread.sleep(1000);
		Action.JSClick(getDriver(),procedtoChecout);
		Thread.sleep(1000);
		Action.JSClick(getDriver(),procedtoChecout);
		Thread.sleep(1000);
		return new ShippingPage();
	}

}
