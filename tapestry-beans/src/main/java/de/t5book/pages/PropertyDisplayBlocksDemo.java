package de.t5book.pages;

import java.util.GregorianCalendar;

import de.t5book.entities.Holiday;

public class PropertyDisplayBlocksDemo {

	public Holiday getHoliday() {
		Holiday holiday = new Holiday();
		holiday.setFrom(new GregorianCalendar(1970, 0, 1));
		holiday.setTo(new GregorianCalendar());
		return holiday;
	}
}
