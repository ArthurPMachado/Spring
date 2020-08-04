package com.arthurmachado.springboot.crudapp.dao;

import java.util.List;

import com.arthurmachado.springboot.crudapp.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
