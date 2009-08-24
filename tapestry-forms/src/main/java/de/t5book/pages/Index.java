package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;

import de.t5book.entities.User;

public class Index {
	@Persist
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
