package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class Attendance extends Test_Config {
	
	String role = User_Screen.role;
	
	@Test
	public void getAttendance() {
		extentTest = extentReports.createTest("Attendace Till Date API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		.when().get("https://hrmsxapi.antllp.com/api/app/user-attendance")
		.then().statusCode(200).log().body();
	}
	
	@Test
	public void sendAttendance() {
		extentTest = extentReports.createTest("Send Attendance reqularize request user");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("attendanceDate", "2023-07-07T06:33:27.870Z");
		parameterValues.put("checkIn", "09:00 AM");
		parameterValues.put("checkOut", "06:30 PM");
		parameterValues.put("workingHours", "09:30");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
		.when().post("https://hrmsxapi.antllp.com/api/app/user-attendance-request/send-attendance-request")
		.then().statusCode(200).body("message", equalTo("Success"));
	} 
	
	@Test
	public void allemploysregularizationrequest()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("all employs regularization request");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
			.when().get("https://hrmsxapi.antllp.com/api/app/user-attendance-request/employee-attendance-request-list")
			.then().statusCode(200).body("message", equalTo("Success"));
	}
	
	@Test
	public void markattendancebyhr()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("mark attendance by hr");
			HashMap<String, String> parameterValues = new HashMap<String,String>();
			parameterValues.put("attendanceDate", "2023-07-10T06:33:27.870Z");
			parameterValues.put("checkIn", "09:00 AM");
			parameterValues.put("checkOut", "06:30 PM");
			parameterValues.put("workingHours", "09:30");
			parameterValues.put("userId", "7b546d58-b6ab-a1e7-0456-3a0bfa9b65ec");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
			.when().post("https://hrmsxapi.antllp.com/api/app/user-attendance-request/employee-attendance-request-list")
			.then().statusCode(200).body("message", equalTo("Success"));
	}
	
	@Test
	public void markattendancethroughfile()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("mark attendance through file");
			File file = new File(System.getProperty("user.dir")+"./UserAttendanceDownloadTemplate.xlsx");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).multiPart("UploadFile",file).contentType("multipart/form-data")
			.when().post("https://hrmsxapi.antllp.com/api/app/user-attendance/upload-emp-attendance-excel")
			.then().statusCode(200).body("message", equalTo("Success"));
	}
	
	@Test
	public void ActionOnAttendanceRequest()
	{
		if(role.equals("admin"))
			extentTest = extentReports.createTest("Action On Attendance Request");
			HashMap<String, String> parameterValues = new HashMap<String,String>();
			parameterValues.put("attReqRecordId", "d8b9713e-c3bc-6fcd-00e2-3a0c51700761");
			parameterValues.put("status", "approve");
			RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken).body(parameterValues)
			.when().post("https://hrmsxapi.antllp.com/api/app/user-attendance-request/action-on-employee-attendance-request")
			.then().statusCode(200).body("message", equalTo("Success"));
	}

}
