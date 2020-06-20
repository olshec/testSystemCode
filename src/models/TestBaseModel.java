package models;

import java.util.List;

/**
 * Represents a database containing tests.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TestBaseModel {
	private List<TestModel> tests;

	
	/**Creates a TestBaseModel.
	 */
	public TestBaseModel() {
		setTests(tests);
	}
	
	/**
	 * @param tests
	 */
	public TestBaseModel(List<TestModel> tests) {
		this.tests = tests;
	}

	/**
	 * @return the tests
	 */
	public List<TestModel> getTests() {
		return tests;
	}

	/**
	 * @param tests the tests to set
	 */
	public void setTests(List<TestModel> tests) {
		this.tests = tests;
	}
	
	
}
