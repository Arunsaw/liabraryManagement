package com.liabrarymanagement.srcode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_categories")
public class Categories {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private Long id  ; 
	@Column(name = "category_name")
	private String name ; 
	
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
 
    public Categories() {
		
	}
	public Categories(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

}
