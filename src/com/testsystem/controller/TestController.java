package com.testsystem.controller;

import java.util.List;
import com.testsystem.models.Question;
import com.testsystem.models.Test;
import com.testsystem.models.User;

/**
 * Represents a test controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestController {

	Test test;

	/**
	 * Creates a TestController.
	 */
	public TestController() {
		;
	}

	/**
	 * Creates a TestController.
	 * 
	 * @param The test.
	 */
	public TestController(Test test) {
		setTestModel(test);
	}

	/**
	 * Gets model of test.
	 * 
	 * @return the test.
	 */
	public Test getTestModel() {
		return test;
	}

	/**
	 * Sets the model of test.
	 * 
	 * @param test The test.
	 */
	public void setTestModel(Test test) {
		this.test = test;
	}

	/**
	 * Gets name
	 * 
	 * @return The test's name.
	 */
	public String getName() {
		return test.getName();
	}

	/**
	 * Sets name of test.
	 * 
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.test.setName(name);
	}

	/**
	 * Adds result of test.
	 * 
	 * @param student The student for grading.
	 * @param points  The student point.
	 */
	public void addResult(User student, int points) {
		for (int i = 0; i < test.getStudents().size(); i++) {
			if (test.getStudents().get(i).getId() == student.getId()) {
				test.getResults().set(i, points);
			}
		}
	}

	/**
	 * Gets result: does the student have a test.
	 * 
	 * @param The student.
	 * @return Returns the true if test student has this test. Otherwise returns
	 *         false.
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
	 * Gets number of question
	 * 
	 * @return The number of questions.
	 */
	public int getNumberQuestions() {
		return test.getQuestions().size();
	}

	/**
	 * Adds new student
	 * 
	 * @param user The user for add to test.
	 */
	public void addStudent(User user) {
		test.getStudents().add(user);
		test.getResults().add(-1);
	}

	/**
	 * Gets result: does the teacher have a test.
	 * 
	 * @param The model of teacher.
	 * @return Returns the true if test teacher has this test. Otherwise returns
	 *         false.
	 */
	public boolean hasTeacher(User teacher) {
		if (test.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * Gets students
	 * 
	 * @return students The list of students.
	 */
	public List<User> getStudents() {
		return test.getStudents();
	}

	/**
	 * Gets the result of tests.
	 * 
	 * @return List<Integer> the results of test.
	 */
	public List<Integer> getResults() {
		return test.getResults();
	}

	/**
	 * Adds new question
	 * 
	 * @param question The question to add.
	 */
	public void addQuestion(Question question) {
		test.getQuestions().add(question);
	}

}
