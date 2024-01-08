package api.mahindra;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class AddUser extends Test_Config{
	
	@Test
	public void Test625_validateAddUser() {
		extentTest = extentReports.createTest("When Adding User without Authentication");
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		parameterValues.put("referenceCode", "");
		parameterValues.put("role", "");
		parameterValues.put("userName", "admin@admin.com");
		parameterValues.put("email", "Admin@123");
		parameterValues.put("firstName", "Admin@123");
		parameterValues.put("lastName", "admin@admin.com");
		parameterValues.put("password", "");
		parameterValues.put("language", "");
		parameterValues.put("phoneNumber", "");
		parameterValues.put("designation", "");
		parameterValues.put("reportingManagerCode", "");
		parameterValues.put("projectCoordinatorCode", "");
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "");
		parameterValues.put("state", "");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("tehsil", "");
		parameterValues.put("operatorType", "");
		parameterValues.put("status", "");
		
		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post("https://mahindraapi.antllp.com/api/v1.0/AddUser");
		
		response.then().statusCode(401);
				
		
		
	}
	
	@Test
	public void Test626_validateAddUser() {
		extentTest = extentReports.createTest("When Passing Blank Values to all Fields");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", null);
		parameterValues.put("role", null);
		parameterValues.put("userName", null);
		parameterValues.put("email", null);
		parameterValues.put("firstName", null);
		parameterValues.put("lastName", null);
		parameterValues.put("password", null);
		parameterValues.put("language", null);
		parameterValues.put("phoneNumber", null);
		parameterValues.put("designation", null);
		parameterValues.put("reportingManagerCode", null);
		parameterValues.put("projectCoordinatorCode", null);
		parameterValues.put("lockedOn", null);
		parameterValues.put("fulfilmentOfficerCode", null);
		parameterValues.put("state", null);
		parameterValues.put("startDate", null);
		parameterValues.put("tehsil", null);
		parameterValues.put("operatorType", null);
		parameterValues.put("status", null);
		String zone[]= {null};
		parameterValues.put("zone", zone);
		String territory[]= {null};
		parameterValues.put("territory", territory);
		String cluster[]= {null};
		parameterValues.put("cluster",cluster);
		String region[]= {null};
		parameterValues.put("region",region );
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(400);
		
	}
	
	@Test
	public void Test627_validateAddUser() {
		extentTest = extentReports.createTest("When Passing values to all field as null");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", "null");
		parameterValues.put("role", "null");
		parameterValues.put("userName", "null");
		parameterValues.put("email", "null");
		parameterValues.put("firstName", "null");
		parameterValues.put("lastName", "null");
		parameterValues.put("password", "null");
		parameterValues.put("language", "null");
		parameterValues.put("phoneNumber", "null");
		parameterValues.put("designation", "null");
		parameterValues.put("reportingManagerCode", "null");
		parameterValues.put("projectCoordinatorCode", "null");
		parameterValues.put("lockedOn", "null");
		parameterValues.put("fulfilmentOfficerCode", "null");
		parameterValues.put("state", "null");
		parameterValues.put("startDate", "null");
		parameterValues.put("tehsil", "null");
		parameterValues.put("operatorType", "null");
		parameterValues.put("status", "null");
		String zone[]= {"null","null"};
		parameterValues.put("zone", zone);
		String territory[]= {"null","null"};
		parameterValues.put("territory", territory);
		String cluster[]= {"null","null"};
		parameterValues.put("cluster",cluster);
		String region[]= {"null","null"};
		parameterValues.put("region",region );
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(400);
		
	}
	
	@Test
	public void Test628_validateAddUser() {
		extentTest = extentReports.createTest("When Passing Valid Values to all Fields");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", "null");
		parameterValues.put("role", "FDO");
		parameterValues.put("phoneNumber", ""+ setMobile());
		parameterValues.put("userName", setName());
		parameterValues.put("email", setEmail());
		parameterValues.put("firstName", "Test");
		parameterValues.put("lastName", "Test");
		parameterValues.put("password", "null");
		parameterValues.put("language", "Marathi");
		parameterValues.put("designation", "null");
		parameterValues.put("reportingManagerCode", "1");
		parameterValues.put("projectCoordinatorCode", "null");
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "1");
		parameterValues.put("state", "Maharashtra");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("district", "null");
		parameterValues.put("tehsil", "null");
		parameterValues.put("operatorType", "null");
		parameterValues.put("status", "Active");
		String zone[]= {"North"};
		parameterValues.put("zone", zone);
		String territory[]= {"T3"};
		parameterValues.put("territory", territory);
		String cluster[]= {"Aakash"};
		parameterValues.put("cluster",cluster);
		String region[]= {"R5"};
		parameterValues.put("region",region);
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(201)
		.body("role", equalTo("FDO"))
		.body("userName", equalTo(name))
		.body("email", equalTo(email))
		.body("zone", equalTo("North"))
		.body("territory", equalTo("T3"))
		.body("cluster", equalTo("Aakash"))
		.body("region", equalTo("R5"));
				
	}
	
	@Test
	public void Test629_validateAddUser() {
		extentTest = extentReports.createTest("When Passing phonenumber value more than 10 digit");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", "null");
		parameterValues.put("role", "FDO");
		parameterValues.put("phoneNumber", "+91"+ setMobile());
		parameterValues.put("userName", setName());
		parameterValues.put("email", setEmail());
		parameterValues.put("firstName", "Test");
		parameterValues.put("lastName", "Test");
		parameterValues.put("password", "null");
		parameterValues.put("language", "Marathi");
		parameterValues.put("designation", "null");
		parameterValues.put("reportingManagerCode", "1");
		parameterValues.put("projectCoordinatorCode", "null");
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "1");
		parameterValues.put("state", "Maharashtra");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("district", "null");
		parameterValues.put("tehsil", "null");
		parameterValues.put("operatorType", "null");
		parameterValues.put("status", "Active");
		String zone[]= {"North"};
		parameterValues.put("zone", zone);
		String territory[]= {"T3"};
		parameterValues.put("territory", territory);
		String cluster[]= {"Aakash"};
		parameterValues.put("cluster",cluster);
		String region[]= {"R5"};
		parameterValues.put("region",region );
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test630_validateAddUser() {
		extentTest = extentReports.createTest("When entered start date, end date, locked on date same");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", "null");
		parameterValues.put("role", "FDO");
		parameterValues.put("phoneNumber", ""+ setMobile());
		parameterValues.put("userName", setName());
		parameterValues.put("email", setEmail());
		parameterValues.put("firstName", "Test");
		parameterValues.put("lastName", "Test");
		parameterValues.put("password", "null");
		parameterValues.put("language", "Marathi");
		parameterValues.put("designation", "null");
		parameterValues.put("reportingManagerCode", "1");
		parameterValues.put("projectCoordinatorCode", "null");
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "1");
		parameterValues.put("state", "Maharashtra");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("endDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("district", "null");
		parameterValues.put("tehsil", "null");
		parameterValues.put("operatorType", "null");
		parameterValues.put("status", "Active");
		String zone[]= {"North"};
		parameterValues.put("zone", zone);
		String territory[]= {"T3"};
		parameterValues.put("territory", territory);
		String cluster[]= {"Aakash"};
		parameterValues.put("cluster",cluster);
		String region[]= {"R5"};
		parameterValues.put("region",region );
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test631_validateAddUser() {
		extentTest = extentReports.createTest("Adding user already exist");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", "null");
		parameterValues.put("role", "FDO");
		parameterValues.put("phoneNumber", "213212131221");
		parameterValues.put("userName", "Shahid");
		parameterValues.put("email", "shahid@gmail.com");
		parameterValues.put("firstName", "Test");
		parameterValues.put("lastName", "Test");
		parameterValues.put("password", "null");
		parameterValues.put("language", "Marathi");
		parameterValues.put("designation", "null");
		parameterValues.put("reportingManagerCode", "1");
		parameterValues.put("projectCoordinatorCode", "null");
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "1");
		parameterValues.put("state", "Maharashtra");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("endDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("district", "null");
		parameterValues.put("tehsil", "null");
		parameterValues.put("operatorType", "null");
		parameterValues.put("status", "Active");
		String zone[]= {"North"};
		parameterValues.put("zone", zone);
		String territory[]= {"T3"};
		parameterValues.put("territory", territory);
		String cluster[]= {"Aakash"};
		parameterValues.put("cluster",cluster);
		String region[]= {"R5"};
		parameterValues.put("region",region );
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test632_validateAddUser() {
		extentTest = extentReports.createTest("Adding other values for Language, Role, Zone, Territory, \nCluster, Region than preferred");
		apiURL = "https://mahindraapi.antllp.com/api/v1.0/AddUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("referenceCode", "null");
		parameterValues.put("language", "Test");
		String zone[]= {"Test"};
		parameterValues.put("zone", zone);
		String territory[]= {"Test"};
		parameterValues.put("territory", territory);
		String cluster[]= {"Test"};
		parameterValues.put("cluster",cluster);
		String region[]= {"Test"};
		parameterValues.put("region",region );
		parameterValues.put("role", "FDO");
		parameterValues.put("phoneNumber",""+ setMobile());
		parameterValues.put("userName", setName());
		parameterValues.put("email", setEmail());
		parameterValues.put("firstName", "Test");
		parameterValues.put("lastName", "Test");
		parameterValues.put("password", "null");
		parameterValues.put("designation", "null");
		parameterValues.put("reportingManagerCode", "1");
		parameterValues.put("projectCoordinatorCode", "null");
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "1");
		parameterValues.put("state", "Test");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("endDate", "2023-12-08T06:36:17.070Z");
		parameterValues.put("district", "null");
		parameterValues.put("tehsil", "null");
		parameterValues.put("operatorType", "null");
		parameterValues.put("status", "Active");
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
				.when()
				.post(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	

}
