package de.t5book.entities;

import org.apache.tapestry5.ioc.annotations.Inject;

public class StringParameter extends ReportParameter<String> {

	@Inject
	public StringParameter() {
		super();
	}

	public StringParameter(String name) {
		super(name);

	}

}
