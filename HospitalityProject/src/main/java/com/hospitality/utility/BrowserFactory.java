package com.hospitality.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	public static WebDriver StartApplication(WebDriver driver,String browsername,String URL)
	{
     if (browsername.equals("Chrome"))
     {
    	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	 driver=new ChromeDriver();
     }
     else if(browsername.equals("Firefox"))
     {
    	 System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    	 driver=new FirefoxDriver();
     }
     else if(browsername.equals("Edge"))
     {
    	 System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
    	 driver=new EdgeDriver();
     }
     else
     {
    	 System.out.println("browser is not in the list");
     }
     driver.manage().window().maximize();
     driver.get(URL);
     return driver;
	}
	
	public static void SignOff(WebDriver driver)
    {
    	driver.quit();
    }

}
