package com.exam.portal.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.model.exam.Question;
import com.exam.portal.model.exam.Quiz;
import com.exam.portal.service.QuestionService;
import com.exam.portal.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	@GetMapping("/quiz{qId}")
	public ResponseEntity<?> getQuestions(@PathVariable("qId") Long quizId){
//		Quiz quiz=new Quiz();
//		quiz.setqId(quizId);
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz = this.quizService.getQuiz(quizId);
		Set<Question> questions = quiz.getQuestions();
		List list=new ArrayList<>(questions);
		
		if (list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{quizId}")
	public Question get(@PathVariable("quizId") Long quizId) {
		return this.questionService.getQuestion(quizId);
	}
	
	@DeleteMapping("/{questionId}")
	public void delete(@PathVariable("questionId") Long questionId) {
		 this.questionService.deleteQuestion(questionId);
	}
	
	
}
