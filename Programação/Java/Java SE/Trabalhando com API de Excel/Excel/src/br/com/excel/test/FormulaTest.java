package br.com.excel.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FormulaTest {

	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row1 = sheet.createRow(0);
		
		HSSFCell cell1 = row1.createCell(0);
		HSSFCell cell2 = row1.createCell(1);
		HSSFCell cell3 = row1.createCell(2);
		HSSFCell cell4 = row1.createCell(3);
		HSSFCell cell5 = row1.createCell(4);
		
		cell1.setCellValue(56);
		cell2.setCellValue("+");
		cell3.setCellValue(199);
		cell4.setCellValue("=");
		
		cell5.setCellFormula("A1+C1");
		
		HSSFRow row2 = sheet.createRow(1);
		
		HSSFCell cell21 = row2.createCell(0);
		HSSFCell cell22 = row2.createCell(1);
		HSSFCell cell23 = row2.createCell(2);
		HSSFCell cell24 = row2.createCell(3);
		HSSFCell cell25 = row2.createCell(4);
		
		cell21.setCellValue(1);
		cell22.setCellValue(2);
		cell23.setCellValue(3);
		cell24.setCellValue(4);
		
		cell25.setCellFormula("SUM(A2:D2)");

		try {
			FileOutputStream output = new FileOutputStream("formula.xls");
			workbook.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
