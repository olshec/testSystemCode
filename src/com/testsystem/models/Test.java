package com.testsystem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Test {
	
	private String name;
	private User teacher;
	private List<Question> questions;
	private List<User> students;
	private List<Integer> results;
	
	/**
	 * Creates a TestModel.
	 */
	public Test() {}
	
	/**
	 * Creates a test.
	 * 
	 * @param  name The name of test.
	 * @param teacher The teacher.
	 */
	public Test(String name, User teacher) {
		this.init();
		setName(name);
		setTeacher(teacher);
	}
	
	private void init() {
		setQuestions(new ArrayList<Question>());
		setStudents(new ArrayList<User>());
		setResults(new ArrayList<Integer>()); 
	}
	
	/**
	 * Gets name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets name.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets teacher.
	 * 
	 * @return the teacher
	 */
	public User getTeacher() {
		return teacher;
	}
	
	/**
	 * Sets teacher.
	 * 
	 * @param teacher the teacher.
	 */
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	
	/**
	 * Gets list of questions.
	 * 
	 * @return the questions.
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	
	/**
	 * Sets questions.
	 * 
	 * @param questions the list of questions.
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * Gets student.
	 * 
	 * @return the students
	 */
	public List<User> getStudents() {
		return students;
	}
	
	/**
	 * Sets student.
	 * 
	 * @param students the list of students.
	 */
	public void setStudents(List<User> students) {
		this.students = students;
	}
	
	/**
	 * Gets results of test.
	 * 
	 * @return the list of tests.
	 */
	public List<Integer> getResults() {
		return results;
	}
	
	/**
	 * Sets result.
	 * 
	 * @param results the list of tests.
	 */
	public void setResults(List<Integer> results) {
		this.results = results;
	}
	
}
