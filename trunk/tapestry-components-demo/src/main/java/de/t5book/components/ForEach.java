package de.t5book.components;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;

public class ForEach {
	@Parameter(value = "defaultValueForStartParameter")
	private int start;

	@Parameter(required = true)
	private int end;

	@Parameter
	private int step = 1;

	@Parameter
	private int value;

	@SetupRender
	void initializeValue() {
		value = start;
	}

	@AfterRender
	boolean next() {
		int newValue = value + step;

		if (newValue <= end) {
			value = newValue;
			return false;
		}

		return true;
	}

	public int getDefaultValueForStartParameter() {
		return 10;
	}

}
