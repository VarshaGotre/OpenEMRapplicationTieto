package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void readProperties() throws IOException
	{
		FileInputStream fis=new FileInputStream("testdata/data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String baseUrl=prop.getProperty("url");
		System.out.println(baseUrl);
	}
		
	@Test
	public void excelRead() throws IOException
	{
	FileInputStream file = new FileInputStream("testdata/OpenEMRData.xlsx");

	XSSFWorkbook book = new XSSFWorkbook(file);

	XSSFSheet sheet = book.getSheet("validCredentialData");

	int rowCount=sheet.getPhysicalNumberOfRows();
	System.out.println(rowCount);
	
	int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println(cellCount);
	
	Object[][] main=new Object[rowCount-1][cellCount];
	
	DataFormatter format = new DataFormatter();
	for(int r=1;r<rowCount;r++)
	{
		XSSFRow row = sheet.getRow(r);	
		for(int c=0;c<cellCount;c++)
		{
			XSSFCell cell = row.getCell(c);	
			
			String cellValue= format.formatCellValue(cell);
			
			System.out.println(cellValue);
			main[r-1][c]=cellValue;
		}
	}
	
	book.close();
	file.close();
}
	}
		
	//john,john123
	//peter,peter123
	//paul,paul123
	
//	@DataProvider
//	public Object[][] fillFormData()
//	{
//		Object[][] main=new Object[3][2];
//		//i no. of test cases
//		//j no. of parameters
//		
//		main[0][0]="john";
//		main[0][1]="john123";
//		
//		main[1][0]="peter";
//		main[1][1]="peter123";
//		
//		main[2][0]="paul";
//		main[2][1]="paul123";
//		
//		return main;
//		
//	}
//	
//	//john,john123                                //peter,peter123
//	//French(std)								  //Armenian
//	//Invalid username or pwd	                  //Invalid username or pwd
//	
//	@DataProvider
//	public Object[][] invalidData()
//	{
//		Object[][] obj= new Object[2][4];
//		obj[0][0] = "john";
//		obj[0][1] = "john123";
//		obj[0][2] = "French(std)";
//		obj[0][3]= "Invalid username or pwd";
//		
//		obj[1][0] = "peter";
//		obj[1][1] = "peter123";
//		obj[1][2] = "Armenian";
//		obj[1][3]= "Invalid username or pwd";
//		
//		return obj;
//	}
//		
//				
//			
//	@Test(dataProvider="fillFormData")
//	public void fillFormTest(String username,String pwd)
//	{
//		System.out.println(username+pwd);
//	}
//	
//	@Test(dataProvider="invalidData")
//	
//	public void invalidTest(String uname,String password,String language,String expectedValue)
//	{
//		System.out.println(uname+password+language+expectedValue);
//	}
//
//}
