package com.liabrarymanagement.srcode.servicesInterface;

import org.springframework.stereotype.Service;

import com.liabrarymanagement.srcode.entity.Student;

@Service
public interface StudentServiceInterface {
	
	
	public void saveStudent(Student s);
	public Student getStudentByName(String n);

}
