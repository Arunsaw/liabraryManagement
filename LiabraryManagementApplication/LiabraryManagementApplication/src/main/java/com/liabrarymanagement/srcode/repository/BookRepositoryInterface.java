package com.liabrarymanagement.srcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liabrarymanagement.srcode.entity.Books;
@Repository
public interface BookRepositoryInterface extends JpaRepository<Books,Long> {
	

	}


