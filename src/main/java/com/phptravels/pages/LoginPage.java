package com.phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(super.driver, this);
	}

   //Page Locators - Login Function
	@FindBy(xpath = "//a[contains(@class, 'theme-btn-transparent') and text()='Login']")
	private WebElement loginButtonHomePage;
	
	@FindBy(xpath = "//html//head//title")
	public WebElement loginPagetitle;
	
	@FindBy(xpath = "//input[@name='email' and @type='email']")
	private WebElement emailInputField;
	
	@FindBy(xpath = "//input[@name= 'password' and @type='password']")
	private WebElement passwordInputField;
	
	@FindBy(xpath = "//span[text()='Login']//parent::button")
	private WebElement loginButtonLoginPage;
	

	/**
	 * @return the loginPagetitle
	 */
//	public WebElement getLoginPagetitle() {
//		return loginPagetitle;
//	}

	
    public void loginToApp(String emailId, String password) {
    	
    	loginButtonHomePage.click();
    	emailInputField.sendKeys(emailId);
    	passwordInputField.sendKeys(password);
    	loginButtonLoginPage.click();
    }


    //Overloading loginToApp method - negative test case 
    public void loginToApp() {
    	loginButtonHomePage.click();
    	emailInputField.sendKeys();
    	passwordInputField.sendKeys();
    	loginButtonLoginPage.click();
    }
}