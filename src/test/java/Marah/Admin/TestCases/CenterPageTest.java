package Marah.Admin.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Bagisto.MarahAdmin.App;
import Marah.pages.Centers;
import Marah.pages.Events;
import Marah.pages.ServicesTypes;
import Marah.pages.Users;

public class CenterPageTest extends App{

	public CenterPageTest() {
		super();
	}
	@BeforeMethod
	
	public void set_up(Method method) {
		
		//LoginPage loginpage =new LoginPage();
         //loginpage.go_to_login_page();
         Logger= extent.startTest(method.getName());
	}
	
	@Test(priority=1)
	public void go_to_Center_page(Method method) throws InterruptedException {
		Centers center= new Centers();
        center.go_to_centers_page();
		String ActualResult=center.geturlcenter();
		String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/centers";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	
	@Test(priority=2)

	public void add_center() throws InterruptedException {
		
		Centers center= new Centers();
        center.go_to_centers_page();
        center.add_center_button();
        center.addcenter();
		 Thread.sleep(1000);
        center.save_center_button();
		 Thread.sleep(1000);
		 
		 String ActualResult=center.get_message_center();

	        String ExpectedResult="Successfully Added New Center";
	          Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
        
	}
	
	
	@Test(priority=3)

	public void delete_center() throws InterruptedException {
		Centers center= new Centers();
		ServicesTypes services= new ServicesTypes();

        center.go_to_centers_page();
        center.delete_center_button();
		Thread.sleep(1000);
		   services.confirmdelete();
		    String ActualResult=services.getmessage();
		    String ExpectedResult="Successfully Deleted Center";
		    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");

		
	}
	
@Test(priority=4)
	
	public void edit_center(Method method) throws InterruptedException {
	Centers center= new Centers();
	ServicesTypes services= new ServicesTypes();

    center.go_to_centers_page();
    center.edit_center_button();
    center.add_Edited_center();
    center.save_center_button();
     String ActualResult=services.getmessage();
		    String ExpectedResult="Successfully Updated Center";
		    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
    


}

	@Test(priority=5)
	public void add_center_with_empty(Method method) throws InterruptedException {
		Centers center= new Centers();
		Events event=new Events();
		Users user= new Users();
	    center.go_to_centers_page();
        center.add_center_button();
center.save_center_button();
String ActualResult=event.get_alert_message();
String ExpectedResult="The Name field is required.";
Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
String ActualResult1=event.get_alert_message1();
String ExpectedResult1="The Address field is required.";
Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");
String ActualResult2=event.get_alert_message2();
String ExpectedResult2="The Phone field is required.";
Assert.assertEquals(ActualResult2, ExpectedResult2, " it is inValid");
String ActualResult3=user.get_alert_message3();
String ExpectedResult3="The Working From field is required.";
Assert.assertEquals(ActualResult3, ExpectedResult3, " it is inValid");
String ActualResult4=user.get_alert_message4();
String ExpectedResult4="The Working To field is required.";
Assert.assertEquals(ActualResult4, ExpectedResult4, " it is inValid");
String ActualResult6=center.get_alert_message6();
String ExpectedResult6="The Center User field is required.";
Assert.assertEquals(ActualResult6, ExpectedResult6, " it is inValid");
String ActualResult7=center.get_alert_message7();
String ExpectedResult7="The Number Of Reservations Per Day field is required.";
Assert.assertEquals(ActualResult7, ExpectedResult7, " it is inValid");
String ActualResult8=center.get_alert_message8();
String ExpectedResult8="The Main Image field is required.";
Assert.assertEquals(ActualResult8, ExpectedResult8, " it is inValid");}

@Test(priority=6)
	
	public void disable_center(Method method) throws InterruptedException {
	Centers center= new Centers();
	ServicesTypes services= new ServicesTypes();
	 String Status;
    center.go_to_centers_page();
   
    Status=center.check_status_center();

    center.block_center_button();
    
    if(Status=="Block")
    {
    
    String ActualResult=services.getmessage();
    String ExpectedResult="Successfully blocked center";
    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
    
}
    else if (Status=="Active") {
		
	
     String ActualResult1=services.getmessage();
    String ExpectedResult1="Successfully activated center";
    Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");
    	
    }}

@Test(priority=7)

public void disable_reservation_center(Method method) throws InterruptedException {
Centers center= new Centers();
ServicesTypes services= new ServicesTypes();

center.go_to_centers_page();
String Status1=center.check_status_reservation();
center.block_reservation_center_button();

if(Status1=="Enable Reservation")
{
String ActualResult=services.getmessage();
String ExpectedResult="Successfully enabled reservation services";
Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
else if(Status1=="Disable Reservation")
{
	String ActualResult1=services.getmessage();
	String ExpectedResult1="Successfully diabled reservation services";
	Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");
}
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
