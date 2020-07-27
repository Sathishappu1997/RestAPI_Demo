package BaseClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Basic_Class extends Payloads {
	
	@Test(priority = 0)
	public void methods() {
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		
		RestAssured.given()
						.log().all().body(postauthor()).when()
						.post("api/insert.php")
						.then()
						.log().all().statusCode(200);
		
	}
	
	@Test(priority = 1)
	public void ragulshetty() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		RestAssured.given()
		.log().all()
		.queryParam("key", "qaclick123")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"")
			 	.when()
			 	.post("maps/api/place/add/json")
			 	.then()
			 	.log().all().statusCode(200);
		
	}

}
