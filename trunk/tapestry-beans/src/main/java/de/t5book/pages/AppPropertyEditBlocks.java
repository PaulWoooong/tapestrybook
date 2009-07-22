package de.t5book.pages;

import org.apache.tapestry5.FieldValidator;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.DateField;
import org.apache.tapestry5.services.PropertyEditContext;

public class AppPropertyEditBlocks {
	@Property
	@Environmental
	private PropertyEditContext context;

	@Component(parameters = { "value=context.propertyValue",
			"label=prop:context.label", "clientId=prop:context.propertyid",
			"validate=prop:dateFieldValidator" })
	private DateField dateField;

	public FieldValidator getDateFieldValidator() {
		return context.getValidator(dateField);
	}
}