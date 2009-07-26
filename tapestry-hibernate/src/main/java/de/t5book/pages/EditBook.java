package de.t5book.pages;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import de.t5book.entities.Book;

public class EditBook {
	@PageActivationContext
	@Property
	@Persist("entity")
	private Book book;

	@Inject
	private Session session;

	@CommitAfter
	Object onSuccess() {
		session.update(book);
		return ShowBooks.class;
	}
}
