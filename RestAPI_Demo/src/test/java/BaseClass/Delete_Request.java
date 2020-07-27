package BaseClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete_Request extends Payloads {
	
	@Test
	public void deleteauthor() {
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		
		RestAssured.given()
		.log().all().body(deleteauthorname())
		.when()
		.delete("/api/delete.php")
		.then()
		.log().all().statusCode(200);
	}

}
