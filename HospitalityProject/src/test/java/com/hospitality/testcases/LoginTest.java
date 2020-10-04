package com.hospitality.testcases;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hospitality.Base.TestBase;
import com.hospitality.pages.HomePage;
import com.hospitality.utility.FillExcelUtility;

public class LoginTest extends TestBase {
	
	@Test(priority=1)
	public void loginToClearTrip()
	{
		logger=report.createTest("login to clearTrip.com");
		HomePage homepage= PageFactory.initElements(driver, HomePage.class);
		
		Map<String,String> data=FillExcelUtility.getExcelData2(System.getProperty("user.dir")+ "/TestData/ClearTrip.xlsx", "User");
		String user= data.get("UserID");
		System.out.println(user);
		
		
		logger.info("logined to the application");
		homepage.LoginToCleartrip(data.get("UserID"),data.get("Password"));
		Reporter.log("login is successful");//it's to write in TestNG report and true to write on console
		logger.pass("login is success");//it's to write the log in extent Report
	}
	
	
    @Test(priority =2, enabled= false)
    public void loginApp1()
    {
    	logger=report.createTest("test case 2");
    	logger.fail("test case is failed ");
    }
}
