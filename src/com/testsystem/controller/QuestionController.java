package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Answer;
import com.testsystem.models.Question;

/**
 * Represents a question controller.
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public class QuestionController {
	private List<Question> questionsModel;

	/** 
	 * Creates a QuestionController.
	 */
	public QuestionController() {
		questionsModel=new ArrayList<Question>();
	}
	
	/**
	 * @param idQuestion the index question
	 * @return the text question
	 */
	public String getText(int idQuestion) {
		return questionsModel.get(idQuestion).getText();
	}
	
	/**
	 * Set text question
	 * @param text the text question
	 * @param idQuestion the index question
	 */
	public void setText(String text, int idQuestion) {
		questionsModel.get(idQuestion).setText(text);
	}

	/**
	 * @param idQuestion the index question
	 * @return the answers
	 */
	public List<Answer> getAnswers(int idQuestion) {
		return questionsModel.get(idQuestion).getAnswers();
	}

	/**
	 * Set answers
	 * @param answers the answers
	 * @param idQuestion the index question
	 */
	public void setAnswers(List<Answer> answers,int idQuestion) {
		questionsModel.get(idQuestion).setAnswers(answers);
	}
	
	/**
	 * @param question the question to add
	 */
	public void addQuestion(Question question) {
		questionsModel.add(question);
	}

}
