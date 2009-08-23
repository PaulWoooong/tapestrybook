package de.t5book.pages.book;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import de.t5book.entities.Book;

public class ViewBook {

	@PageActivationContext
	@Property(write=false)
	private Book book;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	Object onActionFromAddToShoppingCart(Book book) {
		System.err.println("onActionFromShoppingCartLink: " + book);
		return pageRenderLinkSource.createPageRenderLinkWithContext(ViewBook.class, book);
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

}
