package de.t5book.entities;

import java.util.Calendar;

public class Holiday {
	private Calendar from;
	private Calendar to;
	public Calendar getFrom() {
		return from;
	}
	public void setFrom(Calendar from) {
		this.from = from;
	}
	public Calendar getTo() {
		return to;
	}
	public void setTo(Calendar to) {
		this.to = to;
	}
}
