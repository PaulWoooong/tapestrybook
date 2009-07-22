package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;

import de.t5book.entities.User;


public class Index {
	@Property
	private User user;
	@Property
	private String password2;
	@Inject
	private BeanModelSource beanModelSource;
	@Inject
	private Messages message;

	public BeanModel getModel() {
		BeanModel model = beanModelSource.createEditModel(User.class, message);
		// model.exclude("id");
		// model.add("password2", null);
		// model.reorder("userName", "email", "password", "password2");
		return model;
	}

	public void onSuccess() {
		System.err.println(user);
		System.err.println(user.getUserName());
	}

}
