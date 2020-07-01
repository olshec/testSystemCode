package com.testsystem.models;

import java.util.List;
import java.util.Random;

/**
 * Represents a question.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Question {
	private String text;
	private List<Answer> answers;
	private Integer ID;
	private static Integer idIncrement;
	
	static {
		idIncrement=0;
	}
	
	/** Creates a QuestionModel.
	 * @param text The question’s text.
	 */
	public Question(String text) {
		this.ID=Question.idIncrement;
		Question.idIncrement++;
		setText(text);
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * @return the ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param ID the ID to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	
	
	
}
