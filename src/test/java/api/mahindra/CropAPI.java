package api.mahindra;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.annotations.Test;

import api.configuration.Test_Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CropAPI extends Test_Config{
	
	@Test
	public void Test127_validateCropData() {
		extentTest = extentReports.createTest("Enter all fields values as null");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name","null");
		parameterValues.put("pageNumber", "null");
		parameterValues.put("pageSize", "null");

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test128_validateCropData() {
		extentTest = extentReports.createTest("Enter all fields values as blank");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("pageNumber", null);
		parameterValues.put("pageSize", null);

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test129_validateCropData() {
		extentTest = extentReports.createTest("Get Crop data without authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("pageNumber", null);
		parameterValues.put("pageSize", 1);

		response = RestAssured.given()
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test130_validateCropData() {
		extentTest = extentReports.createTest("Get Crop data with page number and page size as 0");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
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
	public void Test131_validateCropData() {
		extentTest = extentReports.createTest("Enter all fields valid values");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropList";
		HashMap parameterValues = new HashMap();
		parameterValues.put("name", null);
		parameterValues.put("pageNumber", null);
		parameterValues.put("pageSize", 50);

		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.body(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(200);
	}
	
	@Test
	public void Test135_validateCropData() {
		extentTest = extentReports.createTest("Add new crop without login");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", null);
		parameterValues.put("Name", null);
		parameterValues.put("ImageId", null);
		parameterValues.put("IsActive", null);
		parameterValues.put("Image", null);
		parameterValues.put("ImageName", null);
		parameterValues.put("ImagePath", null);
		parameterValues.put("CreatedOn", null);
		
		response = RestAssured.given()
				.contentType(ContentType.URLENC)
				.contentType("application/x-www-form-urlencoded")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(401);
	}
	
	@Test
	public void Test136_validateCropData() {
		extentTest = extentReports.createTest("When Login and Empty filed submitted");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", null);
		parameterValues.put("Name", null);
		parameterValues.put("ImageId", null);
		parameterValues.put("IsActive", null);
		parameterValues.put("Image", null);
		parameterValues.put("ImageName", null);
		parameterValues.put("ImagePath", null);
		parameterValues.put("CreatedOn", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.URLENC)
				.contentType("application/x-www-form-urlencoded")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test138_validateCropData() {
		extentTest = extentReports.createTest("Enter crop name and execute");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", null);
		parameterValues.put("Name", setName());
		parameterValues.put("ImageId", null);
		parameterValues.put("IsActive", null);
		parameterValues.put("Image", null);
		parameterValues.put("ImageName", null);
		parameterValues.put("ImagePath", null);
		parameterValues.put("CreatedOn", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.URLENC)
				.contentType("application/x-www-form-urlencoded")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test142_validateCropData() {
		extentTest = extentReports.createTest("Enter name, is active status and exeute");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("Name", setName());
		parameterValues.put("IsActive", false);
		//parameterValues.put("Image", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.URLENC)
				.contentType("application/x-www-form-urlencoded")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then()
		.statusCode(400);
	}
	
	@Test
	public void Test146_validateCropData() throws FileNotFoundException {
		extentTest = extentReports.createTest("Enter name, is active status and upload image then execute");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		String path = System.getProperty("user.dir") + "./src/test/resources/groundnut.jpg";
		File file = new File(path);
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", null);
		parameterValues.put("Name", setName());
		parameterValues.put("ImageId", null);
		parameterValues.put("IsActive", false);
		//parameterValues.put("Image", file);
		parameterValues.put("ImageName", null);
		parameterValues.put("ImagePath", null);
		parameterValues.put("CreatedOn", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.MULTIPART)  // Set content type for multipart form data
                .multiPart("Image", file) 
//				.contentType(ContentType.URLENC)
//				.contentType("application/*+form-data")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then().statusCode(201)
		.body("data.isActive", equalTo(false));

	}
	
	@Test
	public void Test150_validateCropData() throws FileNotFoundException {
		extentTest = extentReports.createTest("Adding Duplicate Crop Name");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		String path = System.getProperty("user.dir") + "./src/test/resources/groundnut.jpg";
		File file = new File(path);
		HashMap parameterValues = new HashMap();
		parameterValues.put("Name", "Paddy");
		parameterValues.put("IsActive", false);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.MULTIPART)  // Set content type for multipart form data
                .multiPart("Image", file) 
//				.contentType(ContentType.URLENC)
//				.contentType("application/*+form-data")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then().statusCode(400);

	}
	
	@Test
	public void Test154_validateCropData() throws FileNotFoundException {
		extentTest = extentReports.createTest("Keep isactive status empty and execute");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/AddNewCrop";
		String path = System.getProperty("user.dir") + "./src/test/resources/groundnut.jpg";
		File file = new File(path);
		HashMap parameterValues = new HashMap();
		parameterValues.put("Name", setName());
		parameterValues.put("IsActive", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.MULTIPART)  // Set content type for multipart form data
                .multiPart("Image", file) 
//				.contentType(ContentType.URLENC)
//				.contentType("application/*+form-data")
				.formParams(parameterValues)
				
				
			.when()
				.post(apiURL);
		
		response.then().statusCode(400);

	}
}
