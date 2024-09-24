package Commonfunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Exceldata {
	XSSFWorkbook workbook;
	// static WebDriver driver;

	public Exceldata() {

		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./TestData/Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  String getstringdata(String Sheetname, int Row, int column) {
		XSSFCell cell = workbook.getSheet(Sheetname).getRow(Row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}

	public String getPaymentdata(String sheetname, int row, int column) {
		XSSFCell paycell = workbook.getSheet(sheetname).getRow(row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String pay = dataFormatter.formatCellValue(paycell);
		return pay;
	}

	public String getbillingdata(String sheetname, int row, int column) {
		XSSFCell cell = workbook.getSheet(sheetname).getRow(row).getCell(column);
		DataFormatter formatter = new DataFormatter();
		String bill = formatter.formatCellValue(cell);
		return bill;
	}
}
