package com.testsystem.model.test;

import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;

public class ResultTest extends Model {
	
	private User student;
	private Test test;
	private Integer result;
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
	public ResultTest(User student, Test test, Integer result, List<ResultQuestion> resultQuestions) {
		super();
		this.student = student;
		this.test = test;
		this.result = result;
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
		this.result = result;
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
	 * @return the result
	 */
	public Integer getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Integer result) {
		this.result = result;
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
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "ResultTest";
	}
}
