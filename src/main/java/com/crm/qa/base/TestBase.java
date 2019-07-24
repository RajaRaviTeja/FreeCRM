package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties props;
	
	// Step 1: Initializing properties in TestBase constructor
	public TestBase(){
		try{
			if(null==props){
			props = new Properties();
			System.out.println("props obj created with hash code as "+props.hashCode());
			String propsFilePath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
		    FileInputStream fis = new FileInputStream(propsFilePath);	
			props.load(fis);
			} else{props=this.props;}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();}
		catch(IOException e){
			e.printStackTrace();}
	}
	
	//Step 2: Initializing browser object
	public static void initialization(){
		String browsername=props.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		e_driver.register(new WebDriverListener());
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(props.getProperty("url"));
		
		
	}
	
	 
}
