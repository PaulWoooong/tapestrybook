package de.t5book.entities;

import java.util.Date;

import org.apache.tapestry5.ioc.annotations.Inject;

public class DateParameter extends ReportParameter<Date> {

	@Inject
	public DateParameter() {
		super();
	}

	public DateParameter(String name) {
		super(name);

	}

}
