package com.exam.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuestionRepositary;
import com.exam.repo.QuizRepositary;
import com.exam.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepositary questionRepositary;

	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepositary.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepositary.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepositary.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		
		return this.questionRepositary.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		
		return this.questionRepositary.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question = new Question();
		question.setQuesId(quesId);
		this.questionRepositary.delete(question);
		
	}

	@Override
	public Question get(Long questionsId) {
		
		return this.questionRepositary.getOne(questionsId);
	}

}
