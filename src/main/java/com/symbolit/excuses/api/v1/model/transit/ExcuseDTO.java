package com.symbolit.excuses.api.v1.model.transit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExcuseDTO {
	
    @JsonProperty("http_code")
    private int httpCode;
	private String tag;
	private String message;
	
	
	public int getHttpCode() {
		return httpCode;
	}
	
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
