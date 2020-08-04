package com.arthurmachado.springboot.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arthurmachado.springboot.crudapp.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// Define field for EntityManager
	private EntityManager manager;
	
	// Set up Constructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// Get the current hibernate session
		Session currentSession = manager.unwrap(Session.class);
		
		// Create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// Execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// Return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// Get the current hibernate session
		Session currentSession = manager.unwrap(Session.class);
		
		// Get the employee
		Employee employee = currentSession.get(Employee.class, id);
		
		// Return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// Get the current hibernate session
		Session currentSession = manager.unwrap(Session.class);
		
		// Save employee
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		
		// Get the current hibernate session
		Session currentSession = manager.unwrap(Session.class);
		
		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
	
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
