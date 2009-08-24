package de.t5book.components;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;

public class Outer2 {
	@Parameter
	private String text;
	
	@Component(parameters="value=inherit:text")
	private Inner inner;
	
	@Component(parameters="value=inherit:text")
	private Inner inner2;
}
 