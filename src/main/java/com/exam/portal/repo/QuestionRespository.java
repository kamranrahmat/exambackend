package com.exam.portal.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.model.exam.Question;
import com.exam.portal.model.exam.Quiz;

public interface QuestionRespository  extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz quiz);

}
