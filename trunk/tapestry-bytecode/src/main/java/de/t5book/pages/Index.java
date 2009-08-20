package de.t5book.pages;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Session;

import de.t5book.annotations.SessionAttribute;
import de.t5book.entities.User;

public class Index {
	@Inject
	private Request request;
	
	@SessionAttribute("xxx")
	@Property
	private User user;

	void onActivate() {
		user = createRandomUser();
		
		Session session = request.getSession(false);
		System.err.println(session.getAttribute("xxx"));
	}
	
	private User createRandomUser(){
		return new User(RandomStringUtils.randomAlphabetic(8));
	}
}
