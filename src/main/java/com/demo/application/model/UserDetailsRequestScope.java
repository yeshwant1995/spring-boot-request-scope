package com.demo.application.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class UserDetailsRequestScope {

	private String userName;
	private Long userId;

	public String getUserName() {
		return userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUser(String userName, Long userId) {
		this.userName = userName;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetailsRequestScope [userName=" + userName + ", userId=" + userId + "]";
	}

}
