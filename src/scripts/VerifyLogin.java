package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import generics.BaseTests;
import generics.ExcelSheet;
import pom.ActiLoginPage;
import pom.EnterTimeTrackPage;

public class VerifyLogin extends BaseTests{
	
	@Test(groups={"Smoke"})//(priority=1, invocationCount=1)
	public void testValidLogin() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		String un=ExcelSheet.getCellData(INPUT_PATH, "VerifyLogin", 1, 0);
		String pw=ExcelSheet.getCellData(INPUT_PATH, "VerifyLogin", 1, 1);
		String eTittle=ExcelSheet.getCellData(INPUT_PATH, "VerifyLogin", 1, 4);
		ActiLoginPage a= new ActiLoginPage(driver);
		a.clickLogin(un, pw);
		
		
		EnterTimeTrackPage e= new EnterTimeTrackPage(driver);
		String HTittle=ExcelSheet.getCellData(INPUT_PATH, "VerifyLogin", 1, 2);
		
		e.verifyTitle(HTittle);
		
		e.clickLogout();
		a.verifyTitle(eTittle);
		//a.verifyErrMsg();
	}

}
