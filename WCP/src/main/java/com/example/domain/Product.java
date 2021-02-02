package com.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //Converting POJO's to JPA Entity, that can be persisted by hibernate to a database
public class Product {
	@Id //Initializing the below variable as Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Declaring the generation type, for auto incremental value
	private Long productId;
	@NonNull
	private String productName;
	@NonNull
	private Double price;
	@NonNull
	private String description;
	@NonNull
	private String image;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	
}
