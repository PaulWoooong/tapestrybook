package de.t5book.pages;

import java.util.Date;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class DateFieldExample {
	@Persist
	@Property
	private Date birthday;

	void onSuccess() {
		System.out.println("birthday = " + birthday);
	}
}
