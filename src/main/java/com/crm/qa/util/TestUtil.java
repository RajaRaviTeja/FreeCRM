package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String SAMPLE_XLSX_FILE_PATH="C:/D/QURATE/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
	
	public static void main(String args[]){
		//getCRMTestDataAsString();
		getCRMTestData();
	}
	
	public static Object[][] getTestDataInToObjectArray(String sheetName){
		Object[][] testDateObjData=null;
		Object[][] data=null;
		XSSFWorkbook book=null;
		XSSFSheet sheet=null;
		int lastColumn=0;

		try{
			
		    book= new XSSFWorkbook(new FileInputStream(SAMPLE_XLSX_FILE_PATH));
			sheet=book.getSheet(sheetName);
			
			testDateObjData=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];	
	    	
			System.out.println( "FirstRowNum: "+sheet.getFirstRowNum() +"-----LastRowNum: "+sheet.getLastRowNum());
			System.out.println("FirstCellNum: "+sheet.getRow(0).getFirstCellNum() + "--------LastCellNum: "+sheet.getRow(0).getLastCellNum());
			System.out.println();
			System.out.println("====Adding below records to Object[][]====");
	    	
			for(int row=1;row<=sheet.getLastRowNum();row++){
				  for(int column=0;column<sheet.getRow(row).getLastCellNum();column++){
					  System.out.println("Adding data at ["+ (row-1) +"]["+column+"]  "+sheet.getRow(row).getCell(column).toString());
					  testDateObjData[row-1][column]=sheet.getRow(row).getCell(column).toString();
				  }
				  System.out.println("--------------");
			  }
			}
			catch(FileNotFoundException e){
				   e.printStackTrace();} 
			catch (IOException e) {
				   e.printStackTrace();
			}
		    System.out.println();
			return testDateObjData;
	  }
 

	 public static Object [][] getCRMTestData(){
		   Object [][]data=getTestDataInToObjectArray("Contacts");
		   
		   System.out.println("====Printing data from Object[][]====");
		   System.out.println(data.toString());
		   System.out.println("No of rows in Object[][]  "+data.length);
		   System.out.println("No of columns in each row  "+data[0].length);
		   
		   
		   /*System.out.println(data[0][0]);
		   System.out.println(data[0][1]);
		   System.out.println(data[0][2]);
		   
		   System.out.println(data[1][0]);
		   System.out.println(data[1][1]);
		   System.out.println(data[1][2]);
		
		   System.out.println(data[2][0]);
		   System.out.println(data[2][1]);
		   System.out.println(data[2][2]);*/
		   
		   

		   System.out.println();
		  for(int i=0;i<data.length;i++){
			   for(int j=0;j<data[i].length;j++){
			
				   System.out.println(" data["+ (i)+ "]["+ j +"] 		"+data[i][j]);
			   }
			      System.out.println("---------------------------------");
		
		   }
	
		   return data;
	   }
	
	
	
	
	public static String[] getTestDataInToStringArray(String sheetName){
		Object[][] testDateObjData=null;
		String[] testDataString=null;
		XSSFWorkbook book=null;
		XSSFSheet sheet=null;

		try{
			   
		    book= new XSSFWorkbook(new FileInputStream(SAMPLE_XLSX_FILE_PATH));
			sheet=book.getSheet(sheetName);
			testDataString = new String [sheet.getLastRowNum()];
	    	System.out.println( "FirstRowNum: "+sheet.getFirstRowNum() +"-----LastRowNum: "+sheet.getLastRowNum());
			System.out.println("FirstCellNum: "+sheet.getRow(0).getFirstCellNum() + "--------LastCellNum: "+sheet.getRow(0).getLastCellNum());
			System.out.println();

			System.out.println("====Adding below records to String[]====");
	    	for(int row=1;row<=sheet.getLastRowNum();row++){
	    		//System.out.println(sheet.getRow(row).getCell(0).toString()+" "+sheet.getRow(row).getCell(1).toString()+" "+sheet.getRow(row).getCell(2).toString());
	    		testDataString[row-1]=sheet.getRow(row).getCell(0).toString()+" "+sheet.getRow(row).getCell(1).toString()+" "+sheet.getRow(row).getCell(2).toString();
	    		//System.out.println("--------------");
			  }
			}
			catch(FileNotFoundException e){
				   e.printStackTrace();} 
			catch (IOException e) {
				   e.printStackTrace();
			}
		    System.out.println();
			return testDataString;
	  }

	
	
	
	 public static String[] getCRMTestDataAsString(){
		   String[] data=getTestDataInToStringArray("Contacts");
		   
		   System.out.println("====Printing data from Object[][]====");
		   System.out.println("No of rows in Object[][]  "+data.length);
		   System.out.println();
		   for(int i=0;i<data.length;i++){
			      System.out.println("---------------------------------"+data[i]);
		   }
		   return data;
	   }
	   
	
	
	public static void takeScreenShots(){
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f,new File( System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		
		
		
	}
	
	
}


/*
System.out.println(data[1][0]);
System.out.println(data[1][1]);
System.out.println(data[1][2]);
System.out.println(data[2][0]);
System.out.println(data[2][1]);
System.out.println(data[2][2]);
System.out.println(data[3][0]);
System.out.println(data[3][1]);
System.out.println(data[3][2]);
*/   
