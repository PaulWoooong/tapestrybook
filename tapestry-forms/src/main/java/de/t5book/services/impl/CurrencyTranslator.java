package de.t5book.services.impl;

import java.util.Currency;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.Translator;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.services.FormSupport;

public class CurrencyTranslator implements Translator<Currency> {

	public String getMessageKey() {
		return "currency-parse-exception";
	}

	public String getName() {
		return "currency";
	}

	public Class<Currency> getType() {
		return Currency.class;
	}

	public Currency parseClient(final Field field, final String clientValue,
			final String message) throws ValidationException {
		try {
			return Currency.getInstance(clientValue);
		} catch (final IllegalArgumentException e) {
			throw new ValidationException(message);
		}
	}

	public void render(final Field field, final String message,
			final MarkupWriter writer, final FormSupport formSupport) {

	}

	public String toClient(final Currency value) {
		return value.toString();
	}
}