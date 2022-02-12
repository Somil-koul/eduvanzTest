package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Pages {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Pages(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	//abstract methods
	
	public abstract String getPageTitle();

	//explicit waits
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public abstract void selectByVisibleText(WebElement element, String value);

	public abstract void scrollDown();
	
	public abstract void JsClick(WebElement element);

	public abstract void waitUntilClickable(WebElement element);

	public abstract void implicitWait(int waittime);
	
	public abstract boolean waitUntilVisbility(WebElement element);

	
	
}
