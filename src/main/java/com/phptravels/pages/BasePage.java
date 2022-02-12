package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends Pages {

	public BasePage(WebDriver driver) {
		super(driver);	
	}

	@Override 
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public void waitForElementPresent(By locator) {
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		} catch (Exception e) {
			
			System.out.println("exception/error occured while waiting for element " +locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		
		try {
			wait.until(ExpectedConditions.titleContains(title));
			
		} catch (Exception e) {
			
			System.out.println("exception/error occured while waiting for title " +title);
			e.printStackTrace();
		}
	}
	
	
	/* To Perform Select Option by Visible Text */
	@Override
	public void selectByVisibleText(WebElement element, String value) {
		
		Select se = new Select(element);
		se.selectByVisibleText(value);
	}
	
	@Override
	public void scrollDown() {
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	/* To click a certain Web Element using DOM/ JavaScript Executor */
	@Override
	public void JsClick(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	@Override
	public void waitUntilClickable(WebElement element) {
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	@Override
	public boolean waitUntilVisbility(WebElement element) {
		boolean status = false;

		for (int i = 0; i <= 2; i++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 5);
				status = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
				break;

			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {

				}
				i++;
			}

		}
		return status;
	}
	
	@Override
	public void implicitWait(int waittime) {
		
		try {
			Thread.sleep(waittime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
}
