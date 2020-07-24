package com.testsystem.models;

public class StudentTestResult {

	User student; 
	Integer result;
	
	public StudentTestResult(User student, Integer result) {
		setStudent(student);
		setResult(result);
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

	
}
