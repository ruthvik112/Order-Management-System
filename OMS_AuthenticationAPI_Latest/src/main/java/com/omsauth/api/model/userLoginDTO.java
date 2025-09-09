package com.omsauth.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;

public class userLoginDTO {

	private String userName;
	private String password;
	public userLoginDTO() {
		
	}
	public userLoginDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userLoginDTO [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
