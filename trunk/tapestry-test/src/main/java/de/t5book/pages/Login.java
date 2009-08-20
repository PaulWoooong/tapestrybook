package de.t5book.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;

import de.t5book.entities.SimpleUser;

public class Login {
	@Property
	@Persist
	private SimpleUser user;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String message;

	@Component(parameters = { "object=user", "clientValidation=false" })
	private BeanEditForm form;

	void onValidateForm() {
		if (!"secret".equals(user.getPassword())) {
			form.recordError("Passwort ist falsch.");
		}

	}

	void onSuccess() {
		message = String.format("Herzlich Willkommen, %s!", user.getUserName());
	}
}
