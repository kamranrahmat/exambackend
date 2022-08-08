package com.exam.portal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.model.exam.Category;
import com.exam.portal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	public List<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(boolean value);
	
	public List<Quiz> findByCategoryAndActive(Category category,boolean value);
	
}
