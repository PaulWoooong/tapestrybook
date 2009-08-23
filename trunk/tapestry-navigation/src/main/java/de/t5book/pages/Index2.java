package de.t5book.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import de.t5book.entities.Book;
import de.t5book.pages.book.ViewBook;
import de.t5book.services.BookService;

public class Index2 {
	@Property
	private Book currentBook;

	@Inject
	private BookService bookService;

	@InjectPage
	private ViewBook viewBook;

	public List<Book> getBooks() {
		return bookService.findAllBooks();
	}

	Object onAction(Book book) {
		System.out.println("onAction()");
		viewBook.setBook(book);
		return viewBook;
	}

}
