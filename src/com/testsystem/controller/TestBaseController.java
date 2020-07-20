package com.testsystem.controller;

import java.util.List;
import com.testsystem.models.Test;
import com.testsystem.models.TestBase;

/**
 * Represents a controller to the database containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestBaseController {

	private TestBase testBase;

	/**
	 * Creates a TestBaseController.
	 */
	public TestBaseController() {
		setTestBaseModel(new TestBase());
	}

	/**
	 * Creates a TestBaseController.
	 * 
	 * @param testBase The database of tests
	 */
	public TestBaseController(TestBase testBase) {
		setTestBaseModel(testBase);
	}

	/**
	 * Gets all tests.
	 * 
	 * @return the all tests
	 */
	public List<Test> getAllTests() {
		return testBase.getTests();
	}

	/**
	 * Adds list of test.
	 * 
	 * @param tests the tests to add.
	 */
	public void addTests(List<Test> tests) {
		this.testBase.setTests(tests);
	}

	/**
	 * Gets test.
	 * 
	 * @param 	the test id.
	 * @return 	the TestModel.
	 */
	public Test getTest(int idTest) {
		if (idTest < testBase.getTests().size() && idTest >= 0) {
			return testBase.getTests().get(idTest);
		}
		return null;
	}

	/**
	 * Gets the database of tests.
	 * 
	 * @return The database of tests
	 */
	public TestBase getTestBaseModel() {
		return testBase;
	}

	/**
	 * Sets the database of tests.
	 * 
	 * @param testBase The database of tests
	 */
	public void setTestBaseModel(TestBase testBase) {
		this.testBase = testBase;
	}

}
