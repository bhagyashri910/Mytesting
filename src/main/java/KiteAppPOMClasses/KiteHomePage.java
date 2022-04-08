package KiteAppPOMClasses;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class KiteHomePage 
{
@FindBy(xpath = "//span[@class='user-id']")private WebElement userID;
@FindBy(xpath = "//a[@target='_self']")private WebElement logOutButton;
 public KiteHomePage (WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 public String getactualUserID()
 {
	 //String expectedUserID = UserID;
	 
	  String actualUserID = userID.getText();
	  return actualUserID;
	  
	  //we will verify using TestNG asserts so not using if-else statement.
	  
//	  if(actualUserID.equals(expectedUserID))
//	  {
//		  System.out.println("result is matching then TC is passed");
//	  }
//	  else
//	  {
//		  System.out.println("result is not matching then TC case is failed");
//	  }
	  
	 
 }//4
 public void logOut() throws InterruptedException
 {
	  userID.click();
	  Thread.sleep(2000);
	  logOutButton.click();
	  
 }
}
