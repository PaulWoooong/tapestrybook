package de.t5book.pages;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PropertyOutputContext;

public class AppPropertyDisplayBlocks {
	@Environmental
	private PropertyOutputContext context;

	@Inject
	private Locale locale;
	
	public Date getCalendarDate(){
		Calendar calendar = (Calendar) context.getPropertyValue();
		return calendar.getTime();
	}

	public DateFormat getDateFormat() {
		return DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
	}
}
