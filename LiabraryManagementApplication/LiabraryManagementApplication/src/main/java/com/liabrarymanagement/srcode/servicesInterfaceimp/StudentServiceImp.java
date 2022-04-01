package com.liabrarymanagement.srcode.servicesInterfaceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liabrarymanagement.srcode.entity.Student;
import com.liabrarymanagement.srcode.repository.StudentRepositoryInterface;
import com.liabrarymanagement.srcode.servicesInterface.StudentServiceInterface;

@Service
public class StudentServiceImp implements StudentServiceInterface {
	@Autowired
	StudentRepositoryInterface repo ; 
	@Override
	public void saveStudent(Student s) {
		repo.save(s);
		
	}
	public Student getStudentByName(String n)
	{
		return repo.findByName(n);
	}

}
