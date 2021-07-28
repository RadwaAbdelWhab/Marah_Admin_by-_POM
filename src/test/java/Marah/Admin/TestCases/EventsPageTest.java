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

public class EventsPageTest extends App {

	public EventsPageTest() {
		super();
	}
	@BeforeMethod
	
	public void set_up(Method method) {
		
		//LoginPage loginpage =new LoginPage();
         //loginpage.go_to_login_page();
         Logger= extent.startTest(method.getName());
	}

	@Test(priority=1)
	public void go_to_Events_page(Method method) throws InterruptedException {
		Events event=new Events();
		event.go_to_events_page();
		String ActualResult=event.geturlevent();
		String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/events";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	
	@Test(priority=2)
	 public void add_event_with_empty(Method method) throws InterruptedException {
		
		Events event=new Events();
		event.go_to_events_page();

        Thread.sleep(2000);
		ServicesTypes services= new ServicesTypes();
		services.add();
		services.save();
		String ActualResult=event.get_alert_message();
		String ExpectedResult="The appointment from field is required.";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
		String ActualResult1=event.get_alert_message1();
		String ExpectedResult1="The name ar field is required.";
		Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");
		String ActualResult2=event.get_alert_message2();
		String ExpectedResult2="The image field is required.";
		Assert.assertEquals(ActualResult2, ExpectedResult2, " it is inValid");
		
	}
	
	
	@Test(priority=3)
	 public void add_eventwith_name_only(Method method) {
		Events event=new Events();
		ServicesTypes services= new ServicesTypes();
		event.go_to_events_page();
		services.add();
		event.enter_name_event();
		services.save();
		String ActualResult=event.get_alert_message();
		String ExpectedResult="The appointment from field is required.";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
		String ActualResult2=event.get_alert_message1(); // alertmessage2
		String ExpectedResult2="The image field is required.";
		Assert.assertEquals(ActualResult2, ExpectedResult2, " it is inValid");
		
	}
	
	
@Test(priority=4)
public void add_event_with_invalid_date(Method method) throws InterruptedException {
	Events event=new Events();
	ServicesTypes services= new ServicesTypes();
	event.go_to_events_page();
	Thread.sleep(1000);

	services.add();
	event.enter_invalid_event();
	Thread.sleep(2000);
	String ActualResult=event.get_alert_message();
	String ExpectedResult="The appointment to must be a date after or equal to appointment from.";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	String ActualResult1=event.get_alert_message1();
	String ExpectedResult1="The image field is required.";
	Assert.assertEquals(ActualResult1, ExpectedResult1, " it is inValid");
}
	
@Test(priority=5)
public void add_event_special_show(Method method) throws InterruptedException {
	Events event=new Events();
	ServicesTypes services= new ServicesTypes();
	event.go_to_events_page();
	Thread.sleep(1000);

	services.add();
	event.enter_special_show_event();;
	boolean cropped= event.validate_cropped_image();
	Thread.sleep(1000);

	if(cropped)
	{
		services.save();
		Thread.sleep(1000);

		
	}
	
	else
	{
		System.out.println("error in cropped image");
	}

	String ActualResult=services.getmessage();
	String ExpectedResult="Successfully Added New Event";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	Thread.sleep(1000);


}
@Test(priority=6)
public void add_event_special_price(Method method) throws InterruptedException {
	Events event=new Events();
	ServicesTypes services= new ServicesTypes();
	event.go_to_events_page();
	Thread.sleep(1000);

	services.add();
	event.enter_special_price_event();;
	boolean cropped= event.validate_cropped_image();
	if(cropped)
	{
		services.save();
		Thread.sleep(1000);

	}
	
	else
	{
		System.out.println("error in cropped image");
	}
	String ActualResult=services.getmessage();
	String ExpectedResult="Successfully Added New Event";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
@Test(priority=7)
public void delete_event(Method method) throws InterruptedException {
	ServicesTypes services= new ServicesTypes();
	Events event=new Events();
    event.delete_event();
	Thread.sleep(2000);
    services.confirmdelete();
    String ActualResult=services.getmessage();
    String ExpectedResult="Successfully Deleted Event";
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
