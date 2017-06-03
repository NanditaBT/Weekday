package generics;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public static int getRowCount(String path,String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException
	{ int rc=0;
		
	Workbook wb=WorkbookFactory.create(new File(path));
		try
		{
		rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			
		}
		return rc;
	}
	
	public static String getCellData(String path,String sheet,int r,int c) throws EncryptedDocumentException, InvalidFormatException, IOException
	{ String v="";
	 
	Workbook wb = WorkbookFactory.create(new File(path));
	 try
	 {
	  v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
	 }
	catch(Exception e)
	 {
		
	 }
	 return v;
	}
	
	

}
