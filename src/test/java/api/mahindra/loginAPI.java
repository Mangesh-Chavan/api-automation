package api.mahindra;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class loginAPI extends Test_Config{
	

	@Test
	public void Test10_ValidateWebsite() {
		extentTest = extentReports.createTest("Validate Server Avaibility");
		response =RestAssured
		.when().get("https://mahindraapi.antllp.com/");
		
		response.then().statusCode(200);
		
	}
	
	@Test
	public void Test11_InvalidLogin() {
		extentTest = extentReports.createTest("When Passing Inputs as Null");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
//		parameterValues.put("grant_type", "password");
//		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("userName", "");
		parameterValues.put("password", "");
//		parameterValues.put("scope", "ANT_HRMS");
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/Login");
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test12_InvalidLogin1() {
		extentTest = extentReports.createTest("Enter valid email and blank pwd");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
//		parameterValues.put("grant_type", "password");
//		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("userName", "admin@admin.com");
		parameterValues.put("password", "");
//		parameterValues.put("scope", "ANT_HRMS");
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/Login");
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test13_InvalidLogin() {
		extentTest = extentReports.createTest("Enter blank email and valid pwd");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
//		parameterValues.put("grant_type", "password");
//		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("userName", "");
		parameterValues.put("password", "Admin@123");
//		parameterValues.put("scope", "ANT_HRMS");
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/Login");
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test14_InvalidLogin() {
		extentTest = extentReports.createTest("Invalid email and valid pwd");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
//		parameterValues.put("grant_type", "password");
//		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("userName", "navin@admin.com");
		parameterValues.put("password", "Admin@123");
//		parameterValues.put("scope", "ANT_HRMS");
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/Login");
		
		response.then()
		.statusCode(400);
	}
	
	
	@Test
	public void Test15_InvalidLogin() {
		extentTest = extentReports.createTest("Valid email id & invalid pwd");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
//		parameterValues.put("grant_type", "password");
//		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("userName", "admin@admin.com");
		parameterValues.put("password", "Admin@124");
//		parameterValues.put("scope", "ANT_HRMS");
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/Login");
		
		response.then()
		.statusCode(400);
	}
	
	@BeforeMethod
	public void Test16_validLogin() {
		extentTest = extentReports.createTest("valid email id & valid pwd");
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
	

}
