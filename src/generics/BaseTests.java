package generics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

abstract public class BaseTests implements AutoConst{
	
 public WebDriver driver;
	//@Parameters({"node","browser"})
    @BeforeMethod(alwaysRun= true)
	public void openApplication()
	{
  /*FirefoxProfile fp= new FirefoxProfile();
  fp.setAcceptUntrustedCertificates(true);
  fp.setAssumeUntrustedCertificateIssuer(false);
  driver= new FirefoxDriver(fp);*/
 
//driver= new RemoteWebDriver(url,d);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
	}
	
	@AfterMethod(alwaysRun= true)
	public void closeApplication(ITestResult result) throws IOException
	{
		
//		String testname=result.getName();
//		int status=result.getStatus();
		if(ITestResult.FAILURE==result.getStatus())
		{
			Library.getSnapshot("./snapshot/"+result.getName(), driver);
		}
		
		driver.quit();
	}

}
