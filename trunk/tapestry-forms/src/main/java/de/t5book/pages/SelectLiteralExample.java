package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class SelectLiteralExample {

	@Persist
	@Property
	private String paymentType;

	void onSuccess() {
		System.out.println("paymentType = " + paymentType);
	}
}
