package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
