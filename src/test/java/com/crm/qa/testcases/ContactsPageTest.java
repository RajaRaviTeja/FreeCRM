package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login("xcardtier1@gmail.com","Test@123");
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
   @Test(priority=1)
   public void clickUserCheckBox(){
	   driver.navigate().refresh();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   contactsPage.clickCheckBox();
   }
   
  /* 
   @DataProvider
   public Object [][] getCRMTestData(){
	   Object [][]data=TestUtil.getTestDataInToObjectArray("Contacts");
	    return data;
   }
   
   @Test(priority=2,dataProvider="getCRMTestData")//
   public void validateCreateNewContactFromObjectArrayOfdata(String firstName,String lastName,String email){
	   
	   System.out.println("Printing records from Object[][]  "+firstName+"::"+lastName+"::"+email);
	   contactsPage.clickAddNewContactButton();
	   contactsPage.createNewContact(firstName, lastName, email);
	   //contactsPage.createNewContact("firstName","lastName","lastName@lastName.com");
   }
   */
   
   @DataProvider
   public String [] getCRMTestDataAsString(){
	   String []data=TestUtil.getTestDataInToStringArray("Contacts");
	    return data;
   }
   
   @Test(priority=2,dataProvider="getCRMTestDataAsString")//
   public void validateCreateNewContactFromStringArrayOfData(String empDetails){
	   
	   String split[]=empDetails.split(" ");
	   System.out.println("Printing records from String[]  "+split[0]+"::"+split[1]+"::"+split[2]);
	    
	   contactsPage.clickAddNewContactButton();
	   contactsPage.createNewContact(split[0], split[1], split[2]);
	   //contactsPage.createNewContact("firstName","lastName","lastName@lastName.com");
   }
   
   
   
   

   @AfterMethod
   public void tearDown(){
	   driver.quit();
   }
}
