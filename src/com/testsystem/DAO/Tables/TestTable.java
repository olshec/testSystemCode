package com.testsystem.DAO.Tables;

import java.util.List;

import com.testsystem.models.Test;

/**
 * Represents a table containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestTable {
	
	private List<Test> tests;

	/**
	 * Creates a TestTable.
	 */
	public TestTable() {}

	/**
	 * Creates a TestTable.
	 * 
	 * @param tests the list of tests
	 */
	public TestTable(List<Test> tests) {
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
