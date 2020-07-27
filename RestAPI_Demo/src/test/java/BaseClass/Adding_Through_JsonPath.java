package BaseClass;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Adding_Through_JsonPath {

	@Test(priority = 1)
	public void putmethod() {

		API_Resource putmethod = API_Resource.valueOf("UpdateAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RequestSpecification rspec = RestAssured.given();

		rspec.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "11");
		json.put("author", "Franklin Testing");

		rspec.body(json.toJSONString());

		Response response = rspec.put(putmethod.getresource());

		String respbody = response.getBody().asString();

		System.out.println(respbody);
	}

	@Test(priority = 0)
	public void PostAuthormethod() {

		API_Resource postmethod = API_Resource.valueOf("PostAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RequestSpecification rspec = RestAssured.given();

		rspec.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("title", "The new one");
		json.put("body", "The New Book");
		json.put("author", "Franklin Testing");

		rspec.body(json.toJSONString());

		Response response = rspec.post(postmethod.getresource());

		String respbody = response.getBody().asString();

		System.out.println(respbody);
	}
	
	@Test(priority = 2)
	public void PostAuthormethod1() {

		API_Resource postmethod = API_Resource.valueOf("PostAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RequestSpecification rspec = RestAssured.given();

		rspec.header("Content-Type", "application/json");

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", "The new one");
		map.put("body", "The New Book");
		map.put("author", "Franklin Testing");

		rspec.body(map);

		Response response = rspec.post(postmethod.getresource());

		
		

		
	}
	

}
