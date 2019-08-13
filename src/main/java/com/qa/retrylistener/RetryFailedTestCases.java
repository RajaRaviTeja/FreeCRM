package com.qa.retrylistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	public int retryCount=0;
	
	
	// until retry() returns true, testng will re execute the fail test cases, once it returns false, testng will not retry
	@Override
	public boolean retry(ITestResult result) {
		
		while(retryCount<2){
	         
			System.out.println("----Retrying "+result.getName()+" for "+ (retryCount+1) +" time----");	
			retryCount++;
			return true;
		}
		return false;
	}

}
