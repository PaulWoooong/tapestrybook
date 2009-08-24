package de.t5book.components;

import org.apache.tapestry5.annotations.Component;

public class Outer {
	@Component(publishParameters = "value")
	private Inner inner;

}
