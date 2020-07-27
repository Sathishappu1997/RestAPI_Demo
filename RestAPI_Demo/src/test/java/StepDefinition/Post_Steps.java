package StepDefinition;

import org.testng.Assert;

import Using_Pojo.PostByUsingPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_Steps {
	
	Response response;
	JsonPath json;
	PostByUsingPojo post;
	
	@Given("Initialize base uri and base path")
	public void initialize_base_uri_and_base_path() {
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		RestAssured.basePath="/api";
	}


	@Then("Call the pojo class")
	public void call_the_pojo_class() {
		
		post = new PostByUsingPojo();
		
	}

	@Then("Get the Response for Post Method with {string} {string} and {string}")
	public void get_the_response_for_post_method_with_and(String body, String title, String author) {		
		response = RestAssured.given()
					.log().all().contentType(ContentType.JSON).body(post.PostMethod(body,title, author))
					.when()
					.post("/insert.php")
					.then()
					.log().all().assertThat().statusCode(200).extract().response();
			
	}

	@Then("validate the Response using jsonpath")
	public void validate_the_response_using_jsonpath() {
		
		json = new JsonPath(response.asString());
		String acutalmsg = json.getString("message");
		String expectedmsg = "Data Inserted Successfully";
		Assert.assertEquals(acutalmsg, expectedmsg);
		
		System.out.println("Post Validation Passed");
		
	}

}
