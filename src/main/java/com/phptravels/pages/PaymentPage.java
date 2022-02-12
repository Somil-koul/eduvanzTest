package com.phptravels.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(super.driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstname_1']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname_1']")
	private WebElement lastName;
	
	@FindBy(xpath ="//select[@class='form-select form-select nationality']")
	private WebElement nationalityDropdown;
	
	@FindBy(xpath="//select[@name='dob_month_1']")
	private WebElement dobMonthDropdown;
	
	@FindBy(xpath ="//select[@name='dob_day_1']")
	private WebElement dobDayDropdown;
	
	@FindBy(xpath ="//select[@name='dob_year_1']")
	private WebElement dobYearDropdown;
	
	@FindBy(id ="gateway_wallet-balance")
	private WebElement paymentCheckbox;
	
	@FindBy(id="agreechb")
	private WebElement agreeCheckbox;
	
	@FindBy(xpath ="//button[@id='booking']")
	private WebElement confirmBookingButton;
	
	@FindBy(xpath ="//button[@id='cookie_stop']")
	private WebElement cookiePolicy;

	@FindBy(xpath ="span[text()='Total Price:']")
	private WebElement totalPrice;
	
	@FindBy(xpath ="//div[@class='infobox infobox-danger']//strong[1]")
	public WebElement pendingMessage;
	
	@FindBy(xpath ="//input[@value='Proceed']")
	private WebElement proceedButton;
	
	@FindBy(xpath ="//button[@class='pay']")
	private WebElement payButton;
	
	@SuppressWarnings("deprecation")
	public void addPassengerDetails(String Fname,String Lname, String Day, String Month, String Year ) {	
		
		firstName.sendKeys(Fname);
		lastName.sendKeys(Lname);
	
		Select nationDrp = new Select(nationalityDropdown);
		nationDrp.selectByVisibleText("India");
		
		selectByVisibleText(dobMonthDropdown, Month);
		selectByVisibleText(dobDayDropdown, Day);
		selectByVisibleText(dobYearDropdown, Year);
		
		scrollDown();
		
		waitUntilVisbility(cookiePolicy);
		cookiePolicy.click();
		
		waitUntilClickable(paymentCheckbox);
		JsClick(paymentCheckbox);
		scrollDown();
		JsClick(agreeCheckbox);
		JsClick(confirmBookingButton);	
		
	}
	
	public void pay() {
		
		proceedButton.click();
		implicitWait(10000);
		payButton.click();
	}
	  

}
