package com.liabrarymanagement.srcode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	@Column
	private String name ; 
	
	@OneToOne(fetch = FetchType.LAZY , mappedBy = "student")
	private Books issuedBook ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Books getIssuedBook() {
		return issuedBook;
	}

	public void setIssuedBook(Books books) {
		this.issuedBook = books;
	}

	
	
	

}
