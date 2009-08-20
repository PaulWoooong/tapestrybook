package de.t5book.services.impl;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import de.t5book.services.MyService;

public class ExampleBean {
	private MyService myService;
	private AnotherBean anotherBean;

	@Autowired
	public ExampleBean(@Inject MyService myService, AnotherBean anotherBean ) {
		super();
		this.myService = myService;
		this.anotherBean = anotherBean;
	}

	public void doWork(String input) {
		System.err.println("ExampleBean.doWork(" + input + ")");
		myService.doBusiness(input);
		anotherBean.doSomething(input);
	}
}
