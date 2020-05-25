package com.hospitality.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hospitality.Base.TestBase;
import com.hospitality.pages.HomePage;

public class LoginTest extends TestBase {
	
	@Test(priority=1)
	public void loginToClearTrip()
	{
		logger=report.createTest("login to clearTrip.com");
		HomePage homepage= PageFactory.initElements(driver, HomePage.class);
		logger.info("logined to the application");
		homepage.LoginToCleartrip("ritu.aparna2707@gmail.com", "May@2020");
		Reporter.log("login is successful");//it's to write in TestNG report and true to write on console
		logger.pass("login is success");//it's to write the log in extent Report
	}
	
	
    @Test(priority =2)
    public void loginApp1()
    {
    	logger=report.createTest("test case 2");
    	logger.fail("test case is failed ");
    }
}
