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
import Marah.pages.ServicesTypes;

public class ServicesTypesTest extends App {

	public ServicesTypesTest() {
		super();
	}
	
@BeforeMethod
	
	public void set_up(Method method) {
		
		//LoginPage loginpage =new LoginPage();
         //loginpage.go_to_login_page();
         Logger= extent.startTest(method.getName());
	}
	
	@Test(priority=1)
	public void go_to_services_Types_page(Method method) throws InterruptedException {
		ServicesTypes services= new ServicesTypes();
		

		services.go_to_page();

		String ActualResult=services.geturl();

		String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/service_types";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
		
		
	}
	
	@Test(priority=2)
	public void add_services_types(Method method) {
		ServicesTypes services= new ServicesTypes();
        services.add();
        services.enter_data();
        services.save();
        String ActualResult=services.getmessage();

        String ExpectedResult="Successfully Added New Service Type";
          Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");

	}
	
@Test(priority=5)
	
	public void edit_services_types(Method method)
	
	{ServicesTypes services= new ServicesTypes();
    services.go_to_page();
	services.edit();
	services.enter_edited_data();
	services.save();
	 String ActualResult=services.getmessage();
     String ExpectedResult="Successfully Updated Service Type";
       Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");

	
	}

@Test(priority=4)
public void add_empty_field(Method method) {
	ServicesTypes services= new ServicesTypes();
	services.add();
	services.save();
	 String ActualResult=services.get_empty_data_message();
     String ExpectedResult="Please fill out this field.";
       Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
@Test(priority=3)
public void delete_services_types(Method method) throws InterruptedException {
	ServicesTypes services= new ServicesTypes();
    services.delete();
	Thread.sleep(1000);
    services.confirmdelete();
    String ActualResult=services.getmessage();
    String ExpectedResult="Successfully Deleted Service Type";
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
