package de.t5book.entities;

import org.apache.tapestry5.beaneditor.Validate;


public class SimpleUser {
	private String userName;
	private String password;
	
	@Validate("required")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Validate("required")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
