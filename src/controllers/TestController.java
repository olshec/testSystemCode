package controllers;

import java.util.ArrayList;
import java.util.List;

import models.QuestionModel;
import models.TestModel;
import models.UserModel;

/**
 * Represents a test.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestController {

	TestModel testModel;

	/**
	 * Creates a test.
	 * @param name  The test's name.
	 * @param teacher The test’s teacher.
	 */
	public TestController(String name, UserModel teacher) {
		this.init();
		testModel.setName(name);
		testModel.setTeacher(teacher);
	}

	private void init() {
		testModel=new TestModel();
		testModel.setQuestions(new ArrayList<QuestionModel>());
		testModel.setStudents(new ArrayList<UserModel>());
		testModel.setResults(new ArrayList<Integer>()); 
	}

	/**
	 * Creates a test.
	 * @return String The name of test.
	 */
	public String getName() {
		return testModel.getName();
	}

	public void addResult(UserModel student, int points) {
		for (int i = 0; i <testModel.getStudents().size(); i++) {
			if (testModel.getStudents().get(i).getId() == student.getId()) {
				testModel.getResults().set(i, points);
			}
		}
	}

	public boolean hasStudent(UserModel student) {
		for (int i = 0; i < testModel.getStudents().size(); i++) {
			if (testModel.getStudents().get(i).getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}

	public int getNumberQuestions() {
		return testModel.getQuestions().size();
	}

	public void addStudent(UserModel user) {
		testModel.getStudents().add(user);
		testModel.getResults().add(-1);
	}

	public boolean hasTeacher(UserModel teacher) {
		if (testModel.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	public List<UserModel> getStudents() {
		return testModel.getStudents();
	}

	public List<Integer> getResults() {
		return testModel.getResults();
	}

	public void addQuestion(QuestionModel q) {
		testModel.getQuestions().add(q);
	}

}
