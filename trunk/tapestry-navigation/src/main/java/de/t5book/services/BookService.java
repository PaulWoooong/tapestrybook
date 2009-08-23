package de.t5book.services;

import java.util.List;

import de.t5book.entities.Book;

public interface BookService {
	 List<Book> findAllBooks();
	 
	 Book findBookById(Long id);
	 
	 public void save(Book book);
	 
	 public void delete(Book book);
}
