package io.restassured.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.base.TestBase;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
public class GetTest extends TestBase {
	
	public String baseURI=null;
	public String endpointUrl=null;
	public String finalAPIURL=null;
	public GetTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	@BeforeMethod
	public void setup() {
		RestAssured.baseURI=prop.getProperty("baseurl");
		endpointUrl=prop.getProperty("serviceAPI");
		finalAPIURL=endpointUrl+"?page=2";
	}
	
	
	
	@Test(priority=1,description="Get the List of user")
	public void GetListUser()
	{
		

		String Resp=given().
				when().
				get(finalAPIURL).
				then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("server", "cloudflare").and(). 
				header("x-powered-by","Express").and().
				body("page",equalTo(2)).and().
				body("data[1].first_name",equalTo("Lindsay")).and().
				extract().
				response().asString();

		System.out.println("Response is\t"+Resp);
	}
}
