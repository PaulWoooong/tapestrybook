package de.t5book.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import de.t5book.entities.Employee;
import de.t5book.services.EmployeeService;

@IncludeJavaScriptLibrary("AutocompleteExtDemo.js")
public class AutocompleteExtDemo {

	@Inject
	private EmployeeService employeeService;
	
	@Property
	private Long employeeId;
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private Employee employee;
	
	void onSuccess(){
		employee = employeeService.findById(employeeId);
	}

	Employee[] onProvideCompletionsFromEmployee(String input) {
		return employeeService.findByName(input);
	}
}
