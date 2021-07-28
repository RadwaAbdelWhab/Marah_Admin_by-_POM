package Marah.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class Complain extends App {
	public Complain() {
	PageFactory.initElements(driver, this);

	}
	@FindBy (className="voyager-plus")
	WebElement AddButtonComplain;
	@FindBy(name="username")
	WebElement CustomerNameComplain;
	@FindBy(name="phone")
	WebElement CustomerPhoneComplain;
	@FindBy(name="description")
	WebElement DescriptionComplain;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div/div[2]/div/div/div/form[1]/div[2]/button")
	WebElement SaveButtonComplain;
	@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[7]/a[1]")
	WebElement DeleteButtonComplain;
	@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[7]/a[2]")
	WebElement EditButtonComplain;
	@FindBy(className="select2-selection__arrow")
	WebElement SelectionStatusButton;
	@FindBy(xpath="*//*[@class='select2-results__options']/li[1]")
	WebElement Status;

	public void go_to_page_Complain() {
		 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/complains");
	}
	public String get_url_Complain() {
		String url=driver.getCurrentUrl();
		return url;

	}
	public void enter_data_Complain() {
	CustomerNameComplain.sendKeys("customer");
	CustomerPhoneComplain.sendKeys("+966500555600");
	DescriptionComplain.sendKeys("there is new Complain");

	}
	public void enter_edited_data_Complain() throws InterruptedException {
		CustomerNameComplain.clear();
	CustomerNameComplain.sendKeys("edited customer");
	CustomerPhoneComplain.clear();
	CustomerPhoneComplain.sendKeys("+966555555600");
	DescriptionComplain.clear();
	DescriptionComplain.sendKeys("there is two Complain");
	SelectionStatusButton.click();
	Thread.sleep(1000);
	Status.click();

	}

	public void add_Complain_button() {
		AddButtonComplain.click();
	}
	public void save_Complain_button() {
		SaveButtonComplain.click();
	}
	public void edit_Complain_button() {
		EditButtonComplain.click();
	}
	public void delete_Complain_button() {
		DeleteButtonComplain.click();
	}


	

}
