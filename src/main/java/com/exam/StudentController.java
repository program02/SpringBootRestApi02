package com.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/")
public class StudentController {
	StudentRepository studentRepository;
	List<Student> stList;
	Student student;
	@Autowired
	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@GetMapping("students")
	public List<Student> findStudents() {
		stList = new ArrayList<>();
		stList = studentRepository.findAll();
		return stList;
	}
	@GetMapping("student/{id}")
	public Student findStudent(@PathVariable Integer id) {
		student = new Student();
		student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		return student;
	}
	


}
