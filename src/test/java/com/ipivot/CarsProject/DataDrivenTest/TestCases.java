package com.ipivot.CarsProject.DataDrivenTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ipivot.CarsProject.PageObject.HomePage;
import com.ipivot.CarsProject.PageObject.ResearchPage;
import com.ipivot.CarsProject.TestBase.TestBaseClass;

public class TestCases {
	 TestBaseClass tb =new TestBaseClass();
	  ExtentReports extent;
	  WebDriver driver;
	  HomePage hp;
	  ResearchPage rp;
	  ExtentTest logger ;
	      
		
		@BeforeClass
		public void reportSetUp() {
		//Set details for extent report.
			ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output\\ExtentReport.html"); 
		    extent = new ExtentReports();
			extent.attachReporter(html);
			html.config().setDocumentTitle("Test Automation Report - Execution Report - CarsProject");
			html.config().setReportName("Test Automation Report - Execution Report - CarsProject");
			html.config().setTheme(Theme.DARK);
		}
		
		@BeforeMethod
		public void testSetUp() throws Exception {
			//create the instances
			 driver = tb.LaunchandNavigateBrowser();
			 hp=new HomePage(driver);
			 rp=new ResearchPage(driver);
		}
		
		@Test()
		public void testcase1() {
			logger = extent.createTest("Test1");
		
			hp.clickResearchBtn();
			rp.clickOnMakeBtn();
			rp.clickOnAcura();
				
		}
		@Test
		public void testcase2() {
			logger = extent.createTest("Test2");
		
			hp.clickCars4SaleBtn();
			rp.clickOnCategoryBtn();
			rp.clickOnCategoryList();
		}
		
		@AfterMethod
		public void getResult(ITestResult result) throws IOException{
			if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed.", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Case Failed.", ExtentColor.RED));
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".jpeg";
			FileUtils.copyFile(src, new File(screenshotPath));
			logger.fail("Test Case is failed, Screenshot is attached. "+logger.addScreenCaptureFromPath(screenshotPath));
			
			}
			 else if(result.getStatus() == ITestResult.SKIP){
			 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "- Test Case is SKipped.", ExtentColor.ORANGE));
			 }
			 else if(result.getStatus() == ITestResult.SUCCESS){
				 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "- Test Case is Passed.", ExtentColor.GREEN));
				 }
			 if(driver!= null) {
				 driver.close();
			 }
			 }
			 
		
		@AfterClass
		public void teardown() {
			//endReport(){
				     extent.flush();
				    }
}
