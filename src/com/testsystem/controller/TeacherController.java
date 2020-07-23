/**
 * 
 */
package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.Tables.TestTable;
import com.testsystem.models.Teacher;
import com.testsystem.models.Test;
import com.testsystem.models.User;

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
	public TeacherController(User user) {
		super(user);
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
	public List<Test> getTests(TestTable testTable) {
		ArrayList<Test> masTests = new ArrayList<Test>();
		for (int i = 0; i < testTable.getTests().size(); i++) {
			TestController testController = new TestController(testTable.getTests().get(i));
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
	public Test getTestResult(int idTest, TestTable testBase) {

		if (idTest >= 0 && idTest < this.getTests(testBase).size()) {
			return this.getTests(testBase).get(idTest);
		}
		return null;
	}
}
