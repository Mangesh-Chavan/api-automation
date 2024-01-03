package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class LMS extends Test_Config {
	
	String role = User_Screen.role;
	
	//@Test
	public void Leaves_for_current_user()
	{
		extentTest = extentReports.createTest("Leaves for current user");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().get("https://hrmsxapi.antllp.com/api/app/leave")
		.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void requestLeave()
	{
		extentTest = extentReports.createTest("Leave Application for Current User");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("leaveTypeId", "3fa85f64-5717-4562-b3fc-2c963f66afa6");
		parameterValues.put("fromDate", "2023-08-02T07:16:49.519Z");
		parameterValues.put("toDate", "2023-08-02T07:16:49.519Z");
		parameterValues.put("reason", "Test");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		.when().post("https://hrmsxapi.antllp.com/api/app/leave/leave-request")
		.then().statusCode(200).log().body();
	}
	
	@Test
	public void List_of_applied_leave()
	{
		extentTest = extentReports.createTest("Leaves for current user");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().get("https://hrmsxapi.antllp.com/api/app/leave/leaves-for-current-user")
		.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void List_of_Leave_for_All_Users()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("List of Leave for All Users");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
			.when().get("https://hrmsxapi.antllp.com/api/app/leave/leaves-for-all-users")
			.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void AddAssignCompOff()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("Add Assign CompOff API");
			HashMap<String, String> parameterValues = new HashMap<String,String>();
			parameterValues.put("workingDate", "2023-08-15T09:19:13.515Z");
			parameterValues.put("reason", "Test");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
			.when().get("https://hrmsxapi.antllp.com/api/app/comp-off")
			.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void EmployeeCompOffRequestList()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("Employee CompOff Request List API");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
			.when().get("https://hrmsxapi.antllp.com/api/app/request-comp-off/comp-off-requestlist-for-all-users")
			.then().statusCode(200).body("message", equalTo("Success !"));
	}
	
	@Test
	public void InNext7daysApproved()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("In Next 7 days Approved API");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
			.when().get("https://hrmsxapi.antllp.com/api/app/leave/on-leave-in-next-seven-days")
			.then().statusCode(200).body("message", equalTo("Success"));
	}
}
