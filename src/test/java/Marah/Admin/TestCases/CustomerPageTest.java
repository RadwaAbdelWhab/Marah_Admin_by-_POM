package Marah.Admin.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import Marah.pages.Customer;
import Marah.pages.Events;
import Marah.pages.ServicesTypes;

public class CustomerPageTest {
	public CustomerPageTest() {
		super();
	}
	@Test(priority=1)
	public void go_to_Customer_page(Method method) {
Customer customer= new Customer();
	customer.go_to_page_Customer();
	String ActualResult=customer.get_url_customer();
	String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/customers";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	@Test(priority=2)
	public void add_Customer(Method method) throws InterruptedException {
		Customer customer= new Customer();
		ServicesTypes services= new ServicesTypes();

		customer.go_to_page_Customer();
		customer.add_customer_button();
		customer.enter_data_customer();

		customer.save_customer_button();
		Thread.sleep(1000);

		   String ActualResult=services.getmessage();
	       String ExpectedResult="Successfully Added New Customer";
	         Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	@Test(priority=3)
	public void add_user_admin_by_registered_phone (Method method) throws InterruptedException {
		Customer customer= new Customer();
		Events event=new Events();

		customer.go_to_page_Customer();
		customer.add_customer_button();
		customer.enter_data_customer();
		customer.save_customer_button();
		String ActualResult=event.get_alert_message();
		 Thread.sleep(1000);

		String ExpectedResult="The Phone has already been taken.";
		Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
		
	}
	@Test(priority=4)
	public void edit_Customer(Method method) throws InterruptedException {
		Customer customer= new Customer();
		ServicesTypes services= new ServicesTypes();

		customer.go_to_page_Customer();
	
	customer.edit_customer_button();
	Thread.sleep(2000);
   customer.enter_edited_data_customer();
   customer.save_customer_button();
   Thread.sleep(1000);

   String ActualResult=services.getmessage();
   String ExpectedResult="Successfully Updated Customer";
     Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	
	@Test(priority=5)
	public void delete_Customer(Method method) throws InterruptedException {
		Customer customer= new Customer();
		ServicesTypes services= new ServicesTypes();
		customer.go_to_page_Customer();
	customer.delete_customer_button();
	Thread.sleep(2000);
    services.confirmdelete();
    String ActualResult=services.getmessage();
    String ExpectedResult="Successfully Deleted Customer";
    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
    }


@Test(priority=6)
public void add_Customer_without_name(Method method) throws InterruptedException {
	Customer customer= new Customer();
	ServicesTypes services= new ServicesTypes();

	customer.go_to_page_Customer();
	customer.add_customer_button();
	customer.save_customer_button();
	 String ActualResult=services.get_empty_data_message();
     String ExpectedResult="Please fill out this field.";
       Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}


}