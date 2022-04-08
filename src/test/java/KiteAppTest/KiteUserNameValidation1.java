package KiteAppTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import BaseClasses.Base1;
import KiteAppPOMClasses.KiteHomePage;
import KiteAppPOMClasses.KiteLoginPage;
import KiteAppPOMClasses.KitePinPage;
import utility.Utility;

//only using listener for new class create.
@Listeners(listener.Listener.class)
public class KiteUserNameValidation1 extends Base1
{
	KiteLoginPage login;
	  KitePinPage pin;
	  KiteHomePage home;
	  @BeforeClass
	  public void browserLaunch()
	   {
		  launchBrowser();
		 login=new KiteLoginPage(driver);
		  pin=new KitePinPage(driver);
		   home=new KiteHomePage(driver);
		  
	  }
	  @BeforeMethod
	  public void loginToKiteApp() throws EncryptedDocumentException, IOException
	  {
		 login.enterUserID(Utility.readDataFromExcel(0, 0));
		  login.enterPassword(Utility.readDataFromExcel(0, 1));
		  login.clickOnLoginButton();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		  pin.enterPin(Utility.readDataFromExcel(0, 2));
		  pin.clikOnContinueButton();
	  }
	  @Test
	  public void validateUserName() throws EncryptedDocumentException, IOException
	  {
		  //int TCID = 100;
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		  String actualUserID = home.getactualUserID();
		 String expectedUserID = Utility.readDataFromExcel(0, 3);
		 Assert.assertEquals(actualUserID, expectedUserID,"Actual and Expected UserID are not matching");
		 
		 //Utility.takeScreenShot(driver, TCID);
		 Reporter.log("Validate USerNAme",true);
	  }
	  @AfterMethod
	  public void logoutFromKiteApp() throws InterruptedException
	  {
		  home.logOut();
		  Reporter.log("Logging out",true);
	  }
	 @AfterClass
	  public void clossingBrowser()
	  {
		  closeBrowser();
	  }
}
