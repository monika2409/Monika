package Aprimo;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Excelread
{
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public Excelread(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
 
    public String getCellData(String sheetName,int colNum,int rowNum)
    {
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if(cell.getCellTypeEnum() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
            {
                String cellValue  = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
        }
    }
    
    public int getRowCount(int sheetIndex) 
	{
		int row =  workbook.getSheetAt(sheetIndex).getLastRowNum();
		row=row + 1;
		return row;
	}
	  
}