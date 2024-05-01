package com.exam.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepositary;

import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepositary quizRepositary;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepositary.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepositary.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<>(this.quizRepositary.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		return this.quizRepositary.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		
		this.quizRepositary.deleteById(quizId);
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		
		return this.quizRepositary.findBycategory(category);
	}

	//get active quizzes
	
	@Override
	public List<Quiz> getActiveQuizzes() {
		
		return this.quizRepositary.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		
		return this.quizRepositary.findByCategoryAndActive(c,  true);
	}

}
