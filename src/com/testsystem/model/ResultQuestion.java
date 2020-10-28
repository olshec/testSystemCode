package com.testsystem.model;

import java.util.List;

public class ResultQuestion {
	
	private int numberAnswers;
	private int numberCorrectAnswers;
	private int percentCorrectAnswers;
	private Question question;
	
	/**
	 * 
	 */
	public ResultQuestion() {
		super();
	}
	/**
	 * @param numberAnswers
	 * @param numberCorrectAnswers
	 * @param percentCorrectAnswers
	 * @param question
	 */
	public ResultQuestion(int numberAnswers, int numberCorrectAnswers, int percentCorrectAnswers, Question question) {
		super();
		setNumberAnswers(numberAnswers);
		setNumberCorrectAnswers(numberCorrectAnswers);
		setPercentCorrectAnswers(percentCorrectAnswers);
		setQuestion(question);
	}
	/**
	 * @return the numberAnswers
	 */
	public int getNumberAnswers() {
		return numberAnswers;
	}
	/**
	 * @param numberAnswers the numberAnswers to set
	 */
	public void setNumberAnswers(int numberAnswers) {
		this.numberAnswers = numberAnswers;
	}
	/**
	 * @return the numberCorrectAnswers
	 */
	public int getNumberCorrectAnswers() {
		return numberCorrectAnswers;
	}
	/**
	 * @param numberCorrectAnswers the numberCorrectAnswers to set
	 */
	public void setNumberCorrectAnswers(int numberCorrectAnswers) {
		this.numberCorrectAnswers = numberCorrectAnswers;
	}
	/**
	 * @return the percentCorrectAnswers
	 */
	public int getPercentCorrectAnswers() {
		return percentCorrectAnswers;
	}
	/**
	 * @param percentCorrectAnswers the percentCorrectAnswers to set
	 */
	public void setPercentCorrectAnswers(int percentCorrectAnswers) {
		this.percentCorrectAnswers = percentCorrectAnswers;
	}
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
