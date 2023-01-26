package com.kotak.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

	public static String p;
	public static String rt;
	public static String y;
	
	public static Double Principal;
	public static Double rate;
	public static Double year;
	
	@DataProvider(name="userLoanData")
	@Test
	
	public Map<String, Double> LoanData() throws Exception
	{

FileInputStream fis=new FileInputStream("C:\\Users\\RESHMA\\git\\Kotak\\DataFiles\\Book1.xlsx");
		
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheet("Book1");
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
		Map<String,Double> mapdata=new HashMap<String,Double>();
		System.out.println("rows "+rows);
		System.out.println("cols "+cols);
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			Double value=(Double)row.getCell(1).getNumericCellValue();
			String key=(String)row.getCell(0).getStringCellValue();
			mapdata.put(key,value);
			
			if(p.equalsIgnoreCase(key))
			{
				 Principal=value;
			}
			else
				{
				if(rt.equalsIgnoreCase(key))
					 rate=value;
					else
					{	 
					if(y.equalsIgnoreCase(key))
						 year=value;
					}
				}
			    
			}
			
		return mapdata;
}
}




















//FileInputStream fis=new FileInputStream("C:\\Users\\RESHMA\\git\\Kotak\\DataFiles\\Book1.xlsx");
//XSSFWorkbook wrk=new XSSFWorkbook(fis);
//XSSFSheet sht=wrk.getSheet("Book1");
//DataFormatter dff=new DataFormatter();
//
//int rows=sht.getLastRowNum();	
//int cols=sht.getRow(0).getLastCellNum();
//System.out.println("rows="+rows);
//System.out.println("cols="+cols);
//String[][] data=new String[rows][cols];
//
//
//for(int r=0;r<rows;r++)
//{
//	XSSFRow row=sht.getRow(r); //due to index of row of array and Excel sheet 
//	for(int c=0;c<cols;c++)
//	{
//		data[r][c]=dff.formatCellValue(row.getCell(c));				
//		System.out.print(data[r][c]+"    ");
//		System.out.println("excel data"+data[r][c]);
//	}
//}
//fis.close();
//wrk.close();
//System.out.println("Done!!");
////	return data;
//				
//