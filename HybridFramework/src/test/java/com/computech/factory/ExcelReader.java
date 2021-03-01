package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell col;
	public ExcelReader()  {
						
		File excelFilePath = new File(System.getProperty("user.dir")+"\\TestData\\ProjectData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(excelFilePath);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int rowsCount(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
		/*sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		return rows;*/
	}
	public int colsCount(String sheetName, int rowNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getPhysicalNumberOfCells();
	}
	
	public String getStringData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public String getStringData(int sheetIndex, int rowNo, int colNo) {
		return wb.getSheetAt(sheetIndex).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public double getDecimalData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public int getNumberData(String sheetName, int rowNo, int colNo) {
		return (int) wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	
	public boolean getBooleanData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getBooleanCellValue();
	}

}
