package com.xebia.assignment.response;

public class ArticleReadResponse {
	private String id;
	private ReadTime timeToRead;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReadTime getTimeToRead() {
		return timeToRead;
	}

	public void setTimeToRead(ReadTime timeToRead) {
		this.timeToRead = timeToRead;
	}

	public ArticleReadResponse(String id, ReadTime timeToRead) {
		this.id = id;
		this.timeToRead = timeToRead;
	}

}
