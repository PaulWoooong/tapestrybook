package de.t5book.pages.view;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

import de.t5book.entities.Book;

public class ViewBook {
	@PageActivationContext
	@Property
	private Book book;
}
