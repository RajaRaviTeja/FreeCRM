package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//a[@href='/home']")
	WebElement homeLink;
	
	@FindBy(xpath="//a[@href='/calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@href='/companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@href='/cases']")
	WebElement casesLink;
	
	@FindBy(xpath="//a[@href='/documents']")
	WebElement documentsLink;
	
	@FindBy(xpath="//a[@href='/email']")
	WebElement emailLink;

	@FindBy(xpath="//a[@href='/campaigns']")
	WebElement campaignsLink;

    
	
	//Initializing the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	} 

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String  verifyCorrectUserName(){
		return userNameLabel.getText();
	}
	
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		Actions actions=new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		contactsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink(){
		contactsLink.click();
		return new TasksPage();
	}
	
	
	
	
	
	
	
	
}

