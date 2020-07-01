package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Test;
import com.testsystem.models.TestBase;
import com.testsystem.models.User;

/**
 * Represents a controller to the database containing tests.
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
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
	 *  @param testBaseModel the database containing tests.
	 */
	public TestBaseController(TestBase testBaseModel) {
		setTestBaseModel(testBaseModel);
		}

	/**
	 * @return the all tests.
	 */
	public List<Test> getAllTests() {
		return testBase.getTests();
	}

	/**
	 * @param tests the tests to add.
	 */
	public void addTests(List<Test> tests) {
		this.testBase.setTests(tests);
	}
	
	/**
	 * @return the TestModel.
	 */
	public Test getTest(int index) {
		if (index < testBase.getTests().size() && index >= 0) {
			return testBase.getTests().get(index);
		}
		return null;
	}

	/**
	 * @return the testBaseModel
	 */
	public TestBase getTestBaseModel() {
		return testBase;
	}

	/**
	 * @param testBaseModel the testBaseModel to set
	 */
	public void setTestBaseModel(TestBase testBaseModel) {
		this.testBase = testBaseModel;
	}

}
