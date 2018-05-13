package guru99;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class util {

	public static  String url = "http://demo.guru99.com";
	
	public static String[] getxcldata(int i) throws IOException
	{
		
		String[] data = new String[2];
		FileInputStream fis2 = new FileInputStream("D:\\sel_workspace\\selenium\\UP.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis2);
		XSSFSheet sh = wb.getSheet("Sheet1");
		XSSFRow rw = sh.getRow(i);
		XSSFCell cl =rw.getCell(0);
		
		data[0] = cl.getStringCellValue();
		cl =rw.getCell(1);
		data[1] = cl.getStringCellValue();
		
		fis2.close();
		return data;
		
	}
	
}
