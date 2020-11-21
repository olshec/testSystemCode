package com.testsystem.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.controller.test.ResultTestController;
import com.testsystem.controller.test.TestController;
import com.testsystem.model.test.ResultTest;
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
	 * @param User the teacher
	 */
	public TeacherController(User teacher) {
		super(teacher);
	}

	/**
	 * Returns new teacher.
	 * 
	 * @param String the lastName
	 * @param String the firstName
	 * @param String the username
	 * @param String the password
	 * @return Teacher the teacher
	 */
	public Teacher getNewTeacher(String lastName, String firstName, 
			String username, String password) {
		return new Teacher(lastName, firstName, username, password);
	}
	
	/**
	 * Returns the list of tests for teacher.
	 * 
	 * @return List<Test> the list of tests
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
	 * @return List<ResultTest> 	the list of result test by id
	 */
	public List<ResultTest> getTestResult(int idTest) {
		ResultTestController resultController = new ResultTestController();
		return resultController.getResultsOfTest(idTest);
	}
}
