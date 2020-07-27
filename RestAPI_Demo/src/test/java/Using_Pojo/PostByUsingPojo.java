package Using_Pojo;

import Post_Pojo.Post_Body;

public class PostByUsingPojo {
	
	
	public Post_Body PostMethod(String body, String title, String author) {
		
		Post_Body post = new Post_Body();
		
		post.setAuthor(author);
		post.setBody(body);
		post.setTitle(title);
		
		return post;
		
	}
	
public Post_Body PostMethod1() {
		
		Post_Body post = new Post_Body();
		
		post.setAuthor("Franklin");
		post.setBody("Automation");
		post.setTitle("Rest Assured");
		
		return post;
		
	}

}
