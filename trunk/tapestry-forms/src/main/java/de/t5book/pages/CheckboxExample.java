package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class CheckboxExample {

	@Persist
	@Property
	private boolean subscribeNewsletter;

	void onSuccess() {
		System.out.println("subscribeNewsletter = " + subscribeNewsletter);
	}
}
