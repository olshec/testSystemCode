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

	/**
	 * Creates a TestBaseModel.
	 */
	public TestBase() {
		// setTests(tests);
	}

	/**
	 * Creates a TestBaseModel.
	 * 
	 * @param tests the list of tests
	 */
	public TestBase(List<Test> tests) {
		this.tests = tests;
	}

	/**
	 * Gets test.
	 * 
	 * @return the list of tests
	 */
	public List<Test> getTests() {
		return tests;
	}

	/**
	 * Sets test.
	 * 
	 * @param tests the list of tests
	 */
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
}
