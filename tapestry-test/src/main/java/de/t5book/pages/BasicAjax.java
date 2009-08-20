package de.t5book.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class BasicAjax {
	@InjectComponent
	@Property
	private Zone output;

	@Property
	@Persist
	private int number;

	Object onActionFromIncrement() {
		System.err.println("onActionFromIncrement()");
		number++;
		return output.getBody();
	}

	Object onActionFromReset() {
		number = 0;
		return output.getBody();
	}
}
