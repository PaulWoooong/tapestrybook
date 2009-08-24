package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;

import de.t5book.entities.Book;
import de.t5book.entities.User;

public class Index {
	@Property
	private User user;

	@Property
	private Book book;
	
	void onActivate() {
		user  = new User();
		user.setId(123l);

		book= new Book();
		book.setId(1l);
	}

}
