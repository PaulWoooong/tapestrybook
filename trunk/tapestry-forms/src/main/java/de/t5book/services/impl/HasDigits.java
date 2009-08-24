package de.t5book.services.impl;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.ioc.MessageFormatter;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.validator.AbstractValidator;

public class HasDigits extends AbstractValidator<Integer, String> {

	public HasDigits() {
		super(Integer.class, String.class, "has-digits");
	}

	public void validate(Field field, Integer constraintValue,
			MessageFormatter formatter, String value)
			throws ValidationException {

		int count = 0;

		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) {
				count++;
			}
		}
		if (count != constraintValue) {
			String message = formatter
					.format(field.getLabel(), constraintValue);
			throw new ValidationException(message);
		}
	}

	public void render(Field field, Integer constraintValue,
			MessageFormatter formatter, MarkupWriter writer,
			FormSupport formSupport) {
	}
}
