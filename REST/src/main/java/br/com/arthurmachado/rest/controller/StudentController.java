package br.com.arthurmachado.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthurmachado.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> theStudents;
	
	// Define @PostConstruct to load the student data ... only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}

	// Define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		
		return theStudents;
	}
}