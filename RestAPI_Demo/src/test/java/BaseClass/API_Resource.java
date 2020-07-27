package BaseClass;

public enum API_Resource {
	
	DeleteAuthor("/api/delete.php"),
	UpdateAuthor("/api/update.php"),
	GetAuthor("/api/read.php"),
	PostAuthor("/api/insert.php");
	
	private String Resource;
	
	API_Resource(String resource){
		
		this.Resource=resource;
		
	}
	
	public String getresource() {
		
		return Resource;
		
	}

}
