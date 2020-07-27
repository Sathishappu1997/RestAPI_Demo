package StepDefinition;

import org.testng.Assert;

import Using_Pojo.DeleteByUsingPojo;
import Using_Pojo.PutByUsingPojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Delete_Steps {
	
	Response response;
	DeleteByUsingPojo deleterequest;
	JsonPath json;
	
	@When("call the delete pojo class")
	public void call_the_delete_pojo_class() {
		
		deleterequest = new DeleteByUsingPojo();
		
	}

	@Then("Get the Response for delete Method")
	public void get_the_response_for_delete_method() {
		
		response = RestAssured.given()
				.log().all().contentType(ContentType.JSON).body(deleterequest.deletemethod())
				.when()
				.post("/delete.php")
				.then()
				.log().all().assertThat().statusCode(200).extract().response();
		
		
	}

	@Then("validate the delete Response using jsonpath")
	public void validate_the_delete_response_using_jsonpath() {
		
		json = new JsonPath(response.asString());
		String deleteactual=json.getString("message");
		String deleteexpected="Post Deleted Successfully";
		Assert.assertEquals(deleteactual, deleteexpected);
		
	}

}
