package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import de.t5book.entities.Gender;

public class EnumRadioExample {
	@Persist
	@Property
	private Gender gender;

	@Property
	private Gender currentElement;

	public Gender[] getValues() {
		return Gender.values();
	}

	public String getLabel() {
		return currentElement.name().toLowerCase();
	}

	void onSuccess() {
		System.out.println("gender = " + gender);
	}
}
