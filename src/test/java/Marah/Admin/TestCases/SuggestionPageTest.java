package Marah.Admin.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import Marah.pages.ServicesTypes;
import Marah.pages.Suggestion;

public class SuggestionPageTest {
public SuggestionPageTest() {
	super();
	
}
@Test(priority=1)
public void go_to_Suggestion_page(Method method) {
	Suggestion suggestion=new Suggestion();
suggestion.go_to_page_Suggestion();
String ActualResult=suggestion.get_url_suggestion();
String ExpectedResult="http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/suggestions";
Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
@Test(priority=2)
public void add_suggestion(Method method) throws InterruptedException {
	ServicesTypes services= new ServicesTypes();
	Suggestion suggestion=new Suggestion();
	suggestion.go_to_page_Suggestion();
	suggestion.add_suggestion_button();
	suggestion.enter_data_suggestion();

	suggestion.save_suggestion_button();;
	Thread.sleep(1000);

	   String ActualResult=services.getmessage();
       String ExpectedResult="Successfully Added New Suggestion";
         Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
@Test(priority=3)
public void edit_suggestion(Method method) throws InterruptedException {
	ServicesTypes services= new ServicesTypes();
	Suggestion suggestion=new Suggestion();
	suggestion.go_to_page_Suggestion();
	suggestion.edit_suggestion_button();
	Thread.sleep(2000);
suggestion.enter_edited_data_suggestion();
suggestion.save_suggestion_button();
Thread.sleep(1000);

String ActualResult=services.getmessage();
String ExpectedResult="Successfully Updated Suggestion";
  Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");

}
@Test(priority=4)
public void delete_suggestion(Method method) throws InterruptedException {
	ServicesTypes services= new ServicesTypes();
	Suggestion suggestion=new Suggestion();
	suggestion.go_to_page_Suggestion();
	suggestion.delete_suggestion_button();
	Thread.sleep(2000);
    services.confirmdelete();
    String ActualResult=services.getmessage();
    String ExpectedResult="Successfully Deleted Suggestion";
    Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
	}
@Test(priority=5)
public void add_suggetion_without_name(Method method) throws InterruptedException {	
	Suggestion suggestion=new Suggestion();
	ServicesTypes services= new ServicesTypes();

suggestion.go_to_page_Suggestion();
suggestion.add_suggestion_button();

suggestion.save_suggestion_button();

String ActualResult=services.get_empty_data_message();
String ExpectedResult="Please fill out this field.";
  Assert.assertEquals(ActualResult, ExpectedResult, " it is inValid");
}
}
