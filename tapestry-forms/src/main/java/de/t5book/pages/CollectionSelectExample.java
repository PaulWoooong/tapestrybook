package de.t5book.pages;

import java.util.Arrays;
import java.util.Collection;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class CollectionSelectExample {

	@Persist
	@Property
	private String creditCard;

	public Collection<String> getValues() {
		return Arrays.asList("Master Card", "Visa", "American Express",
				"Diners Club");
	}

	void onSuccess() {
		System.out.println("creditCard = " + creditCard);
	}
}
