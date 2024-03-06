package com.luma.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import com.luma.utility.NewExcelLibrary;

public class DataProviders extends  NewExcelLibrary{
	
	@DataProvider(name = "credentials")
	public Object[][] credentialsEnter(){
		String fileName = "C:\\Users\\yogit\\eclipse-workspace\\MyFlipcartProject\\src\\test\\resources\\TestData\\TestData.xlsx";
		System.out.println("excel file get");
		Object[][] data11 = getexcelData(fileName,"Credentials");
		System.out.println("excel sheet get");
		return data11;
	}
	
	@DataProvider(name = "searchProduct")
	public Object[][] searchProductEnter(){
		String fileName = "C:\\Users\\yogit\\eclipse-workspace\\MyFlipcartProject\\src\\test\\resources\\TestData\\TestData.xlsx";
		System.out.println("excel file get");
		Object[][] data11 = getexcelData(fileName,"SearchProduct");
		System.out.println("excel sheet get");
		return data11;
	}
	
	@DataProvider(name = "getProduct")
	public Object[][] AddtoCartEner(){
		String fileName = "C:\\Users\\yogit\\eclipse-workspace\\MyFlipcartProject\\src\\test\\resources\\TestData\\TestData.xlsx";
		System.out.println("excel file get");
		Object[][] data11 = getexcelData(fileName,"ProductDetails");
		System.out.println("excel sheet get");
		return data11;
	}
	
	
//	@DataProvider(name="loginCredentials")
//	public Object[][] dataset11(){
//		obj.ExcelSheet = (obj.ExcelBook).getSheet("Credentials");
//		int rowCount = ((obj.ExcelSheet).getLastRowNum())+1;
//		System.out.println(rowCount);
//		int columnCount = (obj.ExcelSheet).getRow(0).getLastCellNum();
//		
//		Object[][] loginCredentials = new Object[1][2];
//		loginCredentials[0][0]="Sirijobs@gmail.com";
//		loginCredentials[0][1]="Siri@12345";
//		return loginCredentials;
//	}
//	
//	Object[][] loginCredentials = new Object[1][2];
//	loginCredentials[0][0]="Sirijobs@gmail.com";
//	loginCredentials[0][1]="Siri@12345";
//	return loginCredentials;
//	for(int currentRow = 1; currentRow < rowCount; currentRow++) {
//		for(int CurrentCol = 1; CurrentCol<columnCount;CurrentCol++) {
//			obj.getCell
//			data[currentRow][CurrentCol] = ExcelSheet.getRow(currentRow).getCell(CurrentCol).toString();
//		}
		
//	}
	
//	return new Object[][]
//			{
//			{"Sirijobs@gmail.com","Siri@12345"}
//			};
			//	public Object[][] getCredentials() {
		
//		
		
//	}
//	@DataProvider(name = "credentials")
//	public Object[][] getCredentials() {
//		// Totals rows count
//		int rows = obj.getRowCount("Credentials");
//		// Total Columns
//		int column = obj.getColumnCount("Credentials");
//		int actRows = rows - 1;
//
//		Object[][] data = new Object[actRows][column];
//
//		for (int i = 0; i < actRows; i++) {
//			for (int j = 0; j < column; j++) {
//				data[i][j] = obj.getCellData("Credentials", j, i + 2);
//			}
//		}
//		return data;
//	}

//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
//	@DataProvider(name = "email")
//	public Object[][] getEmail() {
//		// Totals rows count
//		int rows = obj.getRowCount("Email");
//		// Total Columns
//		int column = obj.getColumnCount("Email");
//		int actRows = rows - 1;
//
//		Object[][] data = new Object[actRows][column];
//
//		for (int i = 0; i < actRows; i++) {
//			for (int j = 0; j < column; j++) {
//				data[i][j] = obj.getCellData("Email", j, i + 2);
//			}
//		}
//		return data;
//	}
//
////Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
//	@DataProvider(name = "getProduct")
//	public Object[][] getProduct() {
//		// Totals rows count
//		int rows = obj.getRowCount("ProductDetails");
//		// Total Columns
//		int column = obj.getColumnCount("ProductDetails");
//		int actRows = rows - 1;
//
//		Object[][] data = new Object[actRows][column];
//
//		for (int i = 0; i < actRows; i++) {
//			for (int j = 0; j < column; j++) {
//				data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
//			}
//		}
//		return data;
//	}
//
//	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
//	@DataProvider(name = "searchProduct")
//	public Object[][] getProductPrice() {
//		// Totals rows count
//		int rows = obj.getRowCount("SearchProduct");
//		// Total Columns
//		int column = obj.getColumnCount("SearchProduct");
//		int actRows = rows - 1;
//
//		Object[][] data = new Object[actRows][column];
//
//		for (int i = 0; i < actRows; i++) {
//			for (int j = 0; j < column; j++) {
//				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
//			}
//		}
//		return data;
//	}
//	
//	@DataProvider(name = "newAcountDetailsData")
//	public Object[][] accountCreation() {
//
//		// Totals rows count
//		int rows = obj.getRowCount("AccountCreationData");
//		// Total Columns
//		int column = obj.getColumnCount("AccountCreationData");
//		int actRows = rows - 1;
//		//Created an object of array to store data
//		Object[][] data = new Object[actRows][1];
//		
//		for (int i = 0; i < actRows; i++) {
//			Map<String, String> hashMap = new HashMap<>();
//			for (int j = 0; j < column; j++) {
//				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
//						obj.getCellData("AccountCreationData", j, i + 2));
//			}
//			data[i][0]=hashMap;
//		}
//		return data;
//	}
//	

}
