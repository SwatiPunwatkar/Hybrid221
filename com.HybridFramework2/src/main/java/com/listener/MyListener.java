package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utility.DriverUtils;

public class MyListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		
			
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Testcase passed with name"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,"Testcase fail with name"+result.getName());
		
		
		try {
			String path= DriverUtils.getScreenshot(result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		public void onTestSkipped(ITestResult result) {
	
			test.log(Status.SKIP,"Testcase skipped with name"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info("Testcase is ready for execution");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info("Testsuite is successfully executed");
		report.flush();
	}
	
}


 
	
	


