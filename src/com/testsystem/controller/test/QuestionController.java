package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.Answer;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultAnswers;
import com.testsystem.model.test.ResultQuestion;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a question controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class QuestionController {

	private Question question;

	/**
	 * 
	 */
	public QuestionController() {
		super();
	}

	/**
	 * @param question
	 */
	public QuestionController(Question question) {
		super();
		this.question = question;
	}

	/**
	 * Gets new Question.
	 */
	public Question getNewQuestion(String text) {
		return new Question(text);
	}
	
	/**
	 * Gets question text.
	 * 
	 * @return the text question
	 */
	public String getText() {
		return question.getText();
	}

	/**
	 * Set text question.
	 * 
	 * @param text the text question
	 */
	public void setText(String text) {
		question.setText(text);
	}

	/**
	 * Gets answers to a question.
	 * 
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return question.getAnswers();
	}

	/**
	 * Set answers.
	 * 
	 * @param answers the answers
	 */
	public void setAnswers(List<Answer> answers) {
		question.setAnswers(answers);
	}

}
