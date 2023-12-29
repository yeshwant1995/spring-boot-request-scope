package com.demo.application.model;

public class UserDetails {

	private Long userId;
	private String userName;
	
	public UserDetails(Long userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
	public UserDetails() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + "]";
	}



}
