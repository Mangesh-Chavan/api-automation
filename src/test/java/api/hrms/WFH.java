package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class WFH extends Test_Config{
	
	public String role = User_Screen.role;

	@Test
	public void AddAssignWorkFromHome()
	{
		if(role .equals("admin"))
			extentTest = extentReports.createTest("Add Assign WorkFrom Home");
			HashMap<String, String> parameterValues = new HashMap<String,String>();
			parameterValues.put("userId", "7b546d58-b6ab-a1e7-0456-3a0bfa9b65ec");
			parameterValues.put("workFromHomeCount", "4");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
			.when().get("https://hrmsxapi.antllp.com/api/app/work-from-home/work-from-home-for-user")
			.then().statusCode(200).log().body();
	}
	
	@Test
	public void WFHforAllUsers()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("WFH for All Users");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
			.when().get("https://hrmsxapi.antllp.com/api/app/work-from-home/work-from-home-requestlist-for-all-users")
			.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void EditWFHCount()
	{
		if(role .equals("admin"))
			extentTest = extentReports.createTest("Add Assign WorkFrom Home");
			HashMap<String, String> parameterValues = new HashMap<String,String>();
			parameterValues.put("userId", "7b546d58-b6ab-a1e7-0456-3a0bfa9b65ec");
			parameterValues.put("workFromHomeCount", "4");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
			.when().get("https://hrmsxapi.antllp.com/api/app/work-from-home/work-from-home-edit-count")
			.then().statusCode(200).log().body();
	}

}
