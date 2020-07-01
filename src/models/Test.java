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
	 * @param  name The test's name.
	 * @param teacher The teacher’s model.
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
	public User getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	/**
	 * @return the students
	 */
	public List<User> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<User> students) {
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
	

