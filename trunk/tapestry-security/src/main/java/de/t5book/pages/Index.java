package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import de.t5book.entities.User;

public class Index {
	@Property
	@SessionState(create=false)
	private User user;
	
	@Property
	private boolean userExists;
}
