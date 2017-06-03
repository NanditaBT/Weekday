package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

abstract public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void verifyTitle(String eTittle)
	{
		String aTitle=driver.getTitle();
		WebDriverWait wait= new WebDriverWait(driver,5);
		try
		{
		wait.until(ExpectedConditions.titleIs(eTittle));
		Reporter.log("Tittle is Matching: PASS",true );
		}
		catch(Exception e)
		{
			Reporter.log("Tittle is NOT Matching: FAIL" ,true);
			Assert.fail();
	
		}
		
	}
		
public void elementIsClickable(WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver,5);
	try
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	catch(Exception e)
	{
		Reporter.log("Element Is Not Clickable");;
	}
}

public void elementISelected(WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver,5);
	try
	{
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
	catch(Exception e)
	{
		Reporter.log("Element Is Not Selected");;
	}
}
}
