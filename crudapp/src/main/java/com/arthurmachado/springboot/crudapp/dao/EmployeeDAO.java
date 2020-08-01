package com.arthurmachado.springboot.crudapp.dao;

import java.util.List;

import com.arthurmachado.springboot.crudapp.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
}
