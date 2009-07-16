package de.t5book.entities;

import org.apache.tapestry5.ioc.annotations.Inject;

public class NumericParameter extends ReportParameter<Number> {

	@Inject
	public NumericParameter() {
		super();
	}

	public NumericParameter(String name) {
		super(name);

	}

}
