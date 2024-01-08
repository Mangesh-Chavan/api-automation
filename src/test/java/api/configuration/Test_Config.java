package api.configuration;

import java.io.IOException;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.response.Response;

public class Test_Config {
	
public static ExtentReports extentReports;
	
	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentTest extentTest;
	
	public static Response response;
	
	public static String apiURL;
	
	public static String accessToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImFkbWluQGFkbWluLmNvbSIsInVuaXF1ZV9uYW1lIjoiNjlhZTM5NmMtOTg2NS00OTllLTllZmQtODJkM2JmMTNjZjlhIiwiYWN0b3J0IjoiMCIsIm5iZiI6MTcwNDY5NTc2OSwiZXhwIjoxNzA1OTkxNzY5LCJpYXQiOjE3MDQ2OTU3NjksImlzcyI6Imh0dHA6Ly93d3cuc2VjdXJpdHkub3JnIiwiYXVkIjoiaHR0cDovL3d3dy5zZWN1cml0eS5vcmcifQ.FSl2pqc7X0GfMBIWHgkAL66PUMyHycIT_mlzA4OVhOk";
	
	public static String email;
	
	public static long mobile;
	
	public static String name;
	
	public static String setEmail() {
		email = name + "@yopmail.com";
		return email;
	}
	
	public static String setName() {
		Random random = new Random();
		
		name = "Test"+ random.nextInt(99);
		return name;
	}
	
	public static long setMobile() {
		Random random = new Random();
        long min = 1000000000L; // Minimum value for a 10-digit number
        long max = 9999999999L; // Maximum value for a 10-digit number
        mobile = random.longs(min, max + 1).findFirst().getAsLong();
        return mobile;
	}
	
	
	
	@BeforeTest
	public void init() {
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"./reports/report.html");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("MyReport");
		extentReports.attachReporter(extentSparkReporter);
	}
	
	@AfterMethod
	public void teardown(ITestResult result, ITestContext context) throws IOException {
		extentTest.assignCategory(result.getTestClass().getName());
		if(result.getStatus()== ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, result.getName() + " Failed");// to add name in report
			extentTest.info(result.getThrowable().getLocalizedMessage());// to add responce in repor
			extentTest.info("URL is " + apiURL);
			extentTest.info("Status Code is " + response.then().extract().response().getStatusCode());
			extentTest.info(MarkupHelper.createCodeBlock(response.then().extract().asString(),CodeLanguage.JSON));
		}
		else if(result.getStatus()== ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, result.getName() + " Skipped");
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS, result.getName() + " Passed");
//			String jsonData = response.then().extract().jsonPath().toString();
//			extentTest.info(response.then().extract().response().getContentType());
			extentTest.info("URL is " + apiURL);
			extentTest.info("Status Code is " + response.then().extract().response().getStatusCode());
			extentTest.info(MarkupHelper.createCodeBlock(response.then().extract().asString(),CodeLanguage.JSON));
			
		}
	}
	
	@AfterTest
	public void destroy() {
		extentReports.flush();
	}

}
