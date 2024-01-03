package api.hrms;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class Dashboard extends Test_Config{
	
	@Test
	public void getLeaveCount() {
		extentTest = extentReports.createTest("Leave Count API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/leave/total-leave-count-for-current-user")
		
		.then().statusCode(200).body("message", equalTo("Success"));
		
		
	}
	
	@Test
	public void getUpcominHolidays() {
		extentTest = extentReports.createTest("Upcoming Holidays API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/holiday/up-comming-holidays")
		
		.then().statusCode(200).body("message", equalTo("Success"));
		
		
	}
	
	@Test
	public void getTodaysBirthday() {
		extentTest = extentReports.createTest("Todays Birthday API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/user-detail/todays-birthday")
		
		.then().statusCode(200).body("message", equalTo("Success"));
		
		
	}
	
	@Test
	public void getLeavesOnToday() {
		extentTest = extentReports.createTest("Todays Applied Leave API");
		RestAssured.given().header("Authorization","Bearer "+ User_Screen.accessToken)
		
		.when().get("https://hrmsxapi.antllp.com/api/app/leave/who-is-on-leavetoday")
		
		.then().statusCode(200).body("message", equalTo("Success"));
		
		
	}

}
