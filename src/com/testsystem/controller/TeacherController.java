package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Model;
import com.testsystem.model.Teacher;
import com.testsystem.model.Test;
import com.testsystem.model.User;
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
	 * 
	 * @param user
	 */
	public TeacherController(User teacher) {
		super(teacher);
	}

	/**
	 * Gets new teacher.
	 */
	public static Teacher getNewTeacher(String lastName, String firstName, 
			String username, String password) {
		return new Teacher(lastName, firstName, username, password);
	}
	
	/**
	 * Gets tests
	 * 
	 * @param testTable 	the database of tests
	 * @return 			the all tests of teacher
	 */
	public List<Test> getTests() {
		List<Model> listTest = ServiceLocator.getDaoProvider()
				.getRecords(Test.nameModel);
		ArrayList<Test> masTests = new ArrayList<Test>();
		for (int i = 0; i < listTest.size(); i++) {
			TestController testController = new TestController((Test)listTest.get(i));
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
	 * @param testBase 	the database
	 * @return Test 	the model of tests
	 */
	public Test getTestResult(int idTest) {
		if (idTest >= 0 && idTest < this.getTests().size()) {
			return this.getTests().get(idTest);
		}
		return null;
	}
}
