package Marah.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class Users extends App {
	
	public Users() {
		PageFactory.initElements(driver, this);

		
	}
	
	
	@FindBy(id="name")
	WebElement UserName;
	@FindBy(id="email")
	WebElement UserEmail;
	@FindBy(id="phone")
	WebElement UserPhone;
	@FindBy(id="password")
	WebElement UserPassword;
	@FindBy(className="select2-selection__arrow")
	WebElement SelectorRoleButton;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div/div[2]/form[1]/button")
	WebElement SaveButtonUser;
	@FindBy(xpath="*//*[@class='select2-results__options']/li[2]")
	WebElement AdminRole;
	@FindBy(xpath="*//*[@class='select2-results__options']/li[3]")
	WebElement CenterAdminRole;
	@FindBy(xpath="*//*[@class='select2-results__options']/li[4]")
	WebElement TechnicalSupportRole;
	@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[9]/a[1]")
	WebElement DeleteUser;
	@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[9]/a[2]")
	WebElement EditUser;
	@FindBy (className="voyager-plus")
	WebElement AddButtonUser;
	@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[4]")
	WebElement AlertMessage4;
	@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[5]")
	WebElement AlertMessage5;
	
	
	public void go_to_users_page() {
		 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/users/");
	} 
	public String geturluser() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public String get_alert_message3() {
		String message= AlertMessage4.getText();
		return message;
		
	}
	public String get_alert_message4() {
		String message= AlertMessage5.getText();
		return message;
		
	}
	public void add_user() {
		AddButtonUser.click();
	}
	public void save_user() {
		SaveButtonUser.click();
	}
	public void delete_user() {
		DeleteUser.click();
	}
	public void edit_user() {
		EditUser.click();
	}
	public void enter_data_Admin_Role() throws InterruptedException {
		UserName.sendKeys("Admin");
		UserEmail.sendKeys("Admin@gmail.com");
		UserPhone.sendKeys("+966500200100");
		UserPassword.sendKeys("123456");
		SelectorRoleButton.click();
		Thread.sleep(1000);

		AdminRole.click();
		
	
	}
	
	public void enter_data_center_admin_Role() throws InterruptedException {
		UserName.sendKeys("centerAdmin");
		UserEmail.sendKeys("centerAdmin@gmail.com");
		UserPhone.sendKeys("+966500100100");
		UserPassword.sendKeys("123456");
		SelectorRoleButton.click();
		Thread.sleep(1000);

		CenterAdminRole.click();
		
	
	}
	public void enter_data_center_Technical_support_Role() throws InterruptedException {
		UserName.sendKeys("Technical Support10");
		UserEmail.sendKeys("Technical Support12@gmail.com");
		UserPhone.sendKeys("+966500505110");
		UserPassword.sendKeys("123456");
		SelectorRoleButton.click();
		Thread.sleep(1000);

		CenterAdminRole.click();
		
	
	}

	public void enter_edited_data_Admin_Role() {
		UserName.clear();
		UserName.sendKeys("edited Admin");
		UserEmail.clear();
		UserEmail.sendKeys("edited7.Admin@gmail.com");
		
	
	}
}
