package Marah.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class ServicesTypes extends App {
	public ServicesTypes() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (className="voyager-plus")
	WebElement AddButton;
	@FindBy(className="form-control")
	WebElement Type;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/div/form[1]/div[2]/button")
	WebElement SaveButton;
	@FindBy (xpath="/html/body/div[3]/div/div")
	WebElement CheckMessage;
			
	@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[3]/a[1]")
	WebElement DeleteButton;
	@FindBy(xpath="*//*[@id='delete_form']/input[3]")
	WebElement ConfirmDeleteButton;
	
	@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[3]/a[2]")
	WebElement EditButton;
	@FindBy(className="form-control")
	WebElement AlertMessage;
	
	
	public void login() throws InterruptedException {
	LoginPage loginpage =new LoginPage();
    loginpage.enter_data();
    loginpage.click();
    }
	public void go_to_page() {
		 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/service_types");
	} 
	public void add() {
		AddButton.click();
	}
	public void delete() {
		DeleteButton.click();
	}
	public void confirmdelete() throws InterruptedException {
		ConfirmDeleteButton.click();
		Thread.sleep(1000);
	}
	public void edit() {
		EditButton.click();
	}
public String geturl() {
	String url=driver.getCurrentUrl();
	return url;

}
public void enter_data() {
Type.sendKeys("waterball");

}
public void enter_edited_data() {
	Type.clear();
Type.sendKeys("chess");

}
public void save() {
	SaveButton.click();
}
public String getmessage() {
	String message= CheckMessage.getAttribute("innerText");
	return message;
	
}
public String get_empty_data_message() {
	String message= AlertMessage.getAttribute("validationMessage");
	return message;
	
	
}
}
