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
	 */
	public TestController() {;}
	
	/**
	 * Creates a test.
	 * @param   The test's model.
	 */
	public TestController(TestModel testModel) {
		setTestModel(testModel);
	}


	public TestModel getTestModel() {
		return testModel;
	}


	public void setTestModel(TestModel testModel) {
		this.testModel = testModel;
	}


	/**
	 * Get name of test.
	 * @return  The name of test.
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
