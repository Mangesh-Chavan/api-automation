package api.hrms;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Department extends Test_Config{
	
	String id="";
	
	@Test(priority = 1)
	public void getDepartment() {
		extentTest = extentReports.createTest("List Department API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/department")
		
		.then().statusCode(200).log().body();
	}

	@Test(priority = 2)
	public void postDepartment() {
		extentTest = extentReports.createTest("Add New Department Data API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("name", "Admin");
		Response responce = RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		
		.when().post("https://hrmsxapi.antllp.com/api/app/department")
		
		.then().statusCode(200).extract().response();
		
		id = responce.jsonPath().getString("id");
	}
	
	@Test(priority = 3)
	public void putDepartment() {
		extentTest = extentReports.createTest("Change Department Name API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("name", "Adminitrator");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/department/"+id)
		
		.then().statusCode(200);
	}
	
	@Test(priority = 4)
	public void deleteDepartment() {
		extentTest = extentReports.createTest("Delete Department Data API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/department/"+id)
		
		.then().statusCode(204);
	}
	
	@Test(priority = 5)
	public void getDepartmentInfo() {
		extentTest = extentReports.createTest("Get Department API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/department/"+id)
		
		.then().statusCode(404).log().body();
	}

}
