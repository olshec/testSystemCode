package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;

public class ResultAnswers extends Model {
	
	private int numberCorrectAnswers;
	private int numberNotCorrectAnswer;
	private double percentCorrectAnswers;
	private List<Answer> answers;
	
	/**
	 * 
	 */
	public ResultAnswers() {
		super();
	}
	
	/**
	 * @param numberCorrectAnswers
	 * @param numberNotCorrectAnswer
	 * @param percentCorrectAnswers
	 * @param answers
	 */
	public ResultAnswers(List<Answer> answers) {
		super();
		this.answers = answers;
	}
	
	/**
	 * @param numberCorrectAnswers
	 * @param numberNotCorrectAnswer
	 * @param percentCorrectAnswers
	 * @param answers
	 */
	public ResultAnswers(int numberCorrectAnswers, int numberNotCorrectAnswer,
			double percentCorrectAnswers, List<Answer> answers) {
		super();
		this.numberCorrectAnswers = numberCorrectAnswers;
		this.numberNotCorrectAnswer = numberNotCorrectAnswer;
		this.percentCorrectAnswers = percentCorrectAnswers;
		this.answers = answers;
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
	 * @return the numberNotTrueAnswer
	 */
	public int getNumberNotCorrectAnswer() {
		return numberNotCorrectAnswer;
	}

	/**
	 * @param numberNotTrueAnswer the numberNotTrueAnswer to set
	 */
	public void setNumberNotCorrectAnswer(int numberNotTrueAnswer) {
		this.numberNotCorrectAnswer = numberNotTrueAnswer;
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "Question";
	}

}
