package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;

public class ResultQuestion extends Model {
	
	private int numberCorrectAnswers;
	private int numberNotCorrectAnswer;
	private double percentCorrectAnswers;
	private List<Answer> answers;
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
	public ResultQuestion(List<Answer> answers, Question question) {
		super();
		this.answers = answers;
		this.question = question;
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
	public int getNumberNotCorrectAnswer() {
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
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultQuestion";
	}
}
