package de.t5book.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class SelectExample {

	@Persist
	@Property
	private String paymentType;

	public List<String> getOptions() {
		return Arrays.asList("Credit Card", "Bank Transfer", "Cash", "PayPal");

	}

	void onSuccess() {
		System.out.println("paymentType = " + paymentType);
	}
}
