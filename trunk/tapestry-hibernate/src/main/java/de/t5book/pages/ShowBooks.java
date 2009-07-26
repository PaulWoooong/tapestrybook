package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.t5book.entities.Book;

public class ShowBooks {
	@Inject
	private Session session;
	@Property
	private Book currentBook;

	public GridDataSource getBooks() {
		return new HibernateGridDataSource(session, Book.class) {
			protected void applyAdditionalConstraints(Criteria criteria) {
				criteria.add(Restrictions.lt("price", new Double(50)));
			}
		};
	}

}
