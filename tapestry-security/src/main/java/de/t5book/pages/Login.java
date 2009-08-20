package de.t5book.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationStateManager;

import de.t5book.entities.User;

public class Login {
	@Property
	@Persist
	private User user;

	@Inject
	private ApplicationStateManager applicationStateManager;

	@Component(parameters = { "object=user", "clientValidation=false", "submitLabel=Einloggen" })
	private BeanEditForm form;

	void onValidateForm() {
		if (form.getHasErrors()) {
			return;
		}
		if (!"root".equals(user.getUserName())
				|| !"secret".equals(user.getPassword())) {
			form.recordError("Benutzername oder Passwort ist falsch.");
		}

	}

	Object onSuccess() {
		applicationStateManager.set(User.class, user);
		return Index.class;
	}

}
