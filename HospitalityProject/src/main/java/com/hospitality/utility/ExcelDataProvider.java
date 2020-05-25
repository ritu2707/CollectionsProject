package com.hospitality.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook xb;
	public ExcelDataProvider() 
	{
		try {
			File src= new File("./TestData/testdata.xlsx");
			FileInputStream fis= new FileInputStream(src);
			
				xb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File Not found"+ e.getMessage());
		
	}
	}
		
		public String getStringvalue(String sheetname,int row,int col)
		{
			return xb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		public double getintvalue(String sheetname,int row,int col)
		{
			return xb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
		}
}

