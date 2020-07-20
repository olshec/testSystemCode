package com.testsystem.models;

import java.util.List;

/**
 * Represents a table for get answers from student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentTest {

	private Test test;
	private Student student;
	private List<List<Integer>> listAnswers;
	
	public StudentTest() {
		
	}

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
	 * Gets answers.
	 * 
	 * @return the listAnswers
	 */
	public List<List<Integer>> getListAnswers() {
		return listAnswers;
	}

	/**
	 * Sets answers.
	 * 
	 * @param listAnswers the listAnswers to set
	 */
	public void setListAnswers(List<List<Integer>> listAnswers) {
		this.listAnswers = listAnswers;
	}
}
