package BaseClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Calling_Method_Using_Enum_Class extends Payloads {

	@Test(priority = 0)
	public void callingenum() {

		API_Resource method = API_Resource.valueOf("PostAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RestAssured.given().log().all().body(postauthor()).when().post(method.getresource()).then().log().all()
				.statusCode(200);

	}

	@Test(priority = 0)
	public void callingput() {

		API_Resource putmethod = API_Resource.valueOf("UpdateAuthor");

		RestAssured.baseURI = "https://www.change2testautomation.com";

		RestAssured.given().log().all().body(putauthor()).when().put(putmethod.getresource()).then().log().all()
				.statusCode(200);
	}

	@Test(priority = 1)
	public void callingdel() {

		API_Resource delmethod = API_Resource.valueOf("DeleteAuthor");

		RestAssured.given().log().all().body(deleteauthorname()).when().put(delmethod.getresource()).then().log().all()
				.statusCode(200);
	}

}
