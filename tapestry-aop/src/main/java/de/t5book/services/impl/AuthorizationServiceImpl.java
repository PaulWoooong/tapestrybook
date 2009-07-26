package de.t5book.services.impl;

import org.apache.tapestry5.services.ApplicationStateManager;

import de.t5book.entities.User;
import de.t5book.services.AuthorizationService;

public class AuthorizationServiceImpl implements AuthorizationService {
	ApplicationStateManager applicationStateManager;
	
	public AuthorizationServiceImpl(
			ApplicationStateManager applicationStateManager) {
		super();
		this.applicationStateManager = applicationStateManager;
	}
	
	public boolean isAuthorizedCall() {
		User user = applicationStateManager.getIfExists(User.class);
		if(user==null){
			return false;
		}
		return true;
	}

}
