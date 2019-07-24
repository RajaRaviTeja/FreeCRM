package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

    @FindBy(name="email")
    WebElement username;

    @FindBy(name="password")
    WebElement password;
    
    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    WebElement logIn;

    @FindBy(xpath="//a[contains(text(),'Sign Up')]")
    WebElement signUp;

    
    public LoginPage(){
    	PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle(){
    	return driver.getTitle();
    }
    
    public HomePage login(String un,String pw){
    	username.sendKeys(un);
    	password.sendKeys(pw);
    	logIn.click();
    	
    	return new HomePage();
    	
    }
    
    
    
    
    
    
    
    

}


