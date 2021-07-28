package Marah.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class Customer extends App {
public Customer() {
	PageFactory.initElements(driver, this);

}

@FindBy (className="voyager-plus")
WebElement AddButtonCustomer;
@FindBy(name="username")
WebElement CustomerName;
@FindBy(name="phone")
WebElement CustomerPhone;
@FindBy(name="email")
WebElement CustomerEmail;
@FindBy(name="password")
WebElement CustomerPassword;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div/div[2]/div/div/div/form[1]/div[2]/button")
WebElement SaveButtonCustomer;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[4]/a[1]")
WebElement DeleteButtonCustomer;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[4]/a[2]")
WebElement EditButtonCustomer;


public void go_to_page_Customer() {
	 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/customers");
}
public String get_url_customer() {
	String url=driver.getCurrentUrl();
	return url;

}
public void enter_data_customer() {
CustomerName.sendKeys("customer");
CustomerPhone.sendKeys("+966500555600");
CustomerEmail.sendKeys("customer@gmail.com");
CustomerPassword.sendKeys("12345678");

}

public void enter_edited_data_customer() {
	CustomerName.clear();
CustomerName.sendKeys("edited customer");
CustomerPhone.clear();
CustomerPhone.sendKeys("+966555666999");
CustomerEmail.clear();
CustomerEmail.sendKeys("editedcustomer@gmail.com");


}



public void add_customer_button() {
	AddButtonCustomer.click();
}
public void save_customer_button() {
	SaveButtonCustomer.click();
}
public void edit_customer_button() {
	EditButtonCustomer.click();
}
public void delete_customer_button() {
	DeleteButtonCustomer.click();
}


}
