package de.t5book.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationStateManager;

import de.t5book.entities.User;
import de.t5book.services.MyService;

public class AuthorizationAdviceDemo {
	@Inject
	private MyService myService;
	
	@Inject
	private ApplicationStateManager applicationStateManager;
	
	void onActionFromAuthorized(){
		applicationStateManager.set(User.class, new User());
		myService.doWork();
	}
	
	void onActionFromNotauthorized(){
		applicationStateManager.set(User.class, null);
		myService.doWork();
	}
}
