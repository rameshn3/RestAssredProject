package io.restassured.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.base.TestBase;

public class DeleteTest extends TestBase{
	
	public DeleteTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public String endPointUrl=null;
	public String endpointAPI=null;
	
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI=prop.getProperty("baseurl");
		endpointAPI=prop.getProperty("serviceAPI");
		endPointUrl=endpointAPI+"/2";
	}

	@Test
	public void deleteTest() {
		String resp=given().
				    when().
				    delete(endPointUrl).
				    then().assertThat().
				    statusCode(204).and().
				    header("server","cloudflare").and().
				    extract().response().asString();
		System.out.println("response is-->"+resp);
	}
	
	
}
