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
	private List<Question> questions;

	/** 
	 * Creates a QuestionController.
	 */
	public QuestionController() {
		questions=new ArrayList<Question>();
	}
	
	/**
	 * @param idQuestion the index question
	 * @return the text question
	 */
	public String getText(int idQuestion) {
		for(int i=0;i<questions.size();i++) {
			if(questions.get(i).getID()==idQuestion) {
				return questions.get(idQuestion).getText();
			}
		}
		return null;
		//return questionsModel.get(idQuestion).getText();
	}
	
	/**
	 * Set text question
	 * @param text the text question
	 * @param idQuestion the ID question
	 */
	public void setText(String text, int idQuestion) {
		for(int i=0;i<questions.size();i++) {
			if(questions.get(i).getID()==idQuestion) {
				questions.get(idQuestion).setText(text);
			}
		}
	}

	/**
	 * @param idQuestion the index question
	 * @return the answers
	 */
	public List<Answer> getAnswers(int idQuestion) {
		for(int i=0;i<questions.size();i++) {
			if(questions.get(i).getID()==idQuestion) {
				return questions.get(idQuestion).getAnswers();
			}
		}
		return null;
	}

	/**
	 * Set answers
	 * @param answers the answers
	 * @param idQuestion the index question
	 */
	public void setAnswers(List<Answer> answers,int idQuestion) {
		for(int i=0;i<questions.size();i++) {
			if(questions.get(i).getID()==idQuestion) {
				questions.get(idQuestion).setAnswers(answers);
			}
		}
	}
	
	/**
	 * @param question the question to add
	 */
	public void addQuestion(Question question) {
		questions.add(question);
	}

}
