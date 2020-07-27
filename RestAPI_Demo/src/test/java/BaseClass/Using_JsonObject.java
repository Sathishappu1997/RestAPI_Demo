package BaseClass;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Using_JsonObject {
	
	@Test(priority = 0)
	public void jsonobjpost() {
		
		API_Resource postmethod = API_Resource.valueOf("PostAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";
		
		RequestSpecification res = RestAssured.given().log().all().contentType(ContentType.JSON);
		
		JSONObject json = new JSONObject();
		
		json.put("title", "The new one");
		json.put("body", "The New Book");
		json.put("author", "Rest Testing");
		
		res.body(json.toJSONString());
		
		res.when().post(postmethod.getresource())
		.then().log().all().statusCode(200);
		
	}
	
	@Test(priority = 1)
	public void UsingPutMap() throws FileNotFoundException {
		
		API_Resource putmethod = API_Resource.valueOf("UpdateAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RequestSpecification res = RestAssured.given().log().all().contentType(ContentType.JSON);
		
		JSONObject json = new JSONObject();
		
		json.put("id", "21");
		json.put("author", "Franklin Testing");
		
		res.body(json.toJSONString());
		
		res.when().put(putmethod.getresource())
		.then().log().all().statusCode(200);

	}
	
	
	@Test(priority = 2)
	public void UsingDeleteMap() throws FileNotFoundException {
		
		API_Resource deletemethod = API_Resource.valueOf("DeleteAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RequestSpecification res = RestAssured.given().log().all().contentType(ContentType.JSON);
		
		JSONObject json = new JSONObject();
		
		json.put("id", "21");
		
		res.body(json.toJSONString());
		
		res.when().delete(deletemethod.getresource())
		.then().log().all().statusCode(200);

	}


}
