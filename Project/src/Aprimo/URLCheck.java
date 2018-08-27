package Aprimo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

public class URLCheck {
	
public static void main(String[] args)throws InterruptedException {

		
		//String url = driver.getCurrentUrl();
		//System.out.println("currenturl" +url);
		
		try {
			    
				WebDriver driver;
				System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get("https://staging.aprimodm.com/Login2.aspx?ReturnUrl=/");
				Thread.sleep(200);
				driver.findElement(By.id("loginname")).sendKeys("NE");
				driver.findElement(By.id("password")).sendKeys("NE1");
				driver.findElement(By.id("imgbtnSubmitAprimo")).click();
				Thread.sleep(500);
				FileInputStream file = new FileInputStream("C:\\Users\\monika\\Desktop\\readexcel.xlsx");
			    FileOutputStream outFile=new FileOutputStream("C:\\Users\\monika\\Desktop\\readexcel.xlsx");
			    HSSFWorkbook workbook=new HSSFWorkbook(file);
			    HSSFSheet sheet=workbook.getSheetAt(2);
			    HSSFCell cell=null;     
			    int s=sheet.getLastRowNum()+1;
			    for(int i=0; i<s; i++)
			    {
			    	cell=sheet.getRow(i).getCell(0);
			        String url=cell.toString();
			        driver.get(url);
			        Thread.sleep(10000);
			        String urlnew=driver.getCurrentUrl().toString();
			        HSSFRow row=sheet.getRow(i);
			        HSSFCell cellresult=row.createCell(1);
			        if(url.equals(urlnew))
			        {
			            cellresult.setCellValue("Pass");
			        }
			        else
			        {
			            cellresult.setCellValue("fail");
			        }
			       workbook.write(outFile);
			    }
			workbook.close();  
			file.close();
			outFile.close();	
		}
		catch(Exception ex )
		{
			
			
		}
			    
		}
	
	}


