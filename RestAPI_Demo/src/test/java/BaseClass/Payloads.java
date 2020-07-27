package BaseClass;

public class Payloads {
	
	public String postauthor() {
		
		return "{\r\n" + 
				"         \"title\": \"a3\",\r\n" + 
				"        \"body\": \"b3\",\r\n" + 
				"        \"author\": \"c2\"\r\n" + 
				"    }";
	}

	
	public String putauthor() {
		
		return "{\"id\":10,\r\n" + 
				"\"author\":\"Change to Automation\"\r\n" + 
				"}";
	}
	
	public String deleteauthorname() {
		
		return "{\"id\":10}";
	}
	
}
