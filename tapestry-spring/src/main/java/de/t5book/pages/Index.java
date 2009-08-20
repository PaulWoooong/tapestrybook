package de.t5book.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

import de.t5book.services.impl.ExampleBean;

public class Index {
	@Inject
	private ExampleBean exampleBean;

	@Inject
	@Property
	private ApplicationContext applicationContext;
	
	void onActivate(){
		exampleBean.doWork("test");
	}
}
