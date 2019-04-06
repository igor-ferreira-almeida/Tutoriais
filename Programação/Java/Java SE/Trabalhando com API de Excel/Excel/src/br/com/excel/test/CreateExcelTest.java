package br.com.excel.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.WorkbookUtil;

public class CreateExcelTest {

	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		HSSFSheet sheet1 = workbook.createSheet();
		HSSFSheet sheet2 = workbook.createSheet("Pankeques");
		HSSFSheet sheet3 = workbook.createSheet(WorkbookUtil.createSafeSheetName("Cartório"));
		HSSFRow row = sheet3.createRow(0);
		HSSFCell cell = row.createCell(3); // A: 0, B: 1
		cell.setCellValue("Hi there");
		
		System.out.println(cell.getRichStringCellValue().toString());
		
		try {
			FileOutputStream output = new FileOutputStream("test1.xls");
			workbook.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
