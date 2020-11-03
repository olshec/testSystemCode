package com.testsystem.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.test.Question;
import com.testsystem.model.test.ResultQuestion;
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
	 * @param the test
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
	 */
	public Test getTest(int idTest) {
		List<Test> listTest = ServiceLocator.getDaoProvider().getTestsRecords(new Test().getNameModel());
		if (idTest < listTest.size() && idTest >= 0) {
			return listTest.get(idTest);
		}
		return null;
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
	 * Adds result of test.
	 * 
	 * @param student the student for grading
	 * @param points  the student point
	 */
	public void saveResultInDatabase(User student, Test test, int points) {
		ServiceLocator.getDaoProvider().addRecord(new ResultTest(student, test, points));
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
	 * @param 	the student.
	 * @return 	the list tests of student.
	 */
	public List<Test> getStudentTests(User student) {
		List<ResultTest> listResultTest = ServiceLocator.getDaoProvider()
				.getResultTestRecords();
		List<Test> listTestReturn = new ArrayList<Test>();
		for (ResultTest result : listResultTest) {
				if(result.getStudent().equals(student)) {
					listTestReturn.add(result.getTest());
				}
			}
		return listTestReturn;
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

//	/**
//	 * Gets students.
//	 * 
//	 * @return students the list of students
//	 */
//	public List<User> getStudents() {
//		List<User> listStudent = new ArrayList<User>();
//		List<StudentTestResult> listStudentTestResult = test.getStudentTestResult();
//		for (StudentTestResult studentTestResult : listStudentTestResult) {
//			listStudent.add(studentTestResult.getStudent());
//		}
//		return listStudent;
//	}

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
	public ResultTest getStudentTestResult(User student, Test test) {
		ResultTestController resultController = new ResultTestController();
		return resultController.getResultsOfTest(student, test);
	}

	/**
	 * Saves test in the database.
	 * 
	 * @param test
	 */
	public static void saveTest(Test test) {
		List<Model> tests = ServiceLocator.getDaoProvider()
				.getRecords(new Test().getNameModel());
		tests.add(test);
	}

	/**
	 * This method checks student test.
	 *
	 *@param test the test
	 */
	public void checkTest(User student, Test test) {
		Test sourceTest = ServiceLocator.getDaoProvider()
				.getTest(test);
		List<ResultQuestion> listResultQuesion = new QuestionController().checkQuestions(test.getQuestions(), sourceTest.getQuestions());
		
		ResultTest resultTest = new ResultTest(student, test, listResultQuesion);
	}
}
