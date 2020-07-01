package com.testsystem.controller;

import java.util.List;

import com.testsystem.models.Question;
import com.testsystem.models.Test;
import com.testsystem.models.User;

/**
 * Represents a test controller.
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */
public class TestController {

	Test test;

	/** 
	 * Creates a TestController.
	 */
	public TestController() {;}
	
	/**
	 * Creates a TestController.
	 * @param testModel the test's model.
	 */
	public TestController(Test testModel) {
		setTestModel(testModel);
	}


	/**
	 * @return the testModel.
	 */
	public Test getTestModel() {
		return test;
	}

	/**
	 * @param testModel the testModel to set.
	 */
	public void setTestModel(Test testModel) {
		this.test = testModel;
	}

	/**
	 * @return  The  test's name.
	 */
	public String getName() {
		return test.getName();
	}
	
	/**
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.test.setName(name);
	}
	
	/**
	 * Method for add result of test.
	 * @param student the student student for grading.
	 * @param points the student point.
	 */
	public void addResult(User student, int points) {
		for (int i = 0; i <test.getStudents().size(); i++) {
			if (test.getStudents().get(i).getId() == student.getId()) {
				test.getResults().set(i, points);
			}
		}
	}

	/**
	 * @return the true if test contains student .
	 */
	public boolean hasStudent(User student) {
		for (int i = 0; i < test.getStudents().size(); i++) {
			if (test.getStudents().get(i).getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the number questions.
	 */
	public int getNumberQuestions() {
		return test.getQuestions().size();
	}

	/**
	 * @param user the user for add to test.
	 */
	public void addStudent(User user) {
		test.getStudents().add(user);
		test.getResults().add(-1);
	}

	/**
	 * @param teacher the teacher's model
	 * @return boolean the boolean.
	 */
	public boolean hasTeacher(User teacher) {
		if (test.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * @return students the list students.
	 */
	public List<User> getStudents() {
		return test.getStudents();
	}

	/**
	 * @return List<Integer>  the results of test.
	 */
	public List<Integer> getResults() {
		return test.getResults();
	}

	/**
	 * @param questionModel the question to add.
	 */
	public void addQuestion(Question questionModel) {
		test.getQuestions().add(questionModel);
	}

}
