package Marah.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class Centers extends App {
	public Centers() {
		PageFactory.initElements(driver, this);
	}
	

	
@FindBy (className="voyager-plus")
WebElement AddButtonCenter;
@FindBy(name="name")
WebElement NameCenter;
@FindBy(name="description")
WebElement DescriptionCenter;
@FindBy(id="places-autocomplete")
WebElement PlaceOFCenter;
@FindBy(name="address")
WebElement AddressCenter;
@FindBy(name="phone")
WebElement PhoneCenter;
@FindBy (id="workingFrom")
WebElement TimeStartCenter;
@FindBy (id="workingTo")
WebElement TimeCloseCenter;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[8]/div/div/div[2]/div[2]/input")
WebElement hour2;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[8]/div/div/div[3]/div[2]/input")
WebElement min;
@FindBy(xpath="*//*[@class='ti_tx']/input")
	WebElement hour;
@FindBy(xpath="*//*[@class='mi_tx']/input")
WebElement minutes;
@FindBy(xpath="*//*[@class='meridian']/div[3]")
WebElement AMButton;
@FindBy(className="select2-selection__arrow")
WebElement SelectionRoleButton;
@FindBy(xpath="*//*[@class='select2-results__options']")
WebElement Role;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[12]/input")
WebElement NumberOfTickets;
@FindBy(name="image")
WebElement ImageCenter;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[15]/div[1]/div/div/button")
WebElement CroppedButton1;
@FindBy(id="croppedImage")
WebElement CroppedImageCenter;
@FindBy(id="submitBtnCenter")
WebElement SaveCenterButton;
@FindBy (xpath="/html/body/div[3]/div/div")
WebElement CheckMessageCenter;
@FindBy (xpath="/html/body/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/form/div[1]/div[10]/div")
WebElement FeaturedButton;
@FindBy(className="toggle-group")
WebElement ReservationButton;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[6]/a[1]")
WebElement DeleteButtonCenter;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[6]/a[2]")
WebElement EditButtonCenter;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[6]/a[4]")
WebElement BlockButtonCenter;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[6]/a[5]")
WebElement BlockReservationButtonCenter;
@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[6]")
WebElement AlertMessage6;
@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[7]")
WebElement AlertMessage7;
@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[8]")
WebElement AlertMessage8;

	public void go_to_centers_page() {
		 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/centers");
	} 
	
	public String geturlcenter() {
		String url=driver.getCurrentUrl();
		return url;
	}
	public void add_center_button() {
		AddButtonCenter.click();
	}
	public void save_center_button() {
		SaveCenterButton.click();
	}
	public void delete_center_button() {
		DeleteButtonCenter.click();
	}
	public void edit_center_button() {
		EditButtonCenter.click();
	}
	public void block_center_button() {
		BlockButtonCenter.click();
	}
	public void block_reservation_center_button() {
		BlockReservationButtonCenter.click();
	}
	
	public String get_alert_message6() {
		String message= AlertMessage6.getText();
		return message;
		
	}
	
	public String get_alert_message7() {
		String message= AlertMessage7.getText();
		return message;
		
	}
	public String get_alert_message8() {
		String message= AlertMessage8.getText();
		return message;
		
	}
	
	
	public void add_Edited_center() throws InterruptedException {
		NameCenter.clear();
		NameCenter.sendKeys("edited center");
		DescriptionCenter.clear();
		DescriptionCenter.sendKeys("edited automation center is place for different games");
		PlaceOFCenter.clear();
		PlaceOFCenter.sendKeys("التحرير");
		AddressCenter.clear();
		AddressCenter.sendKeys("التحرير");
		PhoneCenter.clear();
		PhoneCenter.sendKeys("+955500500515");}
	
	public void addcenter() throws InterruptedException {
		NameCenter.sendKeys("center");
		DescriptionCenter.sendKeys("automation center is place for different games");
		PlaceOFCenter.sendKeys("التجمع الخامس");
		AddressCenter.sendKeys("التجمع الخامس");
		PhoneCenter.sendKeys("+955500500500");
		TimeStartCenter.click();
		 Thread.sleep(1000);

		hour.clear();
		hour.sendKeys("12");
		AMButton.click();
		 Thread.sleep(1000);

		minutes.clear();
		minutes.sendKeys("15");
		minutes.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);

		TimeCloseCenter.click();
		
		/*
		hour2.clear();
		 Thread.sleep(2000);
		
		hour.sendKeys("12");
		 Thread.sleep(3000);

	
		min.clear();
		min.sendKeys("15");
		
		 Thread.sleep(1000);
*/
		min.sendKeys(Keys.ENTER);

		SelectionRoleButton.click();
		 Thread.sleep(1000);

		Role.click();
		 Thread.sleep(1000);
		 FeaturedButton.click();
		 Thread.sleep(2000);

//		 ReservationButton.click();


		NumberOfTickets.sendKeys("500");
		ImageCenter.sendKeys("C:\\Users\\tarek\\Desktop\\download.jpg");
		 Thread.sleep(2000);

		CroppedButton1.click();
		 Thread.sleep(2000);

	}
	public String get_message_center() {
		String message= CheckMessageCenter.getAttribute("innerText");
		return message;
		
	}
	public String check_status_reservation() {
		String message= BlockReservationButtonCenter.getAttribute("innerText");
		System.out.println(message);
		return message;
		
	}
	public String check_status_center() {
		String message= BlockButtonCenter.getAttribute("innerText");
		System.out.println(message);
		return message;
		
	}
	
	
}
