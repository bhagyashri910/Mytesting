package BaseClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Base1
{
	protected static WebDriver driver;
public void launchBrowser()
{
	System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM folder of SW\\chromedriver.exe");
    ChromeOptions opt=new ChromeOptions();
    opt.addArguments("--start-maximize");
    opt.addArguments("--disable-notification");
driver=new ChromeDriver(opt);

    driver.get("https://kite.zerodha.com/");
   
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    driver.manage().window().maximize();
    Reporter.log("Browser launched success",true);
}
public void takeScreenShot(String TCName) throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("D:\\Myscreenshot\\TC "+TCName+"Myscreenshot.png");
FileHandler.copy(src, dest);
Reporter.log("screenShot taken for TC "+TCName,true);
	

}
public void closeBrowser()
{
	driver.close();
	Reporter.log("Browser closed sucusses",true);
}
}
