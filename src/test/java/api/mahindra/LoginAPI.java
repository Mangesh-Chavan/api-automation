package api.mahindra;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class LoginAPI extends Test_Config{
	

	@Test
	public void Test10_ValidateWebsite() {
		extentTest = extentReports.createTest("Validate Server Avaibility");
		apiURL="https://mahindraapi.antllp.com/";
		response =RestAssured
		.when().get(apiURL);
		
		response.then().statusCode(200);
		
	}
	
	@Test
	public void Test11_InvalidLogin() {
		extentTest = extentReports.createTest("When Passing Inputs as Null");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/Login";
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
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test12_InvalidLogin1() {
		extentTest = extentReports.createTest("Enter valid email and blank pwd");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/Login";
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("userName", "admin@admin.com");
		parameterValues.put("password", null);
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test13_InvalidLogin() {
		extentTest = extentReports.createTest("Enter blank email and valid pwd");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/Login";
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
//		parameterValues.put("grant_type", "password");
//		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("userName", null);
		parameterValues.put("password", "Admin@123");
//		parameterValues.put("scope", "ANT_HRMS");
		
		response = RestAssured.given()
//				.contentType(ContentType.URLENC)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test14_InvalidLogin() {
		extentTest = extentReports.createTest("Invalid email and valid password");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/Login";
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
				.post(apiURL);
		
		response.then()
		.statusCode(404);
	}
	
	
	@Test
	public void Test15_InvalidLogin() {
		extentTest = extentReports.createTest("Valid email id & invalid pwd");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/Login";
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
				.post(apiURL);
		
		response.then()
		.statusCode(404);
	}
	
	@Test
	public void Test16_validLogin() {
		extentTest = extentReports.createTest("valid email id & valid pwd");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/Login";
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("userName", "admin@admin.com");
		parameterValues.put("password", "Admin@123");

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(200)
		.extract()
        .response();

		accessToken = response.jsonPath().getString("token");
	}
	

}
