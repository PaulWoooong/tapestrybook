package de.t5book.components;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Parameter;

public class Inner {
	@Parameter
	private String value;

	boolean beginRender(MarkupWriter writer) {
		writer.writeRaw(value);
		return false;
	}
}
