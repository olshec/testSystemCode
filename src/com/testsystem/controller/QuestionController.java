package com.testsystem.controller;

import java.util.List;
import com.testsystem.models.Answer;
import com.testsystem.models.Group;
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
	public QuestionController() {}

	
	/**
	 * Gets new Question.
	 */
	public static Question getNewQuestion(String text) {
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
	 * @param text       the text question
	 * @param idQuestion the ID question
	 */
	public void setText(String text) {
		question.setText(text);
	}

	/**
	 * Gets answers to a question.
	 * 
	 * @param idQuestion 	the index question
	 * @return 				the answers
	 */
	public List<Answer> getAnswers() {
		return question.getAnswers();
	}

	/**
	 * Set answers.
	 * 
	 * @param answers    the answers
	 */
	public void setAnswers(List<Answer> answers) {
		question.setAnswers(answers);
	}
}
