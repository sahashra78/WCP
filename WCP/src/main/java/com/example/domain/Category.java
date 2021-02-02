package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //Converting POJO's to JPA Entities, that can be persisted by hibernate to a database
public class Category {
	@Id //Initializing below variable as Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Declaring the generation type, for auto incremental value
	private Long categoryId;
	@NonNull
	private String categoryName;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<Product> productList;

	
}
