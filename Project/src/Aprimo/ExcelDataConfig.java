package Aprimo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public ExcelDataConfig(String excelPath)
	{

	try {
	File src = new File(excelPath);
	FileInputStream fis = new FileInputStream(src);
	wb = new XSSFWorkbook(fis);
	} 
	catch (Exception e) {
	System.out.println(e.getMessage());
	}
	}
	  public String getData(int sheetNumber, int row,int column)
	  {
	  sheet1 = wb.getSheetAt(sheetNumber);
	  String data = sheet1.getRow(row).getCell(column).getStringCellValue();
	  return data;
	 
	  }
	  
	  public int getData1(int sheetNumber, int row,int column)
	  {
	  sheet1 = wb.getSheetAt(sheetNumber);
	  int data1 = (int)sheet1.getRow(row).getCell(column).getNumericCellValue();
	  return data1;
	  }
	  
	  public int getRowCount(int sheetIndex) {
	  
		  int row =  wb.getSheetAt(sheetIndex).getLastRowNum();
		  row=row+1;
		  return row;
	 
	  }
	  
	 //public int getColumnCount(int sheetIndex) {
	// int column = wb.getSheetAt(sheetIndex).getColumnWidth(column);
	// return column;
	 
	// }
	}


	