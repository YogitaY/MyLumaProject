package com.luma.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.actiondriver.Action;
import com.luma.base.BaseClass;

public class HomePage extends BaseClass{
	static Action Action = new Action();
	
	@FindBy(xpath ="//*[@id=\"ui-id-3\"]")
	private WebElement whatsNewElement;
	
	@FindBy(xpath ="//a[@id='ui-id-4']")
	private WebElement womenElement;
	
	@FindBy(xpath ="//a[@id='ui-id-5']")
	private WebElement menElement;
	
	@FindBy(xpath ="//a[@id='ui-id-6']")
	private WebElement gearElement;
	
	@FindBy(xpath ="//a[@id='ui-id-7']")
	private WebElement trainingElement;
	
	@FindBy(xpath ="//a[@id='ui-id-8']")
	private WebElement saleElement;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateWhatsNewElement() throws Exception {
		WebElement[] HomeElements  = {whatsNewElement,womenElement,menElement,gearElement,trainingElement,saleElement};
		for(WebElement HomeElement : HomeElements)
		{
			Action.fluentWaitVisibility(getDriver(), HomeElement, 50);
			Action.isDisplayed(getDriver(), HomeElement);
		}
		return true;
		
	}

	public String getCurrentUrl() {
		String hompePageUrl = getDriver().getCurrentUrl();
		return hompePageUrl;
	}

}
