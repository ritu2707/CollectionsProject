package com.hospitality.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class CommonUtilities {
	
	//Utility for taking screenshot and it's path 
	public static String Screenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String scpath= System.getProperty("user.dir")+"/Screenshots/ClearTrip_"+getCurrentDateTime()+".png";
		//FileHandler.copyFile(src, "./Screenshots/login.png"); no more supported 
		try {
			//FileUtils.copyFile(src, new File("./Screenshots/login.png"));
			FileHandler.copy(src, new File(scpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to take Screeshot "+ e.getMessage());
		}
		return scpath;
	}
	
	//method to get current data and time
	public static String getCurrentDateTime()
	{
		String timestamp= new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
		return timestamp;
	}
	public static void handleframe(WebDriver driver,String name)
	{
		
	}
	//method to handle drop downs
	public static void SelectDropdownvalue(WebElement dropdownname,String tobeSelected)
	{
		Select sc=new Select(dropdownname);
		sc.selectByVisibleText(tobeSelected);		
	}
    //to perform mouse hover action
	public static void mouseHoverMethod(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();		
	}
	
	//select a date from Calendar
	public static void dateSelect(String date,WebElement calendar,WebDriver driver)
	{// id is sent as 2nd argument
		//((JavascriptExecutor)driver).executeScript ("document.getElementById('DepartDate').removeAttribute('readonly',0);");
		((JavascriptExecutor)driver).executeScript ("arguments[0].removeAttribute('readonly','readonly')", calendar);
		// Enables the from date box

		try {
			calendar.clear();
			calendar.sendKeys(date);// D, d M, yy
			calendar.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("calendar is not selected "+e.getMessage());
		}
	}
}
