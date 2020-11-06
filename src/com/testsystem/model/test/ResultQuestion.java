package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;

public class ResultQuestion extends Model {
	
	private ResultAnswers resultAnswers;
	private Question question;

	/**
	 * 
	 */
	public ResultQuestion() {
		super();
	}
	
	/**
	 * @param resultAnswers
	 * @param question
	 */
	public ResultQuestion(ResultAnswers resultAnswers, Question question) {
		super();
		this.resultAnswers = resultAnswers;
		this.question = question;
	}

	/**
	 * @return the resultAnswers
	 */
	public ResultAnswers getResultAnswers() {
		return resultAnswers;
	}

	/**
	 * @param resultAnswers the resultAnswers to set
	 */
	public void setResultAnswers(ResultAnswers resultAnswers) {
		this.resultAnswers = resultAnswers;
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
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultQuestion";
	}
}
