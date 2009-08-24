package de.t5book.services.impl;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.ioc.MessageFormatter;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.validator.AbstractValidator;

public class AlphanumericValidator extends AbstractValidator<Void, String> {

	public AlphanumericValidator() {
		super(null, String.class, "not-alphanumeric");
	}

	public void render(Field field, Void constraintValue,
			MessageFormatter formatter, MarkupWriter writer,
			FormSupport formSupport) {
		 formSupport.addValidation(field, "alphanumeric", buildMessage(formatter, field), null);
	}

	public void validate(Field field, Void constraintValue,
			MessageFormatter formatter, String value)
			throws ValidationException {
		if (!value.matches("[a-zA-Z0-9]+")) {
			throw new ValidationException(buildMessage(formatter, field));
		}
	}

	private String buildMessage(MessageFormatter formatter, Field field) {
		return formatter.format(field.getLabel());
	}

}
