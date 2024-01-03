package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class Punch_In_Punch_Out extends Test_Config{
	
	@Test
	public void CreatePunchIn()
	{
		extentTest = extentReports.createTest("Puch In API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("inorOutFlag", "in");
		parameterValues.put("attendanceDate", "2023-07-11T10:49:13.947Z");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		.when().post("https://hrmsxapi.antllp.com/api/app/user-attendance/puch-in-punch-out-time")
		.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void CreatePunchOut()
	{
		extentTest = extentReports.createTest("Puch Out API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("inorOutFlag", "out");
		parameterValues.put("attendanceDate", "2023-07-11T18:00:13.947Z");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		.when().post("https://hrmsxapi.antllp.com/api/app/user-attendance/puch-in-punch-out-time")
		.then().statusCode(200).body("message", equalTo("Success !"));
	}


}
