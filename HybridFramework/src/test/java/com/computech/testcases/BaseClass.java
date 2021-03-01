package com.computech.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.computech.factory.BrowserFactory;
import com.computech.factory.DataProviderFactory;
import com.computech.utilites.Utility;

@SuppressWarnings("unused")
public class BaseClass {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger; 
	String path;
	
	@BeforeSuite
	public void setupTestSuite() {
		path = System.getProperty("user.dir")+"\\Reports\\OrangeHRM.html";
		ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplicaion(DataProviderFactory.getConfig().getStagingURL(), 
				                             DataProviderFactory.getConfig().getBrowser());
	}
	@AfterMethod
	public void tearDownTest(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed..");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test failed: "+ result.getThrowable().getMessage() );
			try {
				MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test case is skipped..");
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		Utility.waitTo(3);
		//driver.get(path);
		BrowserFactory.closeApp(driver);
	}
	
	
	/*
	 @BeforeClass
	public void setUp() {
		ConfigProvider config = new ConfigProvider();
		driver = BrowserFactory.startApplicaion(config.getStagingURL(), config.getBrowser());
	}
	 */
}
