package com.hospitality.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hospitality.Base.TestBase;
import com.hospitality.utility.CommonUtilities;

public class FlightPage extends TestBase{
	
	//OR of Flight page
	@FindBy(id="OneWay")
	WebElement oneway;
	
	@FindBy(id="RoundTrip")
	WebElement RoundTrip;
	
	@FindBy(id="MultiCity")
	WebElement multiCity;
	
	@FindBy(id="FromTag")
	WebElement frominput;
	
	@FindBy(id="ToTag")
	WebElement ToInput;

	@FindBy(id="DepartDate")
	WebElement departdate;
	
	@FindBy(id="ReturnDate")
	WebElement returndate;
	
	@FindBy(id="Adults")
	WebElement Adultsdropdown;
	
	@FindBy(id="Childrens")
	WebElement childdropdown;
	
	@FindBy(id="Infants")
	WebElement infantdropdown;
	
	@FindBy(id="SearchBtn")
	WebElement SearchButton;
	
	//to search one way flight
	public void onewayFlight(String from, String to,String datedepart,String Adult,String child,String infant) throws InterruptedException
	{
		frominput.sendKeys(from);
		ToInput.sendKeys(to);
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('DepartDate').removeAttribute('readonly',0);"); // Enables the from date box

		//WebElement fromDateBox= driver.findElement(By.id("fromDate"));
		departdate.clear();
		departdate.sendKeys(datedepart); // D, d M, yy
		Thread.sleep(5000);
		
		CommonUtilities.SelectDropdownvalue(Adultsdropdown, Adult);
		Thread.sleep(2000);
		CommonUtilities.SelectDropdownvalue(childdropdown, child);
		Thread.sleep(2000);
		CommonUtilities.SelectDropdownvalue(infantdropdown, infant);
		Thread.sleep(2000);
		SearchButton.click();
		
		
	}
	
	
	
	

}
