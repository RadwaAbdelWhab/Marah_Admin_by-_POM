package Marah.Admin.TestCases;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import Marah.pages.ServicesTypes;
import Marah.pages.Complain;
public class ComplainPageTest {
public ComplainPageTest() {
		super();
		
	}
	@Test(priority=1)
	public void go_to_Complain_page(Method method) {
		Complain Complain=new Complain();
	Complain.go_to_page_Complain();
	String ActualResult=Complain.get_url_Complain();
	String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/complains";
	Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	@Test(priority=2)
	public void add_Complain(Method method) throws InterruptedException {
		ServicesTypes services= new ServicesTypes();
		Complain Complain=new Complain();
		Complain.go_to_page_Complain();
		Complain.add_Complain_button();
		Complain.enter_data_Complain();

		Complain.save_Complain_button();;
		Thread.sleep(1000);

		   String ActualResult=services.getmessage();
	       String ExpectedResult="Successfully Added New Complain";
	         Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	@Test(priority=3)
	public void edit_Complain(Method method) throws InterruptedException {
		ServicesTypes services= new ServicesTypes();
		Complain Complain=new Complain();
		Complain.go_to_page_Complain();
		Complain.edit_Complain_button();
		Thread.sleep(2000);
	Complain.enter_edited_data_Complain();
	Complain.save_Complain_button();
	Thread.sleep(1000);

	String ActualResult=services.getmessage();
	String ExpectedResult="Successfully Updated Complain";
	  Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");

	}
	@Test(priority=4)
	public void delete_Complain(Method method) throws InterruptedException {
		ServicesTypes services= new ServicesTypes();
		Complain Complain=new Complain();
		Complain.go_to_page_Complain();
		Complain.delete_Complain_button();
		Thread.sleep(2000);
	    services.confirmdelete();
	    String ActualResult=services.getmessage();
	    String ExpectedResult="Successfully Deleted Complain";
	    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
		}
	@Test(priority=5)
	public void add_suggetion_without_name(Method method) throws InterruptedException {	
		Complain Complain=new Complain();
		ServicesTypes services= new ServicesTypes();

	Complain.go_to_page_Complain();
	Complain.add_Complain_button();

	Complain.save_Complain_button();

	String ActualResult=services.get_empty_data_message();
	String ExpectedResult="Please fill out this field.";
	  Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
	


}
