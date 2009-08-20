package de.t5book.services;

import java.io.IOException;

import org.apache.tapestry5.internal.EmptyEventContext;
import org.apache.tapestry5.internal.services.RequestConstants;
import org.apache.tapestry5.services.ApplicationStateManager;
import org.apache.tapestry5.services.Dispatcher;
import org.apache.tapestry5.services.PageRenderRequestHandler;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Response;

import de.t5book.entities.User;
import de.t5book.pages.Login;

public class AuthorizationDispatcher implements Dispatcher {

	private PageRenderRequestHandler requestHandler;
	private ApplicationStateManager applicationStateManager;

	public AuthorizationDispatcher(PageRenderRequestHandler handler,
			ApplicationStateManager applicationStateManager) {
		super();
		this.requestHandler = handler;
		this.applicationStateManager = applicationStateManager;
	}

	public boolean dispatch(Request request, Response response)
			throws IOException {
		String loginPageName = Login.class.getSimpleName();
		String path = request.getPath();

		if (path.toLowerCase().startsWith("/" + loginPageName.toLowerCase())) {
			return false;
		}

		User user = this.applicationStateManager.getIfExists(User.class);

		if (user == null) {

			PageRenderRequestParameters parameters = new PageRenderRequestParameters(
					loginPageName, new EmptyEventContext());
			this.requestHandler.handle(parameters);

			return true;
		}

		return false;
	}

}
