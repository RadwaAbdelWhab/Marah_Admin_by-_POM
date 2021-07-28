package Marah.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class LoginPage extends App {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	 

	@FindBy(className="signin")
	WebElement signin;
	
	
	@FindBy (id="email")
	WebElement email;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (className="list-unstyled")
	WebElement AlertMessage;
	
	@FindBy (id="errorList")
	WebElement ErrorMessage;
	@FindBy(className="analytics-container")
	WebElement WelcomeMessage;
	
	public void go_to_login_page() {

	 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/login");
	}
	public void click() throws InterruptedException {
		signin.click();
		Thread.sleep(1000);

	}
	
	public String get_error_message() {
		String errormessage= ErrorMessage.getText();
		return errormessage ;
		
	}
	public String get_empty_data_message() {
		String message= AlertMessage.getText();
		return message ;
		
	}

public void enter_data() {
	email.clear();
	email.sendKeys("admin@kodyonco.com");
	password.clear();
	password.sendKeys("6bpw#tKh?NA?Z99M");

}
public void enter_invalid_data() {
	email.clear();
	password.clear();

	email.sendKeys("admin.com");
	password.sendKeys("6bpw#");

}

public String get_Welcome_message() {
	String message= driver.getCurrentUrl();
	return message;
	
	
}
}
