package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	//Initializing and loading properties from .properties file
	//Before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case - close the browser
	
	public HomePageTest(){
		super();
	}
	
	// test case should be separated - independent of each other
	//
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(props.getProperty("username"), props.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRM","HomePage Title Not Matching");
	}
	
	
	
	@Test(priority=2)
	public void verifytUserName(){
		System.out.println("user name label "+homePage.verifyCorrectUserName());
		Assert.assertEquals(homePage.verifyCorrectUserName(), "Raja Ravi N","--User name not matching");
	}
	
	
	
	@Test(priority=4)
	public void verifyContactsLinkTest(){
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
}
