package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.Question;
import com.testsystem.model.StudentResultOfTest;
import com.testsystem.model.Test;
import com.testsystem.model.User;
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
	 * Adds list of test.
	 * 
	 * @param tests the tests to add
	 */
	public void setTests(List<Model> tests) {
		ServiceLocator.getDaoProvider().setTable(new Test().getNameModel(), tests);
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
	public void addResult(User student, Test test, int points) {
		//test.getStudentTestResult().add(new StudentTestResult(student, points));
		List<StudentResultOfTest> ls = ServiceLocator.getDaoProvider().getStudentResultOfTestRecords();
		ls.add(new StudentResultOfTest(student, test, points));
	}

	/**
	 * Gets result: does the student have a test.
	 * 
	 * @param the student.
	 * @return the true if test student has this test. Otherwise returns false.
	 */
	public boolean hasStudentThisTest(User student, Test test) {
		List<StudentResultOfTest> ls = ServiceLocator.getDaoProvider()
				.getStudentResultOfTestRecords();
		for (StudentResultOfTest studentResult : ls) {
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
		List<StudentResultOfTest> listStudentResultofTest = ServiceLocator.getDaoProvider()
				.getStudentResultOfTestRecords();
		List<Test> listTestReturn = new ArrayList<Test>();
		for (StudentResultOfTest result : listStudentResultofTest) {
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
	public StudentResultOfTest getStudentTestResult(User student) {
		StudentResultOfTestController resultController = new StudentResultOfTestController();
		return resultController.getResultsOfTest(student);
	}
	
}
