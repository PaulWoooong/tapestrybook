package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class RadioExample {
	@Persist
	@Property
	private String gender;

	void onSuccess() {
		System.out.println("gender = " + gender);
	}
}
