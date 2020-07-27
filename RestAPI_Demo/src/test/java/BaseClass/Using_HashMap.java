package BaseClass;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Using_HashMap extends Loggin_All_Results {
	
	@Test(priority = 0)
	public void UsingPostMap() throws FileNotFoundException {
		
		API_Resource postmethod = API_Resource.valueOf("PostAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", "The new one");
		map.put("body", "The New Book");
		map.put("author", "Online Testing");
		
		resp().body(map)
		.when().post(postmethod.getresource())
		.then().statusCode(200);
		
	}
	
	@Test(priority = 1)
	public void UsingPutMap() throws FileNotFoundException {
		
		API_Resource putmethod = API_Resource.valueOf("UpdateAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "20");
		map.put("author", "Franklin Testing");
		
		resp().body(map)
		.when().put(putmethod.getresource())
		.then().statusCode(200);

	}
	
	
	@Test(priority = 2)
	public void UsingDeleteMap() throws FileNotFoundException {
		
		API_Resource deletemethod = API_Resource.valueOf("DeleteAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "20");
		
		resp().body(map).when().delete(deletemethod.getresource())
		.then().statusCode(200);

	}

}
