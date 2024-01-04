package api.hrms;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_Screen extends Test_Config{
	
	public static String accessToken = "";
	public static String role;

	@Test(priority = 1)
	public void getHomePage() {
		extentTest = extentReports.createTest("Home Page API");
		RestAssured.given()
		
		.when().get("https://hrmsxapi.antllp.com")
		
		.then().statusCode(200);
	}
	
	@Test(priority = 2)
	public void getToken() {
		extentTest = extentReports.createTest("Login Page API");
		
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
		parameterValues.put("grant_type", "password");
		parameterValues.put("client_id", "ANT_HRMS_App");
		parameterValues.put("username", "admin");
		parameterValues.put("password", "1q2w3E*");
		parameterValues.put("scope", "ANT_HRMS");
		
		Response response = RestAssured.given()
				.contentType(ContentType.URLENC)
				.contentType("application/x-www-form-urlencoded")
				.formParams(parameterValues)
				
				
			.when()
				.post("https://hrmsxapi.antllp.com/connect/token")
				
			.then()
				.statusCode(400)
				.extract()
	            .response();
		
		accessToken = response.jsonPath().getString("access_token");
	}
	
	@Test
	public void getUserScreen() {
		extentTest = extentReports.createTest("Logged User API");
		Response response = RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/user-detail/log-in-user-role")
		
		.then().statusCode(200).extract().response();//.body("role", equalTo("admin"));
		
		role = response.jsonPath().getString("role");
	
		
		
	}
}
