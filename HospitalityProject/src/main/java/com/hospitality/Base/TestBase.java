package com.hospitality.Base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hospitality.utility.BrowserFactory;
import com.hospitality.utility.CommonUtilities;
import com.hospitality.utility.ConfigurationRead;

public class TestBase {
		
	public static WebDriver driver;
	public static ConfigurationRead cr;
	public static ExtentHtmlReporter extent;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	// Extent report logger of class ExtentTest is used to write the logs on Extent reports
	// to understand the failure of the statements, we can write logs -Reporter.log for custom logs
	//we can use Apache4j log as well - bt that is via listener, so it will have standard/pre defined logs 
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting is going to be done",true);
		cr=new ConfigurationRead();
		extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/extentReport_"+CommonUtilities.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting is done-test can be started",true);
		//logger.info("extent report is set up");
		
	}
	@BeforeClass
	public void setUp()
	{
		Reporter.log("Browser can be started",true);
		driver= BrowserFactory.StartApplication(driver,cr.returnValue("browser"),cr.returnValue("url") );
		Reporter.log("Browser launched",true);
	}

	
    @AfterClass
    public void tearDown()
    {
    	BrowserFactory.SignOff(driver);
    }
    
    @AfterMethod
    public void failResults(ITestResult result) throws IOException
    {
    	Reporter.log("Test is about to end",true);
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		//logger.fail("test case is failed ",MediaEntityBuilder.createScreenCaptureFromPath(CommonUtilities.Screenshot(driver)).build());
    		//logger.addScreenCaptureFromPath(CommonUtilities.Screenshot(driver));
    		String despath= CommonUtilities.Screenshot(driver);
    		//logger.log(Status.FAIL, logger.addScreenCaptureFromPath(despath));
    		logger.log(Status.FAIL, "test case is failed ",MediaEntityBuilder.createScreenCaptureFromPath(CommonUtilities.Screenshot(driver)).build());
    		
    		}
    	else if(result.getStatus()==ITestResult.SUCCESS)
    	{
    		String screenshotPath=CommonUtilities.Screenshot(driver);
    		//logger.pass("test case is passed", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtilities.Screenshot(driver)).build());
    		//logger.addScreenCaptureFromPath(CommonUtilities.Screenshot(driver));
    		logger.log(Status.PASS, "test case is passed ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    	}
    	report.flush();
    	
    	Reporter.log("report is generated ",true);
    }
    
}
