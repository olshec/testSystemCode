package com.testsystem.model.test;

import com.testsystem.model.Model;

public class ResultQuestion extends Model {
	
	private int numberCorrectAnswers;
	private int numberNotCorrectAnswer;
	private double percentCorrectAnswers;
	private Question question;

	/**
	 * 
	 */
	public ResultQuestion() {
		super();
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
	 * @return the numberNotCorrectAnswer
	 */
	public int getNumberNotCorrectAnswers() {
		return numberNotCorrectAnswer;
	}

	/**
	 * @param numberNotCorrectAnswer the numberNotCorrectAnswer to set
	 */
	public void setNumberNotCorrectAnswer(int numberNotCorrectAnswer) {
		this.numberNotCorrectAnswer = numberNotCorrectAnswer;
	}

	/**
	 * @return the percentCorrectAnswers
	 */
	public double getPercentCorrectAnswers() {
		return percentCorrectAnswers;
	}

	/**
	 * @param percentCorrectAnswers the percentCorrectAnswers to set
	 */
	public void setPercentCorrectAnswers(double percentCorrectAnswers) {
		this.percentCorrectAnswers = percentCorrectAnswers;
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultQuestion";
	}
}
