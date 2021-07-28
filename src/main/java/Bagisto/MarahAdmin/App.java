package Bagisto.MarahAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class App 
{
	public App() {
		super();
	}
   
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest Logger;
	
	
	@BeforeSuite
	public void webDriver() throws InterruptedException  
	{
		 System.setProperty("webdriver.chrome.driver", "F:\\\\chromedriver_win32 (1)\\\\chromedriver.exe" );
		 Thread.sleep(5000);
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}

	@AfterSuite
	public void webDriver1() throws InterruptedException  
	{
		driver.close();
	}
}
