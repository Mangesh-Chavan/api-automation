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
	
	public String id="bd2db13e-062d-413f-aeb7-ae80da90b0df";
	
	
	@Test
	public void Test01_validateCropData() {
		
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
	public void Test02_validateCropData() {
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
	public void Test03_validateCropData() {
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
		.statusCode(401).body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test04_validateCropData() {
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
	public void Test05_validateCropData() {
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
	public void Test06_validateCropData() {
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
		.statusCode(401)
		.body("message", equalTo("Unauthorized"));
	}
	
	@Test
	public void Test07_validateCropData() {
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
	public void Test08_validateCropData() {
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
	public void Test09_validateCropData() {
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
	public void Test10_validateCropData() throws FileNotFoundException {
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
		
		id = response.jsonPath().getString("data.id");
		System.out.println(id);
		
		response.then().statusCode(201)
		.body("data.isActive", equalTo(false));
		

	}
	
	@Test
	public void Test11_validateCropData() throws FileNotFoundException {
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
	public void Test12_validateCropData() throws FileNotFoundException {
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
	
	@Test
	public void Test13_validateCropData(){
		extentTest = extentReports.createTest("Enter id and execute without authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropById";
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
	public void Test14_validateCropData(){
		extentTest = extentReports.createTest("Enter id as null and execute with authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", null);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(400);

	}
	
	@Test
	public void Test15_validateCropData(){
		extentTest = extentReports.createTest("Enter id as invalid data and execute with authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", "b14ba15d-4b48-46ba-92e2-0093924a4eec");
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(404);

	}
	
	@Test
	public void Test16_validateCropData(){
		extentTest = extentReports.createTest("Enter id  and execute with authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetCropById";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(200);

	}
	
	@Test
	public void Test17_validateCropData() throws FileNotFoundException {
		extentTest = extentReports.createTest("Update Crop Details without authorisation");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateCrop";
		String path = System.getProperty("user.dir") + "./src/test/resources/groundnut.jpg";
		File file = new File(path);
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		parameterValues.put("name", "Test");
		parameterValues.put("IsActive", false);
		
		response = RestAssured.given()
				.contentType("application/json")
				.formParams(parameterValues)
				
				
			.when()
				.put(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));

	}
	
	@Test
	public void Test18_validateCropData(){
		extentTest = extentReports.createTest("Update Crop name as existing name with authorisation");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", id);
		parameterValues.put("name", "Bhuimug");
		parameterValues.put("IsActive", false);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.URLENC)
				.contentType("application/x-www-form-urlencoded")
				.formParams(parameterValues)
				
			.when()
				.put(apiURL);
		
		response.then().statusCode(400);

	}
	
	@Test
	public void Test19_validateCropData() throws FileNotFoundException {
		extentTest = extentReports.createTest("Update Crop name with authorisation");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateCrop";
		String path = System.getProperty("user.dir") + "./src/test/resources/groundnut.jpg";
		File file = new File(path);
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", id);
		parameterValues.put("name", "Test");
		parameterValues.put("IsActive", false);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.MULTIPART)
                .multiPart("Image", file)
				.formParams(parameterValues)
				
			.when()
				.put(apiURL);
		
		response.then().statusCode(201);

	}
	
	@Test
	public void Test20_validateCropData(){
		extentTest = extentReports.createTest("When user want to see all crop names without authentication");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllCropNames";
		
		response = RestAssured.given()
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));

	}
	
	@Test
	public void Test21_validateCropData(){
		extentTest = extentReports.createTest("When user want to see all crop names with authentication");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/GetAllCropNames";
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				
				
			.when()
				.get(apiURL);
		
		response.then().statusCode(200)
		.body("dataList[0]", equalTo("Test"));

	}
	
	@Test
	public void Test22_validateCropData(){
		extentTest = extentReports.createTest("Delete crop without authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/DeleteCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		
		response = RestAssured.given()
				.params(parameterValues)
				
			.when()
				.delete(apiURL);
		
		response.then().statusCode(401)
		.body("message", equalTo("Unauthorized"));

	}
	
	@Test
	public void Test23_validateCropData(){
		extentTest = extentReports.createTest("Delete user with authorization");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/DeleteCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.params(parameterValues)
				
			.when()
				.delete(apiURL);
		
		response.then().statusCode(200);

	}
	
	@Test
	public void Test24_validateCropData(){
		extentTest = extentReports.createTest("Delete user that is already deleted");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/DeleteCrop";
		HashMap parameterValues = new HashMap();
		parameterValues.put("id", id);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.params(parameterValues)
				
			.when()
				.delete(apiURL);
		
		response.then().statusCode(404);

	}
	
	@Test
	public void Test25_validateCropData() throws FileNotFoundException {
		extentTest = extentReports.createTest("Update Crop name of crop that is already deleted");
		apiURL="https://mahindraapi.antllp.com/api/v1.0/UpdateCrop";
		String path = System.getProperty("user.dir") + "./src/test/resources/groundnut.jpg";
		File file = new File(path);
		HashMap parameterValues = new HashMap();
		parameterValues.put("Id", id);
		parameterValues.put("name", "Test");
		parameterValues.put("IsActive", false);
		
		response = RestAssured.given().header("Authorization","Bearer "+ accessToken)
				.contentType(ContentType.MULTIPART)
                .multiPart("Image", file)
				.formParams(parameterValues)
				
			.when()
				.put(apiURL);
		
		response.then().statusCode(204);

	}
	
}
