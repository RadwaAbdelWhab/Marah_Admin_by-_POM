package Marah.Admin.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Bagisto.MarahAdmin.App;
import Marah.pages.Events;
import Marah.pages.LoginPage;
import Marah.pages.ServicesTypes;
import Marah.pages.Users;

public class UsersTest extends App {
@BeforeMethod
	
	public void set_up(Method method) {
		
		//LoginPage loginpage =new LoginPage();
         //loginpage.go_to_login_page();
         Logger= extent.startTest(method.getName());
	}

@Test(priority=1)
public void go_to_Users_page(Method method) {
Users user= new Users();

user.go_to_users_page();
String ActualResult=user.geturluser();
String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/users/";
Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
@Test(priority=2)
public void add_user_with_empty(Method method) throws InterruptedException {
	Events event=new Events();
	Users user= new Users();
		Thread.sleep(2000);
		user.go_to_users_page();

	user.add_user();
	user.save_user();
	String ActualResult=event.get_alert_message();
	String ExpectedResult="The Name field is required.";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	String ActualResult1=event.get_alert_message1();
	String ExpectedResult1="The password field is required.";
	Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");
	String ActualResult2=event.get_alert_message2();
	String ExpectedResult2="The email field is required.";
	Assert.assertEquals(ActualResult2, ExpectedResult2, " it is inValid");
	String ActualResult3=user.get_alert_message3();
	String ExpectedResult3="The Phone field is required.";
	Assert.assertEquals(ActualResult3, ExpectedResult3, " it is inValid");
	String ActualResult4=user.get_alert_message4();
	String ExpectedResult4="The role field is required.";
	Assert.assertEquals(ActualResult4, ExpectedResult4, " it is inValid");
	
	
	}


@Test(priority=3)
public void add_user_admin(Method method) throws InterruptedException {
	Users user= new Users();
	ServicesTypes services= new ServicesTypes();
	user.go_to_users_page();
	Thread.sleep(1000);

	user.add_user();
	user.enter_data_Admin_Role();
	user.save_user();
	Thread.sleep(1000);

	   String ActualResult=services.getmessage();
       String ExpectedResult="Successfully Added New User";
         Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");}

@Test(priority=4)
public void add_user_center_admin(Method method) throws InterruptedException {
	Users user= new Users();
	ServicesTypes services= new ServicesTypes();
	user.go_to_users_page();

	Thread.sleep(2000);
	user.add_user();
	user.enter_data_center_admin_Role();
	user.save_user();
	   String ActualResult=services.getmessage();
       String ExpectedResult="Successfully Added New User";
         Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");}


@Test(priority=5)
public void add_user_technical_support(Method method) throws InterruptedException {
	Users user= new Users();
	
	ServicesTypes services= new ServicesTypes();
	user.go_to_users_page();

	Thread.sleep(2000);

	services.add();
	user.enter_data_center_Technical_support_Role();
	user.save_user();
	   String ActualResult=services.getmessage();
       String ExpectedResult="Successfully Added New User";
         Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");}


@Test(priority=6)
public void delete_user(Method method) throws InterruptedException {
	ServicesTypes services= new ServicesTypes();
	Users user= new Users();
	user.go_to_users_page();
	Thread.sleep(1000);
    user.delete_user();
	Thread.sleep(2000);
    services.confirmdelete();
    String ActualResult=services.getmessage();
    String ExpectedResult="Successfully Deleted User";
    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");}

@Test(priority=7)

public void edit_user(Method method)

{ServicesTypes services= new ServicesTypes();
Users user= new Users();

user.go_to_users_page();
user.edit_user();
user.enter_edited_data_Admin_Role();
user.save_user();
 String ActualResult=services.getmessage();
 String ExpectedResult="Successfully Updated User";
   Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");


}
@Test(priority=8)
public void add_user_admin_by_registered_emai_phone (Method method) throws InterruptedException {
	Users user= new Users();
	Events event=new Events();
	user.go_to_users_page();

	Thread.sleep(2000);

	user.add_user();
	user.enter_data_Admin_Role();
	user.save_user();
	String ActualResult=event.get_alert_message();
	String ExpectedResult="The email has already been taken.";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	String ActualResult1=event.get_alert_message1();
	String ExpectedResult1="The Phone has already been taken.";
	Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");

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
