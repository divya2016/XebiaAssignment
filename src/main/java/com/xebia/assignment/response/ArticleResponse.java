package com.xebia.assignment.response;

public class ArticleResponse {
	private String title;
	private String description;
	private String body;
	private String id;
	private String slung;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public String getSlung() {
		return slung;
	}

	public void setSlung(String slung) {
		this.slung = slung;
	}

	public ArticleResponse(String title, String description, String body, String id, String slung) {
		this.title = title;
		this.description = description;
		this.body = body;
		this.id = id;
		this.slung = slung;
	}

}
