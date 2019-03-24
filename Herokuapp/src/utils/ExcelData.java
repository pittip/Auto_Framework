package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	private static String browser;
	private static String url;
	
	public static String getBrowserTypeFromExcel() {
		
		try {
			FileInputStream fis = new FileInputStream(new File("E:\\EclipseWorkspace\\Herokuapp\\test-input\\data.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Browser");
			
			browser = sheet.getRow(0).getCell(0).toString();
			System.out.println(browser);
			
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return browser.toUpperCase();
	}
	
	public static String getAppURL() {
			
		try {
			FileInputStream fis = new FileInputStream(new File("E:\\EclipseWorkspace\\Herokuapp\\test-input\\data.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			url = workbook.getSheet("AppURL").getRow(0).getCell(0).toString();
			
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return url;
	}
}