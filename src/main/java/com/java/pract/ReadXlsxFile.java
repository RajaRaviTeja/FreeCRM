package com.java.pract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsxFile {
	public static String SAMPLE_XLSX_FILE_PATH="C:/D/QURATE/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
	public static void main(String args[]){
		getTestData("Contacts");
	}
	public static Object[][] getTestData(String sheetName){
			Object [][] testData=null;	
			XSSFWorkbook book=null;
			XSSFSheet sheet=null;
					try {
							book= new XSSFWorkbook(new FileInputStream(SAMPLE_XLSX_FILE_PATH));
						    sheet=book.getSheet(sheetName);
						    System.out.println("No of rows::+1  "+ ((sheet.getLastRowNum())+1));
						    System.out.println("No of columns::"+ (sheet.getRow(0).getLastCellNum()));
						    testData=new Object[(sheet.getLastRowNum())+1][sheet.getRow(0).getLastCellNum()];
						    for(int rowIndex=1;rowIndex<=sheet.getLastRowNum();rowIndex++){
						    	for(int columnIndex=0;columnIndex<(sheet.getRow(0).getLastCellNum());columnIndex++){
						    		System.out.println(sheet.getRow(rowIndex).getCell(columnIndex));
						    		testData[rowIndex][columnIndex]=sheet.getRow(rowIndex).getCell(columnIndex);
						    	}
						    }
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			return testData;
			}
	}
