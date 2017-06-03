package generics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.IReporter;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class TestNGListener implements ITestListener, IReporter, IRetryAnalyzer{
	SimpleDateFormat f=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss");
	 String f1=f.format(new Date());
	 
	 Date d = new Date();
	 String date=d.toString();
	@Override
	public void onTestStart(ITestResult result) {
		
		Reporter.log(""+result.getStartMillis(),true);
		Reporter.log("Test Case "+result.getName()+" started at " +date+ "",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("Test Case "+result.getName()+" succeded at " +f1+ " " ,true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		
		Reporter.log("Test Case "+result.getName()+" failed at " +f1+ " " ,true );
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		Reporter.log("Test Case "+result.getName()+" skipped at " +f1+ "",true );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		
	}

	int counter = 0;
	int retryLimit = 3;
	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

	
	
}
/** Summary:

  *TestNG has an inbuilt reporting ability in it.
  *After a complete execution of test cases, TestNG generates a test-output folder in the root
   of the project.
  *In the test-output folder, there are two main reports, index.html, and emailable-report.html.
>>*To customize TestNG report we need to implement two interfaces, ITestListener and IReporter.>
>>*If we need to get a report in between execution, we need ITestListener.
>>*For creating a final report after complete execution, we need to implement IReporter.
>>>*Taking the screenshot, in Selenium WebDriver, we need to type cast WebDriver to TakesScreenShot
   interface.
  *To generate pdf reports we need to add IText jar in the project.
  */
