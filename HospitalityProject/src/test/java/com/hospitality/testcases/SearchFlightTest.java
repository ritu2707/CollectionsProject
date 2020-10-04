package com.hospitality.testcases;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hospitality.Base.TestBase;
import com.hospitality.pages.FlightPage;
import com.hospitality.utility.FillExcelUtility;

public class SearchFlightTest extends TestBase {	
	
	@Test(description="test to search one way flight list ",priority=1, enabled= true)
	public void flightSearching() throws InterruptedException {
		
		logger=report.createTest("Flight searcing for one way");
		
		logger.info("test case to search one way Flight");
		Reporter.log("one way flight search test case is started");
		FlightPage fp=PageFactory.initElements(driver, FlightPage.class);
		//fp.onewayFlight("New Delhi", "Chennai", "Fri, 12 Jun, 2020", "1", "2", "1");
		Map<String,String> data= FillExcelUtility.getExcelData2(System.getProperty("user.dir")+ "/TestData/ClearTrip.xlsx", "OneWay");
		fp.onewayFlight(data.get("FromCity"), data.get("ToCity"), data.get("DepartDate"), data.get("Adult"), data.get("Child"), data.get("Infant"));
		logger.info("test case to search one way Flight is completed");
		Reporter.log("one way flight search test case is completed");
	    
	}
	
	@Test(description="test to search round trip flight list ",priority=2)
	public void flightSearching_roundTrip() throws InterruptedException {
		
		logger=report.createTest("Flight searcing for round trip ");
		logger.info("test case to search one way Flight");
		Reporter.log("round trip flight search test case is started");
		FlightPage fp=PageFactory.initElements(driver, FlightPage.class);
		Map<String,String> data= FillExcelUtility.getExcelData2(System.getProperty("user.dir")+ "/TestData/ClearTrip1.xlsx", "roundTrip");
		fp.roundTripFlight(data.get("FromCity"), data.get("ToCity"), data.get("DepartDate"), data.get("ReturnDate"), data.get("Adult"), data.get("Child"), data.get("Infant"));
		logger.info("test case to search round trip Flight is completed");
		Reporter.log("Round Trip flight search test case is completed");
	    
	}

}
