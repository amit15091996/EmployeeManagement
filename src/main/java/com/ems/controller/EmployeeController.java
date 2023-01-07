package com.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emp")
	public List<Employee> getAllEmp() {
		return employeeService.getAll();
	}

	@PostMapping("/add")
	public Employee create(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}

	@GetMapping("/emp/{id}")
	public Employee getEmpById(@PathVariable Integer id) {
		return employeeService.getByID(id);
	}

	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/del/{id}")
	public void deleteEmp(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}
}
