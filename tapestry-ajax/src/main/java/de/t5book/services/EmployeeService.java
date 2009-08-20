package de.t5book.services;

import de.t5book.entities.Employee;

public interface EmployeeService {
	Employee findById(Long id);
	Employee[] findByName(String name);
}
