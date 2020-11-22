package com.testsystem.model.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.user.User;

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
	private Integer id;
	
	/**
	 * Creates a Test.
	 */
	public Test() {
		this.init();
	}
	
	/**
	 * Creates a Test.
	 * 
	 * @param  name 	the name of test
	 * @param  User 	the teacher
	 */
	public Test(String name, User teacher) {
		this.init();
		setName(name);
		setTeacher(teacher);
	}
	
	/*
	 * initialisation method.
	 */
	private void init() {
		this.id = this.getIdIncrement();
		setQuestions(new ArrayList<Question>());
		setStudents(new ArrayList<User>());
	}
	
	/**
	 * Returns the id.
	 * 
	 * @return int the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name.
	 * 
	 * @return String the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param String the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the teacher.
	 * 
	 * @return User the teacher
	 */
	public User getTeacher() {
		return teacher;
	}
	
	/**
	 * Sets the teacher.
	 * 
	 * @param User the teacher
	 */
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	
	/**
	 * Returns the list of questions.
	 * 
	 * @return List<Question> the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	
	/**
	 * Sets questions.
	 * 
	 * @param List<Question> the list of questions
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/**
	 * Returns the list of students.
	 *  
	 * @return List<User> the list of students
	 */
	public List<User> getStudents() {
		return students;
	}

	/**
	 * Sets list of students.
	 * 
	 * @param List<User> the students
	 */
	public void setStudents(List<User> students) {
		this.students = students;
	}
	
	/**
	 * Returns the hash code.
	 * 
	 * @return int the hash code of test
	 */
	@Override
	public int hashCode() {
		final int prime = 32;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Сhecks equality of objects.
	 * 
	 * @param Object the student
	 * @return boolean the result of compare objects
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
		if (id != other.getId())
			return false;
		return true;
	}

	/**
	 * Clears checked answers.
	 */
	public void clearChecked() {
		for(Question q : questions) {
			q.clearAnswers();
		}
	}
	
	/**
	 * Returns the name of test.
	 * 
	 * @return String return the name of model Test
	 */
	@Override
	public String getNameModel() {
		return "Test";
	}

}
