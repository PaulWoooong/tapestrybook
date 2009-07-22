package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import de.t5book.entities.Holiday;

public class PropertyEditBlocksDemo {
	@Property
	@Persist
	private Holiday holiday;

}
