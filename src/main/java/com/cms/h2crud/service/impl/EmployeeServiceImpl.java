package com.cms.h2crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.h2crud.exception.EmployeeNotFoundException;
import com.cms.h2crud.model.Employee;
import com.cms.h2crud.repository.EmployeeRepository;
import com.cms.h2crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + employee.getId()));
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + employeeId));
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + employeeId));
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.isEmpty()) {
			throw new EmployeeNotFoundException("No employee found.");
		}
		return employeeRepository.findAll();
	}

}
