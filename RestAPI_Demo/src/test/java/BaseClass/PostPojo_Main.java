package BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import Using_Pojo.PostByUsingPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class PostPojo_Main {

	@Test
	public void post() {
		
		PostByUsingPojo ps = new PostByUsingPojo();
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		RestAssured.basePath="/api";
		
		Response response=RestAssured.given()
					.log().all().contentType(ContentType.JSON).body(ps.PostMethod1())
					.when()
					.post("/insert.php")
					.then()
					.log().all().statusCode(200).assertThat()
					.body("message", equalTo("Data Inserted Successfully")).extract().response();
		
		JsonPath js = new JsonPath(response.asString());
		String msg=js.getString("message");
		
		Assert.assertEquals(msg, "Data Inserted Successfully");
		
	}
	
}
