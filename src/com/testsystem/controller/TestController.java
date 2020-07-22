package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.models.Question;
import com.testsystem.models.Teacher;
import com.testsystem.models.Test;
import com.testsystem.models.TestBase;
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
	//public TestController() {}

	/**
	 * Creates a TestController.
	 * 
	 * @param the test
	 */
	public TestController(Test test) {
		setTest(test);
	}

	/**
	 * Gets new Test.
	 */
	public static Test getNewTest() {
		return new Test();
	}
	
	/**
	 * Gets new Test.
	 */
	public static Test getNewTest(String name, User teacher) {
		return new Test(name, teacher);
	}
	
	/**
	 * Gets model of test.
	 * 
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * Sets the model of test.
	 * 
	 * @param test the test
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * Gets name
	 * 
	 * @return the name of test
	 */
	public String getName() {
		return test.getName();
	}

	/**
	 * Sets name of test.
	 * 
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.test.setName(name);
	}

	/**
	 * Adds result of test.
	 * 
	 * @param student the student for grading
	 * @param points  the student point
	 */
	public void addResult(User student, int points) {
		test.getStudentResult().put(student, points);
	}

	/**
	 * Gets result: does the student have a test.
	 * 
	 * @param 	the student.
	 * @return 	the true if test student has this test. Otherwise returns false.
	 */
	public boolean hasStudent(User student) {
		return test.getStudentResult().containsKey(student);
	}

	/**
	 * Gets number of question.
	 * 
	 * @return the number of questions
	 */
	public int getNumberQuestions() {
		return test.getQuestions().size();
	}

	/**
	 * Adds new student.
	 * 
	 * @param user the user for add to test
	 */
	public void addStudent(User user) {
		test.getStudentResult().put(user, -1);
	}

	/**
	 * Gets result: does the teacher have a test.
	 * 
	 * @param 	the model of teacher
	 * @return  the true if test teacher has this test. Otherwise returns false
	 */
	public boolean hasTeacher(User teacher) {
		if (test.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * Gets students.
	 * 
	 * @return students the list of students
	 */
	public List<User> getStudents() {
		return new ArrayList<User>(test.getStudentResult().keySet());
	}

	/**
	 * Gets the result of tests.
	 * 
	 * @return List<Integer> the results of test
	 */
	public List<Integer> getResults() {
		return new ArrayList<Integer>(test.getStudentResult().values());
	}

	/**
	 * Adds new question.
	 * 
	 * @param question the question to add
	 */
	public void addQuestion(Question question) {
		test.getQuestions().add(question);
	}
}
