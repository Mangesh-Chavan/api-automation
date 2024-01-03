package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Designation extends Test_Config{
		
	String id="";
	
	@Test(priority = 1)
	public void getDesignation() {
		extentTest = extentReports.createTest("List Designation API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/designation")
		
		.then().statusCode(200).log().body();
	}

	@Test(priority = 2)
	public void postDesignation() {
		extentTest = extentReports.createTest("Add New Designation Data API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("name", "Tester");
		Response responce = RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		
		.when().post("https://hrmsxapi.antllp.com/api/app/designation")
		
		.then().statusCode(200).body("designation", equalTo("Tester")).extract().response();
		
		id = responce.jsonPath().getString("id");
	}
	
	@Test(priority = 3)
	public void putDesignation() {
		extentTest = extentReports.createTest("Change Designation Name API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("name", "Software Tester");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/designation/"+id)
		
		.then().statusCode(200);
	}
	
	@Test(priority = 4)
	public void deleteDesignation() {
		extentTest = extentReports.createTest("Delete designation Data API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/designation/"+id)
		
		.then().statusCode(204);
	}
	
	@Test(priority = 5)
	public void getdesignationInfo() {
		extentTest = extentReports.createTest("Get designation API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/designation/"+id)
		
		.then().statusCode(404).log().body();
	}
}
