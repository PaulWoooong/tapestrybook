package de.t5book.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class AutocompleteDemo {
	@Inject
	private Locale locale;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String country;

	List<String> onProvideCompletionsFromCountry(String input) {
		List<String> result = new ArrayList<String>();

		Locale[] locales = Locale.getAvailableLocales();
		for (Locale next : locales) {
			String country = next.getDisplayCountry(locale);
			if (country.toLowerCase().contains(input.toLowerCase())) {
				result.add(country);
			}
		}
		return result;
	}
}
