package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exam.Category;

public interface CategoryRepositary extends JpaRepository<Category, Long>{

}
