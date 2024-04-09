package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReport   implements ITestListener {

	
	public ExtentReports extentReports;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	
	Logger logger=Log.getlogData(Log.class.getName());

	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		extentReports=new ExtentReports();
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/"+repName);
		extentReports.attachReporter (sparkReporter);
		
		
		extentReports.setSystemInfo("Host name","localhost");
		extentReports.setSystemInfo("Environemnt","QA");
		extentReports.setSystemInfo("OS",System.getProperty("os.name"));
		extentReports.setSystemInfo("user","kaveri");
		
		sparkReporter.config().setDocumentTitle("Demo API Automation Project"); // Tile of report
		sparkReporter.config().setReportName("Demo API Automation Test Report"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		 
	}
	
	public void onTestStart(ITestResult result) {
		logger.info(result.getName()+ ": test started");
	}

	public void onTestSuccess(ITestResult result) {
		test=extentReports.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		logger.info(result.getName()+ ": test passed");
			}

	public void onTestFailure(ITestResult result)  {
		test=extentReports.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the failed information to the report with RED color highlighted
		
		
//		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
//		File sourceFile=takesscreenshot.getScreenshotAs(OutputType.FILE);
//		File destFile=new File("./Screenshots/"+result.getName()+CurrentDateTime.getDateTime()+".png");
//		try {
//			FileUtils.copyFile(sourceFile, destFile);
//			test.addScreenCaptureFromPath(destFile.getAbsolutePath(),"Screenshot");
//			logger.info("Screenshot taken");
//			logger.warn("Test failed:"+result.getName() );
//		} catch (IOException e) {
//			logger.warn("Test failed but couldn't take screenshot:" + e.getMessage());
//		}
  	    
		}
	

	

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.YELLOW));
		logger.info(result.getName()+": test skipped");
	}

	

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	
}
