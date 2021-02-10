package com.xebia.assignment.data.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("articles")
public class Articles extends AuditEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String slug;
	String title;
	String description;
	String body;

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

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

	public Articles(String slug, String title, String description, String body) {
		this.slug = slug;
		this.title = title;
		this.description = description;
		this.body = body;
	}

}
