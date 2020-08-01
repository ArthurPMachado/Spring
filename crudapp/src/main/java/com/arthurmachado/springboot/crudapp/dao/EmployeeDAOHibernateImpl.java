package com.arthurmachado.springboot.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
	@Transactional
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

}
