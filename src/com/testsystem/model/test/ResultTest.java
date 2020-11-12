package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;

public class ResultTest extends Model {
	
	private int numberCorrectQuestions;
	private int numberNotCorrectQuestions;
	private int numberPartlyQuestion;
	private double percentCorrectQuestions;
	private User student;
	private Test test;
	private List<ResultQuestion> resultQuestions;
	
	/**
	 * 
	 */
	public ResultTest() {
		super();
	}
	
	/**
	 * @param student
	 * @param test
	 * @param result
	 * @param resultQuestions
	 */
	public ResultTest(User student, Test test, List<ResultQuestion> resultQuestions) {
		super();
		this.student = student;
		this.test = test;
		this.resultQuestions = resultQuestions;
	}

	/**
	 * @param numberCorrectQuestions
	 * @param numberNotCorrectQuestions
	 * @param numberPartlyQuestion
	 * @param percentCorrectQuestions
	 * @param student
	 * @param test
	 * @param resultQuestions
	 */
	public ResultTest(int numberCorrectQuestions, int numberNotCorrectQuestions, int numberPartlyQuestion,
			double percentCorrectQuestions, User student, Test test, List<ResultQuestion> resultQuestions) {
		super();
		this.numberCorrectQuestions = numberCorrectQuestions;
		this.numberNotCorrectQuestions = numberNotCorrectQuestions;
		this.numberPartlyQuestion = numberPartlyQuestion;
		this.percentCorrectQuestions = percentCorrectQuestions;
		this.student = student;
		this.test = test;
		this.resultQuestions = resultQuestions;
	}

	/**
	 * @param student
	 * @param test
	 * @param result
	 */
	public ResultTest(User student, Test test, Integer result) {
		super();
		this.student = student;
		this.test = test;
	}

	/**
	 * @return the student
	 */
	public User getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(User student) {
		this.student = student;
	}
	
	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * @return the resultQuestions
	 */
	public List<ResultQuestion> getResultQuestions() {
		return resultQuestions;
	}

	/**
	 * @param resultQuestions the resultQuestions to set
	 */
	public void setResultQuestions(List<ResultQuestion> resultQuestions) {
		this.resultQuestions = resultQuestions;
	}

	
	/**
	 * @return the numberCorrectQuestions
	 */
	public int getNumberCorrectQuestions() {
		return numberCorrectQuestions;
	}

	/**
	 * @param numberCorrectQuestions the numberCorrectQuestions to set
	 */
	public void setNumberCorrectQuestions(int numberCorrectQuestions) {
		this.numberCorrectQuestions = numberCorrectQuestions;
	}

	/**
	 * @return the numberNotCorrectQuestions
	 */
	public int getNumberNotCorrectQuestions() {
		return numberNotCorrectQuestions;
	}

	/**
	 * @param numberNotCorrectQuestions the numberNotCorrectQuestions to set
	 */
	public void setNumberNotCorrectQuestions(int numberNotCorrectQuestions) {
		this.numberNotCorrectQuestions = numberNotCorrectQuestions;
	}

	/**
	 * @return the percentCorrectQuestions
	 */
	public double getPercentCorrectQuestions() {
		return percentCorrectQuestions;
	}

	/**
	 * @param percentCorrectQuestions the percentCorrectQuestions to set
	 */
	public void setPercentCorrectQuestions(double percentCorrectQuestions) {
		this.percentCorrectQuestions = percentCorrectQuestions;
	}

	/**
	 * @return the numberPartlyQuestion
	 */
	public int getNumberPartlyQuestion() {
		return numberPartlyQuestion;
	}

	/**
	 * @param numberPartlyQuestion the numberPartlyQuestion to set
	 */
	public void setNumberPartlyQuestion(int numberPartlyQuestion) {
		this.numberPartlyQuestion = numberPartlyQuestion;
	}

	
	/**
	 * Prints result of test.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Количество верных вопросов: " + getNumberCorrectQuestions());
		result.append(System.getProperty("line.separator"));
		result.append("Количество неверных вопросов: " + getNumberNotCorrectQuestions());
		result.append(System.getProperty("line.separator"));
		result.append("Количество частично верных вопросов: " + getNumberPartlyQuestion());
		result.append(System.getProperty("line.separator"));
		result.append("Процент верных вопросов: " + getPercentCorrectQuestions() + "%");
		result.append(System.getProperty("line.separator"));
		
		return result.toString();
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultTest";
	}
}
