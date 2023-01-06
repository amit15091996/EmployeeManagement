package com.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public List<Employee> getAllEmp(){
	return	employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Employee create (@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
}
