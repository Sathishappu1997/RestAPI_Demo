package BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Loggin_All_Results {
	
	static RequestSpecification res;
	
	public RequestSpecification resp() throws FileNotFoundException {
		
		if(res==null) {
		
		PrintStream print = new PrintStream(new File("src/test/resources/Log File/Logging_All_Results.txt"));
		
		res = RestAssured.given().filter(RequestLoggingFilter.logRequestTo(print))
				.filter(ResponseLoggingFilter.logResponseTo(print)).contentType(ContentType.JSON);
		return res;
		}
		return res;
	}

}
