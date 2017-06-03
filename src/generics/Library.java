package generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Library {
	
	public static void getSnapshot(String folder,WebDriver driver) throws IOException{
		//Date d = new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss");
		String dateformat=f.format(new Date());
		//String now=d.toString().replace(':','-');
		
		TakesScreenshot s= (TakesScreenshot) driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File dst= new File(folder+dateformat+".png");
		FileUtils.copyFile(src, dst);

	}

}
