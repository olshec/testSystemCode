/**
 * 
 */
package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.models.Test;
import com.testsystem.models.TestBase;
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
	 * Gets tests
	 * 
	 * @param testBase The tests' database.
	 * @return The all tests of teacher.
	 */
	public List<Test> getTests(TestBase testBase) {
		ArrayList<Test> masTests = new ArrayList<Test>();
		for (int i = 0; i < testBase.getTests().size(); i++) {
			TestController testController = new TestController(testBase.getTests().get(i));
			if (testController.hasTeacher(this.getUserModel())) {
				masTests.add(testController.getTestModel());
			}
		}
		return masTests;
	}

	/**
	 * Gets students test result.
	 * 
	 * @param idTest   The test id.
	 * @param testBase The tests' database.
	 * @return Test The test's model.
	 */
	public Test getTestResult(int idTest, TestBase testBase) {

		if (idTest >= 0 && idTest < this.getTests(testBase).size()) {
			return this.getTests(testBase).get(idTest);
		}
		return null;
	}

}
