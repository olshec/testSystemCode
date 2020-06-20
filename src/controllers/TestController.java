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
	 * @param The test's model.
	 */
	public TestController(TestModel testModel) {
		setTestModel(testModel);
	}


	/**
	 * @return the testModel
	 */
	public TestModel getTestModel() {
		return testModel;
	}

	/**
	 * @param testModel the testModel to set
	 */
	public void setTestModel(TestModel testModel) {
		this.testModel = testModel;
	}

	/**
	 * @return  The  test's name.
	 */
	public String getName() {
		return testModel.getName();
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.testModel.setName(name);
	}
	
	/**
	 * Add result of test
	 * @param student the student student for grading
	 * @param points the student point
	 */
	public void addResult(UserModel student, int points) {
		for (int i = 0; i <testModel.getStudents().size(); i++) {
			if (testModel.getStudents().get(i).getId() == student.getId()) {
				testModel.getResults().set(i, points);
			}
		}
	}

	/**
	 * @return the true if test contains student 
	 */
	public boolean hasStudent(UserModel student) {
		for (int i = 0; i < testModel.getStudents().size(); i++) {
			if (testModel.getStudents().get(i).getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the number questions
	 */
	public int getNumberQuestions() {
		return testModel.getQuestions().size();
	}

	/**
	 * @param user the user for add to test
	 */
	public void addStudent(UserModel user) {
		testModel.getStudents().add(user);
		testModel.getResults().add(-1);
	}

	/**
	 * @return boolean the boolean
	 */
	public boolean hasTeacher(UserModel teacher) {
		if (testModel.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * @return students the list students
	 */
	public List<UserModel> getStudents() {
		return testModel.getStudents();
	}

	/**
	 * @return List<Integer>  the results of test
	 */
	public List<Integer> getResults() {
		return testModel.getResults();
	}

	/**
	 * @param questionModel the question to add
	 */
	public void addQuestion(QuestionModel questionModel) {
		testModel.getQuestions().add(questionModel);
	}

}
