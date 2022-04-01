package com.liabrarymanagement.srcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liabrarymanagement.srcode.entity.Student;
@Repository
public interface StudentRepositoryInterface extends JpaRepository<Student, Long> {
	Student findByName(String Name );
}
