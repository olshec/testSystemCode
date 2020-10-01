package com.testsystem.model;

public class StudentResultOfTest extends Model{
	
	User student;
	Test test;
	Integer result;

	/**
	 * @param student
	 * @param test
	 * @param result
	 */
	public StudentResultOfTest(User student, Test test, Integer result) {
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
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "StudentResultOfTest";
	}
	
}
