package com.testsystem.model.test;

import com.testsystem.model.Model;

/**
 * Represents a result of question.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ResultQuestion extends Model {
	
	public enum StateQuestion {Correct, Incorrect, Partly, Skipped}
	
	private int percentCorrectAnswers;
	private int numberCorrectAnswers;
	private int numberNotCorrectAnswers;
	private Question question;
	private StateQuestion stateQuestion;
	
	/**
	 * Creates a ResultQuestion.
	 */
	public ResultQuestion() {
		super();
	}

	/**
	 * Creates a ResultQuestion.
	 * 
	 * @param int percent of correct answers
	 * @param int number of correct answers
	 * @param int number of not correct answer
	 * @param Question the question
	 * @param StateQuestion the state of question
	 */
	public ResultQuestion(int percentCorrectAnswers, int numberCorrectAnswers, int numberNotCorrectAnswer,
			Question question, StateQuestion stateQuestion) {
		super();
		this.percentCorrectAnswers = percentCorrectAnswers;
		this.numberCorrectAnswers = numberCorrectAnswers;
		this.numberNotCorrectAnswers = numberNotCorrectAnswer;
		this.question = question;
		this.stateQuestion = stateQuestion;
	}

	/**
	 * Returns the question.
	 * 
	 * @return Question the question
	 */
	public Question getQuestion() {
		return question;
	}
	
	/**
	 * Sets the question.
	 * 
	 * @param Question the question
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	/**
	 * Returns the number of correct answers.
	 * 
	 * @return int the number of correct answers
	 */
	public int getNumberCorrectAnswers() {
		return numberCorrectAnswers;
	}

	/**
	 * Sets the number of correct answers.
	 * 
	 * @param int the number of correct answers
	 */
	public void setNumberCorrectAnswers(int numberCorrectAnswers) {
		this.numberCorrectAnswers = numberCorrectAnswers;
	}

	/**
	 * Returns the number of not correct answers.
	 * 
	 * @return int the number of not correct answers
	 */
	public int getNumberNotCorrectAnswers() {
		return this.numberNotCorrectAnswers;
	}

	/**
	 * Sets the number of not correct answers.
	 * 
	 * @param int the number of not correct answers
	 */
	public void setNumberNotCorrectAnswers(int numberNotCorrectAnswers) {
		this.numberNotCorrectAnswers = numberNotCorrectAnswers;
	}

	/**
	 * Returns the percent of correct answers.
	 * 
	 * @return int the percent of correct answers
	 */
	public int getPercentCorrectAnswers() {
		return percentCorrectAnswers;
	}

	/**
	 * Sets the percent of correct answers.
	 * 
	 * @param int the percent of correct answers
	 */
	public void setPercentCorrectAnswers(int percentCorrectAnswers) {
		this.percentCorrectAnswers = percentCorrectAnswers;
	}
	
	/**
	 * Returns the state of question.
	 * 
	 * @return StateQuestion the state of question
	 */
	public StateQuestion getState() {
		return stateQuestion;
	}

	/**
	 * Sets the state of question.
	 * 
	 * @param StateQuestion the state of question
	 */
	public void setState(StateQuestion state) {
		this.stateQuestion = state;
	}

	/**
	 * Prints result of question
	 * 
	 * @return String the result of question
	 */
	@Override
	public String toString() {
		return stateQuestion.toString();
	}

	/**
	 * Returns the name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultQuestion";
	}
}
