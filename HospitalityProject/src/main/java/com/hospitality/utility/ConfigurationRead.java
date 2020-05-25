package com.hospitality.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationRead {
	
	Properties pro;
	public ConfigurationRead()
	{
		try {
			pro=new Properties();
			File  src= new File("./config/config.properties");
			FileInputStream fis= new FileInputStream(src);
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File not found "+e.getMessage());
		} 
		
	}
	
	public String returnValue(String keytobesearched)
	{
		return pro.getProperty(keytobesearched);
	}

}
