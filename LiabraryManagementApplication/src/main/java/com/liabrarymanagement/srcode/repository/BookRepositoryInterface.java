package com.liabrarymanagement.srcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liabrarymanagement.srcode.entity.Books;

public interface BookRepositoryInterface extends JpaRepository<Books,Long> {
	

	}


