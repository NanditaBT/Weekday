package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generics.BaseTests;
import generics.ExcelSheet;
import pom.ActiLoginPage;

public class VerifyVersion extends BaseTests{
	
	@Test(priority=0)
	public void testVerifyVersion() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String eVersion=ExcelSheet.getCellData(INPUT_PATH, "VerifyLogin", 1, 3);
		ActiLoginPage version= new ActiLoginPage(driver);
		version.verifyVersion(eVersion);
		//Assert.fail();
	}

}
