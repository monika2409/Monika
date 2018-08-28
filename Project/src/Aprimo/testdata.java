package Aprimo;


import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


public class testdata {

	private static final Sheet ExcelWSheet = null;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	public static String getCellData(int RowNum, int ColNum) throws Exception{

	try{

	  Cell = (XSSFCell) ExcelWSheet.getRow(RowNum).getCell(ColNum);

	  String CellData = Cell.getStringCellValue();
	//  String Row = Cell.getStringCellValue();

	  return CellData;


	  }catch (Exception e){

	  return"";

	  }

	 }
}
