package Marah.Admin.TestCases;


import java.lang.reflect.Method;

import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Bagisto.MarahAdmin.App;
import Marah.pages.LoginPage;

public class LoginPageTest extends App {

	
	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	
	public void set_up(Method method) {
		
		LoginPage loginpage =new LoginPage();
         loginpage.go_to_login_page();
         Logger= extent.startTest(method.getName());
	}

	@Test(priority = 1)
	
	public void login_with_empty_data(Method method) throws InterruptedException {
		
		LoginPage loginpage =new LoginPage();
		loginpage.click();
        String ActualResult=loginpage.get_empty_data_message();
        String ExpectedResult="Email and Password are required fields";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	
	}
	
	@Test(priority = 2)

	public void login_with_invalid_credentials(Method method) throws InterruptedException {
		LoginPage loginpage =new LoginPage();
		loginpage.enter_invalid_data();
		loginpage.click();
        String ActualResult=loginpage.get_error_message();
        String ExpectedResult="These credentials do not match our records.";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");

	}
	
	
	

	@Test(priority = 3)
	public void login_with_valid_credentials(Method method) throws InterruptedException {

		LoginPage loginpage =new LoginPage();
		loginpage.enter_data();
		loginpage.click();
		String ActualResult=loginpage.get_Welcome_message();
        String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
			


	}

	@AfterMethod
	public void end_method(Method method,ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			Logger.log(LogStatus.PASS, "Test pass");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE){
			Logger.log(LogStatus.FAIL, "Test fail");
			
		}
		else {Logger.log(LogStatus.SKIP, "Test skipped");
			
		}

	}
	
	
}