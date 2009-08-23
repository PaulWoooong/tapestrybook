package de.t5book.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tapestry5.ioc.annotations.Inject;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String title;
	@Column
	private String author;
	
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	@Column
	private String isbn;
	@Column
	private Double price;

	public Book(String title, String author, Date publicationDate, String isbn,
			Double price) {
		super();
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.isbn = isbn;
		this.price = price;
	}


	@Inject
	public Book() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
