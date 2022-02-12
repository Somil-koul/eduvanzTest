package com.phptravels.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.phptravels.pages.BookFlightsPage;
import com.phptravels.pages.LoginPage;
import com.phptravels.pages.PaymentPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	BookFlightsPage flightPage;
	PaymentPage paymentPage;
	
	@Test(priority=1, enabled =true)
	public void verifyLogin() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		loginPage.loginToApp("user@phptravels.com", "demouser");
	}
	
	@Test(priority=2, enabled =true)
	public void testFlightBooking() {
		
		flightPage = new BookFlightsPage(driver);
		flightPage.enterRoute("Mumbai", "Delhi");
		
	}
	@Test(priority=3, enabled =true)
	public void selectFlightTest() {
		
		flightPage = new BookFlightsPage(driver);
		flightPage.selectFlight();
		
	}
	
	@Test(priority=4, enabled =true)
	public void testPaymentPage() {
		
		paymentPage = new PaymentPage(driver);
		paymentPage.addPassengerDetails("TestFName", "TestLName", "19", "03 March", "1997");	
		String paymentStatus = paymentPage.pendingMessage.getText();
		System.out.println(paymentStatus);
		Assert.assertEquals(paymentStatus,"Pending");	
		paymentPage.pay();

		
	}
}