package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

public class MyPage {
	@Inject
	private Request request;

	@Property
	private String serverName;

	public void onAction() {
		this.serverName = this.request.getServerName();
	}

}
