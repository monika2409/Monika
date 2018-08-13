package Aprimo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import Aprimo.ExcelDataConfig;

public class ReadfromExcel {

	WebDriver driver;
	
	@Test(dataProvider = "testdata")
	public void setup(String Firstname,String Lastname, String Email) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://staging.aprimodm.com/Login2.aspx?ReturnUrl=/");
		//String a = driver.findElement(By.className("fancybox-iframe")).getAttribute("name");
		//System.out.println(a);
		driver.findElement(By.id("lnksignon")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='fancybox-iframe']")));
		driver.findElement(By.id("txtUserFName")).sendKeys(Firstname);
		driver.findElement(By.id("txtUserLName")).sendKeys(Lastname);
		driver.findElement(By.id("txtUserEmail")).sendKeys(Email);
		
		//driver.findElement(By.cssSelector("input[name='txtUserPhoneNo']")).sendKeys(""+count);
		driver.findElement(By.id("rbtnNewPartner")).isSelected();
		Thread.sleep(5000);
		}
	@DataProvider(name="testdata")
	public Object[][] passData(){
		
		ExcelDataConfig Config = new ExcelDataConfig("C:\\Users\\monika\\Desktop\\readexcel.xlsx");
		int rows = Config.getRowCount(0);
		Object[][] data = new Object[rows][3];
		for(int i=0;i<rows;i++) {
		data[i][0]= Config.getData(0, i, 0);
		data[i][1]= Config.getData(0, i, 1);
		data[i][2]= Config.getData(0, i, 2);
		//data[i][3]= Config.getData(0, i, 3);
		}
		return data;


	}
	@AfterMethod
	public void Quit() {
		
		driver.close();
	}

}
