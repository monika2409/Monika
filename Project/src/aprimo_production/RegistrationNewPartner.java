package aprimo_production;


//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import Aprimo.SetUp;
//import Aprimo.ExcelDataConfig;

import Aprimo.ExcelDataConfig;

public class RegistrationNewPartner
{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\monika\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://aprimodm.com/Login2.aspx?ReturnUrl=/");
		driver.findElement(By.id("lnksignon")).click();
		Thread.sleep(200);
		
	}
	
	@Test(dataProvider = "testdata")
	public void setup(String Firstname,String Lastname, String Email, String phone, String Companyname, String StreetAddress, String City, String Country,
					  String State, String zipcode, String phone1, String contactemail, String website, String industry, String brandreferral) 
							  throws InterruptedException 
	{
		
		//String a = driver.findElement(By.className("fancybox-iframe")).getAttribute("name");
		//System.out.println(a);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='fancybox-iframe']")));
		driver.findElement(By.id("txtUserFName")).sendKeys(Firstname);
		driver.findElement(By.id("txtUserLName")).sendKeys(Lastname);
		driver.findElement(By.id("txtUserEmail")).sendKeys(Email);
		driver.findElement(By.id("txtUserPhoneNo")).sendKeys(phone);
		//driver.findElement(By.id("txtUserPhoneNo")).sendKeys(String.valueOf(phone));
		//driver.findElement(By.cssSelector("input[name='txtUserPhoneNo']")).sendKeys(Integer.toString(phone));
		driver.findElement(By.id("rbtnNewPartner")).isSelected();
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtCompanyName")).sendKeys(Companyname);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtAddress")).sendKeys(StreetAddress);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtCity")).sendKeys(City);
		Thread.sleep(500);
		Select countrydrpdwn = new Select(driver.findElement(By.id("MainContent_ddlCountry")));
		countrydrpdwn.selectByVisibleText(Country);
		Thread.sleep(500);
		Select statedrpdwn = new Select(driver.findElement(By.id("MainContent_ddlState")));
		statedrpdwn.selectByVisibleText(State);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtZipCode")).sendKeys(zipcode);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtUserPhoneNo")).sendKeys(phone1);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtEmailAddress")).clear();
		driver.findElement(By.id("MainContent_txtEmailAddress")).sendKeys(contactemail);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtWebsite")).sendKeys(website);
		Thread.sleep(500);
		//driver.findElement(By.id("MainContent_ddlNetwork")).sendKeys(industry);
		Select industrydrpdwn = new Select(driver.findElement(By.id("MainContent_ddlNetwork")));
		industrydrpdwn.selectByVisibleText(industry);
		Thread.sleep(500);
		Select brandreferraldrpdwn = new Select(driver.findElement(By.id("MainContent_ddlManufacturerList")));
		brandreferraldrpdwn.selectByVisibleText(brandreferral);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		Thread.sleep(1000);
		driver.get("https://aprimodm.com/Login2.aspx?ReturnUrl=/");
		Thread.sleep(1000);
		driver.findElement(By.id("loginname")).sendKeys("varunverma");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("imgbtnSubmitAprimo")).click();
		Thread.sleep(1000);
		driver.get("https://staging.aprimodm.com/Registration/ApprovePartnerList.aspx");
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_txtManufacterName")).sendKeys(Companyname);
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_btnSearch")).click();
		Thread.sleep(1000);
		try
		{
			Assert.assertEquals(driver.findElement(By.id("MainContent_dgPartner_lnkPartnerName_0")).getText(), Companyname, "Company Not registered Successfully.");
		} 
		catch(AssertionError e) 
		{
			System.out.println("User not registered.");
		    throw e;
		}
		System.out.println("User registered successfully.");
		}
		
	@DataProvider(name="testdata")
	public Object[][] passData()
	{
		ExcelDataConfig Config = new ExcelDataConfig("C:\\Users\\monika\\Desktop\\readexcel.xlsx");
		
		int rows = Config.getRowCount(0);
		
		
		int dataRowPosition = 1;
		
		Object[][] data = new Object[rows - dataRowPosition][15];
		
		for(int i = dataRowPosition; i < rows; i++) 
		{
			data[i - dataRowPosition][0]= Config.getData(0, i, 0);
			data[i - dataRowPosition][1]= Config.getData(0, i, 1);
			data[i - dataRowPosition][2]= Config.getData(0, i, 2);
			data[i - dataRowPosition][3]= Config.getData(0, i, 3);
			data[i - dataRowPosition][4]= Config.getData(0, i, 4);
			data[i - dataRowPosition][5]= Config.getData(0, i, 5);
			data[i - dataRowPosition][6]= Config.getData(0, i, 6);
			data[i - dataRowPosition][7]= Config.getData(0, i, 7);
			data[i - dataRowPosition][8]= Config.getData(0, i, 8);
			data[i - dataRowPosition][9]= Config.getData(0, i, 9);
			data[i - dataRowPosition][10]= Config.getData(0, i, 10);
			data[i - dataRowPosition][11]= Config.getData(0, i, 11);
			data[i - dataRowPosition][12]= Config.getData(0, i, 12);
			data[i - dataRowPosition][13]= Config.getData(0, i, 13);
			data[i - dataRowPosition][14]= Config.getData(0, i, 14);
		}
	
		return data;
	}
	
	@AfterMethod
	public void Quit() 
	{
		driver.close();
	}

}
