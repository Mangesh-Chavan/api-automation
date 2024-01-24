package api.mahindra;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class AddUser extends Test_Config{
	
	private String id="4049504a-6ddf-4669-975a-b80573b3877f";

	@Test
	public void Test01_validateAddUser() {
		extentTest = extentReports.createTest("When Adding User without Authentication");
		apiURL="/AddUser";
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
				.post(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));
				
		
		
	}
	
	@Test
	public void Test02_validateAddUser() {
		extentTest = extentReports.createTest("When adding user with all null values");
		apiURL="/AddUser";
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
	public void Test03_validateAddUser() {
		extentTest = extentReports.createTest("When Passing invalid values to all field");
		apiURL="/AddUser";
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
		parameterValues.put("lockedOn", "2023-12-08T06:36:17.070Z");
		parameterValues.put("fulfilmentOfficerCode", "null");
		parameterValues.put("state", "null");
		parameterValues.put("startDate", "2023-12-08T06:36:17.070Z");
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
	public void Test04_validateAddUser() {
		extentTest = extentReports.createTest("When Passing Valid Values to all Fields");
		apiURL="/AddUser";
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
		
		id = response.jsonPath().getString("data.id");
		System.out.println(id);
		
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
	public void Test05_validateAddUser() {
		extentTest = extentReports.createTest("When Passing phonenumber value more than 10 digit");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("role", "FDO");
		parameterValues.put("phoneNumber", "91474932984329");
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
				.put(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test06_validateAddUser() {
		extentTest = extentReports.createTest("When entered start date, end date, locked on date same");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("role", "FDO");
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
				.put(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test07_validateAddUser() {
		extentTest = extentReports.createTest("Adding user already exist");
		apiURL="/AddUser";
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
	public void Test08_validateAddUser() {
		extentTest = extentReports.createTest("Adding other values for Language, Role, Zone, Territory, \nCluster, Region than preferred");
		apiURL = "/UpdateUser";
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
				.put(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	
	@Test
	public void Test09_validateAddUser() {
		extentTest = extentReports.createTest("Getting all user without authorisation");
		apiURL = "/GetAllUsers";
		HashMap parameterValues = new HashMap();
		parameterValues.put("userName", null);
		parameterValues.put("firstName", null);
		parameterValues.put("lastName", null);
		parameterValues.put("status", null);
		parameterValues.put("role", null);
		parameterValues.put("referenceCode", null);
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 100);
		
		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				.when().post(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));
				
	}
	
	@Test
	public void Test10_validateAddUser() {
		extentTest = extentReports.createTest("Getting all user with passing pageSize as 0");
		apiURL = "/GetAllUsers";
		HashMap parameterValues = new HashMap();
		parameterValues.put("userName", null);
		parameterValues.put("firstName", null);
		parameterValues.put("lastName", null);
		parameterValues.put("status", null);
		parameterValues.put("role", null);
		parameterValues.put("referenceCode", null);
		parameterValues.put("pageNumber", 0);
		parameterValues.put("pageSize", 0);
		
		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.body(parameterValues)
				
				.when().post(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test11_validateAddUser() {
		extentTest = extentReports.createTest("Getting all user with passing invalid data");
		apiURL = "/GetAllUsers";
		HashMap parameterValues = new HashMap();
		parameterValues.put("userName", "*@");
		parameterValues.put("firstName", null);
		parameterValues.put("lastName", null);
		parameterValues.put("status", null);
		parameterValues.put("role", null);
		parameterValues.put("referenceCode", null);
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 50);
		
		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.body(parameterValues)
				
				.when().post(apiURL);
		
		response.then().statusCode(404);
				
	}
	
	@Test
	public void Test12_validateAddUser() {
		extentTest = extentReports.createTest("Getting all user with passing valid data");
		apiURL = "/GetAllUsers";
		HashMap parameterValues = new HashMap();
		parameterValues.put("userName", null);
		parameterValues.put("firstName", null);
		parameterValues.put("lastName", null);
		parameterValues.put("status", null);
		parameterValues.put("role", null);
		parameterValues.put("referenceCode", null);
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 50);
		
		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.body(parameterValues)
				
				.when().post(apiURL);
		
		response.then().statusCode(200);
				
	}
	
	@Test
	public void Test13_validateAddUser(){
		extentTest = extentReports.createTest("Enter id and execute without authorization");
		apiURL="/GetUserById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		
		response = RestAssured.given()
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));

	}
	
	@Test
	public void Test14_validateAddUser(){
		extentTest = extentReports.createTest("Enter invalid id and execute with authorization");
		apiURL="/GetUserById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", "1c33b9d1-fba1-4118-a129-8da9010e14d2");
		
		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(404);

	}
	
	@Test
	public void Test15_validateAddUser(){
		extentTest = extentReports.createTest("Enter idas null and execute with authorization");
		apiURL="/GetUserById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", null);
		
		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(400);

	}
	
	@Test
	public void Test16_validateAddUser(){
		extentTest = extentReports.createTest("Enter id as null and execute with authorization");
		apiURL="/GetUserById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		
		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(200);

	}
	
	@Test
	public void Test17_validateAddUser() {
		extentTest = extentReports.createTest("Update user will passing null inputs");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
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
		response = RestAssured.given()
				.contentType("application/json")
				.formParams(parameterValues)
				
				
				.when()
				.put(apiURL);
		
		response.then().statusCode(400);
				
	}
	
	@Test
	public void Test18_validateAddUser() {
		extentTest = extentReports.createTest("Update user without authorization");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("role", "NH");
		response = RestAssured.given()//.header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
				.when()
				.put(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));
				
	}
	
	@Test
	public void Test19_validateAddUser() {
		extentTest = extentReports.createTest("Update user with invalid value");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", "bd2db13e-062d-413f-aeb7-ae80da90b0df");
		parameterValues.put("role", "Doctor");
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
				.when()
				.put(apiURL);
		
		response.then().statusCode(404);
				
	}
	
	@Test
	public void Test20_validateAddUser() {
		extentTest = extentReports.createTest("Update user with valid value");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("role", "NH");
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
				.when()
				.put(apiURL);
		
		response.then().statusCode(200);
				
	}
	
	@Test
	public void Test21_validateAddUser() {
		extentTest = extentReports.createTest("When deleted with id passing as null");
		apiURL="/DeleteUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", null);

		response = RestAssured.given()
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test22_validateAddUser() {
		extentTest = extentReports.createTest("When deleted without authorization");
		apiURL="/DeleteUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test23_validateAddUser() {
		extentTest = extentReports.createTest("When deleted with invalid data and authorization");
		apiURL="/DeleteUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", "bd2db13e-062d-413f-aeb7-ae80da90b0df");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(404);
	}
	
	@Test
	public void Test24_validateAddUser() {
		extentTest = extentReports.createTest("When deleted with valid data and authorization");
		apiURL="/DeleteUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test25_validateAddUser() {
		extentTest = extentReports.createTest("Update user for deleted record");
		apiURL="/UpdateUser";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("role", "RH");
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues).header("Authorization","Bearer "+ accessToken)
				
				
				.when()
				.put(apiURL);
		
		response.then().statusCode(204);
				
	}
	
	@Test
	public void Test26_validateAddUser() {
		extentTest = extentReports.createTest("Get all Financial Years without authorization");
		apiURL="/GetAllFYForDropDown";
		
		response = RestAssured.given()
					
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test27_validateAddUser() {
		extentTest = extentReports.createTest("Get all Financial Years with authorization");
		apiURL="/GetAllFYForDropDown";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
					
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test28_validateAddUser() {
		extentTest = extentReports.createTest("Get all Financial Years without authorization");
		apiURL="/GetRoleBasedDropDowns";
		
		response = RestAssured.given()
				.param("roleName", "FDO")	
					
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test29_validateAddUser() {
		extentTest = extentReports.createTest("Get all Financial Years with authorization");
		apiURL="/GetRoleBasedDropDowns";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.param("roleName", "FDO")	
					
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test30_validateAddUser() {
		extentTest = extentReports.createTest("Get all Financial Years without authorization");
		apiURL="/GetUserConstants";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test31_validateAddUser() {
		extentTest = extentReports.createTest("Get all Financial Years with authorization");
		apiURL="/GetUserConstants";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}

}
