package api.configuration;

import java.io.IOException;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Config {
	
public static ExtentReports extentReports;
	
	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentTest extentTest;
	
	public static Response response;
	
	public static String accessToken;
	
	@BeforeTest
	public void init() {
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"./reports/report.html");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("MyReport");
		extentReports.attachReporter(extentSparkReporter);
	}
	
	@BeforeMethod
	public void Test16_validLogin() {
		//extentTest = extentReports.createTest("valid email id & valid pwd");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("userName", "admin@admin.com");
		parameterValues.put("password", "Admin@123");

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/Login");
		
		response.then()
		.statusCode(200)
		.extract()
        .response();

		accessToken = response.jsonPath().getString("access_token");
	}
	
	@AfterMethod
	public void teardown(ITestResult result, ITestContext context) throws IOException {
		extentTest.assignCategory(result.getTestClass().getName());
		if(result.getStatus()== ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, result.getName() + " Failed");// to add name in report
			extentTest.info(result.getThrowable().getLocalizedMessage());// to add responce in repor
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
			extentTest.info("Status Code is " + response.then().extract().response().getStatusCode());
			extentTest.info(MarkupHelper.createCodeBlock(response.then().extract().asString(),CodeLanguage.JSON));
			
		}
	}
	
	@AfterTest
	public void destroy() {
		extentReports.flush();
	}

}
