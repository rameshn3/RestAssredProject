package io.restassured.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.base.TestBase;
import io.restassured.http.ContentType;

public class PostTest extends TestBase{

	public PostTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String endpointUrl=null;
	String reqbo=null;
	@BeforeClass
	public void setup() {
		RestAssured.baseURI=prop.getProperty("baseurl");
		endpointUrl=prop.getProperty("serviceAPI");
		
	}
	@BeforeMethod
	public void resourcedata() {
		
		reqbo="'{ '+\r\n"+
						"' \"name\":\"morpheus\",'+\r\n"+
				        "'\"job\":\"leader\",'+\r\n"+
						"'}';";
	}
	
	@Test
	public void createUser() {
		String resp=given().
				    body(reqbo).
				    when().
				    post(endpointUrl).
				    then().assertThat().statusCode(201).and().
				    contentType(ContentType.JSON).and().
				    header("server","cloudflare").and().
				    extract().response().
				    asString();
		System.out.println("response-->"+resp);
	}

}
