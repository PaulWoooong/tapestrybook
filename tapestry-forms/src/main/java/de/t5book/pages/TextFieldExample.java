package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Width;

public class TextFieldExample {
	@Property
	@Persist
	private String name;

	@Property
	@Persist
	@Width(3)
	private Integer age;

	@Property
	@Persist
	@Width(3)
	private Double rating;

	void onSuccess() {
		System.out.println("name= " + name);
		System.out.println("age = " + age);
		System.out.println("rating = " + rating);
	}

}
