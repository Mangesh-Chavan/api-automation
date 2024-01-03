package api.configuration;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.response.Response;

public class Test_Config {
	
public static ExtentReports extentReports;
	
	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentTest extentTest;
	
	@BeforeTest
	public void init() {
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"./reports/report.html");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("MyReport");
		extentReports.attachReporter(extentSparkReporter);
	}
	
	@AfterMethod
	public void teardown(ITestResult result, Response response) throws IOException {
		extentTest.assignCategory(result.getTestClass().getName());
		if(result.getStatus()== ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, result.getName() + " Failed");// to add name in report
			extentTest.info(result.getThrowable().getLocalizedMessage());// to add responce in repor
			
		}
		else if(result.getStatus()== ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, result.getName() + " Skipped");
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS, result.getName() + " Passed");
			//extentTest.log(Status.PASS, (Media) result);
			extentTest.info(response.getBody().toString());
			
			
		}
	}
	
	@AfterTest
	public void destroy() {
		extentReports.flush();
	}

}
