package com.hospitality.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class CommonUtilities {
	
	public static String Screenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String scpath= System.getProperty("user.dir")+"Screenshots/ClearTrip_"+getCurrentDateTime()+".png";
		//FileHandler.copyFile(src, "./Screenshots/login.png"); no more supported 
		try {
			//FileUtils.copyFile(src, new File("./Screenshots/login.png"));
			FileHandler.copy(src, new File("./Screenshots/ClearTrip_"+getCurrentDateTime()+".png"));
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
	public static void dateSelect(String date,WebDriver calendar,WebDriver driver)
	{
		
	}
}
