package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generics.BaseTests;

@Listeners(generics.TestNGListener.class)
public class RaviTest extends BaseTests{
	
	@Test(groups={"Smoke"})
	public void testRavi() throws InterruptedException
	{
		FirefoxProfile fp= new FirefoxProfile();
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//wait.until(NoSuchElementException.class);
		driver.get("http://www.fb.com");
		Thread.sleep(1000);
		driver.navigate().refresh();
		WebElement e= driver.findElement(By.id("t1"));
		
		Thread.sleep(1000);
		//Assert.fail();
	}

}
