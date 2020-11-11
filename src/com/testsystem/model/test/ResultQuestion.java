package com.testsystem.model.test;

import com.testsystem.model.Model;

public class ResultQuestion extends Model {
	
	private enum StateQuestion {Correct, Incorrect, Partly, Skipped}
	
	private int numberCorrectAnswers;
	private int numberNotCorrectAnswer;
	private double percentCorrectAnswers;
	private Question question;
	private StateQuestion state;
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
	 * Prints result of question
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(state);
		return result.toString();
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
