package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebDriverListener extends TestBase implements WebDriverEventListener {

	public void afterAlertAccept(WebDriver arg0) {
	 System.out.println("");

	}

	public void afterAlertDismiss(WebDriver arg0) {
		 
		System.out.println("");
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("");

	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("");

	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("");

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("");
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		System.out.println("");

	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("");

	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("");
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("");

	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("");

	}

	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("");
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("");

	}

	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("");

	}

	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("");

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("");

	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("");

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("");

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("");

	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		System.out.println("");

	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("");
	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("");
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("");
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("");
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("");
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("");
	}

	public void onException(Throwable arg0, WebDriver arg1) {
        System.out.println("WebDriverEventListener-onException");
		TestUtil.takeScreenShots();
	}

	
}
