package de.t5book.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

import de.t5book.entities.User;

public class Login {
	@Property
	@Persist
	private User user;

	@InjectComponent
	private Form loginForm;

	@InjectPage
	private Index indexPage;

	void onPrepareForRender() {
		System.out.println("onPrepareForRender");
	}

	void onPrepare() {
		System.out.println("onPrepare");
		
		if (user == null) {
			user = new User();
		}
	}

	void onPrepareForSubmit() {
		System.out.println("onPrepareForSubmit");
	}

	void onValidateForm() {
		System.out.println("onValidateForm");

		if (loginForm.getHasErrors()) {
			return;
		}

		if (!"root".equals(user.getUserName())
				|| !"secret".equals(user.getPassword())) {
			loginForm.recordError("Benutzername oder Passwort ist falsch.");
		}

	}

	void onFailure() {
		System.out.println("onFailure");
	}

	Object onSuccess() {
		System.out.println("onSuccess");

		indexPage.setUser(user);
		return indexPage;
	}

	void onSubmit() {
		System.out.println("onSubmit");
	}
}
