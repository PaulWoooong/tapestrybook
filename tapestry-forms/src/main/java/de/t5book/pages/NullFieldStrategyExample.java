package de.t5book.pages;

import org.apache.tapestry5.NullFieldStrategy;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class NullFieldStrategyExample {

	@Persist
	@Property
	private Integer age;

	public NullFieldStrategy getNullStrategy() {
		return new NullFieldStrategy() {

			public String replaceFromClient() {
				return String.valueOf(Integer.MIN_VALUE);
			}

			public Object replaceToClient() {
				return Integer.MIN_VALUE;
			}

		};
	}

	void onSuccess() {
		System.out.println("age = " + age);
	}
}
