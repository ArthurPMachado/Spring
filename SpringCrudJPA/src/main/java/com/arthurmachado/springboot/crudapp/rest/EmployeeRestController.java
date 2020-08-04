package com.arthurmachado.springboot.crudapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurmachado.springboot.crudapp.entity.Employee;
import com.arthurmachado.springboot.crudapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	// Inject employee dao (use constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	// Add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return employee;
	}
	
	// Add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		// Also just in case they pass an id in JSON ... set id to 0
		// This is to force a save of new item ... instead of update
		
		employee.setId(0);
		
		employeeService.save(employee);
				
		return employee;
	}
	
	// Add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		
		return employee;
	}
	
	// Add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		
		// Throw exception if null
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
}
