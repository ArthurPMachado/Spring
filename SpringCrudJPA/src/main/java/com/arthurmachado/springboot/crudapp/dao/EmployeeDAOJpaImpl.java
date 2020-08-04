package com.arthurmachado.springboot.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arthurmachado.springboot.crudapp.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager manager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public List<Employee> findAll() {
		// Create a query
		Query query = manager.createQuery("from Employee");
		
		// Execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// Return
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// Get employee
		Employee employee = manager.find(Employee.class, id);
		
		// Return employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// Save or update the employee
		Employee dbEmployee = manager.merge(employee);
		
		// Update with id from db ... so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		// Delete object with primary key
		Query query = manager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
