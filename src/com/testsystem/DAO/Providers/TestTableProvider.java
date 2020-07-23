package com.testsystem.DAO.Providers;

import java.util.List;

import com.testsystem.DAO.Tables.TestTable;
import com.testsystem.models.Test;

/**
 * Represents a provider to the database containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestTableProvider {

	private TestTable testTable;

	/**
	 * Creates a TestBaseTable.
	 * 
	 * @param testTable The table of tests
	 */
	public TestTableProvider(TestTable testTable) {
		setTestTable(testTable);
	}
	
	/**
	 * Gets new TestTable.
	 */
	public static TestTable getNewTestTable() {
		return new TestTable();
	}

	/**
	 * Gets all tests.
	 * 
	 * @return the all tests
	 */
	public List<Test> getAllTests() {
		return testTable.getTests();
	}

	/**
	 * Adds list of test.
	 * 
	 * @param tests the tests to add
	 */
	public void addTests(List<Test> tests) {
		this.testTable.setTests(tests);
	}

	/**
	 * Gets test.
	 * 
	 * @param 	the test id.
	 * @return 	the TestModel.
	 */
	public Test getTest(int idTest) {
		if (idTest < testTable.getTests().size() && idTest >= 0) {
			return testTable.getTests().get(idTest);
		}
		return null;
	}

	/**
	 * Gets the table of tests.
	 * 
	 * @return the table of tests
	 */
	public TestTable getTestTable() {
		return testTable;
	}

	/**
	 * Sets the table of tests.
	 * 
	 * @param testTable the table of tests
	 */
	public void setTestTable(TestTable testTable) {
		this.testTable = testTable;
	}
}
