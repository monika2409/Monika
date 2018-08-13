package Aprimo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Admin
 *
 */
public class NewTest
{
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
	//XSSFWorkbook wb;

 @BeforeTest
 /*public void TestSetup()
{
	// Set the path of the Firefox driver.
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	// Enter url.
	driver.get("http://staging.aprimodm.com");
	driver.manage().window().maximize();
	
	wait = new WebDriverWait(driver,30);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}*/
 

@SuppressWarnings("resource")
@Test
 public void ReadData() throws IOException
 {
	try{
		File src=new File("C:\\Users\\monika\\Desktop\\readexcel.xlsx");
	 
	   // load file
	   FileInputStream fis=new FileInputStream(src);
	 
	   // Load workbook
	   XSSFWorkbook wb=new XSSFWorkbook(fis);
	   
	   // Load sheet- Here we are loading first sheetonly
	      XSSFSheet sh1= wb.getSheetAt(0);
	 
	  // getRow() specify which row we want to read.
	 
	  // and getCell() specify which column to read.
	  // getStringCellValue() specify that we are reading String data.
	 
	 System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
	 
	 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
	 
	 System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
	 
	 System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
	 
	  } catch (Exception e) {
	 
	   System.out.println(e.getMessage());
	 
	  }
	  
	 }
}
