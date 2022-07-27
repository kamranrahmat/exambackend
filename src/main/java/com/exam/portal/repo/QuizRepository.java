package com.exam.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
