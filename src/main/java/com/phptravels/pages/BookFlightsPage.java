package com.phptravels.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.iterators.ArrayListIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.phptravels.*;

public class BookFlightsPage {
	
WebDriver driver;	

public BookFlightsPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//a[text()='flights']")
	private WebElement flightsNavBar;
	
	@FindBy(xpath="//input[@placeholder='Flying From' and @id='autocomplete']")
	private WebElement sourceInputField;
	
	@FindBy(xpath ="//div[@class='autocomplete-location' and text()='Mumbai, India']")
	private WebElement sourceValue;
	
	@FindBy(css =".autocomplete-wrapper #autocomplete2")
	private WebElement destinationInputField;
	
	@FindBy(xpath ="//div[@class='autocomplete-location' and text()='Delhi, India']")
	private WebElement destinationValue;
	
	@FindBy(id ="#one-way")
	private WebElement oneWay;
	
	@FindBy(xpath="//button[@id='flights-search']")
	private WebElement searchFlightsButton;
	
	@FindBy(xpath="//h2[text()='SEARCH FOR BEST FLIGHTS' ]//parent::div")
	public WebElement flightsHeader;
	
	//Tickets 
	@FindBy(xpath="//button[@type='submit']//strong")
	public WebElement priceButton;
	
	@FindBy(xpath="//button[@type='submit']//strong")
	public WebElement bookFlightButton;
		
	public void enterRoute(String source, String destination){
		
		 flightsNavBar.click();
		 sourceInputField.sendKeys(source);
		 sourceValue.click();
		 destinationInputField.sendKeys(destination);
		 destinationValue.click();
		 searchFlightsButton.click();
	}
	
	public void selectFlight() {
		
		List<WebElement> prices = driver.findElements(By.xpath("//button[@type='submit']//strong"));
		int noOfFlights = prices.size();
		System.out.println("Total flights for the selected route " +noOfFlights);
		
	for(int i =0; i<1; i++)	{
		for (WebElement ele: prices) {		
				try {
					
					String individualPrice = ele.getText();
				    System.out.println("Individual price is " +individualPrice);
				    driver.findElement(By.xpath("//button[@type='submit']//strong[text()='"+individualPrice+"']")).click();
				    
				} catch (Exception e) {
					e.printStackTrace();
				}		
		     	
		}
		
	}
		/*lowest flight price selection -unfixed
		 *
		 * List<WebElement> prices = driver.findElements(By.xpath("//button[@type='submit']//strong"));
		int noOfFlights = prices.size();
		System.out.println("No Of flights for the selected route " +noOfFlights);
	
		HashSet<Float>priceSet = new HashSet<Float>();
		ArrayList<Float> priceList = new ArrayList<Float>();
	
		for (WebElement ele: prices) {		
						
		     	String individualPrice = ele.getText();
			   //System.out.println("Individual price is " +individualPrice);
			    String floatPrice= individualPrice.replaceAll("[a-zA-Z]*", "");
			    
			    Float floatVal = Float.valueOf(floatPrice).floatValue();
			    //System.out.println("Current flight Price is " +floatVal);
			    priceSet.add(floatVal);
			    
				}

				Float[] sortedPriceArray = priceSet.toArray(new Float[priceSet.size()]);
				float lowestFlightPrice = sortedPriceArray[0];
				driver.findElement(By.xpath("//button[@type='submit']//strong[text()= 'USD "+lowestFlightPrice+"']")).click();
			
	*/

			
		}	
	  	
   }

