package de.t5book.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import de.t5book.entities.Book;
import de.t5book.services.BookService;

public class Index {
	@Property
	private Book currentBook;

	@Inject
	private BookService bookService;

	public List<Book> getBooks() {
		return bookService.findAllBooks();
	}

	Object onActionFromX() {
		System.out.println("onActionFromX()");
		return "MyPage";
	}

	Object onActionFromY() {
		System.out.println("onActionFromY()");
		return MyPage.class;
	}

}
