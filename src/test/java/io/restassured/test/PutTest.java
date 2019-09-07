package io.restassured.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.base.TestBase;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class PutTest extends TestBase{

	public PutTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String endpointurl=null;
	public String finalUrl=null;
	String reqputbo=null;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI=prop.getProperty("baseurl");
		endpointurl=prop.getProperty("serviceAPI");
		finalUrl=endpointurl+"/2";
	}
	
	@BeforeMethod
	public void requestputBody() {
		
		reqputbo="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}";
				
	}
	
	@Test
	public void putTest() {
		
		String Resp=given().
				body("reqputbo").
				when().
				put(finalUrl).
				then().assertThat(). 
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("server", "cloudflare").and(). 
				extract().
				response().asString();

		System.out.println("Response is\t"+Resp);
	}

}
