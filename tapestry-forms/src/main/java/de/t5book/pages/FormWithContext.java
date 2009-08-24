package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class FormWithContext {
	@Property
	@Persist
	private String input;

	public Object[] getFormContext() {
		return new Object[] { new Integer(7), new Double(3.14159) };
	}

	void onValidateForm(Integer first, Double second) {
		System.err.println(input);
		System.out.println("onValidateForm(" + first + ", " + second + ")");
	}

	void onSuccess(Double first) {
		System.out.println("onSuccess(" + first + ")");
	}

	Object onSubmit() {
		System.out.println("onSubmit");
		return FormWithContext.class;
	}

}
