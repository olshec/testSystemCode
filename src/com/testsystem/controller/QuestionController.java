package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.models.Answer;
import com.testsystem.models.Question;

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
	 * Creates a QuestionController.
	 */
	public QuestionController() {
	}

	/**
	 * Gets question text.
	 * 
	 * @param idQuestion The ID question
	 * @return The text question
	 */
	public String getText() {
		return question.getText();
	}

	/**
	 * Set text question
	 * 
	 * @param text       The text question
	 * @param idQuestion The ID question
	 */
	public void setText(String text) {
		question.setText(text);
	}

	/**
	 * Gets answers to a question
	 * 
	 * @param idQuestion the index question
	 * @return The answers
	 */
	public List<Answer> getAnswers() {
		return question.getAnswers();
	}

	/**
	 * Set answers
	 * 
	 * @param answers    The answers
	 * @param idQuestion The index question
	 */
	public void setAnswers(List<Answer> answers) {
		question.setAnswers(answers);
	}

}
