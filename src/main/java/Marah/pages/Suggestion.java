package Marah.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bagisto.MarahAdmin.App;

public class Suggestion extends App {

public Suggestion() {
	PageFactory.initElements(driver, this);

}
@FindBy (className="voyager-plus")
WebElement AddButtonSuggestion;
@FindBy(name="username")
WebElement CustomerNameSuggestion;
@FindBy(name="phone")
WebElement CustomerPhoneSuggestion;
@FindBy(name="description")
WebElement DescriptionSuggestion;
@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div/div[2]/div/div/div/form[1]/div[2]/button")
WebElement SaveButtonSuggestion;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[7]/a[1]")
WebElement DeleteButtonSuggestion;
@FindBy(xpath="*//*[@id='dataTable']/tbody/tr[1]/td[7]/a[2]")
WebElement EditButtonSuggestion;
@FindBy(className="select2-selection__arrow")
WebElement SelectionStatusButton;
@FindBy(xpath="*//*[@class='select2-results__options']/li[1]")
WebElement Status;

public void go_to_page_Suggestion() {
	 driver.navigate().to("http://kid-tst.eu-west-1.elasticbeanstalk.com/admin/suggestions");
}
public String get_url_suggestion() {
	String url=driver.getCurrentUrl();
	return url;

}
public void enter_data_suggestion() {
CustomerNameSuggestion.sendKeys("customer");
CustomerPhoneSuggestion.sendKeys("+966500555600");
DescriptionSuggestion.sendKeys("there is new suggestion");

}
public void enter_edited_data_suggestion() throws InterruptedException {
	CustomerNameSuggestion.clear();
CustomerNameSuggestion.sendKeys("edited customer");
CustomerPhoneSuggestion.clear();
CustomerPhoneSuggestion.sendKeys("+966555555600");
DescriptionSuggestion.clear();
DescriptionSuggestion.sendKeys("there is two suggestion");
SelectionStatusButton.click();
Thread.sleep(1000);
Status.click();

}

public void add_suggestion_button() {
	AddButtonSuggestion.click();
}
public void save_suggestion_button() {
	SaveButtonSuggestion.click();
}
public void edit_suggestion_button() {
	EditButtonSuggestion.click();
}
public void delete_suggestion_button() {
	DeleteButtonSuggestion.click();
}


}
