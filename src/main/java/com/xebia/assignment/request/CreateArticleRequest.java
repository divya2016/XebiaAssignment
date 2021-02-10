package com.xebia.assignment.request;

public class CreateArticleRequest {

	private String title;
	private String description;
	private String body;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public CreateArticleRequest(String title, String description, String body) {
		this.title = title;
		this.description = description;
		this.body = body;
	}

}
