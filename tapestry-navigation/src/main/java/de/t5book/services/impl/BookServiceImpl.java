package de.t5book.services.impl;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.tapestry5.hibernate.HibernateSessionManager;

import de.t5book.entities.Book;
import de.t5book.services.BookService;

public class BookServiceImpl implements BookService {

	private HibernateSessionManager hibernateSessionManager;

	public BookServiceImpl(HibernateSessionManager hibernateSessionManager) {
		super();
		this.hibernateSessionManager = hibernateSessionManager;
		createDemoData();
	}

	public List<Book> findAllBooks() {
		return hibernateSessionManager.getSession().createCriteria(Book.class)
				.list();
	}

	public Book findBookById(Long id) {
		return (Book) hibernateSessionManager.getSession().load(Book.class, id);
	}

	public void save(Book book) {
		hibernateSessionManager.getSession().saveOrUpdate(book);
	}

	private void createDemoData() {
		save(createBook("Tapestry 5", "Igor Drobiazko", newDate(2009, 8, 28),
				"978-3827328441", 29.95));
		save(createBook("Java Persistence with Hibernate", "Christian Bauer",
				newDate(2009, 11, 7), "978-1932394887", 43.95));
		save(createBook("Design Patterns", "Erich Gamma et al.", newDate(1995,
				3, 14), "978-0201633610", 40.95));
		save(createBook("Effective Java", "Joshua Bloch", newDate(2008, 4, 22),
				"978-0321356680", 37.95));
		save(createBook("Eclipse Modeling Framework", "David Steinberg et al.",
				newDate(2009, 0, 28), "978-0321331885", 35.95));
		save(createBook("The Pragmatic Programmer", "Andrew Hunt et al.",
				newDate(1999, 10, 24), "978-0201616224", 27.95));
		save(createBook("Patterns of Enterprise Application Architecture", "Martin Fowler",
				newDate(2002, 10, 15), "978-0321127426", 37.95));
		save(createBook("Handbuch der Java-Programmierung", "Guido Krüger et al.",
				newDate(2009, 6, 29), "978-3827323736", 49.80));
		save(createBook("Refactoring to Patterns", "Joshua Kerievsky", newDate(
				2004, 7, 24), "978-0321213358", 37.95));

		hibernateSessionManager.commit();
	}
	
	private Book createBook(String title, String author, Date publicationDate,
			String isbn, Double price) {
		return new Book(title, author, publicationDate, isbn, price);
	}
	
	private Date newDate(int year, int month, int day) {
		return new GregorianCalendar(year, month, day).getTime();
	}

	public void delete(Book book) {
		hibernateSessionManager.getSession().delete(book);
	}

}
