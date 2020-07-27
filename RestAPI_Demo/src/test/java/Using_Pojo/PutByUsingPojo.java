package Using_Pojo;

import Put_Pojo.Put_Body;

public class PutByUsingPojo {
	
	public Put_Body putmethod() {
		
		Put_Body put = new Put_Body();
		
		put.setAuthor("Franklin");
		put.setId(23);
		
		return put;
		
	}

}
