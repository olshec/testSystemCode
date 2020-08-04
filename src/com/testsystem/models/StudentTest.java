package com.testsystem.models;

import java.util.List;

/**
 * Represents a table for get answers from student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentTest extends Model {

	private Test test;
	private Student student;
	private List<Question> listQuestions;
	
	public StudentTest() {}

	/**
	 * Gets test.
	 * 
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * Sets test.
	 * 
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * Gets student.
	 * 
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets student.
	 * 
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Gets questions.
	 * 
	 * @return the listQuestions
	 */
	public List<Question> getListAnswers() {
		return listQuestions;
	}

	/**
	 * Sets questions.
	 * 
	 * @param listQuestions the listAnswers to set
	 */
	public void setListAnswers(List<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "StudentTest";
	}
}
