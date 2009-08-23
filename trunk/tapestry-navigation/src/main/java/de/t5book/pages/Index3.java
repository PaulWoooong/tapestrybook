package de.t5book.pages;

import java.util.List;

import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import de.t5book.entities.Book;
import de.t5book.pages.book.ViewBook;
import de.t5book.services.BookService;

public class Index3 {
	@Property
	private Book currentBook;

	@Inject
	private BookService bookService;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	public List<Book> getBooks() {
		return bookService.findAllBooks();
	}

	Object onAction(Book book) {
		Link link = pageRenderLinkSource.createPageRenderLinkWithContext(
				ViewBook.class, book);
		System.out.println(link.toAbsoluteURI());

		return link;
	}

}
