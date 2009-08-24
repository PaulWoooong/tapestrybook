package de.t5book.pages;

import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

@IncludeJavaScriptLibrary("classpath:/de/t5book/validator.js")
public class AlphanumericValidatorExample {
	@Property
	@Persist
	private String value;
}
