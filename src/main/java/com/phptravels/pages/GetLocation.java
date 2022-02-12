package com.phptravels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GetLocation extends BasePage {

	
	public GetLocation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(super.driver, this);
	
	}


	public void getSource(String source) {
		
		List<WebElement> sourcesList = driver.findElements(By.xpath("//div[@class='autocomplete-location']"));

		for (WebElement i: sourcesList){
		    
			String src = i.getText();	
			System.out.println(src);
			
		        if(src.contains(source)==true){
		         
		        	 String srcLoc= "//div[@class='autocomplete-location' and text()='" +src+"']";
		        	 System.out.println(srcLoc);
			         driver.findElement(By.xpath(srcLoc)).click();
			
		        }

		}
	
}

	
	public void getDestination(String destn) {
		
	List<WebElement> destinationList = driver.findElements(By.xpath("//div[@class='autocomplete-location']"));

	for (WebElement e: destinationList){
	    
		String destin = e.getText();	
		System.out.println(destin);
		
	        if(destin.contains(destn)==true){
	         
	        	 String destnLoc= "//div[@class='autocomplete-location' and text()='" +destin+"']";
	        	 System.out.println(destnLoc);
		         driver.findElement(By.xpath(destnLoc)).click();
		
	    }
	}
	
  }
	
}
