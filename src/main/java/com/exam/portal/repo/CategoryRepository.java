package com.exam.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
