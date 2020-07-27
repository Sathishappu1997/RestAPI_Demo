package BaseClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get_Request {
	
	@Test
	public void getplace() {
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		
		RestAssured.given()
		.log().all().queryParam("id", 6)
		.when()
		.get("api/read.php")
		.then()
		.log().all().statusCode(200);
		
	}

}
