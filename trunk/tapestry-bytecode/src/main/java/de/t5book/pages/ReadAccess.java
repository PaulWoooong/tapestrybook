package de.t5book.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Session;

import de.t5book.annotations.SessionAttribute;
import de.t5book.entities.User;

public class ReadAccess {
	@Inject
	private Request request;
	
	@SessionAttribute("logged_in_user")
	@Property
	private User user;

	@SessionAttribute
	@Property
	private User anotherUser;
	
	@Property
	private String currentName;
	
	
	public Session getSession(){
		System.err.println(request);
		return request.getSession(true);
	}
	
	private List<String> getAttributeNames(){
		return getSession().getAttributeNames();
	}
}
