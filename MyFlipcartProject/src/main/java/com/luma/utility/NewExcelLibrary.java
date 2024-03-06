package com.luma.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.luma.base.BaseClass;

public class NewExcelLibrary{
	public String[][] getexcelData(String FileName, String SheetName){
		String[][]  data1 = null;
		System.out.println("excel fetching");
		try {
			System.out.println("excel fetching inputStream");
			FileInputStream inputStream1 = new FileInputStream(FileName);
			System.out.println("excel fetching workBook");
			Thread.sleep(5000);
			XSSFWorkbook workBook1 = new XSSFWorkbook(inputStream1);
			Thread.sleep(5000);
			System.out.println("workBook got");
			System.out.println("excel fetching excelSheet");
			XSSFSheet excelSheet = workBook1.getSheet(SheetName);
			System.out.println("excel fetching totalRow");
			int totalRow = excelSheet.getLastRowNum()+1;
			System.out.println("totalRow is"+totalRow);
			System.out.println("excel fetching totalCol");
			int totalCol = excelSheet.getRow(0).getLastCellNum();
			System.out.println("totalCol is"+totalCol);
			
			data1 = new String[totalRow-1][totalCol];
			System.out.println("data1 is");
			System.out.println(data1);
			System.out.println("for loop started");
			
			for(int currentRow=1;currentRow<totalRow;currentRow++) {
				System.out.println("for outer loop");
				for(int currentCell=0;currentCell<totalCol;currentCell++) {
					System.out.println("for inner loop");
					data1[currentRow-1][currentCell] = excelSheet.getRow(currentRow).getCell(currentCell).toString();
					System.out.println("for inner loop"+data1[currentRow-1][currentCell]);
				}
			}
			System.out.println("closing workbook");
			workBook1.close();
			System.out.println("workbook closed ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data1;
	}

}
