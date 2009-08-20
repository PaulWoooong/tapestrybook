package de.t5book.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class InPlaceEditorDemo {
	@Persist
	@Property
	private String edit;

	void onActivate() {
		if (edit == null) {
			edit = "Bitte hier Klicken";
		}
	}
}
