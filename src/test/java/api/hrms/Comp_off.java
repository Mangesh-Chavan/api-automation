package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class Comp_off extends Test_Config{

	@Test
	public void requestCompoff()
	{
		extentTest = extentReports.createTest("Request Compoff for Current User API");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("workingDate", "2023-07-09T09:19:13.515Z");
		parameterValues.put("reason", "Test");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		.when().post("https://hrmsxapi.antllp.com/api/app/request-comp-off/request-comp-off")
		.then().statusCode(200).body("message", equalTo("Success !"));
	}
}
