package com.testsystem.controller.test;

import com.testsystem.model.test.ResultQuestion;

public class ResultQuestionController {

	private ResultQuestion resultQuestion;
	/**
	 * 
	 */
	public ResultQuestionController() {
		super();
	}

	/**
	 * @param resultQuestion
	 */
	public ResultQuestionController(ResultQuestion resultQuestion) {
		super();
		this.resultQuestion = resultQuestion;
	}

	/**
	 * @return the resultQuestion
	 */
	public ResultQuestion getResultQuestion() {
		return resultQuestion;
	}

	/**
	 * @param resultQuestion the resultQuestion to set
	 */
	public void setResultQuestion(ResultQuestion resultQuestion) {
		this.resultQuestion = resultQuestion;
	}
}
