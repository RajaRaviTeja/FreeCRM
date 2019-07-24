package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[contains(text(),'Sarada Teja Potti')]/preceding-sibling::td")
    WebElement checkBox;
    
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newButton;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@class='field']//label[contains(text(),'Email')]/following-sibling::div//input[1]")
	WebElement emailId;
	
	@FindBy()
	WebElement address;
	public void clickCheckBox(){
		checkBox.click();
	}
	
	public void clickAddNewContactButton(){
		newButton.click();
	}
	
	
	public void createNewContact(String fn,String ln,String em){
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailId.sendKeys(em);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		saveButton.click();
	}
	
	
	
}
