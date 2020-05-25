package com.hospitality.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hospitality.Base.TestBase;
import com.hospitality.pages.FlightPage;

public class SearchFlightTest extends TestBase {	
	
	@Test(description="test to search one way flight list ",priority=1)
	public void flightSearching() throws InterruptedException {
		logger=report.createTest("Flight searcing for one way");
		logger.info("test case to search one way Flight");
		Reporter.log("one way flight search test case is started");
		FlightPage fp=PageFactory.initElements(driver, FlightPage.class);
		fp.onewayFlight("New Delhi", "Chennai", "Fri, 12 Jun, 2020", "1", "2", "1");
		logger.info("test case to search one way Flight is completed");
		Reporter.log("one way flight search test case is completed");
	    
	}

}
