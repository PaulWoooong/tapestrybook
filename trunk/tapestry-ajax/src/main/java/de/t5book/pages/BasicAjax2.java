package de.t5book.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

@IncludeJavaScriptLibrary("basic.js")
public class BasicAjax2 {
	@InjectComponent 
	@Property
	private Zone output;
	
	@Inject
	private Block messageContent;
	
	@Property
	@Persist
	private int number;
	
	Object onActionFromIncrement(){
		number++;
		return output.getBody();
	}
	
	Object onActionFromReset(){

		number = 0;
		return messageContent;
	}
}
