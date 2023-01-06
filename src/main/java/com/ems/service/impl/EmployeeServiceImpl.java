package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
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

}
