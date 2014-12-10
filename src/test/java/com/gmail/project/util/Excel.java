package com.gmail.project.util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel {

	public static FileInputStream fileInput;
	public static FileOutputStream fileOut;
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	public static HSSFCell cell;
	public static DataFormatter formatter;

	public static void setExcel(String path, String sheetname) throws IOException{
		fileInput=new FileInputStream(path);
		workbook=new HSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetname);
	}
	public static String getCellValue(int row,int col){
		cell=sheet.getRow(row).getCell(col);
		formatter=new DataFormatter();
		return formatter.formatCellValue(cell);
	}
	public static void putCellValue(String path,int row,int col,String value) throws IOException{
		fileOut=new FileOutputStream(path);
		workbook.write(fileOut);
		cell=sheet.getRow(row).getCell(col);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
	}
}
