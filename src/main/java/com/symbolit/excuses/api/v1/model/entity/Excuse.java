package com.symbolit.excuses.api.v1.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Excuse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="http_code")
	private int httpCode;
	private String tag;
	private String message;
	
	public Excuse() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Excuse(int httpCode, String tag, String message) {
		super();
		this.httpCode = httpCode;
		this.tag = tag;
		this.message = message;
	}
	
}
