package de.t5book.pages;

import java.util.Currency;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class CurrencyTranslatorExample {
	@Property
	@Persist(PersistenceConstants.FLASH)
	private Currency currency;

	void onSuccess() {
		System.err.println("Waehrung: " + currency);
	}

}