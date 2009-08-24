package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class MultipleForms {
	@Property
	@Persist
	private String userName;
	
	@Property
	@Persist
	private String password;
	
	@Property
	@Persist
	private String search;

	void onValidateFormFromLoginForm() {
		System.out.println("onValidateFormFromLoginForm");
	}

	void onSuccessFromLoginForm() {
		System.out.println("onSuccessFromLoginForm");
	}

	void onSubmitFromLoginForm() {
		System.out.println("onSubmitFromLoginForm");
	}

	Object onValidateFormFromSearchForm() {
		System.out.println("onValidateFormFromSearchForm");
		return null;
	}

	void onSuccessFromSearchForm() {
		System.out.println("onSuccessFromSearchForm");
	}

	void onSubmitFromSearchForm() {
		System.out.println("onSubmitFromSearchForm");
	}

}
