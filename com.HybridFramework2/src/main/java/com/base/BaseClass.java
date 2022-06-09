package com.base;

import java.util.concurrent.TimeUnit;

import javax.naming.ldap.ExtendedRequest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtils;

public class BaseClass {
	
	public static WebDriver driver= null;
	public static Logger Log=Logger.getLogger(BaseClass.class);
	
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	public static ExtentSparkReporter spark= null;
	
	
	
	public static void initialization() throws Exception {
		
		System.out.println("reading a browser name from config file");
		Log.info("reading a browser name from config file");
		
		String browser=PropertiesUtils.readProperties("browser");
		Log.info("browser name found in config file as: "+browser);
	
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","F:\\JAVA\\Syllanium\\javabykiran-Selenium-Softwares\\javabykiran-Selenium-Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.readProperties("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
public static void reportInit() {
	report= new ExtentReports();
	spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html"); 
	report.attachReporter(spark);
}
}
