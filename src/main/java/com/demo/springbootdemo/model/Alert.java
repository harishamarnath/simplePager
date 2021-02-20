package com.demo.springbootdemo.model;

import com.demo.springbootdemo.enums.AlertType;

public class Alert {
	
	private AlertType alertType;
	private Long teamId;
	private String additionalMessage;
	
	
	public Alert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlertType getAlertType() {
		return alertType;
	}
	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getAdditionalMessage() {
		return additionalMessage;
	}
	public void setAdditionalMessage(String additionalMessage) {
		this.additionalMessage = additionalMessage;
	}
	
	

}
