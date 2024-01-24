package api.mahindra;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.time.LocalDate;
import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class DealerAPI extends Test_Config{
	
	public String id="146471cb-401b-41b9-8feb-b905a8ddb844";
	
	@Test
	public void Test01_validateDealerData() {
		extentTest = extentReports.createTest("When enter data without authorisation");
		apiURL="/AddDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", "Test");
		parameterValues.put("name", "Test");
		parameterValues.put("state", "Maha");
		parameterValues.put("district", "Th");
		parameterValues.put("tehsil", "Th");
		parameterValues.put("village", "KK");
		parameterValues.put("pincode", "400709");
		parameterValues.put("territory", "T2");
		parameterValues.put("region", "R1");
		parameterValues.put("zone", "North");
		parameterValues.put("cluster", "Akash");
		parameterValues.put("isActive", true);
		parameterValues.put("startDate", "Test");
		parameterValues.put("endDate", "Test");

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
	public void Test02_validateDealerData() {
		extentTest = extentReports.createTest("When enter null value and execute ");
		apiURL="/AddDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", null);
		parameterValues.put("name", null);
		parameterValues.put("state", null);
		parameterValues.put("district", null);
		parameterValues.put("tehsil", null);
		parameterValues.put("village", null);
		parameterValues.put("pincode", null);
		parameterValues.put("territory", null);
		parameterValues.put("region", null);
		parameterValues.put("zone", null);
		parameterValues.put("cluster", null);
		parameterValues.put("isActive", null);
		parameterValues.put("startDate", null);
		parameterValues.put("endDate", null);

		response = RestAssured.given()
				.contentType("application/json").header("Authorization","Bearer "+ accessToken)
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test03_validateDealerData() {
		extentTest = extentReports.createTest("When enter invalid data with authorisation");
		apiURL="/AddDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", setName());
		parameterValues.put("name", "PQR");
		parameterValues.put("state", "Mh");
		parameterValues.put("district", "Th");
		parameterValues.put("tehsil", "Th");
		parameterValues.put("village", "Test");
		parameterValues.put("pincode", "400709");
		parameterValues.put("territory", "Test");
		parameterValues.put("region", "Test");
		parameterValues.put("zone", "Test");
		parameterValues.put("cluster", "Test");
		parameterValues.put("isActive", false);
		parameterValues.put("startDate", "Test");
		parameterValues.put("endDate", "Test");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test04_validateDealerData() {
		extentTest = extentReports.createTest("when enter valid data with authorization");
		apiURL="/AddDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", setName());
		parameterValues.put("name", "Test");
		parameterValues.put("state", "Maharashtra");
		parameterValues.put("district", "Thane");
		parameterValues.put("tehsil", "Thane");
		parameterValues.put("village", "Koperkhairane");
		parameterValues.put("pincode", "400709");
		parameterValues.put("territory", "T2");
		parameterValues.put("region", "R3");
		parameterValues.put("zone", "North");
		parameterValues.put("cluster", "Akash");
		parameterValues.put("isActive", false);
//		parameterValues.put("startDate", "2023-12-13");
//		parameterValues.put("endDate", "Test");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		id = response.jsonPath().getString("data.id");
		System.out.println(id);
		
		LocalDate date = LocalDate.now();
		System.out.println(date.toString());
		
		response.then()
		.statusCode(201)
		.body("data.startDate", containsString(date.toString()));
		
		
	}
	
	@Test
	public void Test05_validateDealerData() {
		extentTest = extentReports.createTest("Update value and execute without authorisation");
		apiURL="/UpdateDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("name", "Tester");

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test06_validateDealerData() {
		extentTest = extentReports.createTest("Update null value with authorization");
		apiURL="/UpdateDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("name", null);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test07_validateDealerData() {
		extentTest = extentReports.createTest("Update data with invalid Id");
		apiURL="/UpdateDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", "7f995df1-b638-440f-b661-caa98af2ccc3");
		parameterValues.put("name", "Tester");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(404);
	}

	@Test
	public void Test08_validateDealerData() {
		extentTest = extentReports.createTest("Update value with authorization");
		apiURL="/UpdateDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("code", "Dealer");
		parameterValues.put("name", "Dealer");

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(201);
	}
	
	
	@Test
	void Test09_validateDealerData() {
		extentTest = extentReports.createTest("When get record without authorization");
		apiURL="/GetDealerById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401);
		
	}
	
	@Test
	public void Test10_validateDealerData() {
		extentTest = extentReports.createTest("When get record with authorization");
		apiURL="/GetDealerById";
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
	public void Test11_validateDealerData() {
		extentTest = extentReports.createTest("When deleted without authorization");
		apiURL="/DeleteDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()
				.contentType("application/json")
				.params(parameterValues)
				
				
			.when()
				.delete(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test12_validateDealerData() {
		extentTest = extentReports.createTest("When deleted with authorization");
		apiURL="/DeleteDealer";
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
	public void Test13_validateDealerData() {
		extentTest = extentReports.createTest("Update data for deleted record");
		apiURL="/UpdateDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("Code", "dealer");
		parameterValues.put("name", "Tester");	

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then().statusCode(204);
				
	}
	
	@Test
	public void Test14_validateDealerData() {
		extentTest = extentReports.createTest("When enter data without authorisation");
		apiURL="/GetAllDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", null);
		parameterValues.put("name", null);
		parameterValues.put("isActive", null);
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 1);

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
	public void Test15_validateDealerData() {
		extentTest = extentReports.createTest("When enter null value and execute ");
		apiURL="/GetAllDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", null);
		parameterValues.put("name", null);
		parameterValues.put("isActive", null);
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
	public void Test16_validateDealerData() {
		extentTest = extentReports.createTest("When enter invalid data with authorisation");
		apiURL="/GetAllDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", "Test");
		parameterValues.put("name", null);
		parameterValues.put("isActive", true);
		parameterValues.put("pageNumber", 0);
		parameterValues.put("pageSize", 0);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(404);
	}
	
	@Test
	public void Test17_validateDealerData() {
		extentTest = extentReports.createTest("when enter valid data with authorization");
		apiURL="/GetAllDealer";
		HashMap parameterValues = new HashMap();
		parameterValues.put("code", "Dealer");
		parameterValues.put("name", null);
		parameterValues.put("isActive", true);
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 50);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		
		response.then()
		.statusCode(200)
		.body("Status",equalTo(true));
	
	}
	
	@Test
	public void Test18_validateDealerData() {
		extentTest = extentReports.createTest("Get all Dealers without authorization");
		apiURL="/GetDealers";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test19_validateDealerData() {
		extentTest = extentReports.createTest("Get all Dealers with authorization");
		apiURL="/GetDealers";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test20_validateDealerData() {
		extentTest = extentReports.createTest("Get all FDO's without authorization");
		apiURL="/GetAllFdosDropDown";
		
		response = RestAssured.given()	
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test21_validateDealerData() {
		extentTest = extentReports.createTest("Get all FDO's with authorization");
		apiURL="/GetAllFdosDropDown";
		
		HashMap parameterValues = new HashMap();
		parameterValues.put("dealerCode", "AGSSA5474");
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.params(parameterValues)	
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test22_validateDealerData() {
		extentTest = extentReports.createTest("Get all FDO's with authorization when Dealercode is null");
		apiURL="/GetAllFdosDropDown";
		
		HashMap parameterValues = new HashMap();
		parameterValues.put("dealerCode", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.params(parameterValues)	
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(404);
	}
	
	@Test
	public void Test23_validateDealerData() {
		extentTest = extentReports.createTest("Get all Operator's without authorization ");
		apiURL="/GetAllOperatorDropdown";
		
		response = RestAssured.given()
						
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test24_validateAddUser() {
		extentTest = extentReports.createTest("Get all Operator's with authorization");
		apiURL="/GetAllOperatorDropdown";
		
		HashMap parameterValues = new HashMap();
		parameterValues.put("dealerCode", "AGSSA5474");
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.params(parameterValues)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test25_validateDealerData() {
		extentTest = extentReports.createTest("Get all Operator's with authorization");
		apiURL="/GetAllOperatorDropdown";
		
		HashMap parameterValues = new HashMap();
		parameterValues.put("dealerCode", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.params(parameterValues)
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(404);
	}

}
