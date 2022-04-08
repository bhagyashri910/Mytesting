package BaseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class Base 
{
	protected WebDriver driver;
public void launchBrowser()
{
	System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM folder of SW\\chromedriver.exe");
    ChromeOptions opt=new ChromeOptions();
    opt.addArguments("--start-maximize");
    opt.addArguments("--disable-notification");
driver=new ChromeDriver(opt);
//	 System.setProperty("webdriver.gecko.driver", "D:\\SELENIUM folder of SW\\geckodriver.exe");
//     FirefoxOptions opt=new FirefoxOptions();
//     opt.addArguments("--disable-notifications");
//     driver = new FirefoxDriver(opt);
    driver.get("https://kite.zerodha.com/");
   
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    driver.manage().window().maximize();
    Reporter.log("Browser launched success",true);
}
public void closeBrowser()
{
	driver.close();
	Reporter.log("Browser closed sucusses",true);
}
}
