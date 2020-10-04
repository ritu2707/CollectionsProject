package com.hospitality.utility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloTest {

	public static void main(String[] args) throws FilloException {
		// TODO Auto-generated method stub
		
		Fillo fillo= new Fillo();
		Connection connection =fillo.getConnection(System.getProperty("user.dir")+ "/TestData/ClearTrip.xlsx");
		String strquery= "Select * from OneWay";
		Recordset recordset= connection.executeQuery(strquery );
		while(recordset.next())
		{
			System.out.println(recordset.getField("FromCity"));
			//System.out.println(recordset.getField("Password"));
		}
		
		recordset.close();
		connection.close();

	}

}
