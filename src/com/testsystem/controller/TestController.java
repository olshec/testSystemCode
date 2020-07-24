package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.models.Question;
import com.testsystem.models.StudentTestResult;
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

	private Test test;
	private DAOProvider daoProvider;

	/**
	 * Creates a TestController.
	 */
	//public TestController() {}

	/**
	 * Creates a TestController.
	 */
	public TestController(DAOProvider daoProvider) {
		this.setDaoProvider(daoProvider);
	}

	/**
	 * Creates a TestController.
	 * 
	 * @param the test
	 */
	public TestController(Test test) {
		this.setTest(test);
	}
	
	/**
	 * Creates a TestController.
	 */
	public TestController(DAOProvider daoProvider, Test test) {
		this.setDaoProvider(daoProvider);
		this.setTest(test);
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
	 * Gets DAOProvider.
	 * 
	 * @return the DAOProvider
	 */
	public DAOProvider getDaoProvider() {
		return daoProvider;
	}
	
	/**
	 * Sets DAOProvider.
	 * 
	 * @param daoProvider the DAOProvider to set
	 */
	public void setDaoProvider(DAOProvider daoProvider) {
		this.daoProvider = daoProvider;
	}
	
	/**
	 * Gets new Test.
	 */
	public static Test getNewTest() {
		return new Test();
	}
	
	/**
	 * Gets all tests.
	 * 
	 * @return the all tests
	 */
	public  List<Test> getAllTests() {
		return daoProvider.getTestTable().getTests();
	}

	/**
	 * Adds list of test.
	 * 
	 * @param tests the tests to add
	 */
	public void addTests(List<Test> tests) {
		this.daoProvider.getTestTable().setTests(tests);
	}

	/**
	 * Gets test.
	 * 
	 * @param 	the test id.
	 * @return 	the TestModel.
	 */
	public Test getTest(int idTest) {
		if (idTest < daoProvider.getTestTable().getTests().size() && idTest >= 0) {
			return daoProvider.getTestTable().getTests().get(idTest);
		}
		return null;
	}
	
	/**
	 * Gets new Test.
	 */
	public static Test getNewTest(String name, User teacher) {
		return new Test(name, teacher);
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
		test.getStudentResult().add(new StudentTestResult(student, points));
	}

	/**
	 * Gets result: does the student have a test.
	 * 
	 * @param 	the student.
	 * @return 	the true if test student has this test. Otherwise returns false.
	 */
	public boolean hasStudent(User student) {
		return test.getStudentResult().getStudent(student);
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
		test.getStudentResult().add(new StudentTestResult(user, -1));
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
		return new ArrayList<User>(test.getStudents());
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
