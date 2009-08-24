package de.t5book.entities;

import org.apache.tapestry5.beaneditor.Validate;

public class User {
	@Validate("required")
	private String userName;
	@Validate("required")
	private String password;
	
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
}
