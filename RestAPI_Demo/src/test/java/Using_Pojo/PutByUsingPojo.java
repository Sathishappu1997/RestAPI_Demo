package Using_Pojo;

import Put_Pojo.Put_Body;

public class PutByUsingPojo {
	
	public Put_Body putmethod() {
		
		Put_Body put = new Put_Body();
		
		put.setAuthor("updated new name");
		put.setId(155);
		
		return put;
		
	}

}
