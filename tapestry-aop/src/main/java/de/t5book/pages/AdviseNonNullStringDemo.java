package de.t5book.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import de.t5book.services.StringService;

public class AdviseNonNullStringDemo {
	@Inject
	private StringService stringService;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String output;
	
	void onActionFromNonEmpty(){
		output = stringService.doWork("foo bar");
	}
	
	void onActionFromEmpty(){
		output = stringService.doWork(null);
	}
}
