package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility1
{
	static Sheet Mysheet;
	public static String readDataFromExcel(int rowIndex,int coloumnIndex) throws EncryptedDocumentException, IOException
	{
		 FileInputStream myfile=new FileInputStream("D:\\SELENIUM folder of SW\\excelTest.xlsx");
		 Mysheet=WorkbookFactory.create(myfile).getSheet("Sheet6");
		 String value = Mysheet.getRow(rowIndex).getCell(coloumnIndex).getStringCellValue();
		 return value;

	}
}
