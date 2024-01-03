package api.hrms;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
 * given()
 * 		content type, set cookies, add auth, add param set header info etc..
 * 
 * when()
 * 		get, post, put, delete
 * then()
 * 		validate status code, extract response, extract headers cookies & response body
 */

public class SampleTest {
	
	
	
	@Test
	public void Authenticate_User() {
		HashMap<String, String> parameterValues = new HashMap<String,String>();
		//JSONObject parameterValues = new JSONObject();
		parameterValues.put("grant_type", "password");
		parameterValues.put("client_id", "MarketPlace_App");
		parameterValues.put("username", "admin");
		parameterValues.put("password", "1q2w3E*");
		parameterValues.put("scope", "MarketPlace");
		System.out.print("grant_type:password\nclient_id:MarketPlace_App\nusername:admin\npassword:1q2w3E*\nscope:MarketPlace\n");
		//config().sslConfig(null)
		String requestBody="";
		try {
			requestBody = "grant_type" + URLEncoder.encode("password", "UTF-8")
			+ "&client_id=" + URLEncoder.encode("MarketPlace_App", "UTF-8")
			+ "&username=" + URLEncoder.encode("admin", "UTF-8")
			+ "&password=" + URLEncoder.encode("1q2w3E*", "UTF-8")
			+ "&scope=" + URLEncoder.encode("MarketPlace", "UTF-8");
			System.out.println(requestBody);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Response response = RestAssured.given()
			.contentType(ContentType.URLENC)
			.contentType("application/x-www-form-urlencoded")
			.formParams(parameterValues)
//			.body("grant_type:password\nclient_id:MarketPlace_App\nusername:admin\npassword:1q2w3E*\nscope:MarketPlace\n")
//			.body(requestBody)
			
			
		.when()
			.post("https://marketplace.projectnimbus.co.in/connect/token")
			
		.then()
			.statusCode(200)
			.extract()
            .response();
		
		String accessToken = response.jsonPath().getString("access_token");
        System.out.println("Access Token: " + accessToken);
	}
	
	//@Test
	public void getUsers() {
		
		given()
			
		
		.when()
			.get("https://hrmsxapi.antllp.com/api/app/department")
		
		.then()
			.statusCode(200)
			.body("totalCount", equalTo(2))
			.log().all();
	}

}
