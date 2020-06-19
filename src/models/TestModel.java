package models;

import java.util.List;

import controllers.QuestionController;

/**
 * @author user1
 *
 */
public class TestModel {
	private String name;
	private UserModel teacher;
	private List<QuestionModel> questions;
	private List<UserModel> students;
	private List<Integer> results;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UserModel getTeacher() {
		return teacher;
	}
	
	public void setTeacher(UserModel teacher) {
		this.teacher = teacher;
	}
	
	public List<QuestionModel> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<QuestionModel> questions) {
		this.questions = questions;
	}
	
	public List<UserModel> getStudents() {
		return students;
	}
	
	public void setStudents(List<UserModel> students) {
		this.students = students;
	}
	
	public List<Integer> getResults() {
		return results;
	}
	
	public void setResults(List<Integer> results) {
		this.results = results;
	}
	
	
	
}
