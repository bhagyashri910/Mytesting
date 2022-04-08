package KiteAppPOMClasses;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
{
@FindBy(id="userid")private WebElement UserID;
@FindBy(id="password")private WebElement Password;
@FindBy(xpath ="//button[@type='submit']")private WebElement LoginButton;

public KiteLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void enterUserID(String uid)
{
	UserID.sendKeys(uid);
}
public void enterPassword(String pwd)
{
	Password.sendKeys(pwd);
}
public void clickOnLoginButton()
{
	LoginButton.click();
}
}
