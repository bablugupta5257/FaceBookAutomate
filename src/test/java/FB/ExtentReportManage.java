package FB;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentReportManage extends BaseClass implements ITestListener{

	public ExtentSparkReporter sparkReporter;// for UI of report
	public	ExtentReports extent; // populate common dtails like system details
	public	ExtentTest test; // for creating test case enteries abd updating report 
	
	@Override
	public void onTestStart(ITestResult result) {
		
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		
		sparkReporter.config().setDocumentTitle("FB Automation Report");// Title of report
		sparkReporter.config().setReportName("Function Testing"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);// Report theme will be dark
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);// used to combine information with UI
		
		extent.setSystemInfo("Computer Name","Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Bablu");
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Browser", "Chrome");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "The Test Case passes is: "+result.getName()); // update in report status as passed if passed
		
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is :"+result.getName());
		test.log(Status.FAIL, "Test Case Failed cause is :"+result.getThrowable());
		
		String PassSS = result.getName();
		TakesScreenshot t = (TakesScreenshot)driver;
		File scr = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+PassSS+".png");
		
		try {
			Files.copy(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case Skipped is :"+result.getName());
		
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		ITestListener.super.onFinish(context);
	}

	
}
