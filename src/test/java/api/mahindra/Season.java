package api.mahindra;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;

public class Season extends Test_Config{
	
	public String id="b14ba15d-4b48-46ba-92e2-0093924a4eec";
	
	@Test
	public void Test497_validateSeasonData() {
		extentTest = extentReports.createTest("When enter null value and execute ");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("fy", null);
		parameterValues.put("startDate", null);
		parameterValues.put("endDate", null);
		parameterValues.put("isActive", null);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test498_validateSeasonData() {
		extentTest = extentReports.createTest("When enter data without authorisation");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("fy", null);
		parameterValues.put("startDate", null);
		parameterValues.put("endDate", null);
		parameterValues.put("isActive", null);

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test503_validateSeasonData() {
		extentTest = extentReports.createTest("when enter name and FY data invalid");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Test");
		parameterValues.put("fy", "23-24");
		parameterValues.put("startDate", "2023-12-13T06:25:34.906Z");
		parameterValues.put("endDate", "2023-12-13T06:25:34.906Z");
		parameterValues.put("isActive", true);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test509_validateSeasonData() {
		extentTest = extentReports.createTest("when enter valid name and FY, is active-False");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Kharip");
		parameterValues.put("fy", "2027-2026");
		parameterValues.put("startDate", "2022-12-13");
		parameterValues.put("endDate", "2022-04-01");
		parameterValues.put("isActive", false);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(201);
		
		id = response.jsonPath().getString("data.id");
		System.out.println(id);
	}
	
	@Test
	public void Test515_validateSeasonData() {
		extentTest = extentReports.createTest("when we pass start and end date as null");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Kharip");
		parameterValues.put("fy", "2023-2024");
		parameterValues.put("startDate", null);
		parameterValues.put("endDate", null);
		parameterValues.put("isActive", true);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test521_validateSeasonData() {
		extentTest = extentReports.createTest("when entered end date is before start date");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", setName());
		parameterValues.put("fy", "2024-2025");
		parameterValues.put("startDate", "2023-12-13");
		parameterValues.put("endDate", "2023-08-13");
		parameterValues.put("isActive", true);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test527_validateSeasonData() {
		extentTest = extentReports.createTest("when entered is active status as null");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Kharib");
		parameterValues.put("fy", "2024-2025");
		parameterValues.put("startDate", "2023-12-13");
		parameterValues.put("endDate", "2023-12-14");
		parameterValues.put("isActive", null);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test533_validateSeasonData() {
		extentTest = extentReports.createTest("when entered value and execute without authorisation");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Kharif");
		parameterValues.put("fy", "2023-2024");
		parameterValues.put("startDate", "2023-12-13");
		parameterValues.put("endDate", "2023-12-14");
		parameterValues.put("isActive", true);

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test534_validateSeasonData() {
		extentTest = extentReports.createTest("when enter null value and execute");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("fy", null);
		parameterValues.put("startDate", null);
		parameterValues.put("endDate", null);
		parameterValues.put("isActive", null);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(400);
	}

	@Test
	public void Test539_validateSeasonData() {
		extentTest = extentReports.createTest("when enter all value and execute");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("name", "Test");
		parameterValues.put("fy", "2023-2024");
		parameterValues.put("startDate", "2023-12-13");
		parameterValues.put("endDate", "2023-12-13");
		parameterValues.put("isActive", true);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(201);
	}
	
	@Test
	public void Test540_validateSeasonData() {
		extentTest = extentReports.createTest("When entered dates are diffrent from chosen financial year and FY is diffrent that preferred");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("name", "Test");
		parameterValues.put("fy", "2021-2024");
		parameterValues.put("startDate", "1996-12-13");
		parameterValues.put("endDate", "1996-12-13");
		parameterValues.put("isActive", true);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test546_validateSeasonData() {
		extentTest = extentReports.createTest("When deleted without authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/DeleteSeason";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()//.header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test547_validateSeasonData() {
		extentTest = extentReports.createTest("When deleted with authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/DeleteSeason";
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
	public void Test549_validateSeasonData() {
		extentTest = extentReports.createTest("When get record without authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetSeasonById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given()//.header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(401);
		
	}
	
	@Test
	public void Test550_validateSeasonData() {
		extentTest = extentReports.createTest("When get record with authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetSeasonById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then()
		.statusCode(200)
		.body("data.isDeleted",equalTo(true));
	}
	
	@Test
	public void Test554_validateSeasonData() {
		extentTest = extentReports.createTest("When entered values without autorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllSeasons";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("fy", null);
		parameterValues.put("pageNumber", null);
		parameterValues.put("pageSize", 50);

		response = RestAssured.given()//.header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test555_validateSeasonData() {
		extentTest = extentReports.createTest("When entered pagesize 0 page Number 0");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllSeasons";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("fy", null);
		parameterValues.put("pageNumber", 0);
		parameterValues.put("pageSize", 0);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test556_validateSeasonData() {
		extentTest = extentReports.createTest("When entered all data as null");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllSeasons";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("fy", null);
		parameterValues.put("pageNumber", null);
		parameterValues.put("pageSize", null);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test557_validateSeasonData() {
		extentTest = extentReports.createTest("When entered all valid values");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllSeasons";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Kharif");
		parameterValues.put("fy", "2023-2024");
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 25);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test558_validateSeasonData() {
		extentTest = extentReports.createTest("When entered all invalid values");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllSeasons";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", "Test");
		parameterValues.put("fy", "1996-1997");
		parameterValues.put("pageNumber", 1);
		parameterValues.put("pageSize", 25);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(404);
	}
}
	