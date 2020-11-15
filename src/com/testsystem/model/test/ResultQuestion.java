package com.testsystem.model.test;

import com.testsystem.model.Model;

/**
 * @author user1
 *
 */
public class ResultQuestion extends Model {
	
	public enum StateQuestion {Correct, Incorrect, Partly, Skipped}
	
	private int percentCorrectAnswers;
	private int numberCorrectAnswers;
	private int numberNotCorrectAnswer;
	private Question question;
	private StateQuestion state;
	/**
	 * 
	 */
	public ResultQuestion() {
		super();
	}

	/**
	 * @param percentCorrectAnswers
	 * @param numberCorrectAnswers
	 * @param numberNotCorrectAnswer
	 * @param question
	 * @param state
	 */
	public ResultQuestion(int percentCorrectAnswers, int numberCorrectAnswers, int numberNotCorrectAnswer,
			Question question, StateQuestion state) {
		super();
		this.percentCorrectAnswers = percentCorrectAnswers;
		this.numberCorrectAnswers = numberCorrectAnswers;
		this.numberNotCorrectAnswer = numberNotCorrectAnswer;
		this.question = question;
		this.state = state;
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
	 * @return the state
	 */
	public StateQuestion getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(StateQuestion state) {
		this.state = state;
	}

	/**
	 * Prints result of question
	 */
	@Override
	public String toString() {
		return state.toString();
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
