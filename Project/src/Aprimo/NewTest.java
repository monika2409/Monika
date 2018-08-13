package Aprimo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://staging.revenewnetwork.com/Login.aspx?ReturnUrl=/");
		driver.findElement(By.id("lnksignon")).click();
		
  }
  
  @Dataprovider
  public void readexcel() {
	  
  }
  
}
