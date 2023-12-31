package com.ActtimeGenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelibrary {
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./Testdata/testdata.property");
		Properties p=new Properties();
		p.load(fis);
		String value =p.getProperty(key);
		return value;
		}
	public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Automation.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String value = wb.getSheet("Dere").getRow(row).getCell(cell).getStringCellValue();
		return value;
     }
}
