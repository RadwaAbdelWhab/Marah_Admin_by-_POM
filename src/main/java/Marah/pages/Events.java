package Marah.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class Events extends App{
	
	public Events() {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[1]")
WebElement AlertMessage;
@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[2]")
WebElement AlertMessage1;
@FindBy(xpath="*//*[@class='alert alert-danger']/ul/li[3]")
WebElement AlertMessage2;
@FindBy(name="name")
WebElement Name;
@FindBy(name="description")
WebElement Description;
@FindBy(name="appointment_from")
WebElement Appointment_from;
@FindBy(name="appointment_to")
WebElement Appointment_To;
@FindBy(className="select2-selection__arrow")
WebElement SelectorTypes;
@FindBy(xpath="*//*[@class='select2-results']/ul/li[2]")
WebElement SpecialShowType;
@FindBy(xpath="*//*[@class='select2-results']/ul/li[1]")
WebElement SpecialPriceType;
@FindBy(name="image")
WebElement Image;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/div/form[1]/div[1]/div[6]/div/div/div/button")
WebElement CropButton;
@FindBy(id="croppedImage")
WebElement CroppedImage;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[6]/a[1]")
WebElement DeleteEvent;

public void go_to_events_page() {
	 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/events");
} 
public String geturlevent() {
	String url=driver.getCurrentUrl();
	return url;
}
public String get_alert_message() {
	String message= AlertMessage.getText();
	return message;
	
}
public String get_alert_message1() {
	String message= AlertMessage1.getText();
	return message;
	
}
public String get_alert_message2() {
	String message= AlertMessage2.getText();
	return message;
	
}

public void enter_name_event() {
	Name.sendKeys("Eid_Test");
}

public void enter_invalid_event() {
	Name.sendKeys("Eid_Test");
	Description.sendKeys("Eid is new event ,it is run by test automation");
	Appointment_from.sendKeys("06/28/2022 1:19 PM");
	Appointment_To.sendKeys("06/25/2021 1:19 PM");
	SelectorTypes.click();
	SpecialPriceType.click();
	
	
}
public void enter_special_price_event() {
	Name.sendKeys("Eid_Test_special_price");
	Description.sendKeys("Eid is new event ,it is run by test automation");
	Appointment_from.sendKeys("06/28/2022 1:19 PM");
	Appointment_To.sendKeys("06/30/2022 1:19 PM");
	SelectorTypes.click();
	SpecialPriceType.click();
	Image.sendKeys("C:\\Users\\tarek\\Desktop\\download.jpg");
	CropButton.click();
	
}
public void enter_special_show_event() {
	Name.sendKeys("Eid_Test_special_show");
	Description.sendKeys("Eid is new event ,it is run by test automation");
	Appointment_from.sendKeys("07/28/2022 1:19 PM");
	Appointment_To.sendKeys("07/30/2022 1:19 PM");
	SelectorTypes.click();
	SpecialShowType.click();
	Image.sendKeys("C:\\Users\\tarek\\Desktop\\download.jpg");
	CropButton.click();
	
}
public boolean validate_cropped_image() {
	return CroppedImage.isDisplayed();
	
}

public void delete_event() {
	DeleteEvent.click();
}

}
