package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAll();

	Employee addEmployee(Employee emp);

	Employee getByID(Integer id);

	Employee updateEmployee(Employee emp);

	void deleteEmployee(Integer id);

}
