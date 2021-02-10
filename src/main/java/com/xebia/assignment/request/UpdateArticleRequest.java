package com.xebia.assignment.request;

public class UpdateArticleRequest extends CreateArticleRequest {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UpdateArticleRequest(String title, String description, String body, String id) {
		super(title, description, body);
		this.id = id;
	}

}
