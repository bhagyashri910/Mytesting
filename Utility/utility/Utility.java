package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	static Sheet Mysheet;
public static String readDataFromExcel(int rowIndex,int coloumnIndex) throws EncryptedDocumentException, IOException
{
	 FileInputStream myfile=new FileInputStream("D:\\SELENIUM folder of SW\\excelTest.xlsx");
	 Mysheet=WorkbookFactory.create(myfile).getSheet("Sheet6");
	 String value = Mysheet.getRow(rowIndex).getCell(coloumnIndex).getStringCellValue();
	 return value;

}
public static void takeScreenShot(WebDriver driver,int TCID) throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("D:\\Myscreenshot\\TC "+TCID+"Myscreenshot.png");
FileHandler.copy(src, dest);
Reporter.log("screenShot taken for TC "+TCID,true);
	

}
}
