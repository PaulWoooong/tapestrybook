package de.t5book.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.json.JSONObject;

public class BasicAjax3 {
	@InjectComponent
	@Property
	private Zone output;

	@Property
	@Persist
	private int number;

	Object onActionFromIncrement() {
		number++;
		return output.getBody();
	}

	Object onActionFromReset() {

		number = 0;
		JSONObject json = new JSONObject();
		json.put("content", "Der Zähler wurde zurückgesetzt.");
		return json;
	}
}
