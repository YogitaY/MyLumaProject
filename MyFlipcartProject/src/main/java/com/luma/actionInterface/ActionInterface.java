package com.luma.actionInterface;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	public void ScrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void click(WebDriver driver, WebElement ele);
	public boolean findElement(WebDriver driver, WebElement ele);
	public boolean isDisplayed(WebDriver driver , WebElement ele);
	public boolean isSelected(WebDriver driver , WebElement ele);
	public boolean isenabled(WebDriver driver, WebElement ele);
	public boolean type(WebElement ele, String text);
	public boolean selectBySendkeys(String value,WebElement ele);
	public boolean selectByIndex(WebElement element, int index);
	public boolean selectByValue(WebElement element,String value);
	public boolean selectByVisibleText(String visibletext, WebElement ele);
	public boolean JSClick(WebDriver driver, WebElement ele);
	public boolean launchUrl(WebDriver driver,String url);
	public String getTitle(WebDriver driver);
	public String getCurrentURL(WebDriver driver) ;
	public void implicitWait(WebDriver driver, int timeOut);
	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut );
	public void pageLoadTimeOut(WebDriver driver, int timeOut) ;
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	public void fluentWaitVisibility(WebDriver driver,WebElement element, int timeOut);
	public String screenShot(WebDriver driver, String filename);

}
