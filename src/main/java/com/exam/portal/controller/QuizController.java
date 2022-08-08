package com.exam.portal.controller;

import java.util.List;

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

import com.exam.portal.model.exam.Category;
import com.exam.portal.model.exam.Quiz;
import com.exam.portal.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired()
	private QuizService quizService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
		
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@GetMapping("/{qId}")
	public Quiz getQuiz(@PathVariable("qId") Long qId) {
		return this.quizService.getQuiz(qId);
	}
	
	@DeleteMapping("/{qId}")
	public void deleteQuiz(@PathVariable("qId") Long qId) {
		this.quizService.deleteQuiz(qId);
	}
	
	@GetMapping("/category/{cat_id}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cat_id") Long cat_id){
		Category category=new Category();
		category.setCid(cat_id);
		return this.quizService.getQuizOfCategory(category);
	}
	
	@GetMapping("/category/active/{cat_id}")
	public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cat_id") Long cat_id){
		Category category=new Category();
		category.setCid(cat_id);
		return this.quizService.getActiveQuizOfCategory(category);
	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getActiveQuizzes(){
		return ResponseEntity.ok(this.quizService.getActiveQuizzes());
	}
	
}
