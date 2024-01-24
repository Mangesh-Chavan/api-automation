package api.mahindra;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class UDC extends Test_Config{
	
	public String id="7f995df1-b638-440f-b661-caa98af2ccc3";
	
	
	@Test
	public void Test01_validateUDCData() {
		extentTest = extentReports.createTest("When enter data without authorisation");
		apiURL="/AddUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "District");
		parameterValues.put("value01", "Test");
		parameterValues.put("parentId", "a145e92a-e7b3-432a-97be-4512ea43099f");
		parameterValues.put("status", "Active");

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test02_validateUDCData() {
		extentTest = extentReports.createTest("When enter null value and execute ");
		apiURL="/AddUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", null);
		parameterValues.put("value01", null);
		parameterValues.put("parentId", null);
		parameterValues.put("status", null);

		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test03_validateUDCData() {
		extentTest = extentReports.createTest("When enter invalid data with authorisation");
		apiURL="/AddUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "Test");
		parameterValues.put("value01", "Test");
		parameterValues.put("parentId", "a145e92a-e7b3-432a-97be-4512ea43099f");
		parameterValues.put("status", "Active");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test04_validateUDCData() {
		extentTest = extentReports.createTest("when enter valid data with authorization");
		apiURL="/AddUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "District");
		parameterValues.put("value01", setName());
		parameterValues.put("parentId", "a145e92a-e7b3-432a-97be-4512ea43099f");
		parameterValues.put("status", "Active");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		id = response.jsonPath().getString("data.id");
		System.out.println(id);
		
		response.then()
		.statusCode(201);
		
		
	}
	
	@Test
	public void Test05_validateUDCData() {
		extentTest = extentReports.createTest("Update value and execute without authorisation");
		apiURL="/UpdateUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("value01","Test");
		parameterValues.put("id", id);
		parameterValues.put("status", "Active");

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
		
	}
	
	@Test
	public void Test06_validateUDCData() {
		extentTest = extentReports.createTest("Update null value with authorization");
		apiURL="/UpdateUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", null);
		parameterValues.put("value01", null);
		parameterValues.put("parentId", null);
		parameterValues.put("status", null);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(400);
	}

	@Test
	public void Test07_validateUDCData() {
		extentTest = extentReports.createTest("Update value with authorization");
		apiURL="/UpdateUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "District");
		parameterValues.put("value01","Test");
		parameterValues.put("id", id);
		parameterValues.put("status", "Active");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(201);
	}
	
	@Test
	public void Test08_validateUDCData() {
		extentTest = extentReports.createTest("Update data with invalid Id");
		apiURL="/UpdateUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "Test");
		parameterValues.put("value01","Test");
		parameterValues.put("id", "bd2db13e-062d-413f-aeb7-ae80da90b0df");
		parameterValues.put("status", "Active");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(404);
	}
	
	@Test
	public void Test09_validateUDCData() {
		extentTest = extentReports.createTest("When get record without authorization");
		apiURL="/GetUDCById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()//.header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
		
	}
	
	@Test
	public void Test10_validateUDCData() {
		extentTest = extentReports.createTest("When get record with authorization");
		apiURL="/GetUDCById";
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
	public void Test11_validateUDCData() {
		extentTest = extentReports.createTest("When deleted without authorization");
		apiURL="/DeleteUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()
				.contentType("application/json")
				.params(parameterValues)
				
				
			.when()
				.delete(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test12_validateUDCData() {
		extentTest = extentReports.createTest("When deleted with authorization");
		apiURL="/DeleteUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.params(parameterValues)
				
				
			.when()
				.delete(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test13_validateUDCData() {
		extentTest = extentReports.createTest("When enter data without authorisation");
		apiURL="/GetUDCList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "District");
		parameterValues.put("value01", null);
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 50);

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test14_validateUDCData() {
		extentTest = extentReports.createTest("When enter null value and execute ");
		apiURL="/GetUDCList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", null);
		parameterValues.put("value01", null);
		parameterValues.put("pageNumber", null);
		parameterValues.put("pageSize", null);

		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test15_validateUDCData() {
		extentTest = extentReports.createTest("When enter data invalid with authorisation");
		apiURL="/GetUDCList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "Test");
		parameterValues.put("value01", "Test");
		parameterValues.put("pageNumber", 0);
		parameterValues.put("pageSize", 50);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test16_validateUDCData() {
		extentTest = extentReports.createTest("when enter valid data with authorization");
		apiURL="/GetUDCList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "District");
		parameterValues.put("value01", "Test");
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 50);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(201);
	}
	
	
	@Test
	public void Test17_validateUDCData() {
		extentTest = extentReports.createTest("Get all Cluster data without authorization");
		apiURL="/GetAllCluster";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test18_validateUDCData() {
		extentTest = extentReports.createTest("Get all Cluster data with Authorization");
		apiURL="/GetAllCluster";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	@Test
	public void Test19_validateUDCData() {
		extentTest = extentReports.createTest("Get all Zone data without Authorization");
		apiURL="/GetALLZone";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test20_validateUDCData() {
		extentTest = extentReports.createTest("Get all Zone data with authorization");
		apiURL="/GetALLZone";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	@Test
	public void Test21_validateUDCData() {
		extentTest = extentReports.createTest("Get all Region without authorization");
		apiURL="/GetAllRegion";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test22_validateUDCData() {
		extentTest = extentReports.createTest("Get all Region with authorization");
		apiURL="/GetAllRegion";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	@Test
	public void Test23_validateUDCData() {
		extentTest = extentReports.createTest("Get all Territories data without authorization");
		apiURL="/GetAllTerritories";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test24_validateUDCData() {
		extentTest = extentReports.createTest("Get all Territories data with authorization");
		apiURL="/GetAllTerritories";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	@Test
	public void Test25_validateUDCData() {
		extentTest = extentReports.createTest("Get all Financial Years without authorization");
		apiURL="/GetALLFy";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test26_validateUDCData() {
		extentTest = extentReports.createTest("Get all Financial Years with authorization");
		apiURL="/GetALLFy";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test27_validateUDCData() {
		extentTest = extentReports.createTest("Get Time Slot Data without authorization");
		apiURL="/GetTimeSlot";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test28_validateUDCData() {
		extentTest = extentReports.createTest("Get Time Slot Data with authorization");
		apiURL="/GetTimeSlot";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test29_validateUDCData() {
		extentTest = extentReports.createTest("Get all Dropdowns without authorization");
		apiURL="/GetAllDropdown";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test30_validateUDCDATA() {
		extentTest = extentReports.createTest("Get all Dropdowns with authorization");
		apiURL="/GetAllDropdown";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test31_validateUDCData() {
		extentTest = extentReports.createTest("Update data for deleted record");
		apiURL="/UpdateUDC";
		HashMap parameterValues = new HashMap();
		parameterValues.put("constKey", "District");
		parameterValues.put("value01","DeletedRecord");
		parameterValues.put("id", id);
		parameterValues.put("status", "Active");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then().statusCode(204);
				
	}

}
