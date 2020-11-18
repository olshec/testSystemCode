package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;

public class ResultTest extends Model {
	
	private int numberCorrectQuestions;
	private int numberNotCorrectQuestions;
	private int numberPartlyQuestion;
	private int numberSkippedQuestion;
	private int percentCorrectQuestions;
	private int points;
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
	 * @param numberCorrectQuestions
	 * @param numberNotCorrectQuestions
	 * @param numberPartlyQuestion
	 * @param numberSkippedQuestion
	 * @param percentCorrectQuestions
	 * @param student
	 * @param test
	 * @return resultQuestions
	 */
	public ResultTest(int numberCorrectQuestions, int numberNotCorrectQuestions, int numberPartlyQuestion,
			int numberSkippedQuestion, int percentCorrectQuestions, User student, Test test,
			List<ResultQuestion> resultQuestions) {
		super();
		this.numberCorrectQuestions = numberCorrectQuestions;
		this.numberNotCorrectQuestions = numberNotCorrectQuestions;
		this.numberPartlyQuestion = numberPartlyQuestion;
		this.numberSkippedQuestion = numberSkippedQuestion;
		this.percentCorrectQuestions = percentCorrectQuestions;
		this.student = student;
		this.test = test;
		this.resultQuestions = resultQuestions;
	}

	/**
	 * @param points
	 * @param student
	 * @param test
	 */
	public ResultTest(User student, Test test, int points) {
		super();
		this.points = points;
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
	public int getPercentCorrectQuestions() {
		return (int)percentCorrectQuestions;
	}

	/**
	 * @param percentCorrectQuestions the percentCorrectQuestions to set
	 */
	public void setPercentCorrectQuestions(int percentCorrectQuestions) {
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
	 * @return the numberSkippedQuestion
	 */
	public int getNumberSkippedQuestion() {
		return numberSkippedQuestion;
	}

	/**
	 * @param numberSkippedQuestion the numberSkippedQuestion to set
	 */
	public void setNumberSkippedQuestion(int numberSkippedQuestion) {
		this.numberSkippedQuestion = numberSkippedQuestion;
	}
	
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
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
		result.append("Количество пропущенных вопросов: " + getNumberSkippedQuestion());
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
