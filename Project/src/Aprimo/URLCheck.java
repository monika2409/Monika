package Aprimo;

import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;

public class URLCheck 
{
	@Test
	public void url() {

		try {
				Assertions.initExtentReport(this.getClass().getSimpleName(), true);
				envinfo();
				//To read a file from location
				FileInputStream fis = new FileInputStream("C:\\Users\\monika\\Desktop\\urlsheet.xlsx");
				//workbook
				Workbook wb = new XSSFWorkbook(fis);
				Sheet ws = wb.getSheet("Sheet1");
				
				for(int i=0;i<10;i++)
				{
					Row row = ws.getRow(i);
					Cell cell = row.getCell(0);
					Cell urls = ws.getRow(i).getCell(0);
					String ss = urls.toString();
					System.out.println(ss);
					getDriver().get(ss);
				}
					
			}
		catch(Exception e )
		{
			
			
		}
			    
		}

	private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


