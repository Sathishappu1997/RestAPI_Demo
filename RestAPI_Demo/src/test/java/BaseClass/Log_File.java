package BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Log_File extends Payloads {
	
	@Test
	public void createlog() throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new File("src/test/resources/Log File/Log.txt"));
		
		RestAssured.baseURI="https://www.change2testautomation.com";
		
		RestAssured.given()
		.filter(RequestLoggingFilter.logRequestTo(log))
		.filter(ResponseLoggingFilter.logResponseTo(log))
		.body(postauthor()).when()
		.post("api/insert.php")
		.then()
		.statusCode(200);
		
	}

}
