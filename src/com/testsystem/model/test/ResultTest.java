package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;

/**
 * Represents a result of test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ResultTest extends Model {
	
	private int numberCorrectQuestions;
	private int numberNotCorrectQuestions;
	private int numberPartlyQuestions;
	private int numberSkippedQuestions;
	private int percentCorrectQuestions;
	private double points;
	private User student;
	private Test test;
	private List<ResultQuestion> resultQuestions;
	
	/**
	 * Creates a ResultTest.
	 */
	public ResultTest() {
		super();
	}

	/**
	 * Creates a ResultTest.
	 * 
	 * @param int the number of correct questions
	 * @param int the number of not correct questions
	 * @param int the number of partly question
	 * @param int the number of skipped question
	 * @param int the percent of correct questions
	 * @param double the points
	 * @param User the student
	 * @param Test the test
	 * @param List<ResultQuestion> the list of result question
	 * @return ResultTest the result of questions
	 */
	public ResultTest(int numberCorrectQuestions, int numberNotCorrectQuestions, int numberPartlyQuestion,
			int numberSkippedQuestion, int percentCorrectQuestions, double points, User student, Test test,
			List<ResultQuestion> resultQuestions) {
		super();
		this.numberCorrectQuestions = numberCorrectQuestions;
		this.numberNotCorrectQuestions = numberNotCorrectQuestions;
		this.numberPartlyQuestions = numberPartlyQuestion;
		this.numberSkippedQuestions = numberSkippedQuestion;
		this.percentCorrectQuestions = percentCorrectQuestions;
		this.points = points;
		this.student = student;
		this.test = test;
		this.resultQuestions = resultQuestions;
	}

	/**
	 * Creates a ResultTest.
	 * 
	 * @param User the student
	 * @param Test the test
	 * @param double the points
	 */
	public ResultTest(User student, Test test, double points) {
		super();
		this.student = student;
		this.test = test;
		this.points = points;
	}
	
	/**
	 * Creates a ResultTest.
	 * 
	 * @param User the student
	 * @param double the points
	 */
	public ResultTest(User student, double points) {
		super();
		this.points = points;
		this.student = student;
	}

	/**
	 * Returns the student.
	 * 
	 * @return User the student
	 */
	public User getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 * 
	 * @param User the student
	 */
	public void setStudent(User student) {
		this.student = student;
	}
	
	/**
	 * Returns the test.
	 * 
	 * @return Test the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * Sets the test.
	 * 
	 * @param Test the test
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * Returns the result of question.
	 * 
	 * @return List<ResultQuestion> the result of question
	 */
	public List<ResultQuestion> getResultQuestions() {
		return resultQuestions;
	}

	/**
	 * Sets the result of question.
	 * 
	 * @param List<ResultQuestion> the result of question
	 */
	public void setResultQuestions(List<ResultQuestion> resultQuestions) {
		this.resultQuestions = resultQuestions;
	}

	
	/**
	 * Returns the number of correct questions.
	 * 
	 * @return int the number of correct questions
	 */
	public int getNumberCorrectQuestions() {
		return numberCorrectQuestions;
	}

	/**
	 * Sets the number of correct questions.
	 * 
	 * @param int the number of correct questions
	 */
	public void setNumberCorrectQuestions(int numberCorrectQuestions) {
		this.numberCorrectQuestions = numberCorrectQuestions;
	}

	/**
	 * Returns the number of not correct questions.
	 * 
	 * @return int the number of not correct questions
	 */
	public int getNumberNotCorrectQuestions() {
		return numberNotCorrectQuestions;
	}

	/**
	 * Sets the number of not correct questions.
	 * 
	 * @param int the number of not correct questions
	 */
	public void setNumberNotCorrectQuestions(int numberNotCorrectQuestions) {
		this.numberNotCorrectQuestions = numberNotCorrectQuestions;
	}

	/**
	 * Returns the percent of correct questions.
	 * 
	 * @return int the percent of correct questions
	 */
	public int getPercentCorrectQuestions() {
		return percentCorrectQuestions;
	}

	/**
	 * Sets the percent of correct questions.
	 * 
	 * @param int the percent of correct questions
	 */
	public void setPercentCorrectQuestions(int percentCorrectQuestions) {
		this.percentCorrectQuestions = percentCorrectQuestions;
	}

	/**
	 * Returns the number of partly questions.
	 * 
	 * @return int the number of partly questions
	 */
	public int getNumberPartlyQuestions() {
		return numberPartlyQuestions;
	}

	/**
	 * Sets the number of partly questions.
	 * 
	 * @param int the number of partly questions
	 */
	public void setNumberPartlyQuestions(int numberPartlyQuestion) {
		this.numberPartlyQuestions = numberPartlyQuestion;
	}
	
	/**
	 * Returns the number of skipped question.
	 * 
	 * @return int the number of skipped question
	 */
	public int getNumberSkippedQuestions() {
		return numberSkippedQuestions;
	}

	/**
	 * Sets the number of skipped question.
	 * 
	 * @param int the number of skipped question
	 */
	public void setNumberSkippedQuestions(int numberSkippedQuestions) {
		this.numberSkippedQuestions = numberSkippedQuestions;
	}
	
	/**
	 * Returns the points.
	 * 
	 * @return double the points
	 */
	public double getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 * 
	 * @param double the points
	 */
	public void setPoints(double points) {
		this.points = points;
	}

	/**
	 * Overrides toString() method.
	 * 
	 * @return String the string representation of ResultTest
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Количество верных вопросов: " + getNumberCorrectQuestions());
		result.append(System.getProperty("line.separator"));
		result.append("Количество неверных вопросов: " + getNumberNotCorrectQuestions());
		result.append(System.getProperty("line.separator"));
		result.append("Количество частично верных вопросов: " + getNumberPartlyQuestions());
		result.append(System.getProperty("line.separator"));
		result.append("Количество пропущенных вопросов: " + getNumberSkippedQuestions());
		result.append(System.getProperty("line.separator"));
		result.append("Процент верных вопросов: " + getPercentCorrectQuestions() + "%");
		result.append(System.getProperty("line.separator"));
		
		return result.toString();
	}

	/**
	 * Returns name of model.
	 * 
	 * @return String the name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultTest";
	}
}
