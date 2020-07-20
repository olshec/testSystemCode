package com.testsystem.models;

import java.util.ArrayList;
import java.util.HashMap;
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
	private HashMap<User, Integer> studentsResult;
	
	/**
	 * Creates a TestModel.
	 */
	public Test() {}
	
	/**
	 * Creates a test.
	 * 
	 * @param  name 	the name of test
	 * @param teacher 	the teacher
	 */
	public Test(String name, User teacher) {
		this.init();
		setName(name);
		setTeacher(teacher);
	}
	
	private void init() {
		setQuestions(new ArrayList<Question>());
		setStudentResult(new HashMap<User, Integer>());
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
	 * @param teacher the teacher
	 */
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	
	/**
	 * Gets list of questions.
	 * 
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	
	/**
	 * Sets questions.
	 * 
	 * @param questions the list of questions
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/**
	 * Gets students and their results.
	 * 
	 * @return the result of students
	 */
	public HashMap<User, Integer> getStudentResult() {
		return studentsResult;
	}

	/**
	 * Sets students and their results.
	 * 
	 * @param studentResult the result of students to set
	 */
	public void setStudentResult(HashMap<User, Integer> studentResult) {
		this.studentsResult = studentResult;
	}
	
	/**
	 * Gets students and their results.
	 * 
	 * @return the result of student
	 */
	public int getStudentResult(User student) {
		return studentsResult.get(student);
	}
}
