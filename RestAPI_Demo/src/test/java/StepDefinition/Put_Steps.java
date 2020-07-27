package StepDefinition;

import org.testng.Assert;

import Using_Pojo.PutByUsingPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Put_Steps {

	Response response;
	PutByUsingPojo putrequest;
	JsonPath json;
	
	@When("call the put pojo class")
	public void call_the_put_pojo_class() {
		
		putrequest = new PutByUsingPojo();
		
	}

	@Then("Get the Response for Put Method")
	public void get_the_response_for_put_method() {
		
		response = RestAssured.given()
				.log().all().contentType(ContentType.JSON).body(putrequest.putmethod())
				.when()
				.post("/update.php")
				.then()
				.log().all().assertThat().statusCode(200).extract().response();
		
	}

	@Then("validate the put Response using jsonpath")
	public void validate_the_put_response_using_jsonpath() {
		
		json = new JsonPath(response.asString());
		String putactual=json.getString("message");
		String putexpected="Data updated successfully";
		Assert.assertEquals(putactual, putexpected);
	}

}
