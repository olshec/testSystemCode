package com.testsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Test extends Model {
	
	private String name;
	private User teacher;
	private List<Question> questions;
	private List<User> students;
	//private List<StudentTestResult> studentsResult;
	private Integer id;
	private static Integer idIncrement;
	
	static {
		idIncrement = 0;
	}
	
	/**
	 * Creates a TestModel.
	 */
	public Test() {
		this.init();
	}
	
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
		this.id = Test.idIncrement;
		Test.idIncrement++;
		setQuestions(new ArrayList<Question>());
		setStudents(new ArrayList<User>());
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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

	
	
//	/**
//	 * Gets students and their results.
//	 * 
//	 * @return the result of students
//	 */
//	public List<StudentTestResult> getStudentTestResult() {
//		return studentsResult;
//	}
//
//	/**
//	 * Sets students and their results.
//	 * 
//	 * @param studentResult the result of students to set
//	 */
//	public void setStudentResult(List<StudentTestResult> studentResult) {
//		this.studentsResult = studentResult;
//	}

	/**
	 * @return the users
	 */
	public List<User> getStudents() {
		return students;
	}

	/**
	 * @param users the users to set
	 */
	public void setStudents(List<User> users) {
		this.students = users;
	}
	
	/**
	 * Returns the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 32;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Equals check.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	@Override
	public String getNameModel() {
		return "Test";
	}
}
