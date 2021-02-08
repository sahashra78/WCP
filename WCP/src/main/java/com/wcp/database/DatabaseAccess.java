package com.wcp.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Product;

@Repository
public class DatabaseAccess {
	
	@Autowired
	public NamedParameterJdbcTemplate jdbc;
	
	public ArrayList<Product> getAllProducts(){
		
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "Select * from ProductList";
		products = (ArrayList<Product>)this.jdbc.query(query, 
				new BeanPropertyRowMapper<Product>(Product.class));
		return products;
	}
	

}