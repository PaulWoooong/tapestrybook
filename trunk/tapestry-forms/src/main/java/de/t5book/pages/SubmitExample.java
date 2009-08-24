package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class SubmitExample {
	@Persist
	@Property
	private String userName;

	@Persist
	@Property
	private String email;

	void onSelectedFromCancel() {

		// Abrechen der Registrierung
		this.userName = null;
		this.email = null;
	}

	void onSelectedFromRegister() {
		System.out.println("onSelectedFromRegister()");
		// Zu früh für Registrierung
	}
	
	void onValidateForm() {
		System.out.println("onValidateForm()");
	}

	void onSuccess() {
		// Registrierung erfolgt erst hier
		System.out.println("onSuccess()");
	}
}
