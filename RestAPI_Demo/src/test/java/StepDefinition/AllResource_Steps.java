package StepDefinition;

import org.testng.Assert;

import BaseClass.API_Resource;
import Using_Pojo.DeleteByUsingPojo;
import Using_Pojo.PostByUsingPojo;
import Using_Pojo.PutByUsingPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllResource_Steps {
	
	RequestSpecification resq;
	Response response;
	PostByUsingPojo post;
	PutByUsingPojo put;
	DeleteByUsingPojo delete;
	
	@Given("Initialize uri")
	public void initialize_uri() {
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		
		resq = RestAssured.given().contentType(ContentType.JSON).log().all();
	}

	@When("Call {string} with {string} Method")
	public void call_with_method(String resources, String method) {
		
		post = new PostByUsingPojo();
		put = new PutByUsingPojo();
		delete = new DeleteByUsingPojo();
		
		API_Resource Apiresources = API_Resource.valueOf(resources);
		
		if(method.equalsIgnoreCase("post")) {
			response = resq.body(post.PostMethod1()).when().post(Apiresources.getresource());
		}else if(method.equalsIgnoreCase("put")) {
			response = resq.body(put.putmethod()).when().put(Apiresources.getresource());
		}else if(method.equalsIgnoreCase("delete")){
			response = resq.body(delete.deletemethod()).when().delete(Apiresources.getresource());
		}
		
		
	}

	@Then("API call got succes with status code {int}")
	public void api_call_got_succes_with_status_code(int statuscode) {
	  	
		int expectedcode = response.getStatusCode();
		
		Assert.assertEquals(expectedcode, statuscode);
		
	}

	@Then("{string} in Response body is {string}")
	public void in_response_body_is(String key, String value) {
		
		Assert.assertEquals(response.jsonPath().getString(key),value);
		
	}


}
