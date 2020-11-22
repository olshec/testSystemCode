package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.exception.FindTestException;
import com.testsystem.model.Model;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.RatingStudent;
import com.testsystem.model.test.ResultTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a test controller.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestController {

	private Test test;

	/**
	 * Creates a TestController.
	 */
	public TestController() {}
	
	/**
	 * Creates a TestController.
	 * 
	 * @param Test the test
	 */
	public TestController(Test test) {
		setTest(test);
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
	 * Gets new Test.
	 */
	public Test getNewTest() {
		return new Test();
	}

	/**
	 * Gets all tests.
	 * 
	 * @return the all tests
	 */
	public List<Test> getAllTests() {
		List<Test> listTest = ServiceLocator.getDaoProvider().getTestsRecords(new Test().getNameModel());
		return listTest;
	}

	/**
	 * Gets test.
	 * 
	 * @param  the test id.
	 * @return the Test.
	 * @throws FindTestException 
	 */
	public Test getTest(int idTest) throws FindTestException {
		List<Test> listTest = ServiceLocator.getDaoProvider().getTestsRecords(new Test().getNameModel());
		if (idTest < listTest.size() && idTest >= 0) {
			return listTest.get(idTest);
		}
		throw new FindTestException("Test is not found");
	}

	/**
	 * Gets new Test.
	 */
	public Test getNewTest(String name, User teacher) {
		return new Test(name, teacher);
	}

	/**
	 * Gets name
	 * 
	 * @return the name of test
	 */
	public String getNameTest() {
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
	 * Saves result of test in database.
	 * 
	 * @param student the student for grading
	 * @param points  the student point
	 */
	public void saveResultInDatabase(ResultTest resultTest) {
		new RatingCalculator().updateRatingStudent(resultTest);
	}

	/**
	 * Gets result: does the student have a test.
	 * 
	 * @param the student.
	 * @return the true if test student has this test. Otherwise returns false.
	 */
	public boolean hasStudentThisTest(User student, Test test) {
		List<ResultTest> ls = ServiceLocator.getDaoProvider()
				.getResultTestRecords();
		for (ResultTest studentResult : ls) {
			if (studentResult.getStudent().equals(student)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets tests for student.
	 * 
	 * @param User the student.
	 * @return List<Test> the list tests of student.
	 */
	public List<Test> getStudentTests(User student) {
		List<Test> listTest = ServiceLocator.getDaoProvider().getTestsRecords();
		List<Test> listTestReturn = new ArrayList<Test>();
		for (Test test : listTest) {
			for (User st : test.getStudents()) {
				if (st.equals(student)) {
					listTestReturn.add(test);
				}
			}
		}
		return listTestReturn;
	}

	/**
	 * Gets number of question.
	 * 
	 * @return int the number of questions
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
		test.getStudents().add(user);
	}

	/**
	 * Gets result: does the teacher have a test.
	 * 
	 * @param the model of teacher
	 * @return the true if test teacher has this test. Otherwise returns false
	 */
	public boolean hasTeacher(User teacher) {
		if (test.getTeacher().getId() == teacher.getId()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adds new question.
	 * 
	 * @param question the question to add
	 */
	public void addQuestion(Question question) {
		test.getQuestions().add(question);
	}
	
	/**
	 * Gets students and their results.
	 * 
	 * @return the result of student
	 */
	public List<ResultTest> getStudentTestResult(User student, Test test) {
		ResultTestController resultController = new ResultTestController();
		return resultController.getResultsOfTest(student, test);
	}

	/**
	 * Saves test in the database.
	 * 
	 * @param Test
	 */
	public static void saveTest(Test test) {
		List<Model> tests = ServiceLocator.getDaoProvider()
				.getRecords(new Test().getNameModel());
		tests.add(test);
	}

	/**
	 * This method checks student test.
	 *
	 * @param User the student
	 * @param Test the test
	 */
	public ResultTest checkTest(User student, Test test) {
		ResultTest resultTest = new ResultTestController().
				checkTest(student, test);
		saveResultInDatabase(resultTest);
		return resultTest;
	}

}
