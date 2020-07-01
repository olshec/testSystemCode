package com.testsystem.models;

import java.util.List;

/**
 * Represents a database containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestBase {
	private List<Test> tests;

	
	/**Creates a TestBaseModel.
	 */
	public TestBase() {
		//setTests(tests);
	}
	
	/**Creates a TestBaseModel.
	 * @param tests
	 */
	public TestBase(List<Test> tests) {
		this.tests = tests;
	}

	/**
	 * @return the tests
	 */
	public List<Test> getTests() {
		return tests;
	}

	/**
	 * @param tests the tests to set
	 */
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	
	
}
