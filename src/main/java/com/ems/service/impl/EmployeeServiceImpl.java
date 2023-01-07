package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.repo.EmployeeRepo;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAll() {
		return employeeRepo.findAll();

	}

	@Override
	public Employee addEmployee(Employee emp) {

		return employeeRepo.save(emp);
	}

	@Override
	public Employee getByID(Integer id) {
		return employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));
	}

	@Override
	public Employee updateEmployee(Employee emp) {

		Employee employee = employeeRepo.findById(emp.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + emp.getId()));

		employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setEmail(employee.getEmail());

		Employee empUpdated = employeeRepo.save(employee);

		return empUpdated;

	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}

}
