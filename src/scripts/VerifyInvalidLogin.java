package scripts;

import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import generics.BaseTests;
import generics.ExcelSheet;
import junit.framework.Assert;
import pom.ActiLoginPage;

public class VerifyInvalidLogin extends BaseTests {
	
	@Test(priority=3)
	public void testVerifyInvalidLogin() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String un=""; String pw="";
	ActiLoginPage lp= new ActiLoginPage(driver);
		int rc=ExcelSheet.getRowCount(INPUT_PATH, "VerifyInvalidLogin");
		for(int i=1; i<=rc; i++)
		{
		 un=ExcelSheet.getCellData(INPUT_PATH, "VerifyInvalidLogin", i, 0);
		 pw=ExcelSheet.getCellData(INPUT_PATH, "VerifyInvalidLogin", i, 1);
		 lp.clickLogin(un, pw);

			Thread.sleep(1000);
		 lp.verifyErrMsg();
		 
		
		}

		
		Thread.sleep(1000);
		
		
		
		
	}
	
	

}
