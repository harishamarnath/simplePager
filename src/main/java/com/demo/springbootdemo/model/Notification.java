package com.demo.springbootdemo.model;

import java.io.Serializable;

public class Notification implements Serializable {
	
	private Long phone_number;
	private String message;
	public Long getPhone() {
		return phone_number;
	}
	public void setPhone(Long phone) {
		this.phone_number = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
