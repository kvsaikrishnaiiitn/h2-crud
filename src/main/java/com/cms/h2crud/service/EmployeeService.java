package com.cms.h2crud.service;

import java.util.List;

import com.cms.h2crud.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(Long employeeId);

	Employee getEmployee(Long employeeId);

	List<Employee> getAllEmployees();

}
