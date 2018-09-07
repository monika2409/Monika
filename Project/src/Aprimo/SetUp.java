package Aprimo;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SetUp 
{
	WebDriver driver;
	
	@Test(priority = 1)
	public void setup(String Username, String Password) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.aprimodm.com/Login2.aspx");
		
		Thread.sleep(200);
		
		driver.findElement(By.id("loginname")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("imgbtnSubmitAprimo")).click();
	}
	
	@Test
	public void urls() throws IOException 
	{
		
		try 
		{
			FileInputStream fis1 = new FileInputStream("C:\\Users\\monika\\Desktop\\urlsheet.xlsx");
			Workbook wb1 = new XSSFWorkbook(fis1);
			Sheet ws1 = wb1.getSheet("partnerurl");
			int rows = ws1.getLastRowNum();
			for (int i = 0; i <= rows; i++)
			{
				Row row = ws1.getRow(i);
				Cell cell = row.getCell(0);
				Cell urls = ws1.getRow(i).getCell(0);
				String ss = urls.toString();
				driver.get(ss);
				
				Thread.sleep(200);
				
				System.out.println(ss);
			}		
		}
		catch(Exception e) 
		{
			
		}
	}
	@DataProvider(name="testdata")
	public Object[][] passData()
	{
		ExcelDataConfig Config = new ExcelDataConfig("C:\\Users\\monika\\Desktop\\readexcel.xlsx");
		
		int rows = Config.getRowCount(0);
		int dataRowPosition = 1;
		int col = 
		
		Object[][] data = new Object[rows - dataRowPosition][15];
		
		for(int i = dataRowPosition; i < rows; i++) 
		{
			data[i - dataRowPosition][0]= Config.getData(0, i, 0);
			data[i - dataRowPosition][1]= Config.getData(0, i, 1);
		}
	
		return data;
	}
}
