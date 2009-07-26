package de.t5book.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import de.t5book.services.AdderService;

public class AdviseNonNullDemo {
	@Inject
	private AdderService adderService;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private Integer result;
	
	@OnEvent(value="action", component="add")
	public void add2And3(){
		result = adderService.add(2,3);
	}
	
	@OnEvent(value="action", component="add2")
	public void add2AndNull(){
		result = adderService.add(2,null);
	}
}
