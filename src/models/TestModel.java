package models;

import java.util.ArrayList;
import java.util.List;

import controllers.QuestionController;

/**
 * Represents a test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestModel {
	private String name;
	private UserModel teacher;
	private List<QuestionModel> questions;
	private List<UserModel> students;
	private List<Integer> results;
	
	
	
	/**
	 * Creates a test.
	 */
	public TestModel() {}
	
	/**
	 * Creates a test.
	 * @param   The test's name.
	 * @param  The test’s teacher.
	 */
	public TestModel(String name, UserModel teacher) {
		this.init();
		setName(name);
		setTeacher(teacher);
	}
	
	
	private void init() {
		setQuestions(new ArrayList<QuestionModel>());
		setStudents(new ArrayList<UserModel>());
		setResults(new ArrayList<Integer>()); 
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the teacher
	 */
	public UserModel getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(UserModel teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the questions
	 */
	public List<QuestionModel> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<QuestionModel> questions) {
		this.questions = questions;
	}
	/**
	 * @return the students
	 */
	public List<UserModel> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<UserModel> students) {
		this.students = students;
	}
	/**
	 * @return the results
	 */
	public List<Integer> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<Integer> results) {
		this.results = results;
	}
	

}
	

