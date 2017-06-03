package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generics.BasePage;

public class ActiLoginPage extends BasePage{
	//decleration
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;

	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement errMsg;
	
	//intitialization
	public ActiLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public void clickLogin(String un ,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
	}
	
	public void verifyVersion(String eVersion)
	{
		String actual=version.getText();
		Assert.assertEquals(actual, eVersion);
	}
	
	public void verifyErrMsg()
	{
		WebDriverWait wait= new WebDriverWait(driver,5);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(errMsg));
		Reporter.log("Errormsg is Dispalyed: PASS", true);
		}
		catch(Exception e)
		{
			Reporter.log("Errormsg is Not Dispalyed: FAIL", true);
			Assert.fail();
		}
	}

}
