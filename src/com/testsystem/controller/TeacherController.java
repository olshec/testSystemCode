/**
 * 
 */
package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Model;
import com.testsystem.models.Teacher;
import com.testsystem.models.Test;
import com.testsystem.models.User;
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
	
	public TeacherController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets new teacher.
	 */
	public static Teacher getNewTeacher(String lastName, String firstName, 
			ServerController server, String username, String password) {
		return new Teacher(lastName, firstName, server, username, password);
	}
	
	/**
	 * Gets tests
	 * 
	 * @param testTable 	the database of tests
	 * @return 			the all tests of teacher
	 */
	public List<Test> getTests() {
		List<Model> listTest = ServiceLocator.getDaoProvider()
				.getRecordsTable(Test.nameModel);
		ArrayList<Test> masTests = new ArrayList<Test>();
		for (int i = 0; i < listTest.size(); i++) {
			TestController testController = ServiceLocator.getTestController((Test)listTest.get(i));
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
