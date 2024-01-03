package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class Employee extends Test_Config{

	@Test
	public void EmployeeGetList() {
		extentTest = extentReports.createTest("Employee Get List");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().get("https://hrmsxapi.antllp.com/api/app/user-detail/employee-list")
		.then().statusCode(200).body("message", equalTo("Success"));
	}
	
	@Test
	public void GetIDwiserecord() {
		extentTest = extentReports.createTest("Get ID wise record");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().get("https://hrmsxapi.antllp.com/api/app/user-detail/f5a0f0a0-2899-697c-0dd2-3a0c36bb8e22/user-details")
		.then().statusCode(200).log().body();
	}
	
	@Test
	public void EditEmployee() {
		extentTest = extentReports.createTest("Edit Employee");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().put("https://hrmsxapi.antllp.com/api/app/user-detail/edit-user-details-by-id/f5a0f0a0-2899-697c-0dd2-3a0c36bb8e22")
		.then().statusCode(200).log().body();
	}
	
	@Test
	public void AddEmployee() {
		extentTest = extentReports.createTest("Add Employee");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().post("https://hrmsxapi.antllp.com/api/app/user-detail")
		.then().statusCode(200).log().body();
	}
	
}
