package de.t5book.entities;

import org.apache.commons.lang.builder.ToStringBuilder;

public class User {
	private String userName;

	public User(){
		super();
	}
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
