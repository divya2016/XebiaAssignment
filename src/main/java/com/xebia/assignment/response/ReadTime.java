package com.xebia.assignment.response;

public class ReadTime {

	private String mins;
	private String seconds;

	public String getMins() {
		return mins;
	}

	public void setMins(String mins) {
		this.mins = mins;
	}

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public ReadTime(String mins, String seconds) {
		super();
		this.mins = mins;
		this.seconds = seconds;
	}
}
