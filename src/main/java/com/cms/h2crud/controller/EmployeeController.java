package com.cms.h2crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.h2crud.model.Employee;
import com.cms.h2crud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Object>(employeeService.saveEmployee(employee), HttpStatus.OK);
	}

	@PutMapping
	ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Object>(employeeService.updateEmployee(employee), HttpStatus.OK);
	}

	@DeleteMapping("/{employeeId}")
	ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/{employeeId}")
	ResponseEntity<Object> getEmployee(@PathVariable Long employeeId) {
		return new ResponseEntity<Object>(employeeService.getEmployee(employeeId), HttpStatus.OK);
	}

	@GetMapping
	ResponseEntity<Object> getAllEmployees() {
		return new ResponseEntity<Object>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

}
