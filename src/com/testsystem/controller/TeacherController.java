package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.test.StudentResultOfTest;
import com.testsystem.model.test.Test;
import com.testsystem.model.user.Teacher;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * TeacherController
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TeacherController extends UserController {

	/**
	 * Creates a TeacherController.
	 */
	public TeacherController() {}
	
	/**
	 * Creates a TeacherController.
	 * 
	 * @param user
	 */
	public TeacherController(User teacher) {
		super(teacher);
	}

	/**
	 * Gets new teacher.
	 */
	public Teacher getNewTeacher(String lastName, String firstName, 
			String username, String password) {
		return new Teacher(lastName, firstName, username, password);
	}
	
	/**
	 * Gets tests
	 * 
	 * @return the all tests of teacher
	 */
	public List<Test> getTests() {
		List<Test> listTest = ServiceLocator.getDaoProvider()
				.getTestsRecords(new Test().getNameModel());
		ArrayList<Test> masTests = new ArrayList<Test>();
		for (int i = 0; i < listTest.size(); i++) {
			TestController testController = new TestController(listTest.get(i));
			if (testController.hasTeacher(this.getUser())) {
				masTests.add(testController.getTest());
			}
		}
		return masTests;
	}

	/**
	 * Gets students test result.
	 * 
	 * @param idTest   	the test id
	 * @return Test 	the model of tests
	 */
	public List<StudentResultOfTest> getTestResult(int idTest) {
		StudentResultOfTestController resultController = new StudentResultOfTestController();
		return resultController.getResultsOfTest(idTest);
	}
}
