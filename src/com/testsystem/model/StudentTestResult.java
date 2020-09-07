package com.testsystem.model;

/**
 * Represents a result of student test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentTestResult extends Model {

	User student; 
	Integer result;
	
	/**
	 * Creates a StudentTestResult.
	 */
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
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "StudentTestResult";
	}
}
