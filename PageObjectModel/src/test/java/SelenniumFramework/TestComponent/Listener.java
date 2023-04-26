package SelenniumFramework.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SelenniumFramework.Resources.ExtentReportTestNG;

public class Listener extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReportTestNG.getReportObject();
	ThreadLocal<ExtentTest> threadLocal=new ThreadLocal();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS,"Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		String filePath = null;
		threadLocal.get().fail(result.getThrowable());
		threadLocal.get().log(Status.FAIL,"Test Failed");
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try 
		{
			filePath=getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			threadLocal.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
	}
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
}
