package Aprimo;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class URlCheck_Production
{
	WebDriver driver;
	
	@Test(priority = 1, dataProvider = "testdata")
	public void setup(String username,String password) throws Exception
	{
		
		
		//Open Chrome Browser and launch Revenew website
		System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.aprimodm.com/Login2.aspx?ReturnUrl=/");
		//driver.findElement(By.id("lnksignon")).click();
		Thread.sleep(1000);
		
		//Login with credentials available in sheet
		driver.findElement(By.id("loginname")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("imgbtnSubmitAprimo")).click();
		Thread.sleep(1000);
		
		//Store value of loginowner name from hidden field
		JavascriptExecutor js = (JavascriptExecutor) driver;  
        String value = js.executeScript("return AppData.WorkingAccountOwner;").toString();		
		//WebElement hiddenInput = driver.findElement(By.id("hdnLoginOwner"));
		//String value = hiddenInput.getAttribute("value");
		//System.out.println("value of hidden field" +value);
		
		//Check logged in user is partner, manufacturer
		if(value.equals("Partners")) 
		{
									FileInputStream fis = new FileInputStream("C:\\Users\\monika\\Desktop\\urlsheet.xlsx");
									Workbook wb = new XSSFWorkbook(fis);
									Sheet ws = wb.getSheet("partnerurl");
									int rows = ws.getLastRowNum();
									for (int i = 0; i <= rows; i++)
										{
											Row row = ws.getRow(i);
											Cell cell = row.getCell(0);
											Cell urls = ws.getRow(i).getCell(0);
											String ss = urls.toString();
											driver.get(ss);
											Thread.sleep(200);
											//System.out.println(ss);
											
										}	
									
										
		} 
		else if(value.equals("Manufacturers"))
		{
			
				FileInputStream fis1 = new FileInputStream("C:\\Users\\monika\\Desktop\\urlsheet.xlsx");
				Workbook wb1 = new XSSFWorkbook(fis1);
				Sheet ws1 = wb1.getSheet("brandurl");
				int rows = ws1.getLastRowNum();
				for (int i = 0; i <= rows; i++)
					{
						Row row = ws1.getRow(i);
						Cell cell = row.getCell(0);
						Cell urls = ws1.getRow(i).getCell(0);
						String ss1 = urls.toString();
						driver.get(ss1);
						Thread.sleep(200);
						//System.out.println(ss1);
					}		
					
		} 
		else if(value.equals("Revenew"))
		{
			
			FileInputStream fis1 = new FileInputStream("C:\\Users\\monika\\Desktop\\urlsheet.xlsx");
			Workbook wb1 = new XSSFWorkbook(fis1);
			Sheet ws1 = wb1.getSheet("Adminurl");
			int rows = ws1.getLastRowNum();
			for (int i = 0; i <= rows; i++)
				{
					Row row = ws1.getRow(i);
					Cell cell = row.getCell(0);
					Cell urls = ws1.getRow(i).getCell(0);
					String ss1 = urls.toString();
					driver.get(ss1);
					Thread.sleep(200);
					//System.out.println(ss1);
				}		
				
	} else
			
		{
			System.out.println("User not exists");
		}
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] passData()
	{
		
		ExcelDataConfig Config = new ExcelDataConfig("C:\\Users\\monika\\Desktop\\urlsheet.xlsx");
		int rows = Config.getRowCount(0);
		int dataRowPosition = 1;
		Object[][] data = new Object[rows - dataRowPosition][3];
		for(int i = dataRowPosition; i < rows; i++) 
		{
			data[i - dataRowPosition][0]= Config.getData(0, i, 0);
			data[i - dataRowPosition][1]= Config.getData(0, i, 1);
			data[i - dataRowPosition][2]= Config.getData(0, i, 2);
		}
	
		return data;
	}
	
	@AfterMethod
	public void close() throws Exception
	{
		
		driver.close();
	}
	
}